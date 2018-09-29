package com.demo.bean.redis;


import com.demo.bean.result.Result;

public abstract class RedisLockBusBean {

    public abstract Result doInLock() throws Exception;

    public abstract Result doInCrash(String currentValue) throws Exception;
}
