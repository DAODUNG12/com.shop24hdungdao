package TestassSof304;

import org.testng.annotations.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

public class TestNGMywork {

public String baseUrl="https://mywork.com.vn/dang-ky";

String driverpath = "D:\\No Delete\\Selenium\\chromedriver.exe";

public WebDriver driver;

@BeforeTest

public void launchBrowser(){

System.out.println("launch chrome browser");

System.setProperty("webdriver.chrome.driver", driverpath);

driver= new ChromeDriver();

driver.get(baseUrl);

}

@AfterTest

public void closeBrowser(){

System.out.println("launch chrome browser");

driver.close();

}

@Test

public void tescaseOne() {

driver.manage().window().maximize();

driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/section[1]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div/div/div[1]/input")).sendKeys("DaoVanDung");

driver.findElement(By.xpath("//*[@id=\"btn-register-candidate\"]/span")).click();

driver.findElement(By.xpath("//*[@id=\"btn-register-candidate\"]")).click();

String expectEmail = "Email is required";

String actualEmail = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/form/div[2]/div[1]/div/div/div[2]")).getText();

Assert.assertEquals(actualEmail, expectEmail);

}


@Test

public void tescaseTwo() {

driver.manage().window().maximize();
driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/section[1]/div[2]/div/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div[1]/input")).sendKeys("dungdvph05282@fpt.edu.vn");


driver.findElement(By.xpath("//*[@id=\"btn-register-candidate\"]/span")).click();

driver.findElement(By.xpath("//*[@id=\"btn-register-candidate\"]")).click();

String expectEmail = "Email is required";

String actualEmail = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/form/div[2]/div[1]/div/div/div[2]")).getText();

Assert.assertEquals(actualEmail, expectEmail);

}
@Test
public void tescaseThree() {

driver.manage().window().maximize();

driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/section[1]/div[2]/div/div[2]/div/div[1]/div/form/div[2]/div[2]/div/div/div[1]/input")).sendKeys("0979796789");

driver.findElement(By.xpath("//*[@id=\"btn-register-candidate\"]/span")).click();

driver.findElement(By.xpath("//*[@id=\"btn-register-candidate\"]")).click();

String expectEmail = "Email is required";

String actualEmail = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/form/div[2]/div[1]/div/div/div[2]")).getText();

Assert.assertEquals(actualEmail, expectEmail);

}

@Test
public void tescaseFour() {

driver.manage().window().maximize();

driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/section[1]/div[2]/div/div[2]/div/div[1]/div/form/div[3]/div[1]/div/div/div[1]/input")).sendKeys("xyzkv19");

driver.findElement(By.xpath("//*[@id=\"btn-register-candidate\"]/span")).click();

driver.findElement(By.xpath("//*[@id=\"btn-register-candidate\"]")).click();

String expectEmail = "Email is required";

String actualEmail = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/form/div[2]/div[1]/div/div/div[2]")).getText();

Assert.assertEquals(actualEmail, expectEmail);

}
@Test
public void tescaseFive() {

driver.manage().window().maximize();

driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/section[1]/div[2]/div/div[2]/div/div[1]/div/form/div[3]/div[2]/div/div/div[1]/input")).sendKeys("xyzkv19");

driver.findElement(By.xpath("//*[@id=\"btn-register-candidate\"]/span")).click();

driver.findElement(By.xpath("//*[@id=\"btn-register-candidate\"]")).click();

String expectEmail = "Email is required";

String actualEmail = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/form/div[2]/div[1]/div/div/div[2]")).getText();

Assert.assertEquals(actualEmail, expectEmail);

}

}