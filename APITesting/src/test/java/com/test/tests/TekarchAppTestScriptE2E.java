package com.test.tests;

import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.test.basetest.BaseTest;
import com.test.models.UserObject;

import io.restassured.response.Response;

public class TekarchAppTestScriptE2E extends BaseTest{

	@Test(priority=0)
	public void login() {
		Response res = LoginToApplication();
		res.then().time(Matchers.lessThan(3000L));
		res.then().statusCode(201);
	}

	@Test
	public void testGetAllUser() {
		Response res = getUsers();
		res.then().statusCode(200);

	}

	@Test
	public void testAddUser() {

		Response res = addUser();
		res.then().statusCode(201);
		res.then().body(containsString("success"));
		
		List<UserObject> listUser = getAllUserData();

		for (UserObject u : listUser) {
			if (u.getAccountno().equalsIgnoreCase(user.getAccountno())) {
				user.setUserid(u.getUserid());
				user.setId(u.getId());

			}
		}

	}

	@Test(dependsOnMethods = { "testAddUser" })
	public void testDeleteUser() {

		Response res = deleteUser();
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(3000L));
		res.then().body(containsString("success"));

	}

	@Test(dependsOnMethods = { "testAddUser" }, priority = 1)
	public void testUpdateUser() {
		Response res = updateUser();
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(3000L));
		res.then().body(containsString("success"));

		
		List<UserObject> listUser = getAllUserData();
		for (UserObject u : listUser) {
			if (u.getAccountno().equalsIgnoreCase(user.getAccountno())) {
				System.out.println(u.toString());

			}
		}

	}
	
}
