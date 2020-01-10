package br.com.rsinet.hub_tdd.ProjetoTDD.appModules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.LogIn_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Register_Page;

public class Register_Action {

	public static void Execute(WebDriver driver) {

		Home_Page.lnk_MyAccount(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LogIn_Page.btn_CreateAccount(driver)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LogIn_Page.btn_CreateAccount(driver));

		wait.until(ExpectedConditions.visibilityOf(Register_Page.txtbx_UserName(driver)));

		Register_Page.txtbx_UserName(driver).sendKeys("leonardo");
		Register_Page.txtbx_Email(driver).sendKeys("leonardoferreira54@outlook.com.br");
		Register_Page.txtbx_Password(driver).sendKeys("Teste@1234");
		Register_Page.txtbx_ComfirmPassword(driver).sendKeys("Teste@1234");

		Register_Page.txtbx_FirstName(driver).sendKeys("Leonardo");
		Register_Page.txtbx_LastName(driver).sendKeys("Ferreira");
		Register_Page.txtbx_PhoneNumber(driver).sendKeys("945325532");

		Register_Page.lisbx_City(driver).selectByVisibleText("Brazil");
		Register_Page.txtbx_City(driver).sendKeys("Sao Paulo");
		Register_Page.txtbx_Address(driver).sendKeys("Rua Alto Alegre");
		Register_Page.txtbx_State(driver).sendKeys("São Paulo");
		Register_Page.txtbx_PostalCode(driver).sendKeys("06223070");

		Register_Page.checkbx_Agree(driver).click();
		Register_Page.btnbx_Register(driver).click();

		wait.until(ExpectedConditions.textToBePresentInElement(Home_Page.txt_Login(driver), "leonardo"));

		driver.getCurrentUrl();

	}

	public static void ExecuteFalha(WebDriver driver) {

		Home_Page.lnk_MyAccount(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LogIn_Page.btn_CreateAccount(driver)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LogIn_Page.btn_CreateAccount(driver));

		wait.until(ExpectedConditions.visibilityOf(Register_Page.txtbx_UserName(driver)));

		Register_Page.txtbx_UserName(driver).sendKeys("leonardo34");
		Register_Page.txtbx_Email(driver).sendKeys("leonardoferreira54@outlook.com.br");
		Register_Page.txtbx_Password(driver).sendKeys("Teste@1234");
		Register_Page.txtbx_ComfirmPassword(driver).sendKeys("Teste@1234");

		Register_Page.txtbx_FirstName(driver).sendKeys("Leonardo");
		Register_Page.txtbx_LastName(driver).sendKeys("Ferreira");
		Register_Page.txtbx_PhoneNumber(driver).sendKeys("945325532");

		Register_Page.lisbx_City(driver).selectByVisibleText("Brazil");
		Register_Page.txtbx_City(driver).sendKeys("Sao Paulo");
		Register_Page.txtbx_Address(driver).sendKeys("Rua Alto Alegre");
		Register_Page.txtbx_State(driver).sendKeys("São Paulo");
		Register_Page.txtbx_PostalCode(driver).sendKeys("06223070");

		Register_Page.checkbx_Agree(driver).click();
		Register_Page.btnbx_Register(driver).click();

		wait.until(ExpectedConditions.textToBePresentInElement(Home_Page.txt_Login(driver), "leonardo34"));

		driver.getCurrentUrl();
	}
}
