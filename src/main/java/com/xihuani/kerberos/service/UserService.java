package com.xihuani.kerberos.service;

import java.util.List;

import com.xihuani.kerberos.model.User;

public interface UserService {
	public List<User> getUserList();
	public User findUser(int userId);
	public void addUser(User user);
	public void deleteUser(Integer userId);
//	public void save(User user, int []rolesId);
}
