package com.demo.controller.demo;


import com.demo.bean.result.Result;
import com.demo.dto.request.array.EntityArrayInEntity;
import com.demo.dto.request.array.SimpleArrayInEntity;
import com.demo.dto.request.collection.EntityListInEntity;
import com.demo.dto.request.collection.SimpleListInEntity;
import com.demo.dto.request.demo.DemoReqDTO;
import com.demo.dto.request.entity.*;
import com.demo.dto.request.map.EntityMapInEntity;
import com.demo.dto.request.map.SimpleMapInEntity;
import com.demo.entity.demo.Demo;
import com.demo.service.demo.DemoService;
import com.demo.util.resp.ResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private static final Logger LOG = LogManager.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    /**
     * id = 1
     * str = "bob"
     */
    @PostMapping(value="/doSimpleProperty")
    public Result doSimpleProperty(Integer id, @RequestParam String str){
        Demo demo = demoService.selectByPrimaryKey(id);
        return ResponseUtil.setSuccessDataResponse(demo);
    }

    /**
     * array = "a,b,c"
     */
    @PostMapping(value="/doSimpleArray")
    public Result doSimpleArray(String[] array){
        return ResponseUtil.setDefaultSuccessResponse();
    }

    /**
     * array[0] = "a"
     * array[1] = "b"
     */
    @PostMapping(value="/doSimpleArrayInEntity")
    public Result doSimpleArrayInEntity(SimpleArrayInEntity simpleArrayInEntity){
        return ResponseUtil.setDefaultSuccessResponse();
    }

//    @PostMapping(value="/doEntityArray")
//    public Result doEntityArray(Entity[] array){
//        return ResponseUtil.setDefaultSuccessResponse();
//    }

    /**
     * entities[0].id = 1
     * entities[0].name = "bob"
     * entities[1].id = 2
     * entities[1].name = "john"
     */
    @PostMapping(value="/doEntityArrayInEntity")
    public Result doEntityArrayInEntity(EntityArrayInEntity entity){
        return ResponseUtil.setDefaultSuccessResponse();
    }

    /**
     * stringList = "a,b,c"
     */
    @PostMapping(value="/doSimpleList")
    public Result doSimpleList(/*@ModelAttribute(name = "nameList") */List<String> list){
        return ResponseUtil.setDefaultSuccessResponse();
    }

    /**
     * list[0] = "a"
     * list[1] = "b"
     */
    @PostMapping(value="/doSimpleListInEntity")
    public Result doSimpleListInEntity(SimpleListInEntity entity){
        return ResponseUtil.setDefaultSuccessResponse();
    }

    /**
     * entityList[0].id = 1
     * entityList[0].name = "bob"
     * entityList[1].id = 2
     * entityList[1].name = "john"
     */
    @PostMapping(value="/doEntityListInEntity")
    public Result doEntityListInEntity(EntityListInEntity entity){
        return ResponseUtil.setDefaultSuccessResponse();
    }

    /**
     * id = 1
     * name = "bob"
     */
    @PostMapping(value="/doSimpleMap")
    public Result doSimpleMap(@RequestParam Map<String,String> map){
        return ResponseUtil.setDefaultSuccessResponse();
    }


    /**
     * map[id] = 1
     * map[name] = "bob"
     */
    @PostMapping(value="/doSimpleMapInEntity")
    public Result doSimpleMapInEntity(SimpleMapInEntity entity){
        return ResponseUtil.setDefaultSuccessResponse();
    }

    /**
     * map[car].id = 1
     * map[car].name = "bob"
     * map[fruit].id = 1
     * map[fruit].name = "apple"
     */
    @PostMapping(value="/doEntityMapInEntity")
    public Result doEntityMapInEntity(EntityMapInEntity entity){
        return ResponseUtil.setDefaultSuccessResponse();
    }

    /**
     * id = 1
     * name = "bob"
     * createDate = "2020-02-01"
     */
    @PostMapping(value="/doEntity")
    public Result doEntity(Entity entity) {
        return ResponseUtil.setSuccessDataResponse(entity);
    }

    /**
     * id = 1
     * name = "bob"
     * entity.id = "2"
     * entity.name = "dog"
     */
    @PostMapping(value="/doEntityInEntity")
    public Result doEntityInEntity(EntityInEntity entity) {
        return ResponseUtil.setSuccessDataResponse(entity);
    }

    /**
     * {
     * 	"id":"1",
     * 	"name":"bob",
     * 	"createDate":"2020-02-01"
     * }
     */
    @PostMapping(value="/doJsonEntity",produces= MediaType.APPLICATION_JSON_VALUE)
    public Result doJsonEntity(@RequestBody Entity entity) {
        return ResponseUtil.setSuccessDataResponse(entity);
    }


    @PostMapping(value="/doMix",produces= MediaType.APPLICATION_JSON_VALUE)
    public Result doMix(@RequestBody DemoReqDTO param,
                        @RequestParam Map map,
                        @RequestHeader(value = "token", required = false) String token,
                        String string) {
        return ResponseUtil.setSuccessDataResponse(param);
    }


    @PostMapping(value="/doRequstAndResponse")
    public Result doRequstAndResponse(HttpServletRequest request, HttpServletResponse response){

        return ResponseUtil.setDefaultSuccessResponse();
    }

//    @ModelAttribute
//    public void preModel(int id, String name, Model model){
//        model.addAttribute(id);
//        model.addAttribute(name);
//    }
    @ModelAttribute
    public Result doModelMap(ModelMap modelMap){

        return ResponseUtil.setDefaultSuccessResponse();
    }

}
