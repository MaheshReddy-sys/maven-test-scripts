package org.amazon;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sample.baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonPractice {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.getCurrentUrl();
		driver.manage().window().maximize();
		
		
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("joackey for men innerware");
		
		WebElement clickBtn = driver.findElement(By.id("nav-search-submit-button"));
		clickBtn.click();
		
		WebElement secondWindow = driver.findElement(By.xpath("//span[text()='Mens Printed Trunks']"));
		secondWindow.click();
		
		
		Set<String> windowHandling = driver.getWindowHandles();
		for (String titles : windowHandling) {
			String allTitles = driver.switchTo().window(titles).getTitle();
			System.out.println(allTitles);
			if (titles.contains("Buy Jockey Men's Super Combed Cotton Elastane Stretch Printed Trunk with Ultrasoft Waistband")) {
				driver.switchTo().window(titles);
				
			}
			
		}
		
		WebElement secondWindow1 = driver.findElement(By.xpath("(//span[text()='3,703 ratings'])[1]"));
		secondWindow1.click();
		
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\mahes\\eclipse-workspace\\Selenium\\takesscreenshot\\amazon.png");
		FileUtils.copyFile(src, dest);
		
		WebElement dropdown = driver.findElement(By.id("native_dropdown_selected_size_name"));
		dropdown.click();
		
		Select st = new Select(dropdown);
		
		List<WebElement> alloptions = st.getOptions();
		for (WebElement dropoptions : alloptions) {
			String ss = dropoptions.getText();
			System.out.println(ss);
		}
		st.selectByVisibleText("M");
		Thread.sleep(3000);
		
		
		WebElement cartbtn = driver.findElement(By.id("add-to-cart-button"));
		cartbtn.click();
		
		WebElement cart = driver.findElement(By.id("nav-cart-count-container"));
		cart.click();
		Thread.sleep(5000);
		
		WebElement buyplace = driver.findElement(By.name("proceedToRetailCheckout"));
		buyplace.click();
		
		WebElement createacc = driver.findElement(By.id("createAccountSubmit"));
		createacc.click();
		Thread.sleep(3000);
		
		// creating details
		
		driver.findElement(By.name("customerName")).sendKeys("Mahesh Reddy");
		driver.findElement(By.id("ap_phone_number")).sendKeys("9159972794");
		driver.findElement(By.id("ap_password")).sendKeys("GBMreddy@721");
		driver.findElement(By.id("continue")).click();
		
		
		for (int i = 0; i <3; i++) {
			driver.navigate().back();
			
		}
		
		Actions act = new Actions(driver);
		
		WebElement signin = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		act.moveToElement(signin).perform();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("8328527642");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("GBMreddy@721");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
		
		
		// proceeding to buy
		
		driver.findElement(By.name("proceedToRetailCheckout")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='submit'])[6]")).click();
		
		
		
		
	}
	

	
	
	
	
	
	
	
	

}
