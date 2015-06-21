package com.xihuani.system.service;

import java.util.List;

import com.xihuani.system.model.User;

public interface UserService {
	public List<User> getUserList();
	public User findUser(int userId);
	public void addUser(User user);
	public void deleteUser(Integer userId);
	public void save(User user);
}
