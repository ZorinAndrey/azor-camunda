package ru.azor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.azor.service.ProcessService;
import ru.azor.util.CommonConstants;

/**
 * {@inheritDoc}
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private final RuntimeService runtimeService;

    /**
     * {@inheritDoc}
     */
    @Override
    @KafkaListener(topics = CommonConstants.KAFKA_TOPIC, groupId = CommonConstants.KAFKA_GROUP_ID)
    public void passTheEventToTheProcess(String event) {

        log.info("Get event from Kafka: {}", event);

        if (CommonConstants.START_PARENT_PROCESS_MESSAGE_EVENT.equals(event)) {

            ProcessInstance processInstance = runtimeService.startProcessInstanceByMessage(event);

            log.info("Start process instance {} by message {}", processInstance.getProcessDefinitionId(), event);
        }

        if (CommonConstants.START_FIRST_SUB_PROCESS_MESSAGE_EVENT.equals(event)) {

            log.info(
                "Correlate start message event '{}' for first sub process",
                CommonConstants.START_FIRST_SUB_PROCESS_MESSAGE_EVENT
            );

            runtimeService.createMessageCorrelation(CommonConstants.START_FIRST_SUB_PROCESS_MESSAGE_EVENT).correlate();
        }
    }
}
