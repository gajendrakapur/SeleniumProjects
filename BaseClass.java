package org.JavaP.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
 	    // Declaring WebDriver
		protected WebDriver driver;
			
		@BeforeMethod
		public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","F:\\Regression\\Selenium\\Drivers\\ChromeDriver_77\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.get("https://www.naukri.com");
		// driver.get("https://www.snapdeal.com");
		
		}
		
		@AfterMethod
		public void quitBrowser() throws InterruptedException {
		Thread.sleep(10000);	
	    driver.quit();
		
		}
		
		public void clickOn(By byLocator) {
			WebElement element = driver.findElement(byLocator);
			element.click();
			}
		 public void typeKeyword(By byLocator, String keyword) {
			 WebElement element = driver.findElement(byLocator);
			 element.clear();
			 element.sendKeys(keyword);
				 
		 }
}

