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


public class Test_Reg extends BaseTest{
	
	public void loginout() {
		webtest.open("http://localhost:86/user/register");
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'退出')]");
		}
	}
//	1，注册成功
	@Test
	public void test1_reg() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser5");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "2567398@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("name=agreement");
		webtest.click("xpath=//button[contains(text(),'提交注册用户')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(flag);
	}
	
//	2，注册密码超过规定位数
	@Test
	public void test2_reg() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser3");
		webtest.type("name=user_password", "1234567891011121314151617");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "2567398@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("name=agreement");
		webtest.click("xpath=//button[contains(text(),'提交注册用户')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(!flag);
	}
	
//	3，注册时使用已经存在的会员名
	@Test
	public void test3_reg() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "25673989@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("name=agreement");
		webtest.click("xpath=//button[contains(text(),'提交注册用户')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(!flag);
	}
	
//	4，注册时输入错误验证码
	@Test
	public void test4_reg() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser3");
		webtest.type("name=user_password", "1234567891011121314151617");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "2567398@qq.com");
		webtest.type("name=captcha_code", "22222");
		webtest.click("name=agreement");
		webtest.click("xpath=//button[contains(text(),'提交注册用户')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(!flag);
	}
	
//	5,不勾选“注册协议”
	@Test
	public void test5_reg() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "25673989@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'提交注册用户')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'退出')]");
		assertTrue(!flag);
	}
}