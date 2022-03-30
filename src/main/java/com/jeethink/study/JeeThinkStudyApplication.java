package com.jeethink.study;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import com.jeethink.common.security.annotation.EnableCustomConfig;
import com.jeethink.common.security.annotation.EnableRyFeignClients;
import com.jeethink.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 * 
 * @author jeethink  官方网址:http://www.jeethink.vip
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringCloudApplication
public class JeeThinkStudyApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(JeeThinkStudyApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  jeethink 学习模块启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
