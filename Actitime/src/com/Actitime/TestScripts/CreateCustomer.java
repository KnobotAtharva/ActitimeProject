package com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;
@Listeners(ListenerImplementation.class)

public class CreateCustomer extends BaseClass {
	@Test
		public void createCustomer() throws EncryptedDocumentException, IOException
		{
		HomePage hp = new HomePage(wd);
		hp.getTasks().click();
		TaskPage tp = new TaskPage(wd);
		tp.getAddNewButton().click();
		tp.getNewCust().click();
		FileLibrary fl = new FileLibrary();
		String Name = fl.readDataFromExcelSheet("Sheet1", 5, 1);
		tp.getNewCustTxt().sendKeys(Name);
		String Desp = fl.readDataFromExcelSheet("Sheet1", 2, 2);
		Assert.fail();
		tp.getNewCustDespTxt().sendKeys(Desp);
		tp.getClickButton().click();
		String ExpectedResult = Name;
		String ActualResult = wd.findElement(By.xpath("(//div[.='"+Name+"'])[2]")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ExpectedResult, ActualResult);
		sa.assertAll();
		System.out.println(ActualResult);
		}
}
