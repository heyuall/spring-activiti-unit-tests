package com.workflow.activitiunittests;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

@SpringBootTest
class ActivitiunittestsApplicationTests {
    @Rule
    public ActivitiRule activitiRule = new ActivitiRule();

    @Test
    void contextLoads() {
    }

    @Test
    @Deployment(resources = {"org/activiti/test/one-task-process.bpmn20.xml"})
    public void should_start_process(){
        //given
        RuntimeService runtimeService = activitiRule.getRuntimeService();

        //when
        runtimeService.startProcessInstanceByKey("oneTaskProcess");

        //then
        assertEquals(1,runtimeService.createProcessInstanceQuery().count());
    }

}
