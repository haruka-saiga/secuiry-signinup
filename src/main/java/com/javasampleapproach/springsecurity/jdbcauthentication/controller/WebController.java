package com.javasampleapproach.springsecurity.jdbcauthentication.controller;

import com.javasampleapproach.springsecurity.jdbcauthentication.UserForm;
import com.javasampleapproach.springsecurity.jdbcauthentication.Users;
import com.javasampleapproach.springsecurity.jdbcauthentication.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WebController {
   
    @RequestMapping(value="/")
    public String home(){
        return "home";
    }
   
    @RequestMapping(value="/user")
    public String user(){
        return "user";
    }
  
    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }
   
    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/register")
    public String sign(){
        return "register";
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @ModelAttribute
    UserForm userForm(){
        return new UserForm();
    }

    @RequestMapping(path="/execRegister", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute UserForm userForm){
        jdbcTemplate.update("INSERT INTO users (username, password) values (?, ?)", userForm.getUsername(), userForm.getPassword());
        jdbcTemplate.update("INSERT INTO user_roles (username, role) values (?, ?)", userForm.getUsername(), "ROLE_USER");

        return "redirect:/login";
    }

//    public String (){

//
//        return "sign";
//    }

    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }



}
