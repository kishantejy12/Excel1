package com.excel.facebook.excel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Excel {
		 private WebDriver driver=null;
		    
		    @BeforeClass
		    public void beforeClass() {
		    	

		        System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
		       driver = new ChromeDriver();
		         driver.get("http://facebook.com");
		         driver.manage().window().maximize();
		      
		    }
		    
		    @AfterClass
		    public void afterClass() {
		    	
		       driver.close();
		    }
		    
		    @Test(dataProvider="invalid-login-data")
		    public void sampleLoginTest(String username, String password) throws Exception {
		    	
		        driver.findElement(By.id("email")).sendKeys(username);
		        driver.findElement(By.id("pass")).sendKeys(password);
		        driver.findElement(By.id("loginbutton")).click();
		        // You will verify the error message here then go back Landing 
		        Thread.sleep(1000);
		        driver.navigate().back();
		        driver.findElement(By.id("email")).clear();
		    }
		    
		    @DataProvider(name="invalid-login-data")
		    public Object[][] dpInavlidLogin() throws InterruptedException {
		    	Change config = new Change("C://Selenium//excel.xlsx");
		    	int rows = config.getRowCount(0);
		    	Object[][]data=new Object[rows][2];
		    	for(int i=0;i<rows;i++){
		    		data[i][0]=config.getData(0, i, 0);
		    		data[i][1] = config.getData(0, i, 1);
		    		Thread.sleep(1000);
		    	}
		    	return data;
		        }    
		    }
