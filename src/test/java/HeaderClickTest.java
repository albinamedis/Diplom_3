import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgers.nomoreparties.pageObject.LogInObject;
import stellarburgers.nomoreparties.pageObject.MainObject;
import stellarburgers.nomoreparties.pageObject.RegObject;
import stellarburgers.nomoreparties.СheckDone;

import static stellarburgers.nomoreparties.utils.Utils.randomString;

public class HeaderClickTest {
    private WebDriver driver;
    private String randomName = randomString(8);;
    private String randomEmail = randomString(6)+"@gmail.com";
    private String randomPassword = randomString(12);

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    // Переход в ЛК в авторизованной зоне
    @Test
    public void clickButtonLkWithAuth(){
        RegObject regObject = new RegObject(driver);
        regObject.openReg();
        regObject.inputReg(randomName, randomEmail, randomPassword);
        regObject.clickButtonReg();

        LogInObject logInObject = new LogInObject(driver);
        logInObject.openLogIn();
        logInObject.inputLogIn(randomEmail, randomPassword);
        logInObject.clickAuth();

        MainObject mainObject = new MainObject(driver);
        mainObject.clickLogLk();

        СheckDone checkDone = new СheckDone(driver);
        checkDone.proverkaTextProfile();
    }

    // Переход в ЛК не в авторизованной зоне
    @Test
    public void clickButtonLkWithoutAuth(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickLogLk();

        СheckDone checkDone = new СheckDone(driver);
        checkDone.proverkaTextLogIn();
    }

    // Переход из ЛК в Конструктор (НЕавторизованная зона)
    @Test
    public void clickKonstruktorFromLkWithoutAuth(){
        LogInObject logInObject = new LogInObject(driver);
        logInObject.openLogIn();

        MainObject mainObject = new MainObject(driver);
        mainObject.clickButtonKonstruktor();

        СheckDone checkDone = new СheckDone(driver);
        checkDone.proverkaCreateBurger();
    }


    // Переход из ЛК в Конструктор (авторизованная зона)
    @Test
    public void clickKonstruktorFromLkWithAuth(){
        RegObject regObject = new RegObject(driver);
        regObject.openReg();
        regObject.inputReg(randomName, randomEmail, randomPassword);
        regObject.clickButtonReg();

        LogInObject logInObject = new LogInObject(driver);
        logInObject.openLogIn();
        logInObject.inputLogIn(randomEmail, randomPassword);
        logInObject.clickAuth();

        MainObject mainObject = new MainObject(driver);
        mainObject.clickLogLk();
        mainObject.clickButtonKonstruktor();
    }

    // Переход из ЛК по логотипу Stellar Burgers (НЕавторизованная зона)
    @Test
    public void clickLogofromLK(){
        LogInObject logInObject = new LogInObject(driver);
        logInObject.openLogIn();

        MainObject mainObject = new MainObject(driver);
        mainObject.clickButtonLogo();

        СheckDone checkDone = new СheckDone(driver);
        checkDone.proverkaCreateBurger();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
