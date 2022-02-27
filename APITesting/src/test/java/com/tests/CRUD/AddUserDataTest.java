package com.tests.CRUD;

import static org.hamcrest.CoreMatchers.containsString;
import org.testng.annotations.Test;
import com.test.helpers.UserServiceHelper;
import io.restassured.response.Response;
import com.test.basetest.BaseTest;

public class AddUserDataTest extends BaseTest {	

		@Test
		public void addUser_TC() {
			Response res = LoginToApplication();
			res = addUser();
			res.then().statusCode(201);
			res.then().body(containsString("success"));

		}
	
	
}
