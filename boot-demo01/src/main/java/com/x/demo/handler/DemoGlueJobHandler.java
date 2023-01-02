package com.x.demo.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class DemoGlueJobHandler {

    private final Logger logger = LoggerFactory.getLogger(DemoGlueJobHandler.class);

    @XxlJob("testHandlerDemo")
    public ReturnT<String> execute() {
        String param = XxlJobHelper.getJobParam();
        logger.info("定时任务执行 参数{}", param);
        return ReturnT.SUCCESS;
    }
}

