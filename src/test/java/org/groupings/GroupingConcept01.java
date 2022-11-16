package org.groupings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GroupingConcept01 {

	
	    @Test(groups= {"sanity"})
	    private void MoveActivity() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.kogan.com/au/");
        driver.getCurrentUrl();
        driver.manage().window().maximize();
        
        Actions act = new Actions(driver);
	
	    WebElement wb =  driver.findElement(By.xpath("//span[text()='New Zealand']"));
	    wb.click();
	
	
	
	
	}
}
