package br.com.rsinet.hub_tdd.Projeto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Register_Action;

public class CenarioDeCadastro {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.advantageonlineshopping.com");
		
		Register_Action.Execute(driver);
		
		}
	}
}
