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

public class JoinNow extends BaseClass {


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
    public void joinNowSteps(){
        driver.get(p.get("url").toString());
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='wpcc-btn']")).click();
        driver.findElement(By.xpath("//button[@id='btn-join']//b[contains(text(),'Join Now')]")).click();
        WebElement FirstName = driver.findElement(By.xpath("//input[@id='name-join']"));
        FirstName.sendKeys(p.get("FirstNameVal").toString());
        WebElement Email = driver.findElement(By.xpath("//input[@id='email-join']"));
        Email.sendKeys(p.get("JoinEmail").toString());
        WebElement JoinPassword = driver.findElement(By.xpath("//input[@id='custom-password-field']"));
        JoinPassword.sendKeys(p.get("joinPasswordVal").toString());
        driver.findElement(By.xpath("//button[@id='join']")).click();

    }

}


