package com.testApp.demo.Controller;

import com.testApp.demo.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Service courseService;

    @RequestMapping(path="/importCourseData")
    public void importCourseDataToDB(){
        courseService.saveCourseData();
    }
}
