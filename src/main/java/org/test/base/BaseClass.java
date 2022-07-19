package org.test.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;

	public static WebDriver chromelaunch() {
		
    WebDriverManager.chromedriver().setup();
	
	driver = new ChromeDriver();
	return driver;
	
	}
	//url Launch
	public static void urlLaunch(String url) {
		driver.get(url);

    }
	//sendkeys
	public static void sendkeys(WebElement e, String data) {
		e.sendKeys(data);
	}
	
	//implicit wait
	public static void impWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		
	}
	
	//click
	public static void click(WebElement e) {
		e.click();
		
	}	
    
	//quit
		public static void quit() {
			driver.quit();
		}
		
	//Current Url
		
		public static void currenturl(String currentUrl) {
			driver.getCurrentUrl();
		}
		
	//get Close
		
		public static void getClose() {
			driver.close();
		}
	
	//Actions
	public static void moveToElement(WebElement target) {
		Actions a = new Actions(driver);
		
		a.moveToElement(target).perform();
	}
	
	public static void actClick(WebElement target) {
		Actions a = new Actions(driver);
		
		a.click(target).perform();

	}
	
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions a = new Actions(driver);

        a.dragAndDrop(from, to).perform();
	
	}
	
	public static void clickAndHold(WebElement from, WebElement to) {
		Actions a = new Actions(driver);
	   
		a.clickAndHold(from).moveToElement(to).release().perform();
	
	}
	
	public static void context(WebElement target) {
		Actions a = new Actions(driver);
		
		a.contextClick(target).perform();
	}
	
	public static void doubleClick(WebElement target) {
		Actions a = new Actions(driver);
		
		a.doubleClick(target).perform();
	}
	
	//Alert
	public static void simpleAlert() {
		Alert al = driver.switchTo().alert();
		
		al.accept();
	}
	
	public static void confirmAlert() {
		Alert confirm = driver.switchTo().alert();
		
		confirm.dismiss();

	}
	
	public static void promtAlert(String data) {
		Alert promt = driver.switchTo().alert();
		
		promt.sendKeys(data);
		
		promt.accept();
	}
	
	//Javascript
	public static void javascriptsendkeys(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
	    js.executeScript("arguments[0].setAttribute('value','data')", target);
	
	}
	
	public static void javascriptClick(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
	    js.executeScript("arguments[0].click()", target);
	
	}
	
	public static void javascriptgetAttribute(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
	    js.executeScript("return arguments[0].getAttribute('value')", target);
	
	}
	
	public static void javascriptscrollDown(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
	    js.executeScript("arguments[0].scrollIntoView(true)", target);
	
	}
	
	public static void javascriptscrollUp(WebElement target) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
	    js.executeScript("arguments[0].scrollIntoView(false)", target);
	
	}
	
	//Frames
	public static void frameStringid(String id) {
	
		driver.switchTo().frame(id);

	}
	
	public static void frameStringName(String name) {
		
		driver.switchTo().frame(name);
	
	}
	
    public static void frameWebelementName(WebElement data) {
		
		driver.switchTo().frame(data);
	
	}
	
    public static void frameIndex(String index) {
		
		driver.switchTo().frame(index);
	
	}
	
	//Navigate
    public static void navigateUrl(String url) {
		driver.navigate().to(url);

	}
    
    public static void navigateBack() {
		driver.navigate().back();
    
    }
    
    public static void navigateForward() {
		driver.navigate().forward();
    
    }
    
    public static void navigateRefresh() {
		driver.navigate().refresh();
    
    }
    
    //WINDOWS HANDLNG
	public static void windowsHandling(int index) {
		Set<String> allid = driver.getWindowHandles();
		System.out.println(allid);
		List<String> li=new ArrayList<>();
		li.addAll(allid);
		driver.switchTo().window(li.get(index));
		
	}
    
    //Screenshot
    public static void screenshot(String name) throws IOException {
		
    	 TakesScreenshot ts = (TakesScreenshot)driver;
    	 
    	 File from = ts.getScreenshotAs(OutputType.FILE);
    	 
    	 File to = new File("C:\\Users\\Bhuvaneshwari\\eclipse-workspace\\MavenProjectJune"+name+"\\ScreenShot.png");
    	 
    	 FileUtils.copyFile(from, to);
	}
    
   
  //DROP DOWN
  	// SELECT BY INDEX
  	public static void selectByIndex(WebElement e, int index) {
  		Select s=new Select(e); s.selectByIndex(index);
  	}
  	
  		//SELECT BY VALUE
  	public static void selecrByValue(WebElement e, String value) {
  		Select s=new Select(e); s.selectByValue (value);
  	}
  	
  	//SELECT BY VISIBLE TEXT
  	public static void selectByVisibleText(WebElement e, String text) {
  		Select s=new Select(e); s.selectByVisibleText(text);
  	}

  	//IS MULTIPLE
  	public static void isMultiple(boolean b) {
  		isMultiple(b);
  	}

  	//GET FIRST SELECTED OPTION
  	public static void getFirstSelectedOptions (WebElement e) {
  		Select s=new Select(e); s.getFirstSelectedOption();
  	}
  	
  	//GET ALL SELECTED OPTIONS
  	public static void getallselectedOptions1 (WebElement e) {
  		Select s=new Select(e);
  		s.getAllSelectedOptions();
  	}
  	
  	//GET ALL SELECTED OPTIONS
  	public static void getallselectedOptions (WebElement e) {
  	Select s=new Select(e);
  	s.getAllSelectedOptions();
  	}
  	
  	//DESELECT BY INDEX
  	public static void deSelectByIndex (WebElement e, int index) {
  	Select s=new Select(e);
  	s.deselectByIndex(index);
  	}
  	
  	//DESELECT BY VALUE
  	public static void deSelectByValue(WebElement e, String value) {
  	Select s=new Select(e); s.deselectByValue(value);
  	}
  	
  	//DESELECT BY VISIBLE TEXT
  	public static void deSelectByVisibleText(WebElement e, String text) {
  	Select s=new Select(e); s.deselectByVisibleText(text);
  	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}