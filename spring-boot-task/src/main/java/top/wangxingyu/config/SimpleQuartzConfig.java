package top.wangxingyu.config;


import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.wangxingyu.jobs.SimpleQuartzTask;

/**
 * @author 笼中雀
 */
//@Configuration
public class SimpleQuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(SimpleQuartzTask.class)
                .withIdentity("simpleQuartzTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(){
        // 指定定时任务
        CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("simpleQuartzTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
