import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgers.nomoreparties.nomoreparties.pageObject.LogInObject;
import stellarburgers.nomoreparties.nomoreparties.pageObject.MainObject;
import stellarburgers.nomoreparties.nomoreparties.pageObject.RegObject;
import stellarburgers.nomoreparties.nomoreparties.СheckDone;

import static stellarburgers.nomoreparties.nomoreparties.utils.Utils.randomString;

public class RegistrationTest {

    private WebDriver driver;
    private String randomName = randomString(8);;
    private String randomEmail = randomString(6)+"@gmail.com";
    private String randomPassword = randomString(12);
    private String randomPasswordNoValid = randomString(5);


    @Before
    public void setUp() {
         driver = new ChromeDriver();
    }

    // Проверка успешной регистрации
    @Test
    public void regNewUserDone(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickLogIn();

        LogInObject logInObject = new LogInObject(driver);
        logInObject.clickRegOpenWindow();

        RegObject regObject = new RegObject(driver);
        regObject.inputReg(randomName, randomEmail, randomPassword);
        regObject.clickButtonReg();

        СheckDone checkDone = new СheckDone(driver);
        Assert.assertTrue("Не открылось окно для входа после регистрации", checkDone.openWindowWithLogIn());
    }


    // Проверка отображения ошибки на некорректный пароль
    @Test
    public void regNewUserNotValid(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickLogIn();

        LogInObject logInObject = new LogInObject(driver);
        logInObject.clickRegOpenWindow();

        RegObject regObject = new RegObject(driver);
        regObject.inputReg(randomName, randomEmail, randomPasswordNoValid);
        regObject.clickButtonReg();

        СheckDone checkDone = new СheckDone(driver);
        Assert.assertTrue("Не отобразилась валидация 'Некорректный пароль'", checkDone.textNoValidPassword());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
