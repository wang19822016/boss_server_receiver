package com.boss.server.gate.controller;

import com.boss.server.gate.Model.*;
import com.boss.server.gate.service.ServiceApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by l on 2017/1/22.
 */

@RestController
public class ControllerApi {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/device/install", method = {RequestMethod.GET,RequestMethod.POST})
    public String Install(@RequestBody InstallModel installModel) {
        if (null != installModel) {

           InstallModel newInsall = ServiceApi.validateInstall(installModel);

            if (newInsall != null)
            {
                try {
                if (newInsall != null)
                    redisTemplate.opsForList().leftPush("reqList", objectMapper.writeValueAsString(newInsall));
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
            return "true";

        } else {
            return "false";
        }
    }

    @RequestMapping(value = "/user/register", method = {RequestMethod.POST})
    public String login(@RequestBody RegisterModel registerModel) {
        if (null != registerModel) {

            RegisterModel newRegister = ServiceApi.validateRegister(registerModel);

            if (newRegister != null)
            {
                try {
                    if (newRegister != null)
                        redisTemplate.opsForList().leftPush("reqList", objectMapper.writeValueAsString(newRegister));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "true";

        } else {
            return "false";
        }
    }

    @RequestMapping(value = "/user/login", method = {RequestMethod.POST})
    public String  login(@RequestBody LoginModel loginmodel) {
        if (null != loginmodel) {

            LoginModel newlogin = ServiceApi.validateLogin(loginmodel);

            if (newlogin != null)
            {
                try {
                    if (newlogin != null)
                        redisTemplate.opsForList().leftPush("reqList", objectMapper.writeValueAsString(newlogin));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "true";


        } else {
            return "false";
        }
    }

    @RequestMapping(value = "/user/pay", method = {RequestMethod.POST})
    public String pay(@RequestBody PayModel payModel) {
        if (null != payModel) {
            PayModel newpay = ServiceApi.validatePay(payModel);

            if (newpay != null)
            {
                try {
                    if (newpay != null)
                        redisTemplate.opsForList().leftPush("reqList", objectMapper.writeValueAsString(newpay));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return "true";

        } else {
            return "false";
        }
    }
    @RequestMapping(value = "/user/online", method = {RequestMethod.POST})
    public String  online(@RequestBody OnlineModel onlineModel) {
        if (null != onlineModel) {

            OnlineModel newonline = ServiceApi.validateOnline(onlineModel);

            if (newonline != null)
            {
                try {
                    if (newonline != null)
                        redisTemplate.opsForList().leftPush("reqList", objectMapper.writeValueAsString(newonline));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "true";

        } else {
            return "false";
        }
    }

    @RequestMapping(value = "/user/onlogintest", method = {RequestMethod.POST})
    public String  logintest(@RequestBody LoginModel onlineModel) {
        if (null != onlineModel) {

            if (onlineModel != null)
            {
                try {

                    Date date;
                    int mins = 24*60*60*1000;

                    Random r = new Random();

                    for(int i = 1; i<= 8 ;i++) {
                        int boolnum = r.nextInt(2);
                        if (boolnum == 1) {
                            date = new Date(System.currentTimeMillis() + mins * i);
                            onlineModel.setServerTime(date);
                            redisTemplate.opsForList().leftPush("reqList", objectMapper.writeValueAsString(onlineModel));
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "true";

        } else {
            return "false";
        }
    }

}
