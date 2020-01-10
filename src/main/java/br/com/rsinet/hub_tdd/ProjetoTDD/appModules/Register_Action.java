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
	       
	        JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", LogIn_Page.btn_CreateAccount(driver));
	       
	        wait.until(ExpectedConditions.visibilityOf(Register_Page.txtbx_UserName(driver)));
	       
	        Register_Page.txtbx_UserName(driver).sendKeys("pradoo12");
	        Register_Page.txtbx_Email(driver).sendKeys("emerson.prado@rsinet.com.brqa");
	        Register_Page.txtbx_Password(driver).sendKeys("Teste@1234");
	        Register_Page.txtbx_ComfirmPassword(driver).sendKeys("Teste@1234");
	       
	        Register_Page.txtbx_FirstName(driver).sendKeys("Emerson");
	        Register_Page.txtbx_LastName(driver).sendKeys("Prado");
	        Register_Page.txtbx_PhoneNumber(driver).sendKeys("997420076");
	       
	        Register_Page.lisbx_City(driver).selectByVisibleText("Brazil");
	        Register_Page.txtbx_City(driver).sendKeys("Osasco");
	        Register_Page.txtbx_Address(driver).sendKeys("Avenida dos remédios");
	        Register_Page.txtbx_State(driver).sendKeys("São Paulo");
	        Register_Page.txtbx_PostalCode(driver).sendKeys("06293110");
	       
	        Register_Page.checkbx_Agree(driver).click();
	        Register_Page.btnbx_Register(driver).click();
	       
	        wait.until(ExpectedConditions.textToBePresentInElement(Home_Page.txt_Login(driver), "pradoo12"));
	       
	        driver.getCurrentUrl();
	       
	    }

		
	}
}
