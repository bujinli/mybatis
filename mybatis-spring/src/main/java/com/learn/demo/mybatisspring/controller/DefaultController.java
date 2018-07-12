package com.learn.demo.mybatisspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class DefaultController {

	@GetMapping("ok")
	public String getOk() {
		return "ok";
	}
}
