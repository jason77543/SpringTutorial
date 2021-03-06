package com.ibm.springtutorail.PAS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


class TestsSuccess {

	@BeforeAll
	public static void runsBeforeEverything() {
		System.out.println("Running a Test Class");
	}

	@Test
	void aTestMethodAssertingTrue() {
		System.out.println("Running assert");
		Assertions.assertTrue(true);
	}

	@AfterAll
	public static void runsAfterEverything() {
		System.out.println("Finished Running a Test Class");
	}
	
	
	
	
	@Test
	public void testAddNum() {
		System.out.println("testAddNum Start");
		int ans = addNum(1,1);
		assertEquals(2, ans);
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
		driver.findElement(By.name("q")).sendKeys("Hello World");

		// Click on the search button
		driver.findElement(By.name("btnK")).click();
		
		Assertions.assertTrue(true);
	}
	
	public int addNum(int a,int b) {
		return a+b;
	}
}
