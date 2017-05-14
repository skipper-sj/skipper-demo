package com.skipper.activiti.helper.model;

import com.sun.istack.NotNull;

/**
 * 流程部署入参
 *
 * Created by shoujian on 2017/5/14.
 */
public class DeploymentParam {

    /**
     * 流程部署名称
     */
    @NotNull
    private String deploymentName;

    /**
     * 流程部署bpmn文件路径
     */
    private String deploymentBpmnUrl;

    /**
     * 流程部署xml路径
     */
    private String deploymentXmlUrl;

    /**
     * 流程部署图片地址
     */
    private String deploymentPicUrl;

    public String getDeploymentName() {
        return deploymentName;
    }

    public void setDeploymentName(String deploymentName) {
        this.deploymentName = deploymentName;
    }

    public String getDeploymentBpmnUrl() {
        return deploymentBpmnUrl;
    }

    public void setDeploymentBpmnUrl(String deploymentBpmnUrl) {
        this.deploymentBpmnUrl = deploymentBpmnUrl;
    }

    public String getDeploymentXmlUrl() {
        return deploymentXmlUrl;
    }

    public void setDeploymentXmlUrl(String deploymentXmlUrl) {
        this.deploymentXmlUrl = deploymentXmlUrl;
    }

    public String getDeploymentPicUrl() {
        return deploymentPicUrl;
    }

    public void setDeploymentPicUrl(String deploymentPicUrl) {
        this.deploymentPicUrl = deploymentPicUrl;
    }
}
