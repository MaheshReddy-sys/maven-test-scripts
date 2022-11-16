package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.sample.baseClass;

public class pageObjectModel extends baseClass {

	public pageObjectModel() {
		PageFactory.initElements(d, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBys({

			@FindBy(id = "nav-search-submit-button"), @FindBy(xpath = "//input[@type='submit']") })
	private WebElement startSearch;

	@FindAll({
		@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"),
		@FindBy(xpath="//span[text()='Apple iPhone 14 128GB Starlight']")	
	})
     private  WebElement iphone;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getStartSearch() {
		return startSearch;
	}

	public WebElement getIphone() {
		return iphone;
	}

}
