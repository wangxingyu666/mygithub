package top.wangxingyu.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @author 笼中雀
 */

@Slf4j
public class SimpleQuartzTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
      log.info("SimpleQuartzTask,执行时间:{}", LocalDateTime.now());
    }
}