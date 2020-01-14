package br.com.rsinet.hub_tdd.Projeto;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Pesquisa_Action;
import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Category_Action;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.Constant;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;

public class Category_TC {

private static ChromeDriver driver;
	
	@BeforeClass
	public static void iniciaNavegador() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData, "Busca");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void iniciaTest() throws Exception {
		driver.get("https://www.advantageonlineshopping.com/");

		Category_Action.Execute_BuscaHome(driver);

	
	}
	@AfterClass
	public static void fechaNavegador() {
		
	}
}
