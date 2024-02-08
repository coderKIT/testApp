package com.testApp.demo.Service;

import com.testApp.demo.Model.CourseDTO;
import com.testApp.demo.Model.CourseModel;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private CourseDTO courseDTO;
    String line = "";

    public void saveCourseData(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/data.csv"));
            br.readLine();//to ignore 1st line
////            while((line = br.readLine()) != null) {
////                String[] data = line.split(",");
////                CourseModel courseModel = new CourseModel();
////
////                courseModel.setEmployeeCode(Long.valueOf(data[0]));
////                courseModel.setName(data[1]);
////                courseModel.setEmail(data[2]);
////                courseModel.setPhoneNum(Integer.parseInt(data[3]));
////                courseModel.setCourseCode(data[4]);
////                courseModel.setGrade(data[5]);
////                courseModel.setLectureName(data[6]);
////                courseDTO.save(courseModel);
//
//            }
            sendEmail();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("testjavaemailsmtp@gmail.com");
        message.setTo("wongyuekitcsgo@gmail.com");
        message.setSubject("Subject of the Email");
        message.setText("Your CSV file has successfully uploaded!");

        this.mailSender.send(message);
        System.out.println("MAIL CREATED");
    }
}
