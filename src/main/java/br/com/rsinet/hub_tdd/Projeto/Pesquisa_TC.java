package br.com.rsinet.hub_tdd.Projeto;

import static junit.framework.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.ProjetoTDD.appModules.Pesquisa_Action;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Category_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.Constant;
import br.com.rsinet.hub_tdd.ProjetoTDD.utility.ExcelUtils;
import junit.framework.Assert;

public class Pesquisa_TC {

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

		Pesquisa_Action.Execute_Busca(driver);
		

		Assert.assertEquals(true, Category_Page.lnk_Result(driver).getText().contains(ExcelUtils.getCellData(1, 1).toUpperCase()));

	}
	@Test
	public void iniciaTestInvalido() throws Exception {
		driver.get("https://www.advantageonlineshopping.com/");
		
		Pesquisa_Action.Execute_Busca_Invalida(driver);
		String sInvalido = Category_Page.lnk_NoResult(driver).getText();
		
		assertEquals(true, sInvalido.contains("No results for"));
	}
	@AfterClass
	public static void fechaNavegador() {
		
	}
}
