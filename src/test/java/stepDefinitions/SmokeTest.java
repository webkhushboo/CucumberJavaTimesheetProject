package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {

	WebDriver driver;
    private static WebDriverWait wait;
    
	@Given("^Open chrome and start application$")
	public void Open_chrome_and_start_application() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new  WebDriverWait(driver,30);
		driver.get("https://allegis.ramcocloud.com/RVW/extui/vwrt/LaunchPanel.htm");
		System.out.println("Page open url:" + driver.getCurrentUrl());
	}

	@When("^^I enter valid \"(.*?)\" and valid \"(.*?)\"$")
	public void I_enter_valid_username_and_valid_password(String username,String password)  {
		driver.switchTo().frame(driver.findElement(By.name("ilboinnerframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ide_username']")));
		driver.findElement(By.xpath("//*[@id='ide_username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='ide_password']")).sendKeys(password);

	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login() throws Throwable {
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		Thread.sleep(5000);
	}
	
	@Then("^Click on Manage Time$")
	public void click_on_manage_time() throws Throwable {
		driver.switchTo().frame(driver.findElement(By.name("ilboinnerframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='BOOK_LINK_ROW_003_COL_001_TABLE']")));
		driver.findElement(By.xpath("//table[@id='BOOK_LINK_ROW_003_COL_001_TABLE']//*[@class='essTailLink'][.='Manage Time']")).click();
		Thread.sleep(5000);
	}
	
	@Then("^Click on previous week$")
	public void click_on_previos_week() throws Throwable {
		//driver.switchTo().frame(driver.findElement(By.name("ilboinnerframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='timesheet displayBlock x-datalist-item-box1'][last()]")));
		driver.findElement(By.xpath("//*[@class='timesheet displayBlock x-datalist-item-box1'][last()]")).click();
		Thread.sleep(5000);
	}
	
	@Then("^Click on last date of previous week$")
	public void click_on_last_date_of_previous_week() throws Throwable {
		//driver.switchTo().frame(driver.findElement(By.name("ilboinnerframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='GRID_SEC_ROW_001_COL_001_TABLE']//*[@class='x-grid3-viewport']//*[@class='x-grid3-row '][5]//div")));
		driver.findElement(By.xpath("//*[@id='GRID_SEC_ROW_001_COL_001_TABLE']//*[@class='x-grid3-viewport']//*[@class='x-grid3-row '][5]//div")).click();
		Thread.sleep(5000);
	}
	
	@Then("^Click on copy time$")
	public void click_on_copy_time() throws Throwable {
		//driver.switchTo().frame(driver.findElement(By.name("ilboinnerframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='span_copytime_link']")));
		driver.findElement(By.xpath("//*[@id='span_copytime_link']")).click();
		Thread.sleep(5000);
	}
	
	@Then("^Click on submit button$")
	public void click_on_submit_button() throws Throwable {
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.name("childilboinnerframe")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='x-btn-text x-form-buttontext']")));
		driver.findElement(By.xpath("//*[@class='x-btn-text x-form-buttontext']")).click();
		Thread.sleep(5000);
	}
	
	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}
	
	
	

}
