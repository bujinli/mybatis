package com.learn.demo.mybatisspring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class DefaultController {

	@Value("${vcap.services.jeff-hana.credentials.url}")
	private String url;

	@GetMapping("ok")
	public String getOk() {
		return "ok";
	}
}
