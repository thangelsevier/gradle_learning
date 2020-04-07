package com.thangdtran.client.controllers;

import com.thangdtran.client.interfaces.feign.UserFeignClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping(path = "/customer/{id}", produces = {"application/json"})
    public ResponseEntity<Object> getCustomerInfo(@PathVariable("id") String id) {

        String userJson = userFeignClient.getUserInfo(id);
        JSONObject userObject = new JSONObject(userJson);

        JSONObject responseObject = new JSONObject();
        responseObject.put("id", userObject.get("user_id"));
        responseObject.put("name", userObject.get("user_name"));
        responseObject.put("address", userObject.get("user_address"));

        return new ResponseEntity<>(responseObject.toString(), HttpStatus.OK);
    }
}
