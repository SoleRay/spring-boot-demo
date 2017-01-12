package com.demo.listener;


import com.demo.util.prop.PropUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Arthur on 2016/12/15 0015.
 */
@WebListener
public class PropInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        PropUtil.loadProperties("properties/admin.properties");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
