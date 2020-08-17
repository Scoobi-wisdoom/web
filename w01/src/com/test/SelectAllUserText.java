package com.test;

import java.util.ArrayList;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

public class SelectAllUserText {

	public static void main(String[] args) {
		Db<String, User> db = 
				new UserDb("127.0.0.1","db","db");
		ArrayList<User> list = null;
		//try �� �ȿ��� ���� try�� �ȿ��� �ۿ� ������. �׷��Ƿ� �� �ۿ��� ���� �����Ѵ�.
		try {
			list = db.select();
			for(User u:list) {
				System.out.println(u);
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}

	}

}
