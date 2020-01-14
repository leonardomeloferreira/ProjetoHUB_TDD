package br.com.rsinet.hub_tdd.ProjetoTDD.appModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Category_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Home_Page;

public class Category_Action {

	public static void Execute_BuscaHome(WebDriver driver) throws InterruptedException {
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Home_Page.lnk_Laptops_Home(driver));
		
		Thread.sleep(3000);
		
		executor.executeScript("arguments[0].click();", Category_Page.lnk_Laptop(driver));
		
		
	}
	
}
