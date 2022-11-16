package org.groupings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GroupingConcept {
	

	@Test(groups= {"integration testing"},dataProvider="data")
	private void SearchFunctions(String m) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.kogan.com/au/");
        driver.getCurrentUrl();
        driver.manage().window().maximize();
        
        driver.findElement(By.id("product-search-field")).sendKeys(m);
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	}
	
	    @DataProvider(name="data",indices={1})
	    public String[][] datatest() {
			return new  String [][]{
					{"Admin"},
					{"sony television"}
					


		};
	
	    }
}
