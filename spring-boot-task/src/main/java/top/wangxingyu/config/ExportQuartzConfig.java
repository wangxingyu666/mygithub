package top.wangxingyu.config;


import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.wangxingyu.jobs.ExportJob;
import top.wangxingyu.jobs.SimpleQuartzTask;

/**
 * @author 笼中雀
 */
//@Configuration
public class ExportQuartzConfig {
    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(ExportJob.class)
                .withIdentity("exportTask")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(){
        // 指定定时任务
        CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("exportTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
