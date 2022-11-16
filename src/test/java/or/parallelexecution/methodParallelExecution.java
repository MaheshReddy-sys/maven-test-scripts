package or.parallelexecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Return;

public class methodParallelExecution {


	@Test
	private void chrome() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.kogan.com/au/");
		driver.getCurrentUrl();
		driver.manage().window().maximize();

		driver.findElement(By.id("product-search-field")).sendKeys("sony tv");;
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();	
	}

	@Test(dataProvider = "ecommerce")
	private void chromeone(String m , String n) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.getCurrentUrl();
		driver.manage().window().maximize();

		driver.findElement(By.id("email")).sendKeys(m);;
		driver.findElement(By.id("pass")).sendKeys(n);
		driver.findElement(By.name("login")).click();

	}
	
	@DataProvider(name="ecommerce",indices= {1,1})
	private String [][] dataone() {
		return new String [][] {
			{"maheshgeethareddy@gmail.com","GBMreddy@721"},
			{"abcdefgh","61654154"}
		};
	}

}



