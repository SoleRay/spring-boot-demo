package com.demo.controller.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.helpers.BasicMarker;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("logging")
public class LoggingController {

    @GetMapping("manylog")
    public void manylog(@RequestParam(name="count",defaultValue = "1000") int count){

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        IntStream.rangeClosed(1,count).forEach(i->{
            log.info("log-{}",i);
        });
        stopWatch.stop();
        Marker marker = MarkerFactory.getMarker("time");
        log.info(marker,"cost time {}",stopWatch.getTotalTimeMillis());

    }
}
