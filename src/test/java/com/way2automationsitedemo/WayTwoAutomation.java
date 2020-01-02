package com.way2automationsitedemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WayTwoAutomation {

	public static WebDriver driver;

	// Create an object of SoftAssert
	SoftAssert softassert = new SoftAssert();

	@Test(priority = 0, enabled = true)
	public void launchBrowser() {
		String path = System.getProperty("user.dir");
		String driverPath = path + ".\\browserdriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		/*
		 * String driverPath=
		 * "K://SeleniumMavenProject//Way2AutomationDemo//browserdriver//chromedriver.exe";
		 * System.setProperty("webdriver.chrome.driver", driverPath);
		 */
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1, enabled = true)
	public void launchApplication() { 	

		driver.get("http://way2automation.com/way2auto_jquery/alert.php");
		String actualTitle = driver.getTitle();
		String ecpectedTitle = "Welcome to the Test Site";
		System.out.println("Actual Page Title - " + driver.getTitle());
		// Assert.assertEquals(actualTitle, ecpectedTitle);
		softassert.assertEquals(actualTitle, ecpectedTitle);
		softassert.assertAll();
	}

	@Test(priority = 2, enabled = true)
	public void signInApp() {

		driver.findElement(By.xpath("//a[contains(text(),'Signin')]")).click();
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset[1]/input[@name='username']")).sendKeys("bkunwar");
		driver.findElement(By.xpath("//*[@id='load_form']/fieldset[2]/input[@name='password']")).sendKeys("admin@123");
		driver.findElement(By.xpath("//div[@id='login']/form/div/div[2]/input[@type='submit']")).click();

	}

	@Test(priority = 3, enabled = true)
	public void closeBrowser() {
		driver.close();
	}

}
