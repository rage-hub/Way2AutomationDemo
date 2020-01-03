package com.toolsqademosite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ToolsQADemo {
	
    WebDriver driver;
	Actions action;

	@Test(priority=0)
	public void launchBrowser() {

		String driverPath = "D://SeleniumMavenProject//Way2AutomationDemo//Browser_Driver//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		String appUrl="https://demoqa.com/";
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1, enabled=false)
	public void draganddrop() throws Exception{
		driver.findElement(By.xpath(".//a[@href='https://demoqa.com/droppable/']")).click();
		WebElement from = driver.findElement(By.xpath(".//div[@id='draggable']"));
		WebElement to =   driver.findElement(By.xpath(".//div[@id='droppable']"));
		action = new Actions(driver);
		Thread.sleep(5000);
		action.dragAndDrop(from, to).build().perform();
		Thread.sleep(5000);
		
	}
	
	@Test(priority=2, enabled=false)
	public void draggable() throws Exception{
		driver.findElement(By.xpath(".//a[@href='https://demoqa.com/draggable/']")).click();
		WebElement from=driver.findElement(By.xpath(".//div[@id='draggable']"));
		Thread.sleep(5000);
		action.dragAndDropBy(from, 100, 100).perform();
		Thread.sleep(5000);
		
	}
	
	@Test(priority=3, enabled=true)
	public void Resizable() throws Exception{
		
		driver.findElement(By.xpath(".//a[@href='https://demoqa.com/resizable/']")).click();
		Thread.sleep(6000);
		WebElement drag=driver.findElement(By.xpath(".//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		Actions act = new Actions(driver);
		act.clickAndHold(drag).moveByOffset(300, 100).release(drag).build().perform();
		Thread.sleep(8000);
		
		
	}
	
	@Test(priority=4)
	public void terminateBrowser(){
		driver.close();
	}

}
