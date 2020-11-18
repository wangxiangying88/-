package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.net.URL;

import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;



public class Admin_Test extends BaseTest{
	@BeforeClass
	public void admin() {
		webtest.open("http://localhost:86/admin");
		webtest.type("name=user_name", "admin");
		webtest.type("name=user_passwd", "12345678");
		webtest.click("xpath=//button[contains(text(),'后台登录')]");
	}
	
	@Test
	public void test3() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'商品管理')]");
	}
	

}
