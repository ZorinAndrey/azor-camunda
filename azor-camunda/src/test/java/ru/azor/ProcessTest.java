package ru.azor;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Tests for Camunda process.
 */

@SpringBootTest
@ActiveProfiles("bpm-process-tests")
class ProcessTest {

    final String PROCESS_DEFINITION_KEY = "azor-camunda-process";

    @Autowired
    RuntimeService runtimeService;

    /**
     * Test for starting a process.
     */
    @Test
    @DisplayName("Test for starting a process")
    void test() {

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);

        assertNotNull(processInstance);
    }
}
