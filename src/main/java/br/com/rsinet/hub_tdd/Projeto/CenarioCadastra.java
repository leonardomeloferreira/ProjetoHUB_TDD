package br.com.rsinet.hub_tdd.Projeto;

import static junit.framework.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Register_Action;
import junit.framework.Assert;

public class CenarioCadastra {
		private static ChromeDriver driver;

	@BeforeClass
	public static void iniciaNavegador() {
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	
	@Test
	public void inciaTeste() {
		driver.get("https://www.advantageonlineshopping.com/#/");
		
		Register_Action.Execute(driver);
		
		assertEquals("http://advantageonlineshopping.com/#/", driver.getCurrentUrl());
	}
	
	@Test
	public void inciaTesteComFalha() {
		driver.get("https://www.advantageonlineshopping.com");
		
		Register_Action.ExecuteFalha(driver);
		
		assertEquals("http://advantageonlineshopping.com/#/register", driver.getCurrentUrl());
	}
	
	@AfterClass
	public static void fechaNavegador() {
		driver.quit();
	}
}
