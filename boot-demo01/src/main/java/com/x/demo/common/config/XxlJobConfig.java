package com.x.demo.common.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class XxlJobConfig {
    private static transient Logger logger = LoggerFactory.getLogger(XxlJobConfig.class);
    private final String adminAddresses;
    private final String appname;
    private final String ip;
    private final int port;
    private final String logPath;
    private final int logRetentionDays;

    public XxlJobConfig(@Value("${xxl.job.admin.addresses}") String adminAddresses,
                        @Value("${xxl.job.executor.appname}") String appname,
                        @Value("${xxl.job.executor.ip}")String ip,
                        @Value("${xxl.job.executor.port}")int port,
                        String logPath,
                        int logRetentionDays) {
        this.adminAddresses = adminAddresses;
        this.appname = appname;
        this.ip = ip;
        this.port = port;
        this.logPath = logPath;
        this.logRetentionDays = logRetentionDays;
    }


    @Bean
    public XxlJobSpringExecutor xxlJobExecutor() {
        logger.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppname(appname);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);
//        xxlJobSpringExecutor.setAccessToken(accessToken);
        xxlJobSpringExecutor.setLogPath(logPath);
        xxlJobSpringExecutor.setLogRetentionDays(logRetentionDays);
        return xxlJobSpringExecutor;
    }

}
