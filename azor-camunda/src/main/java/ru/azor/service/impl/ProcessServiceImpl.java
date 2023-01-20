package ru.azor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.exception.NotFoundException;
import org.camunda.bpm.engine.task.Task;
import org.springframework.stereotype.Service;
import ru.azor.service.ProcessService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * {@inheritDoc}
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private static final String PROCESS_DEFINITION_KEY = "azor-camunda-process";
    private static final String TASK_DEFINITION_KEY = "simple-task";

    /**
     * {@inheritDoc}
     */
    @Override
    public void completeProcess() {

        runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);

        log.debug("Process started with definition key {}", PROCESS_DEFINITION_KEY);

        Task task = taskService.createTaskQuery()
            .processDefinitionKey(PROCESS_DEFINITION_KEY)
            .taskDefinitionKey(TASK_DEFINITION_KEY)
            .taskCreatedAfter(Date.from(Instant.now().truncatedTo(ChronoUnit.SECONDS)))
            .singleResult();

        if (task == null) {
            throw new NotFoundException(
                String.format("Task not found with definition key %s in process %s with actual date",
                              TASK_DEFINITION_KEY, PROCESS_DEFINITION_KEY
                ));
        }

        String taskId = task.getId();

        log.debug("Find user task with id {}", taskId);

        taskService.complete(taskId);

        log.debug("Task completed with id {}", taskId);
        log.debug("Process completed with definition key {}", PROCESS_DEFINITION_KEY);
    }
}
