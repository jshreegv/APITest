package com.tests.CRUD;

import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.test.helpers.ReusableMethods;
import io.restassured.response.Response;
import com.test.basetest.BaseTest;

public class DeleteUserDataTest extends BaseTest{

	@Test
	public void deleteUser_TC() {
		Response res = LoginToApplication();
		user = ReusableMethods.getUserFromResponse();
		res = deleteUser();
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(5000L));
		res.then().body(containsString("success"));

	}
	
}
