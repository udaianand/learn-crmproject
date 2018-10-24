package com.freecrm.qa.util;

import java.util.HashMap;

import com.freecrm.qa.base.TestBase;

public class UserCredentails extends TestBase {

	// based on the key of Key-Value Pair in Map Object (UserRole) login in the web
	// Application under test using the value of Key-Value Pair in Map
	// Object(username@password) Ex add("admin","admin1@password123")
	// Split username and password using split

	public HashMap<String, String> userData() {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("admin", "adminuser541@test123 ");
		hm.put("emp1", "empuser681@test123 ");
		hm.put("emp2", "empuser682@test123 ");
		hm.put("emp3", "empuser683@test123 ");
		hm.put("bidder", "buyer@password123");

		return hm;

	}

	public String[] loginAsUserRole(String userRole) {

		UserCredentails l1 = new UserCredentails();
		String credentials = l1.userData().get(userRole);
		String[] userCredential = credentials.split("@");
		return userCredential;

	}

	public HashMap<String, String> getUserDisplayName() {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("admin", "Vasu vasuveera");
		hm.put("emp1", "Raju V");
		hm.put("emp2", "Peter Johnson");
		hm.put("emp3", "Haritha B");

		return hm;

	}

}
