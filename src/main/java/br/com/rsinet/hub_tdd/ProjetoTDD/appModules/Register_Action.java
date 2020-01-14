package br.com.rsinet.hub_tdd.ProjetoTDD.appModules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.LogIn_Page;
import br.com.rsinet.hub_tdd.ProjetoTDD.pageObject.Register_Page;

public class Register_Action {

	public static void Execute(WebDriver driver) throws Exception {

		Home_Page.lnk_MyAccount(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LogIn_Page.btn_CreateAccount(driver)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LogIn_Page.btn_CreateAccount(driver));

		wait.until(ExpectedConditions.visibilityOf(Register_Page.txtbx_UserName(driver)));
	
		
		
		try {

			FileInputStream file = new FileInputStream(new File("C:\\Nova pasta2\\testData1.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				
				String sUserName = sheet.getRow(i).getCell(1).getStringCellValue();
				String sEmail = sheet.getRow(i).getCell(2).getStringCellValue();
				String sPassword = sheet.getRow(i).getCell(3).getStringCellValue();
				String sConfirmPassword = sheet.getRow(i).getCell(4).getStringCellValue();
				String sFirstName = sheet.getRow(i).getCell(5).getStringCellValue();
				String sLastName = sheet.getRow(i).getCell(6).getStringCellValue();
				
				
				String sPhoneNumber = String.format("%09d", sheet.getRow(i).getCell(7).getStringCellValue());
				String ssCity = sheet.getRow(i).getCell(8).getStringCellValue();
				String sCity = sheet.getRow(i).getCell(9).getStringCellValue();
				String sAddress = sheet.getRow(i).getCell(10).getStringCellValue();
				String sState = sheet.getRow(i).getCell(11).getStringCellValue();
//				String sPostalCode = sheet.getRow(i).getCell(12).getStringCellValue();
				String sLogin = sheet.getRow(i).getCell(13).getStringCellValue();

				Register_Page.txtbx_UserName(driver).sendKeys(sUserName);
				Register_Page.txtbx_Email(driver).sendKeys(sEmail);
				Register_Page.txtbx_Password(driver).sendKeys(sPassword);
				Register_Page.txtbx_ComfirmPassword(driver).sendKeys(sConfirmPassword);
				Register_Page.txtbx_FirstName(driver).sendKeys(sFirstName);
				Register_Page.txtbx_LastName(driver).sendKeys(sLastName);
				Register_Page.txtbx_PhoneNumber(driver).sendKeys(sPhoneNumber);
				Register_Page.lisbx_City(driver).selectByVisibleText(ssCity);
				Register_Page.txtbx_City(driver).sendKeys(sCity);
				Register_Page.txtbx_Address(driver).sendKeys(sAddress);
				Register_Page.txtbx_State(driver).sendKeys(sState);
//				Register_Page.txtbx_PostalCode(driver).sendKeys(sPostalCode);
				Home_Page.txt_Login(driver).sendKeys(sLogin);

				driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

			}

			workbook.close();
			file.close();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	
		Register_Page.checkbx_Agree(driver).click();
		Register_Page.btnbx_Register(driver).click();

//		wait.until(ExpectedConditions.textToBePresentInElement(Home_Page.txt_Login(driver), ));

//		WebDriverWait wait2 = new WebDriverWait(driver, 10);
//		Screenshot.captureScreenShot(driver);
		
		driver.getCurrentUrl();

	}

	public static void ExecuteFalha(WebDriver driver) {

		Home_Page.lnk_MyAccount(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LogIn_Page.btn_CreateAccount(driver)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", LogIn_Page.btn_CreateAccount(driver));

		wait.until(ExpectedConditions.visibilityOf(Register_Page.txtbx_UserName(driver)));

		Register_Page.txtbx_UserName(driver).sendKeys("leonardo3456");
		Register_Page.txtbx_Email(driver).sendKeys("leonardof!@@#$@#@outlook.com.br");
		Register_Page.txtbx_Password(driver).sendKeys("Teste@1234");
		Register_Page.txtbx_ComfirmPassword(driver).sendKeys("Teste@1234");

		Register_Page.txtbx_FirstName(driver).sendKeys("Leonardo");
		Register_Page.txtbx_LastName(driver).sendKeys("Ferreira");
		Register_Page.txtbx_PhoneNumber(driver).sendKeys("945325532");

		Register_Page.lisbx_City(driver).selectByVisibleText("Brazil");
		Register_Page.txtbx_City(driver).sendKeys("Sao Paulo");
		Register_Page.txtbx_Address(driver).sendKeys("Rua Alto Alegre1");
		Register_Page.txtbx_State(driver).sendKeys("São Paulo");
		Register_Page.txtbx_PostalCode(driver).sendKeys("06223070");

		Register_Page.checkbx_Agree(driver).click();
		Register_Page.btnbx_Register(driver).click();

		WebDriverWait wait3 = new WebDriverWait(driver, 10);
//		Screenshot.captureScreenShot(driver);
		
	}
}
