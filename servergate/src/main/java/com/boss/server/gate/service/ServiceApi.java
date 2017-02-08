package com.boss.server.gate.service;

import com.boss.server.gate.Model.*;
import com.boss.server.gate.dao.ApiValidate;
import org.springframework.data.redis.core.RedisTemplate;

import javax.security.auth.spi.LoginModule;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by l on 2017/1/22.
 */
public class ServiceApi {

    public static Date date;

    public static InstallModel validateInstall(InstallModel installModel)
    {
            if (installModel!=null)
            {
                date=new Date(System.currentTimeMillis());
                installModel.setServerTime(date);

                return installModel;
            }
            else
            {
                return null;
            }
    }

    public static LoginModel validateLogin(LoginModel loginModel)
    {
        if(loginModel != null)
        {
            date=new Date(System.currentTimeMillis());
            loginModel.setServerTime(date);

            return loginModel;
        }
        else
        {
            return null;
        }
    }


    public static OnlineModel validateOnline(OnlineModel onlineModel)
    {
        if(onlineModel != null)
        {

            date=new Date(System.currentTimeMillis());
            onlineModel.setServerTime(date);

            return onlineModel;
        }
        else
        {
            return null;
        }
    }


    public static PayModel validatePay(PayModel payModel)
    {
        if(payModel != null)
        {
            date=new Date(System.currentTimeMillis());
            payModel.setServerTime(date);

            return payModel;
        }
        else
        {
            return null;
        }
    }

    public static RegisterModel validateRegister(RegisterModel RegisterModel)
    {
        if(RegisterModel != null)
        {
            date=new Date(System.currentTimeMillis());

            RegisterModel.setServerTime(date);

            return RegisterModel;
        }
        else
        {
            return null;
        }
    }


}
