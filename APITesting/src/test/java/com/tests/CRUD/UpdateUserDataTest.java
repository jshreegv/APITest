package com.tests.CRUD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.test.helpers.ReusableMethods;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import com.test.basetest.BaseTest;
import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;
import io.restassured.response.Response;

public class UpdateUserDataTest extends BaseTest {

	@Test
	public void updateUser_TC() {

		Response res = LoginToApplication();
		user = ReusableMethods.getUserFromResponse();
		res=updateUser();
		res.then().statusCode(200);
		res.then().time(Matchers.lessThan(3000L));
		res.then().body(containsString("success"));

		
	}
}
