package com.test;

import com.biz.UserDb;
import com.frame.Db;
import com.vo.User;

public class DeleteUserText {

	public static void main(String[] args) {
		Db<String, User> db = 
				new UserDb("127.0.0.1","db","db");
//		String id = new String("id88");
		try {
			db.delete("id02");
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}

	}

}
