package org.testng1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTestNG {
	
	
		@Test(dataProvider="mahesh")
		private void OrangeHrm(String m , String n) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");
			driver.getCurrentUrl();
			driver.manage().window().maximize();
			
			driver.findElement(By.id("email")).sendKeys(m);
			driver.findElement(By.id("pass")).sendKeys(n);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(5000);
			driver.quit();
			
			
		}
			
			@DataProvider(name = "mahesh",indices={1,1})
			public String[][] data() {
			return new String [][] {
				
				{"Admin" , "admin123"},
				{"maheshgeethareddy@gmail.com", "GBMreddy@721"}

			};
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
