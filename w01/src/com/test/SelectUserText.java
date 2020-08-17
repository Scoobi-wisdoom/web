package com.test;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

public class SelectUserText {

	public static void main(String[] args) {
		Db<String, User> db = 
				new UserDb("127.0.0.1","db","db");
		User user = null;
		//try �� �ȿ��� ���� try�� �ȿ��� �ۿ� ������. �׷��Ƿ� �� �ۿ��� ���� �����Ѵ�.
		try {
			user = db.select("id04");
			System.out.println(user);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}

	}

}
