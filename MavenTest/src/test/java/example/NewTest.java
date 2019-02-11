package example;		
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.google.common.io.Files;

public class NewTest {		
	public String baseUrl = "https://twitter.com/?lang=en";
    String driverPath = "D:\\Library\\chromedriver.exe";    
	public WebDriver driver; 
	
	@BeforeTest
	  public void launchBrowser() {
	      System.out.println("Launching Chrome browser"); 
	      System.setProperty("webdriver.chrome.driver", driverPath);
	      driver= new ChromeDriver();
	      driver.get(baseUrl);
	  }
	  
	  @Test(priority = 0)
	  public void login(){
	  // Click on Login link 
		  driver.findElement(By.linkText("Log in")).click();
		  System.out.println("Login button is clicked.");
	  } 
	  
	  @Test(priority = 1)
	  public void username(){
		// Type UserName in the UserName text box 
				driver.findElement(By.className("js-username-field")).sendKeys("zeelaa10"); 
				System.out.println("Username is entered.");
	  } 
	  
	  @Test(priority = 2)
	  public void password(){
		//Type Password in the Password text box
				driver.findElement(By.className("js-password-field")).sendKeys("zeelaa1234"); 
				System.out.println("Password is entered. ");
	  } 
	  
	  @Test(priority = 3)
	  public void loginButton(){
		// Click on the Login button
				driver.findElement(By.className("EdgeButtom--medium")).click(); 
				System.out.println("Login button is submitted.");
	  } 
	  
	  @Test(priority = 4)
	  public void wait1() throws InterruptedException{
		//Wait
				Thread.sleep(3000);
	  } 
	  
	  @Test(priority = 5)
	  public void tweet(){
		//Find the Tweet Box and enter the Tweet Hello World 
				driver.findElement(By.id("tweet-box-home-timeline")).sendKeys("Selenium Testing 12"); 
				System.out.println("New tweet is posted.");
	  } 
	  
	  @Test(priority = 6)
	  public void tweetButton(){
		//Click on Tweet Button
				driver.findElement(By.xpath(".//button[@class='tweet-action EdgeButton EdgeButton--primary js-tweet-btn']")).click(); 
				System.out.println("Tweet button is clicked.");
	  } 
	  
	  @Test(priority = 7)
	  public void wait2() throws InterruptedException{
		//Wait
				Thread.sleep(2000);
	  } 
	  
	  @Test(priority = 8)
	  public void screenshot() throws IOException{
		// Take Screenshot for Evidence
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
				System.out.println("Screenshot is taken.");

				// Save the screenshot in the given path by the name Tweet.png
				Files.copy(src, new File("C:/Users/Blueninja.io/eclipse-workspace/TwitterScreenshots/Tweet12.png")); 
				System.out.println("Screenshot is saved.");
	  } 
	  
	  @Test(priority = 9)
	  public void dropdown1(){
		//Click on Profile and Settings
				driver.findElement(By.id("user-dropdown-toggle")).click(); 
				System.out.println("Profile and Setting icon is clicked.");
	  } 
	  
	  @Test(priority = 10)
	  public void wait3(){
		new WebDriverWait(driver, 15);
	  } 
	  
	  @Test(priority = 11)
	  public void logout(){
		
			//Wait and Click Logout Button
		  WebDriverWait wait = new WebDriverWait(driver, 15);
		  wait.until(ExpectedConditions.elementToBeClickable(By.id("signout-button"))).click(); 
		    System.out.println("Logout navigation button is clicked.");
	  }


	@AfterTest
	  public void terminateBrowser(){
	      driver.close(); 
	      System.out.println("Chrome browser is closed.");
	  }		
}
