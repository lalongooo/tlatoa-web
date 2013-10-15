package com.xihuani.kerberos.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xihuani.kerberos.common.Constants;
import com.xihuani.kerberos.model.Role;
import com.xihuani.kerberos.model.User;
import com.xihuani.kerberos.service.RoleService;
import com.xihuani.kerberos.service.UserService;

@Controller
public class AccessLevelDirectoryController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/")
	public String home(Map<String, Object> map) {
		return "redirect:" + Constants.View.KERBEROS_USERS;
	}
	
	@RequestMapping("/users")
    public String listPeople(Map<String, Object> map) {
		
		map.put("user", new User());
		map.put("userList", userService.getUserList());
		map.put("users_nav_class","active");
		
		return Constants.View.KERBEROS_HOME_JSP;
    }
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result) {
		userService.addUser(user);
		return "redirect:" + Constants.View.KERBEROS_USERS;
	}
	
	@RequestMapping("/user/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);
		return "redirect:" + Constants.View.KERBEROS_USERS;
	}
	
	@RequestMapping("/roles")
    public String listRoles(Map<String, Object> map) {
		map.put("role", new Role());
		map.put("roleList", roleService.getRoleList());
		map.put("roles_nav_class","active");
		
		return Constants.View.KERBEROS_HOME_JSP;
    }
	
	@RequestMapping(value = "/role/add", method = RequestMethod.POST)
	public String addRole(@ModelAttribute("role") Role role, BindingResult result) {
		roleService.addRole(role);
		return "redirect:" + Constants.View.KERBEROS_ROLES;
	}
	
	@RequestMapping("/role/delete/{roleId}")
	public String deleteRole(@PathVariable("roleId") Integer roleId) {
		userService.deleteUser(roleId);
		return "redirect:" + Constants.View.KERBEROS_ROLES;
	}
	
	@RequestMapping("/access_level")
    public String listAccessLevel(HttpSession session,  @RequestParam(value = "name", required = false) String name, Map<String, Object> map) {
		name = name != null ? name : (String)session.getAttribute("name");
		session.setAttribute("name", name);
		map.put("name", name);
		map.put("roleList", roleService.getRoleList());
		map.put("userList", userService.getUserList());
		map.put("access_level_nav_class","active");
		
		return Constants.View.KERBEROS_HOME_JSP;
    }
	
	@RequestMapping(value = "/access_level/edit/{userId}", method = RequestMethod.POST)
	public String editRoles(@PathVariable("userId") Integer userId, @RequestParam(value = "roleId", required = false) Integer []roleId) {
		User user = userService.findUser(userId);
		List<Role> roles = roleService.findRole(roleId);
		user.setRoles(roles);
//		userService.save(user);
		return "redirect:" + Constants.View.KERBEROS_ACCESS_LEVEL;
	}
}
