package com.example.freemarker.demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private Configuration cfg;

    @RequestMapping(method = RequestMethod.GET, path = "/json/hello")
    public String jsonDemo(@RequestParam(name = "name") String name) throws IOException, TemplateException {
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("flag", true);
        final Template template = cfg.getTemplate("sample.ftl");
        final StringWriter writer = new StringWriter();
        template.process(data, writer);

        return writer.toString();
    }
}
