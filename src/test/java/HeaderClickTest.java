import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgers.nomoreparties.nomoreparties.User;
import stellarburgers.nomoreparties.nomoreparties.createUser.CreateUser;
import stellarburgers.nomoreparties.nomoreparties.pageObject.LogInObject;
import stellarburgers.nomoreparties.nomoreparties.pageObject.MainObject;
import stellarburgers.nomoreparties.nomoreparties.pageObject.RegObject;
import stellarburgers.nomoreparties.nomoreparties.CheckDone;

import static stellarburgers.nomoreparties.nomoreparties.utils.Utils.randomString;

public class HeaderClickTest {
    private WebDriver driver;
    private String randomName = randomString(8);;
    private String randomEmail = randomString(6)+"@gmail.com";
    private String randomPassword = randomString(12);
    private String authToken;
    private CreateUser createUser = new CreateUser();

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        // Регистрация пользователя через API
        User user = new User(randomName,randomEmail,randomPassword);
        Response response = createUser.create(user);
        authToken = response.path("accessToken");
    }

    // Переход в ЛК в авторизованной зоне
    @Test
    public void clickButtonLkWithAuth(){
        LogInObject logInObject = new LogInObject(driver);
        logInObject.openLogIn();
        logInObject.inputLogIn(randomEmail, randomPassword);
        logInObject.clickAuth();

        MainObject mainObject = new MainObject(driver);
        mainObject.clickLogLk();

        CheckDone checkDone = new CheckDone(driver);
        checkDone.proverkaTextProfile();
    }

    // Переход в ЛК не в авторизованной зоне
    @Test
    public void clickButtonLkWithoutAuth(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickLogLk();

        CheckDone checkDone = new CheckDone(driver);
        checkDone.proverkaTextLogIn();
    }

    // Переход из ЛК в Конструктор (НЕавторизованная зона)
    @Test
    public void clickKonstruktorFromLkWithoutAuth(){
        LogInObject logInObject = new LogInObject(driver);
        logInObject.openLogIn();

        MainObject mainObject = new MainObject(driver);
        mainObject.clickButtonKonstruktor();

        CheckDone checkDone = new CheckDone(driver);
        checkDone.proverkaCreateBurger();
    }


    // Переход из ЛК в Конструктор (авторизованная зона)
    @Test
    public void clickKonstruktorFromLkWithAuth(){
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

        CheckDone checkDone = new CheckDone(driver);
        checkDone.proverkaCreateBurger();
    }

    @After
    public void tearDown() {
        driver.quit();
        createUser.delete(authToken);
    }
}
