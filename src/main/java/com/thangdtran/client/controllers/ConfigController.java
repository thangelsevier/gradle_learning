package com.thangdtran.client.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.dbpass}")
    private String dbpass;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${global.title}")
    private String title;

    @GetMapping(path = "/configs", produces = "application/json")
    public ResponseEntity<Object> getConfigs() {

        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isEmpty(title)) {
            jsonObject.put("Status", "Fail");
        } else {
            jsonObject.put("Status", "OK");
            jsonObject.put("Title", title);
            jsonObject.put("DB Url", url);
            jsonObject.put("DB UserName", username);
            jsonObject.put("DB Password", dbpass);
            jsonObject.put("DB Driver", driver);
        }

        ResponseEntity<Object> response = new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
        return response;
    }
}
