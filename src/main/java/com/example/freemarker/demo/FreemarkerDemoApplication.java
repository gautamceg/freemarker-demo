package com.example.freemarker.demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Controller
public class FreemarkerDemoApplication {
	@Autowired
	private Configuration cfg;

	public static void main(String[] args) {
		SpringApplication.run(FreemarkerDemoApplication.class, args);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String hello(@RequestParam(name = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

}
