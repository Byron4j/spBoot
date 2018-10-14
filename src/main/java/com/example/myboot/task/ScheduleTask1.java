package com.example.myboot.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * created by BYRON.Y.Y at 2018/10/10 14:27
 * 定时任务
 */
@Component
public class ScheduleTask1 {

    static Logger logger = LoggerFactory.getLogger(ScheduleTask1.class);

    @Scheduled(cron = "0/5 * * * * ?")
    public void cronProcess(){
        logger.info(this.getClass() + "--" + "cronProcess 执行!");
    }

    @Scheduled(fixedRate = 5000)
    public void fixedProcess(){
        logger.info(this.getClass() + "--" + "fixedProcess 执行!");
    }
}
