package com.lgq.task;

import com.lgq.service.ITravelService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TravelTask {
    @Resource(name = "travelServiceImpl")
    private ITravelService travelService;
    @Scheduled(cron = "0 0 0 * * ?") //每晚12点触发
    public void run(){
        this.travelService.editAuditTask();
    }
}
