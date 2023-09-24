import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import stellarburgers.nomoreparties.pageObject.ForgotPasswordObject;
import stellarburgers.nomoreparties.pageObject.LogInObject;
import stellarburgers.nomoreparties.pageObject.MainObject;
import stellarburgers.nomoreparties.pageObject.RegObject;
import stellarburgers.nomoreparties.СheckDone;

import java.util.concurrent.TimeUnit;

import static stellarburgers.nomoreparties.utils.Utils.randomString;

public class LogInTest {

    private WebDriver driver;
    СheckDone checkDone = new СheckDone(driver);
    private String randomName = randomString(8);;
    private String randomEmail = randomString(6)+"@gmail.com";
    private String randomPassword = randomString(12);


    @Before
    public void setUp() {
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);*/
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        // Регистрация пользователя
        RegObject regObject = new RegObject(driver);
        regObject.openReg();
        regObject.inputReg(randomName, randomEmail, randomPassword);
        regObject.clickButtonReg();
    }

    // Вход по кнопке "Войти в аккаунт"
    @Test
    public void clickButtonLogIn(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickLogIn();

        LogInObject logInObject = new LogInObject(driver);
        logInObject.inputLogIn(randomEmail, randomPassword);
        logInObject.clickAuth();

       // Assert.assertTrue("Кнопка 'офрмить заказ' не отобразилась", checkDone.textCreateOrder());
    }

    // Вход по кнопке "Личный кабинет"
    @Test
    public void clickButtonLk(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickLogLk();

        LogInObject logInObject = new LogInObject(driver);
        logInObject.inputLogIn(randomEmail, randomPassword);
        logInObject.clickAuth();

     //   Assert.assertTrue("Кнопка 'офрмить заказ' не отобразилась", checkDone.textCreateOrder());
    }

    // Вход через кнопку в форме регистрации
    @Test
    public void clickLinkLogInFormReg(){
        RegObject regObject = new RegObject(driver);
        regObject.openReg();
        regObject.clickLinkLogIn();

        LogInObject logInObject = new LogInObject(driver);
        logInObject.inputLogIn(randomEmail, randomPassword);
        logInObject.clickAuth();

      //  Assert.assertTrue("Кнопка 'офрмить заказ' не отобразилась", checkDone.textCreateOrder());
    }

    //вход через кнопку в форме восстановления пароля
    @Test
    public void clickLinkLogInFormForgotPassword(){
        ForgotPasswordObject forgotPasswordObject = new ForgotPasswordObject(driver);
        forgotPasswordObject.openForgotPassword();
        forgotPasswordObject.clickLinkLogIn();

        LogInObject logInObject = new LogInObject(driver);
        logInObject.inputLogIn(randomEmail, randomPassword);
        logInObject.clickAuth();

      //  Assert.assertTrue("Кнопка 'офрмить заказ' не отобразилась", checkDone.textCreateOrder());
    }

    @After
    public void tearDown() {
      //  driver.quit();
    }
}
