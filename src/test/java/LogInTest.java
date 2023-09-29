import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgers.nomoreparties.nomoreparties.User;
import stellarburgers.nomoreparties.nomoreparties.createUser.CreateUser;
import stellarburgers.nomoreparties.nomoreparties.pageObject.ForgotPasswordObject;
import stellarburgers.nomoreparties.nomoreparties.pageObject.LogInObject;
import stellarburgers.nomoreparties.nomoreparties.pageObject.MainObject;
import stellarburgers.nomoreparties.nomoreparties.pageObject.RegObject;
import stellarburgers.nomoreparties.nomoreparties.CheckDone;

import java.util.concurrent.TimeUnit;

import static stellarburgers.nomoreparties.nomoreparties.utils.Utils.randomString;

public class LogInTest {

    private WebDriver driver;
    private String randomName = randomString(8);;
    private String randomEmail = randomString(6)+"@gmail.com";
    private String randomPassword = randomString(12);
    private String authToken;
    private CreateUser createUser = new CreateUser();



    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        // Регистрация пользователя через API
        User user = new User(randomName,randomEmail,randomPassword);
        Response response = createUser.create(user);
        authToken = response.path("accessToken");
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

        CheckDone checkDone = new CheckDone(driver);
        checkDone.proverkaTextCreateOrder();
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

        CheckDone checkDone = new CheckDone(driver);
        checkDone.proverkaTextCreateOrder();
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

        CheckDone checkDone = new CheckDone(driver);
        checkDone.proverkaTextCreateOrder();
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

        CheckDone checkDone = new CheckDone(driver);
        checkDone.proverkaTextCreateOrder();
    }

    @After
    public void tearDown() {
        driver.quit();
        createUser.delete(authToken);
    }
}
