package com.demo.controller.box;

import com.demo.anno.ResponseResult;
import com.demo.entity.box.Box;
import com.demo.service.box.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResult
@RequestMapping("/box")
public class BoxController {

    @Autowired
    private BoxService boxService;

    @PostMapping(value="/selectBox")
    public Box selectBox(Integer id){
        Box box = boxService.selectByPrimaryKey(id);
        return box;
    }
}
