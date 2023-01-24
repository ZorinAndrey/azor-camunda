package ru.azor;

import org.assertj.core.api.SoftAssertions;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricActivityInstance;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.azor.configuration.PostgreSqlContainerConfig;

import java.util.List;

/**
 * Tests for Camunda process.
 */

@SpringBootTest
@ContextConfiguration(classes = PostgreSqlContainerConfig.class)
@Transactional
class ProcessTest {

    @Autowired
    HistoryService historyService;

    @Autowired
    RuntimeService runtimeService;

    private static final String PROCESS_DEFINITION_KEY = "azor-camunda-process";

    /**
     * Test for starting a process.
     */
    @Test
    @DisplayName("Test for starting a process")
    void test() {

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);

        List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery()
            .processInstanceId(processInstance.getProcessInstanceId()).list();

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(processInstance).isNotNull();
        softAssertions.assertThat(historicProcessInstances).hasSize(1);
        softAssertions.assertThat(historicProcessInstances.get(0).getProcessDefinitionKey())
            .isEqualTo(PROCESS_DEFINITION_KEY);

        softAssertions.assertAll();
    }
}
