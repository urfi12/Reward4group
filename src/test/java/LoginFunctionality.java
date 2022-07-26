import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.util.Properties;
import java.util.logging.Logger;

public class LoginFunctionality extends BaseClass {

    private Logger log = Logger.getLogger(Log.class.getName());
    private WebDriver driver;
    private Properties p;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        p = BaseClass.getObjRepo();
    }

    @Test
// Here we are checking login functionality by providing correct email and correct password
    public void loginUsingRightCredentials(){
        driver.get(p.get("url").toString());
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='wpcc-btn']")).click();
        driver.findElement(By.xpath("//button[@id='btn-signin']//b[contains(text(),'Sign In')]")).click();
        WebElement uName = driver.findElement(By.xpath(p.get("username").toString()));
        uName.sendKeys(p.get("uname_val").toString());
        WebElement uPassWord = driver.findElement(By.xpath(p.get("password").toString()));
        uPassWord.sendKeys(p.get("upass_val").toString());
        WebElement logInButton = driver.findElement(By.xpath(p.get("login_btn").toString()));
        logInButton.click();
        driver.quit();
    }
    @Test
// Here we are checking to see by providing wrong password login should fail
    public void usingWrongPassword(){
        {
            driver.get(p.get("url").toString());
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//a[@class='wpcc-btn']")).click();
            driver.findElement(By.xpath("//button[@id='btn-signin']//b[contains(text(),'Sign In')]")).click();
            WebElement uName = driver.findElement(By.xpath(p.get("username").toString()));
            uName.sendKeys(p.get("uname_val").toString());
            WebElement uPassWord = driver.findElement(By.xpath(p.get("password").toString()));
            uPassWord.sendKeys(p.get("incorrectupass").toString());
            WebElement logInButton = driver.findElement(By.xpath(p.get("login_btn").toString()));
            logInButton.click();
            WebElement errorMessage = driver.findElement(By.xpath("//span[@class='text-white mb-4 field-validation-error']"));
            errorMessage.isDisplayed();
        }}

    @Test
//  Here we are checking to see by providing wrong email login should fail
    public void usingWrongEmail(){
        driver.get(p.get("url").toString());
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='wpcc-btn']")).click();
        driver.findElement(By.xpath("//button[@id='btn-signin']//b[contains(text(),'Sign In')]")).click();
        WebElement uName = driver.findElement(By.xpath(p.get("username").toString()));
        uName.sendKeys(p.get("wrongEmail").toString());
        WebElement uPassWord = driver.findElement(By.xpath(p.get("password").toString()));
        uPassWord.sendKeys(p.get("incorrectupass").toString());
        WebElement logInButton = driver.findElement(By.xpath(p.get("login_btn").toString()));
        logInButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//span[@class='text-white mb-4 field-validation-error']"));
        errorMessage.isDisplayed();
    }

}



