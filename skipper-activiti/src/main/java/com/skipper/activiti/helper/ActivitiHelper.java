package com.skipper.activiti.helper;

import com.skipper.activiti.helper.model.DeploymentParam;
import com.skipper.helper.enums.ApiResponseCode;
import com.skipper.helper.exception.SkipperException;
import com.skipper.helper.util.SpringContext;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 流程引擎帮助类
 * <p>
 * Created by shoujian on 2017/5/12.
 */
public class ActivitiHelper {

    private static final ActivitiHelper activitiHelper = new ActivitiHelper();

    private ProcessEngine processEngine;
    private TaskService taskService;
    private RuntimeService runtimeService;
    private RepositoryService repositoryService;

    private ActivitiHelper() {
        processEngine = (ProcessEngine) SpringContext.getBean(ProcessEngine.class);
        runtimeService = (RuntimeService) SpringContext.getBean(RuntimeService.class);
        taskService = (TaskService) SpringContext.getBean(TaskService.class);
        repositoryService = (RepositoryService) SpringContext.getBean(RepositoryService.class);
    }

    /**
     * 部署流程 如果xml文件是.bpmn2.xml结尾，可以直接用xml部署
     *
     * @param deploymentParam 流程部署参数
     * @return 部署结果
     */
    public static Deployment createDeployment(DeploymentParam deploymentParam) {
        SkipperException.isNull(deploymentParam, "流程参数不能为空");

        DeploymentBuilder deploymentBuilder = activitiHelper.repositoryService
                .createDeployment().name(deploymentParam.getDeploymentName());

        if (deploymentParam.getDeploymentBpmnUrl() != null) {
            deploymentBuilder.addClasspathResource(deploymentParam.getDeploymentBpmnUrl());
        }

        if (deploymentParam.getDeploymentPicUrl() != null) {
            deploymentBuilder.addClasspathResource(deploymentParam.getDeploymentPicUrl());
        }

        if (deploymentParam.getDeploymentXmlUrl() != null) {
            deploymentBuilder.addClasspathResource(deploymentParam.getDeploymentXmlUrl());
        }

        return deploymentBuilder.deploy();
    }

    /**
     * 启动一个新的流程
     *
     * @param processDefinitionKey 流程定义的key
     * @return 流程实例对象
     */
    public static ProcessInstance startNewActiviti(String processDefinitionKey) {
        return activitiHelper.runtimeService
                .startProcessInstanceById(processDefinitionKey);
    }

    /**
     * 通过流程实例流转一个流程(仅用于单节点的操作，多节点建议使用另一种
     * )
     *
     * @param processInstance 流程实例详情
     * @param userEntity      用户参数
     * @param variables       流畅流转参数（用于判断流程应该流转到哪个）
     */
    public static void passTask(ProcessInstance processInstance, UserEntity userEntity, Map<String, Object> variables) {
        SkipperException.isNull(processInstance, "流程实例参数不能为空");
        SkipperException.isNull(processInstance.getId(), "流程实例id不能为空");

        List<Task> tasks = activitiHelper.taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();

        if (tasks == null || tasks.size() == 0) {
            SkipperException.fail(ApiResponseCode.DATA_NOT_EXIST, "不存在运行中的流程详情");
        }
        passTask(tasks.get(0), userEntity, variables);
    }

    /**
     * 通过任务参数流转一个流程
     *
     * @param task       任务详情
     * @param userEntity 用户详情
     * @param variables  流程参数
     */
    public static void passTask(Task task, UserEntity userEntity, Map<String, Object> variables) {
        SkipperException.isNull(task, "任务参数不能为空");
        SkipperException.isNull(task.getId(), "流程id不能为空");

        if (userEntity != null && userEntity.getId() != null) {
            activitiHelper.taskService.claim(task.getId(), userEntity.getId());
        }
        activitiHelper.taskService.complete(task.getId(), variables);
    }

    /**
     * 根据用户组id获取代办任务流程实例id列表
     *
     * @param candidateGroupIds 用户组id
     * @return 代办流程列表
     */
    public static List<String> findMyGroupTasks(List<String> candidateGroupIds) {
        SkipperException.isNull(candidateGroupIds, "用户组id不能为空");

        List<Task> tasks = activitiHelper.taskService
                .createTaskQuery()
                .taskCandidateGroupIn(candidateGroupIds)
                .orderByTaskCreateTime()
                .desc()
                .list();

        List<String> processInstanceIds = new ArrayList<>();

        Map<String, List<Task>> taskByProcessInstanceIdMap = tasks.stream().collect(Collectors.groupingBy(Task::getProcessInstanceId));
        processInstanceIds.addAll(taskByProcessInstanceIdMap.keySet());
        return processInstanceIds;
    }

    /**
     * 根据用户id获取任务列表
     *
     * @param candidateUserId 用户id
     * @return 任务列表
     */
    public static List<String> findMyUserTasks(String candidateUserId) {
        SkipperException.isNull(candidateUserId, "用户id列表不能为空");

        List<Task> tasks = activitiHelper.taskService
                .createTaskQuery()
                .taskCandidateUser(candidateUserId)
                .orderByTaskCreateTime()
                .desc()
                .list();

        List<String> processInstanceIds = new ArrayList<>();

        Map<String, List<Task>> taskByProcessInstanceIdMap = tasks.stream().collect(Collectors.groupingBy(Task::getProcessInstanceId));
        processInstanceIds.addAll(taskByProcessInstanceIdMap.keySet());
        return processInstanceIds;
    }


}
