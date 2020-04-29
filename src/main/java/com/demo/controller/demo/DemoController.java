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
        return Result.success(demo);
    }

    /**
     * array = "a,b,c"
     */
    @PostMapping(value="/doSimpleArray")
    public Result doSimpleArray(String[] array){
        return Result.success();
    }

    /**
     * array[0] = "a"
     * array[1] = "b"
     */
    @PostMapping(value="/doSimpleArrayInEntity")
    public Result doSimpleArrayInEntity(SimpleArrayInEntity simpleArrayInEntity){
        return Result.success();
    }

//    @PostMapping(value="/doEntityArray")
//    public Result doEntityArray(Entity[] array){
//        return Result.success();
//    }

    /**
     * entities[0].id = 1
     * entities[0].name = "bob"
     * entities[1].id = 2
     * entities[1].name = "john"
     */
    @PostMapping(value="/doEntityArrayInEntity")
    public Result doEntityArrayInEntity(EntityArrayInEntity entity){
        return Result.success();
    }

    /**
     * stringList = "a,b,c"
     */
    @PostMapping(value="/doSimpleList")
    public Result doSimpleList(/*@ModelAttribute(name = "nameList") */List<String> list){
        return Result.success();
    }

    /**
     * list[0] = "a"
     * list[1] = "b"
     */
    @PostMapping(value="/doSimpleListInEntity")
    public Result doSimpleListInEntity(SimpleListInEntity entity){
        return Result.success();
    }

    /**
     * entityList[0].id = 1
     * entityList[0].name = "bob"
     * entityList[1].id = 2
     * entityList[1].name = "john"
     */
    @PostMapping(value="/doEntityListInEntity")
    public Result doEntityListInEntity(EntityListInEntity entity){
        return Result.success();
    }

    /**
     * id = 1
     * name = "bob"
     */
    @PostMapping(value="/doSimpleMap")
    public Result doSimpleMap(@RequestParam Map<String,String> map){
        return Result.success();
    }


    /**
     * map[id] = 1
     * map[name] = "bob"
     */
    @PostMapping(value="/doSimpleMapInEntity")
    public Result doSimpleMapInEntity(SimpleMapInEntity entity){
        return Result.success();
    }

    /**
     * map[car].id = 1
     * map[car].name = "bob"
     * map[fruit].id = 1
     * map[fruit].name = "apple"
     */
    @PostMapping(value="/doEntityMapInEntity")
    public Result doEntityMapInEntity(EntityMapInEntity entity){
        return Result.success();
    }

    /**
     * id = 1
     * name = "bob"
     * createDate = "2020-02-01"
     */
    @PostMapping(value="/doEntity")
    public Result doEntity(Entity entity) {
        return Result.success(entity);
    }

    /**
     * id = 1
     * name = "bob"
     * entity.id = "2"
     * entity.name = "dog"
     */
    @PostMapping(value="/doEntityInEntity")
    public Result doEntityInEntity(EntityInEntity entity) {
        return Result.success(entity);
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
        return Result.success(entity);
    }


    @PostMapping(value="/doMix",produces= MediaType.APPLICATION_JSON_VALUE)
    public Result doMix(@RequestBody DemoReqDTO param,
                        @RequestParam Map map,
                        @RequestHeader(value = "token", required = false) String token,
                        String string) {
        return Result.success(param);
    }


    @PostMapping(value="/doRequstAndResponse")
    public Result doRequstAndResponse(HttpServletRequest request, HttpServletResponse response){

        return Result.success();
    }

//    @ModelAttribute
//    public void preModel(int id, String name, Model model){
//        model.addAttribute(id);
//        model.addAttribute(name);
//    }
    @ModelAttribute
    public Result doModelMap(ModelMap modelMap){

        return Result.success();
    }

}
