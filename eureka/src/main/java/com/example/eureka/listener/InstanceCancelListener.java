package com.example.eureka.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author luxp
 * @date 2018/12/19
 */
@Configuration
@Slf4j
public class InstanceCancelListener implements ApplicationListener<EurekaInstanceCanceledEvent> {
	@Override
	public void onApplicationEvent(EurekaInstanceCanceledEvent event) {
		log.info("服务挂了. {}", event.getAppName());
	}
}
