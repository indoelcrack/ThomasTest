package PackThomas;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class CheckLinkThomas {

	WebDriver driver;
	Thomas page;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chrome driver/chromedriver.exe");
		driver = new ChromeDriver();
		page = new Thomas(driver);
		driver.get("https://tgscolombia.com/");
	}

	@Test
	public void f() {
		assertTrue(page.Thomass(), "Estos son Links Caidos");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
