package com.tongke.redis_template.controller;


import com.tongke.redis_template.base.utils.RedisConstants;
import com.tongke.redis_template.base.utils.RedisUtils;
import com.tongke.redis_template.base.utils.StateParameter;
import com.tongke.redis_template.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: RedisTestController
 * @Auther: zhangyingqi
 * @Date: 2018/8/28 17:24
 * @Description:
 */
@Controller
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    RedisUtils redisUtil;

    @RequestMapping(value="/list")
    public String view(HttpServletRequest request, String name){
        return "/demoPage/listPage/"+ name;
    }

    /**
     * @auther: zhangyingqi
     * @date: 17:26 2018/8/28
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 测试redis存储&读取
     */
    @RequestMapping(value="/test")
    @ResponseBody
    public ModelMap test(){
        try {
            redisUtil.set("redisTemplate","这是一条测试数据", RedisConstants.datebase2);
            String value = redisUtil.get("redisTemplate", RedisConstants.datebase2).toString();
            return getModelMap(StateParameter.SUCCESS, value, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

    @RequestMapping(value="/setUser")
    @ResponseBody
    public ModelMap setUser(){
        try {
            City city = new City("南宁","广西");

            redisUtil.set("city",city, RedisConstants.datebase1);
            City res = (City)redisUtil.get("city",RedisConstants.datebase1);
            return getModelMap(StateParameter.SUCCESS, res, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

    public ModelMap getModelMap(String status,Object data,String msg){
        ModelMap modelMap=new ModelMap();
        modelMap.put("status", status);
        modelMap.put("data", data);
        modelMap.put("msg", msg);
        return modelMap;

    }

}
