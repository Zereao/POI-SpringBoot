package com.github.zereao.poi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author 何雨伦
 * @version 2018/06/03/11:04
 */
@Configuration
@ConfigurationProperties
public class MailMsgConfig {
    @Value("${zereao.sender.mail}")
    private String sender;

    @Bean
    SimpleMailMessage mailMessage() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        return mailMessage;
    }
}
