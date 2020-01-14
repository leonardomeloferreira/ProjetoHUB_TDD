package br.com.rsinet.hub_tdd.ProjetoTDD.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	
	private static WebElement element;
	
	public static WebElement lnk_MyAccount(WebDriver driver) {
		
		element = driver.findElement(By.id("hrefUserIcon"));
		
		return element;
	}

	public static WebElement txt_Login(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span"));
		
		return element;
	}	
	
	public static WebElement lnk_MenuSearch(WebDriver driver) {
		
		element = driver.findElement(By.id("menuSearch"));
		
		return element;
	}
	
	public static WebElement txt_Search(WebDriver driver) {
		
		element = driver.findElement(By.id("autoComplete"));
		
		return element;
	}

	public static WebElement lnk_Laptop(WebDriver driver) {
		
		element = driver.findElement(By.linkText("HP Pavilion 15t Touch Laptop"));
		
		return element;
	}
	public static WebElement lnk_Laptops_Home(WebDriver driver) {
		
		element = driver.findElement(By.id("laptopsTxt"));
		
		return element;
	}
}
