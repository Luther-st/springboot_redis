package com.tongke.redis_jedis.controller;

import com.tongke.redis_jedis.base.utils.RedisConstants;
import com.tongke.redis_jedis.base.utils.RedisUtil;
import com.tongke.redis_jedis.base.utils.SerializeUtil;
import com.tongke.redis_jedis.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/redis")
public class CityController {

    @Autowired
    RedisUtil redisUtil;

    /**
     * @auther: zhangyingqi
     * @date: 16:23 2018/8/29
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 执行redis写/读/生命周期
     */
    @RequestMapping(value = "getRedis",method = RequestMethod.GET)
    @ResponseBody
    public String getRedis(){
        redisUtil.set("20182018","这是一条测试数据", RedisConstants.datebase1);
        Long resExpire = redisUtil.expire("20182018", 60, RedisConstants.datebase1);//设置key过期时间
        String res = redisUtil.get("20182018", RedisConstants.datebase1);

        //测试Redis保存对象
        City u = new City("深圳","广东");
        redisUtil.set("20181017".getBytes(), SerializeUtil.serialize(u),RedisConstants.datebase1);


        byte[] user = redisUtil.get("20181017".getBytes(),RedisConstants.datebase1);
        City us = (City) SerializeUtil.unserialize(user);
        System.out.println("user="+us.toString());

        return us.toString() +  "----执行成功";
    }
}
