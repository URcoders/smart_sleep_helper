package com.linxu.pillow.utils;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/**
 * @author linxu
 * @date 2019/4/5
 * 请求工具类：
 * 用于微信Auth请求以及其它基于Http协议的网络请求
 */
public class RequestUtil {
    private static final String BASE_URL = "https://api.weixin.qq.com/sns/jscode2session?";
    private static final String APP_ID = "appid=wxe376b4ed6e218aa8&";
    private static final String SECRET = "secret=09f18ef1ea41e85ce84708c72ad893d9&";
    private static final String JS_CODE = "js_code=";
    private static final String GRANT_TYPE = "&grant_type=authorization_code";
    private static final RestTemplate restTemplate = new RestTemplate();

    /**
     * @param code from website
     * @return a string obj  which contains openid、session_key,even unionid
     * the return value maybe a null obj, take care of it .
     */
    public static String code2Session(String code) {
        if (EmptyUtil.isEmpty(code)) {
            return null;
        }
        String url = BASE_URL + APP_ID + SECRET + JS_CODE + code + GRANT_TYPE;
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            System.err.println(responseEntity.getBody());
            return responseEntity.getBody();
        }
        return null;
    }
}
