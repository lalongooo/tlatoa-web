package com.xihuani.kerberos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xihuani.kerberos.model.User;
import com.xihuani.kerberos.service.UserService;

@Controller
@RequestMapping("api")
public class KerberosAPI {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "user/{userId}", method=RequestMethod.GET)
    @ResponseBody
    public User getById(@PathVariable Integer userId) {
		return userService.findUser(userId);
    }
     
    @RequestMapping(value="user", method=RequestMethod.POST)
    @ResponseBody
    public String saveUser(@RequestBody User user) {
    	userService.save(user);
        return "Saved user: " + user.getId();
    }
}
