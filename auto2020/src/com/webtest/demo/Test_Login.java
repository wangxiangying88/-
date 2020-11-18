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
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		if(flag) {
			webtest.click("xpath=//a[contains(text(),'�˳�')]");
		}
	}

//	6����¼�ɹ�
	@Test
	public void test6_Login() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'��Ա��¼')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(flag);
	}
	
//	7,����ʱ�����������
	@Test
	public void test7_Login() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'��Ա��¼')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(!flag);
	}
	
//	8����¼ʱ���������֤��
	@Test
	public void test8_Login() throws InterruptedException {
		loginout();
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_password", "12345678");
		webtest.type("name=captcha_code", "222222");
		webtest.click("xpath=//button[contains(text(),'��Ա��¼')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'�˳�')]");
		assertTrue(!flag);
	}
	
//	9���һ�����ɹ�
	@Test
	public void test9_FindPwd() throws InterruptedException {
		loginout();
		webtest.click("xpath=//a[contains(text(),'��Ա��������')]");
		Thread.sleep(2000);
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_email", "2567390854@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'�ύ�һ�����')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//h3[contains(text(),'�һ�����')]");
		assertTrue(flag);
	}
	
//	10,�һ�����ʱ��ʹ�ô����û���
	@Test
	public void test10_FindPwd() throws InterruptedException {
		loginout();
		webtest.click("xpath=//a[contains(text(),'��Ա��������')]");
		Thread.sleep(2000);
		webtest.type("name=user_name", "test");
		webtest.type("name=user_email", "2567390854@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'�ύ�һ�����')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'����')]");
		assertTrue(flag);
	}
	
//	11,�һ�����ʱ��ʹ�ô�������
	@Test
	public void test11_FindPwd() throws InterruptedException {
		loginout();
		webtest.click("xpath=//a[contains(text(),'��Ա��������')]");
		Thread.sleep(2000);
		webtest.type("name=user_name", "testuser");
		webtest.type("name=user_email", "25673@qq.com");
		webtest.type("name=captcha_code", "11111");
		webtest.click("xpath=//button[contains(text(),'�ύ�һ�����')]");
		Thread.sleep(2000);
		boolean flag=webtest.isDisplayed("xpath=//a[contains(text(),'����')]");
		assertTrue(flag);
		
	}
}
