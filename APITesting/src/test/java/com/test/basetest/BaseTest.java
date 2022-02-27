package com.test.basetest;

import org.testng.annotations.BeforeClass;
import com.test.helpers.UserServiceHelper;
import io.restassured.RestAssured;

public class BaseTest extends UserServiceHelper {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = getBaseURI();
	}
}
