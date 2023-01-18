package com.revature.dao;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;

public interface UserDao {
	static List<User>UserInfo=new ArrayList<>();
	public void getUser();
	public void DisplayUser();
}
