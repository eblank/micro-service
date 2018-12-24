package com.example.gateway.controller;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author luxp
 * @date 2018/12/24
 */
@RestController
public class PermissionController {

	@Resource
	private OAuth2RestTemplate template;

	private final String userPermissionsUrl = "http://127.0.0.1:2333/api/user/menuPerms?clientId={clientId}";

	@GetMapping("/user/menuPerms/{clientId}")
	public Map menus(@PathVariable String clientId) {
		return template.getForObject(userPermissionsUrl, Map.class, clientId);
	}
}
