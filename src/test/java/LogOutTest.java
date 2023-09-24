import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgers.nomoreparties.pageObject.LogInObject;
import stellarburgers.nomoreparties.pageObject.MainObject;
import stellarburgers.nomoreparties.pageObject.ProfileObject;
import stellarburgers.nomoreparties.pageObject.RegObject;
import stellarburgers.nomoreparties.СheckDone;

import static stellarburgers.nomoreparties.utils.Utils.randomString;

public class LogOutTest {

        private WebDriver driver;
        private String randomName = randomString(8);;
        private String randomEmail = randomString(6)+"@gmail.com";
        private String randomPassword = randomString(12);

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void clickLogOut(){
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

        ProfileObject profileObject = new ProfileObject(driver);
        profileObject.clickLogOut();

        СheckDone checkDone = new СheckDone(driver);
        checkDone.proverkaTextLogIn();
    }

    @After
    public void tearDown() {
      //  driver.quit();
    }
}
