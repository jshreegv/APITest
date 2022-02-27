package com.tests.CRUD;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import com.test.basetest.BaseTest;


public class GetUserDataTest extends BaseTest {

	@Test
	public void getAllUser_TC() {
		Response res = LoginToApplication();
		res = getUsers();
		res.then().statusCode(200);

	}
}
