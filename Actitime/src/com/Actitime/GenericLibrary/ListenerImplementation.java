package com.Actitime.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListenerImplementation extends BaseClass implements ITestListener  
{
	@Override
	public void onTestFailure(ITestResult result)
	{
		String Name = result.getName();
		TakesScreenshot ts =(TakesScreenshot)wd;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/"+Name+".png");
		try 
		{
			Files.copy(src, dest);
		} catch (IOException e) {
			System.out.println("Exception Handled");
		}
	}
}
