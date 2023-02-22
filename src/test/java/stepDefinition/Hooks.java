package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import  io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BaseClass;


public class Hooks extends BaseClass{
	
	@Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
    }	
	
	@After
	public void before_or_after(io.cucumber.java.Scenario sc) {
	    System.out.println("This will run after the Scenario");
	  
	    if (sc.isFailed()) {
	    TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        
	    sc.attach(screenshot, "image/png", "taking screenshot...");
	    driver.close();
	    
	    }else {
	    	 TakesScreenshot ts = (TakesScreenshot) driver;
	         byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
	 	    sc.attach(screenshot, "image/png", "Screenshot attached");
	 	   driver.close();
	    }
	    
		 
	}
}
