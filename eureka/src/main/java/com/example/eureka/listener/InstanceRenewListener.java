package com.example.eureka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author luxp
 * @date 2018/12/19
 */
@Configuration
@Slf4j
public class InstanceRenewListener implements ApplicationListener<EurekaInstanceRenewedEvent> {
	@Override
	public void onApplicationEvent(EurekaInstanceRenewedEvent event) {
		log.info("服务心跳检测. {}", event.getInstanceInfo().getAppName());
	}
}
