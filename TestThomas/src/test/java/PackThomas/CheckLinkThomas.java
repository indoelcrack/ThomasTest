package PackThomas;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertTrue;

import javax.xml.crypto.dsig.SignedInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class CheckLinkThomas {

	WebDriver driver;
	Thomas page;
	
	By emailLocator = By.id("email");
	By passwordLocator = By.id("password") ;
	By signInLocator = By.cssSelector("button.btn.btn-primary.w-100.d-flex.justify-content-center");
	By supportLocator = By.linkText("Soporte");
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chrome driver/chromedriver.exe");
		driver = new ChromeDriver();
		page = new Thomas(driver);
		driver.get("https://v2.psicoalianza.com/soportes");
	}

	@Test(dataProvider = "authenticationData")
	public void login(String email, String password) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(emailLocator));
		
		driver.findElement(emailLocator).sendKeys(email);
		driver.findElement(passwordLocator).sendKeys(password);
		driver.findElement(signInLocator).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(supportLocator));
		
		driver.findElement(supportLocator).click();
		
		assertTrue(page.Thomass(), "Estos son Links Caidos");
	}
	
	@DataProvider(name = "authenticationData")
	public Object[][] getData() {
		Object[][]data = new Object[1][2];
		
		data[0][0]="14251103"; data[0][1]="123456789$$";
		
		return data;
	}
	

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
