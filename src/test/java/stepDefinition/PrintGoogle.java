package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.BaseClass;


public class PrintGoogle extends BaseClass {
	
	

@Given("User launch chrome browser")
public void user_launch_chrome_browser() {
    System.out.println("Launching chrome...");
    
 // System Property for Chrome Driver   
    System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");  
    ChromeOptions options = new ChromeOptions();
    //options.addArguments("--headless");
    //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
    
    // Instantiate a ChromeDriver class.     
    driver=new ChromeDriver(options);  
    System.out.println("After Launching chrome..."); 
    driver.manage().window().maximize();
    //driver.get("http://www.google.com");
     driver.get(System.getenv("appUrl").toString());
    
}

@When("User enter bdd in searcch box")
public void user_enter_bdd_in_searcch_box() {
	System.out.println("Searching in chrome...");
	driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("selenium webdriver", Keys.TAB);
	
}

@When("User click on search button")
public void user_click_on_search_button() throws InterruptedException {
	System.out.println("clicking in chrome...");
	
	driver.findElement(By.xpath("(//input[@name='btnK'])[1]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//input[@name='btnK'])[1]")));
	
	Thread.sleep(2000);
	

}



	

}
