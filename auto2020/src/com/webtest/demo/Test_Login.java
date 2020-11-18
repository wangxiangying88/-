package com.webtest.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;



public class Test_Login extends BaseTest{

	public void loginout() {
		webtest.open("http://localhost:86/user/login");
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'退出')]");
		}
	}

//	6，登录成功
	@Test
	public void test6_Login() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'会员登录')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(flag);
	}
	
//	7,登入时输入错误密码
	@Test
	public void test7_Login() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'会员登录')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(!flag);
	}
	
//	8，登录时输入错误验证码
	@Test
	public void test8_Login() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=captcha_code", "222222");
		webtest.click("xpath=//button[contains(text(),'会员登录')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(!flag);
	}
	
//	9，找回密码成功
	@Test
	public void test9_FindPwd() throws InterruptedException {
		loginout();
		webtest.click("xpath=//a[contains(text(),'会员忘记密码')]");
		Thread.sleep(2000);
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_email", "2567390854@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'提交找回密码')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//h3[contains(text(),'找回密码')]");
		assertTrue(flag);
	}
	
//	10,找回密码时，使用错误用户名
	@Test
	public void test10_FindPwd() throws InterruptedException {
		loginout();
		webtest.click("xpath=//a[contains(text(),'会员忘记密码')]");
		Thread.sleep(2000);
		webtest.type("name=user_name", "test");
		webtest.type("name=user_email", "2567390854@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'提交找回密码')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'返回')]");
		assertTrue(flag);
	}
	
//	11,找回密码时，使用错误邮箱
	@Test
	public void test11_FindPwd() throws InterruptedException {
		loginout();
		webtest.click("xpath=//a[contains(text(),'会员忘记密码')]");
		Thread.sleep(2000);
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_email", "25673@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'提交找回密码')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'返回')]");
		assertTrue(flag);
		
	}
}
