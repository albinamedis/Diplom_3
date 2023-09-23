import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import stellarburgers.nomoreparties.PageObject;
import stellarburgers.nomoreparties.СheckDone;

import java.util.concurrent.TimeUnit;

import static utils.Utils.randomString;

public class RegistrationTest {

    private WebDriver webDriver;
    private String randomName = randomString(8);;
    private String randomEmail = randomString(6)+"@gmail.com";
    private String randomPassword = randomString(12);
    private String randomPasswordNoValid = randomString(5);


    @Before
    public void setUp() {
         webDriver = new ChromeDriver();
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);*/
        //webDriver = new FirefoxDriver();
    }

    @Test
    public void regNewUserDone(){
        PageObject pageObject = new PageObject(webDriver);
        pageObject.open();
        pageObject.clickLogLk();
        pageObject.clickRegOpenWindow();
        pageObject.inputReg(randomName, randomEmail, randomPassword);
        pageObject.clickRegButton();
        СheckDone checkDone = new СheckDone(webDriver);
        Assert.assertTrue("Не открылось окно для входа после регистрации", checkDone.openWindowWithLogIn());
    }

    @Test
    public void regNewUserNotValid(){
        PageObject pageObject = new PageObject(webDriver);
        pageObject.open();
        pageObject.clickLogLk();
        pageObject.clickRegOpenWindow();
        pageObject.inputReg(randomName, randomEmail, randomPasswordNoValid);
        pageObject.clickRegButton();
        СheckDone checkDone = new СheckDone(webDriver);
        Assert.assertTrue("Не отобразилась валидация 'Некорректный пароль'", checkDone.textNoValidPassword());
    }

    @After
    public void tearDown() {
        //webDriver.quit();
    }
}
