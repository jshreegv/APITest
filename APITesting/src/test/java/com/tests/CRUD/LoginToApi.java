package com.tests.CRUD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.test.basetest.BaseTest;

import io.restassured.response.Response;

public class LoginToApi extends BaseTest {

	@Test(priority = 0)
	public void login_TC() {
		Response res = LoginToApplication();
		res.then().time(Matchers.lessThan(3000L));
		res.then().statusCode(201);
	}
}
