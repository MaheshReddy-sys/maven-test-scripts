package org.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	public static WebDriver d;
	public static Actions act;
	public static Robot rt;
	public static JavascriptExecutor js;
	public static Alert al;
	public static Select st;
	public static TakesScreenshot tk;
	

	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
	}
	public static void firefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		d = new FirefoxDriver();
	}
	public static void edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		d = new EdgeDriver();
	}
	public static void url(String url) {
		d.get(url);
	}
	public static void currentUrl() {
		d.getCurrentUrl();
	}
	public static String getTitle() {
		String t = d.getTitle();
		return t;
	}
	public static void maximize() {
		d.manage().window().maximize();
	}
	public static void minimize() {
		d.manage().window().minimize();
	} 
	public static void window() {
		d.getWindowHandle();	
	}
	public static void windows() {
		d.getWindowHandles();	
	}
	
	// WEB ELEMENT ACTIONS Return type of FIND ELEMENT
	
	public static void passValue(WebElement ele , String s) {
		ele.sendKeys(s);
	}
    public static void click(WebElement ele) {
		ele.click();
	}
    public static void gettxt(WebElement ele) {
	    ele.getText();	
	}
	
    // ACTIONS - CLASS
    
    public static void moveEle(WebElement ele) {
    	act = new Actions(d);
		act.moveToElement(ele).perform();
	}
    public static void upDown(WebElement ele, String s) {
		act = new Actions(d);
		act.keyDown(ele,Keys.SHIFT).sendKeys(ele, s).keyUp(ele,Keys.SHIFT).perform();
	}
	public static void twiceClick(WebElement ele) {
		act = new Actions(d);
		act.doubleClick(ele);
	}
	public static void conClick(WebElement ele) {
		act = new Actions(d);
		act.contextClick(ele);
	}
	public static void dragDrop(WebElement src, WebElement dest) {
		act = new Actions(d);
		act.dragAndDrop(src,dest);
	}
	
	// ROBOT CLASS
	
	public static void cutCopy() throws AWTException {
		rt = new Robot();
		rt.keyPress(KeyEvent.VK_TAB);
		rt.keyRelease(KeyEvent.VK_TAB);
		
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_COPY);
		
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_V);

	}
	
	// JAVASCRIPT EXECUTOR
	
	public static void insertValue( WebElement ele, String ss) {
		js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].setAttribute('value','"+ss+"')",ele);
	}
	public static void getValue( WebElement ele) {
		js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].getAttribute('value')",ele);
	}
	
	public static void scrollDown(WebElement ele) {
		js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView(true)",ele);
	}
	public static void scrollUp(WebElement ele) {
		js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView(false)",ele);
	}
	
	// DROP DOWNS 
	
	public static void dropDownstxt(WebElement ele, String ss1) {
		st = new Select(ele);
		st.selectByVisibleText(ss1);
	}
	public static void dropDownsvalue(WebElement ele , String ss2) {
		st = new Select(ele);
		st.selectByValue(ss2);
	}
	public static void dropDownIndex(WebElement ele , int in) {
		st = new Select(ele);
	    st.selectByIndex(in);
	}
	
	
	// Data Driven 
	
	public static String Excel(String fname , String shname ,  int row , int colum) throws IOException {
		
		File f = new File("C:\\Users\\mahes\\eclipse-workspace\\mavenProject\\external excel\\"+fname+".xlsx");
		
		FileInputStream fn = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fn);
		Sheet sh = wb.getSheet(shname);
		Row rw = sh.getRow(row);
		Cell c = rw.getCell(colum);
		
		// to know what kind of cell it is 
		String val;
		
		int type = c.getCellType();
		if (type ==1) {
			val = c.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			     Date d = c.getDateCellValue();
			     SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			     val = sim.format(d);	
		}
		// to get numeric values 
		else {
			double dd = c.getNumericCellValue();
			Long h =(long)dd;
			 val = String.valueOf(h);
		}
		return val;
	}
	
	// POM  framework especially for LOCATORS
	
	
	
	
	
	
	
	
	
}
	
	
	
	

	
	
	
	
	
	
	
	
	

	

	
	
	

