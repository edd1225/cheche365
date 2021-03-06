package com.cheche365.cheche.ordercenter.web.model.agent;

import com.cheche365.cheche.common.util.DateUtils;
import com.cheche365.cheche.core.model.AgentRebateHistoryTmp;

import javax.validation.constraints.NotNull;

/**
 * Created by wangshaobin on 2017/5/5.
 */
public class AgentRebateHistoryTmpViewModel {
    private Long id;
    @NotNull
    private Long agent;//代理人
    @NotNull
    private Long area;//城市
    private String areaName;//地区名称
    @NotNull
    private Long insuranceCompany;//保险公司
    private String companyName;//公司名称
    @NotNull
    private Double compulsoryRebate;//交强险返点
    @NotNull
    private Double commercialRebate;//商业险返点
    @NotNull
    private String startTime;//历史费率开始时间
    private String endTime;//历史费率结束时间

    public AgentRebateHistoryTmpViewModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgent() {
        return agent;
    }

    public void setAgent(Long agent) {
        this.agent = agent;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(Long insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Double getCompulsoryRebate() {
        return compulsoryRebate;
    }

    public void setCompulsoryRebate(Double compulsoryRebate) {
        this.compulsoryRebate = compulsoryRebate;
    }

    public Double getCommercialRebate() {
        return commercialRebate;
    }

    public void setCommercialRebate(Double commercialRebate) {
        this.commercialRebate = commercialRebate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public static AgentRebateHistoryTmpViewModel createViewModel(AgentRebateHistoryTmp agentRebateHistory){
        AgentRebateHistoryTmpViewModel viewData=new AgentRebateHistoryTmpViewModel();
        viewData.setAgent(agentRebateHistory.getAgent().getId());
        viewData.setArea(agentRebateHistory.getArea().getId());
        viewData.setInsuranceCompany(agentRebateHistory.getInsuranceCompany().getId());
        viewData.setCommercialRebate(agentRebateHistory.getCommercialRebate());
        viewData.setCompulsoryRebate(agentRebateHistory.getCompulsoryRebate());
        viewData.setStartTime(DateUtils.getDateString(agentRebateHistory.getStartTime(), DateUtils.DATE_LONGTIME24_PATTERN));
        viewData.setEndTime(DateUtils.getDateString(agentRebateHistory.getEndTime(), DateUtils.DATE_LONGTIME24_PATTERN));
        viewData.setAreaName(agentRebateHistory.getArea().getName());
        viewData.setCompanyName(agentRebateHistory.getInsuranceCompany().getName());
        return viewData;
    }

    public String getAreaName() { return areaName; }

    public void setAreaName(String areaName) { this.areaName = areaName; }

    public String getCompanyName() {  return companyName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

}
