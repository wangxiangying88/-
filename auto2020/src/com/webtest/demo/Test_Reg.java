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
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'�˳�')]");
		}
	}
//	1��ע��ɹ�
	@Test
	public void test1_reg() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser5");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "2567398@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("name=agreement");
		webtest.click("xpath=//button[contains(text(),'�ύע���û�')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(flag);
	}
	
//	2��ע�����볬���涨λ��
	@Test
	public void test2_reg() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser3");
		webtest.type("name=user_password", "1234567891011121314151617");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "2567398@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("name=agreement");
		webtest.click("xpath=//button[contains(text(),'�ύע���û�')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(!flag);
	}
	
//	3��ע��ʱʹ���Ѿ����ڵĻ�Ա��
	@Test
	public void test3_reg() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "25673989@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("name=agreement");
		webtest.click("xpath=//button[contains(text(),'�ύע���û�')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(!flag);
	}
	
//	4��ע��ʱ���������֤��
	@Test
	public void test4_reg() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser3");
		webtest.type("name=user_password", "1234567891011121314151617");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "2567398@qq.com");
		webtest.type("name=captcha_code", "22222");
		webtest.click("name=agreement");
		webtest.click("xpath=//button[contains(text(),'�ύע���û�')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(!flag);
	}
	
//	5,����ѡ��ע��Э�顱
	@Test
	public void test5_reg() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=user_com_passwd", "12345678");
		webtest.type("name=user_email", "25673989@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'�ύע���û�')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(!flag);
	}
}