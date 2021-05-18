package SeleniumKurs.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import SeleniumKurs.pages.SeleniumKursLoginPage;

public class TestLoginSeleniumChrome {
 WebDriver  driver;
	@Before
	public void setUp() throws Exception {
		
		System.out.println("Initialisiere Webdriver");
		System.setProperty("webdriver.chrome.driver", "C:\\WebserverTA\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich r�ume");
		//driver.close();
	}

	@Test
	public void testLogin() {
System.out.println("Starte Test Login mit Fehlschlag");
		
		//Arrange
		
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42", "R5vxI0j60");

		//Act
		loginPage.loginButtonAnklicken();

		//Assert
		
		String erfolgsMeldung = loginPage.statusMeldungAuslesen();
		assertTrue(erfolgsMeldung.contains("Willkommen"));
	}
}
