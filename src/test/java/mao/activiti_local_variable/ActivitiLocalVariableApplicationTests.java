package mao.activiti_local_variable;

import mao.activiti_local_variable.entity.Evection;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ActivitiLocalVariableApplicationTests
{

    @Test
    void contextLoads()
    {
    }

    /**
     * 任务办理时设置local流程变量
     */
    @Test
    void completeTask()
    {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Map<String, Object> map = new HashMap<>();
        Evection evection = new Evection();
        evection.setNum(3d);
        taskService.setVariablesLocal("2501", map);
    }

    /**
     * 通过当前任务设置local流程变量
     */
    @Test
    void setLocalVariableByTaskId()
    {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Evection evection = new Evection ();
        evection.setNum(3d);
        taskService.setVariableLocal("2501", "evection", evection);
    }
}
