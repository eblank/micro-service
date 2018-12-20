package com.example.eureka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author luxp
 * @date 2018/12/19
 */
@Configuration
@Slf4j
public class InstanceRegisterListener implements ApplicationListener<EurekaInstanceRegisteredEvent> {
	@Override
	public void onApplicationEvent(EurekaInstanceRegisteredEvent eurekaInstanceRegisteredEvent) {
		log.info("服务注册. {}", eurekaInstanceRegisteredEvent.getInstanceInfo().getAppName());
	}
}
