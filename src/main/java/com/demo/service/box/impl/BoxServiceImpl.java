package com.demo.service.box.impl;

import com.demo.dao.box.BoxDao;
import com.demo.entity.box.Box;
import com.demo.service.base.impl.BaseServiceImpl;
import com.demo.service.box.BoxService;
import org.springframework.stereotype.Service;

@Service
public class BoxServiceImpl extends BaseServiceImpl<BoxDao, Box> implements BoxService {
}
