package com.actitime.genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.objectRepository.HomePage;
import com.actitime.objectRepository.LoginPage;

public class Baseclass {
	Filelibrary f = new Filelibrary();
	public static WebDriver driver;
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("dB is connected",true);
	}
	@BeforeClass
	public void launchbrowser() throws IOException {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String URL = f.readDataFromPropertyFile("url");
		driver.get(URL);
		Reporter.log("browser launched successfully",true);
	}
	@BeforeMethod
	public void login() throws IOException {
		String UN = f.readDataFromPropertyFile("username");
		String PW = f.readDataFromPropertyFile("password");
		LoginPage lp =new LoginPage(driver);
		lp.getUntbx().sendKeys(UN);
		lp.getPwtbx().sendKeys(PW);
		lp.getLgbtn().click();
		Reporter.log("login successfully",true);
	}@AfterMethod
	public void logout() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.getLgoutlnk().click();
		Reporter.log("Logout successfully",true);
	}
	@AfterClass
	public void closebrowser() {
		driver.close();
		Reporter.log("browser close successfully",true);
	}
	@AfterSuite
	public void databaseDisconnect() {
		Reporter.log("dB id disconnected",true);
	}
}
