package simpleselenium;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.htmlunit.corejs.javascript.ast.ForInLoop;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MyFirstSeleniumTest {
	private WebDriver driver;
	
	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}
	
	@After
	public void cleanup() {
		driver.quit();
	}
	
	@Ignore
	public void test() 
	{
	
		driver.get("http://adam.goucher.ca/parkcalc/");
		
		Select dropdown = new Select(driver.findElement(By.id("Lot")));
		dropdown.selectByVisibleText("Economy Parking");
		
		//Start
		WebElement txtEntryTime = driver.findElement(By.name("EntryTime"));
		txtEntryTime.sendKeys(Keys.chord(Keys.CONTROL, "a"), "4:00");
		
		WebElement Radio = driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/font/input[3]"));
		Radio.click();
		
		WebElement txtEntryDate = driver.findElement(By.name("EntryDate"));
		txtEntryDate.sendKeys(Keys.chord(Keys.CONTROL, "a"), "06/27/2014");
	
		//End
		WebElement txtExitTime = driver.findElement(By.name("ExitTime"));
		txtExitTime.sendKeys(Keys.chord(Keys.CONTROL, "a"), "11:00");
		
		WebElement txtExitDate = driver.findElement(By.name("ExitDate"));
		txtExitDate.sendKeys(Keys.chord(Keys.CONTROL, "a"), "06/28/2014");
		
		WebElement btnSubmit = driver.findElement(By.name("Submit"));
		btnSubmit.click();
		
		WebElement totalCost = driver.findElement(By.xpath("html/body/form/table/tbody/tr[4]/td[2]/span/font/b"));
		String cost = totalCost.getText();
		System.out.println(cost);
		
		//assertTrue(cost.equals("$ 9.00"));
		Assert.assertEquals("$ 9.00", cost);


	
	}
	
	@Test
	public void secondTest()
	{
		driver.get("http://adam.goucher.ca/parkcalc/");
		
		Select dropdown = new Select(driver.findElement(By.id("Lot")));
		dropdown.selectByVisibleText("Valet Parking");
		
		//Start
		WebElement txtEntryTime = driver.findElement(By.name("EntryTime"));
		txtEntryTime.sendKeys(Keys.chord(Keys.CONTROL, "a"), "4:00");
		
		WebElement Radio = driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/font/input[3]"));
		Radio.click();
		
		WebElement txtEntryDate = driver.findElement(By.name("EntryDate"));
		txtEntryDate.sendKeys(Keys.chord(Keys.CONTROL, "a"), "06/27/2014");
		

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try 
		{
			FileUtils.copyFile(scrFile, new File("/home/kuser/Desktop/Screenshot.png"));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//End
		WebElement txtExitTime = driver.findElement(By.name("ExitTime"));
		txtExitTime.sendKeys(Keys.chord(Keys.CONTROL, "a"), "11:00");
		
		WebElement txtExitDate = driver.findElement(By.name("ExitDate"));
		txtExitDate.sendKeys(Keys.chord(Keys.CONTROL, "a"), "06/29/2014");
		
		WebElement btnSubmit = driver.findElement(By.name("Submit"));
		btnSubmit.click();
		
	}
	
	@Ignore
	public void firstPet()
	{
		driver.get("http://localhost:8080/petclinic/");
		
		String element = driver.getTitle();
		Assert.assertEquals("PetClinic :: a Spring Framework demonstration", element);
	}
	
	@Ignore
	public void secondPet()
	{
		driver.get("http://localhost:8080/petclinic/");
		
		WebElement background = driver.findElement(By.xpath("html/body/div[1]/img[2]"));
		
		if(background != null)
		{
			System.out.println("Passed");
		}
		
	}
	
	@Ignore
	public void thirdPet()
	{
		driver.get("http://localhost:8080/petclinic/");
		
		WebElement background = driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a"));
		background.click();
	
		WebElement table = driver.findElement(By.xpath("/html/body/div/div[2]/table"));
		List<WebElement> rows = table.findElements(By.id("vets"));
		java.util.Iterator<WebElement> i = rows.iterator();
		
		int j = 0;
		
		while(i.hasNext()) 
		{
			j++;
		    WebElement row = i.next();
		    System.out.println(row.getText());
		    
		    if(j == 2)
		    {
				Assert.assertEquals(2, j);
		    }
		    else
		    {
		    	System.out.println("Fail");
		    }
		}
		
		
	
	}
	
	@Ignore
	public void forthPet()
	{
		driver.get("http://localhost:8080/petclinic/");
		
		WebElement navigate = driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a"));
		navigate.click();
		
	}
	
	@Ignore
	public void fifthPet()
	{
		driver.get("http://localhost:8080/petclinic/");
		
		WebElement navigate = driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[3]/a"));
		navigate.click();
		
		WebElement sort = driver.findElement(By.xpath(".//*[@id='vets']/thead/tr/th[2]"));
		sort.click();//Ascending
		sort.click();//Descending
		
		WebElement top = driver.findElement(By.xpath(".//*[@id='vets']/tbody/tr[1]/td[2]"));
		String topList = top.getText();
		
		Assert.assertEquals("surgery", topList);	
		
	}
	
	//Go back to
	@Ignore
	public void sixthPet()
	{
		driver.get("http://localhost:8080/petclinic/");
		
		WebElement navigate = driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[2]/a"));
		navigate.click();
		
		WebElement name = driver.findElement(By.xpath(".//*[@id='lastName']"));
		
		WebElement txtlastName = driver.findElement(By.name("lastName"));
		txtlastName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Smith");
		
	}
	
	//CBA
	@Ignore
	public void seventhPet()
	{
		driver.get("http://localhost:8080/petclinic/");
		
		WebElement navigate = driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[2]/a"));
		navigate.click();

	}
	
	@Ignore
	public void eighthPet()
	{
		driver.get("http://localhost:8080/petclinic/");
		
		WebElement navigate = driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[2]/a"));
		navigate.click();
		
		WebElement navigateAdd = driver.findElement(By.xpath("html/body/div[1]/a"));
		navigateAdd.click();
		
		WebElement txtFirstName = driver.findElement(By.name("firstName"));
		txtFirstName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "John");
		
		WebElement txtLastName = driver.findElement(By.name("lastName"));
		txtLastName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Smith");
		
		WebElement txtAddress = driver.findElement(By.name("address"));
		txtAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Antrim");
		
		WebElement txtCity = driver.findElement(By.name("city"));
		txtCity.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Belfast");
		
		WebElement txtTelephone = driver.findElement(By.name("telephone"));
		txtTelephone.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1234567");
		
		WebElement navigateSubmit= driver.findElement(By.xpath(".//*[@id='add-owner-form']/div[6]/button"));
		navigateSubmit.click();
		
		WebElement addPet= driver.findElement(By.xpath("html/body/div[1]/table[1]/tbody/tr[5]/td[2]/a"));
		addPet.click();
		
		//Pet 1
		WebElement txtName = driver.findElement(By.name("name"));
		txtName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Super");
		
		WebElement txtBirth = driver.findElement(By.name("birthDate"));
		txtBirth.sendKeys("1990/01/01");

		driver.findElement(By.xpath("html/body/div[1]/table[1]/tbody/tr[5]/td[2]/a"));
	
		
		WebElement enter = driver.findElement(By.xpath(".//*[@id='type']/option[1]"));
		enter.click();
		
		//Pet 2
		
			
	}
	

}
