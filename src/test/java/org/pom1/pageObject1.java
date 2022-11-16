package org.pom1;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.pom.pageObjectModel;
import org.sample.baseClass;

public class pageObject1 extends baseClass {

	public static void main(String[] args) throws IOException {
		
		chromeBrowser();
		maximize();
		url("https://www.amazon.in/");
		
		pageObjectModel pom = new pageObjectModel();
		WebElement wb = pom.getSearchBox();
		passValue(wb, Excel("myOwn", "Sheet1", 2, 2));
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
