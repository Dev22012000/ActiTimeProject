package com.actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.actitime.genericlibrary.Baseclass;
import com.actitime.genericlibrary.Filelibrary;
import com.actitime.objectRepository.HomePage;
import com.actitime.objectRepository.TaskPage;

public class Task extends Baseclass{
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getTasktab().click();
		TaskPage tp =new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		
		Filelibrary f = new Filelibrary();
		String value = f.readDataFromExcel("Sheet1", 1, 2);
		tp.getCustname().sendKeys(value);
		String desc = f.readDataFromExcel("Sheet1", 1, 2);
		tp.getCustdesc().sendKeys(desc);
		tp.getAddcust().click();
	}

}
