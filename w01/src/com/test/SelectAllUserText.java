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
		//try 문 안에서 쓰면 try문 안에서 밖에 못쓴다. 그러므로 꼭 밖에서 먼저 선언한다.
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
