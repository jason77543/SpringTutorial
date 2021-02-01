package com.ibm.springtutorail.PAS;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//@SpringBootTest
class TestsFailed {

	@BeforeAll
	public static void runsBeforeEverything() {
		System.out.println("Running a Test Class");
	}

	@Test
	void aTestMethodAssertingTrue() {
		System.out.println("Running assert");
		int num = Integer.parseInt("A");
		Assertions.assertTrue(true);
	}
	
	@Test
	public void seleniumTest() {
		System.out.println("seleniumTest Start");
		
		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\BrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Launch website
		driver.navigate().to("https://www.google.com/?hl=zh_tw");

		// Click on the search text box and send value
		driver.findElement(By.name("qqqq")).sendKeys("Hello World");

		// Click on the search button
		driver.findElement(By.name("btnK")).click();
		
		Assertions.assertTrue(true);
	}

	@AfterAll
	public static void runsAfterEverything() {
		System.out.println("Finished Running a Test Class");
	}

}
