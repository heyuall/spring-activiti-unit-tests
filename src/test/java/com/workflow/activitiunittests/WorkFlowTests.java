package com.workflow.activitiunittests;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class WorkFlowTests {
    @Rule
    public ActivitiRule activitiRule = new ActivitiRule();

    @Test
    @Deployment(resources = {"org/activiti/test/one-task-process.bpmn20.xml"})
    public void should_start_process() {
        //given
        RuntimeService runtimeService = activitiRule.getRuntimeService();

        //when
        runtimeService.startProcessInstanceByKey("oneTaskProcess");

        //then
        assertEquals(1, runtimeService.createProcessInstanceQuery().count());

    }

    @Test
    @Deployment(resources = {"org/activiti/test/one-task-process.bpmn20.xml"})
    public void should_get_tasks() {
        //given
        RuntimeService runtimeService = activitiRule.getRuntimeService();
        runtimeService.startProcessInstanceByKey("oneTaskProcess");
        TaskService taskService = activitiRule.getTaskService();

        //when & then
        assertEquals(1, taskService.createTaskQuery().count());

    }

    @Test
    @Deployment(resources = {"org/activiti/test/one-task-process.bpmn20.xml"})
    public void should_audit_unfinished_processes() {
        //given
        RuntimeService runtimeService = activitiRule.getRuntimeService();

        runtimeService.startProcessInstanceByKey("oneTaskProcess");
        runtimeService.startProcessInstanceByKey("oneTaskProcess");
        runtimeService.startProcessInstanceByKey("oneTaskProcess");
        HistoryService historyService = activitiRule.getHistoryService();

        //when & then
        assertEquals(3, historyService
                .createHistoricProcessInstanceQuery()
                .unfinished().count());

    }

    @Test
    @Deployment(resources = {"org/activiti/test/one-task-process.bpmn20.xml"})
    public void should_audit_finished_processes() {
        //given
        RuntimeService runtimeService = activitiRule.getRuntimeService();

        runtimeService.startProcessInstanceByKey("oneTaskProcess");
        runtimeService.startProcessInstanceByKey("oneTaskProcess");
        runtimeService.startProcessInstanceByKey("oneTaskProcess");

        HistoryService historyService = activitiRule.getHistoryService();
        TaskService taskService = activitiRule.getTaskService();

        //when
        List<Task> taskInstances = taskService.createTaskQuery().list();
        taskInstances.stream().forEach(task -> {
            taskService.complete(task.getId());
        });

        //then
        assertEquals(3, historyService
                .createHistoricProcessInstanceQuery()
                .finished().count());

    }

    @Test
    @Deployment(resources = {"org/activiti/test/one-task-process.bpmn20.xml"})
    public void should_audit_task_activities() {
        //given
        RuntimeService runtimeService = activitiRule.getRuntimeService();
        runtimeService.startProcessInstanceByKey("oneTaskProcess");

        HistoryService historyService = activitiRule.getHistoryService();

        //when & then
        assertEquals(2, historyService.createHistoricActivityInstanceQuery().count());


    }


}
