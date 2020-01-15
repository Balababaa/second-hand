package com.xiaobai.information.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author XinHuiChen
 */
@RestController
public class OpenIdController {

    private final String APP_ID="wx377532aaaebbdda6";
    private final String App_Secret="c50a1edf1a84313b95804d8ca40a771c";
    private final RestTemplate restTemplate;

    public OpenIdController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

    @GetMapping(value = "/openid")
    public ResponseEntity<String> getOpenId(@RequestParam String code){
        return restTemplate
                .getForEntity("https://api.weixin.qq.com/sns/jscode2session?appid={1}&secret={2}&js_code={3}&grant_type=authorization_code", String.class, APP_ID, App_Secret, code);
    }
}
