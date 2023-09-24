import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgers.nomoreparties.nomoreparties.pageObject.MainObject;
import stellarburgers.nomoreparties.nomoreparties.СheckDone;

public class KonstruktorTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void clickBulki(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickButtonSouce();
        mainObject.clickButtonBulka();

        СheckDone checkDone = new СheckDone(driver);
        Assert.assertTrue("Раздел 'Булки' не выбран", checkDone.textBulki());
    }

    @Test
    public void clickSouse(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickButtonSouce();

        СheckDone checkDone = new СheckDone(driver);
        Assert.assertTrue("Раздел 'Соусы' не выбран", checkDone.textSouce());
    }

    @Test
    public void clickNachinka(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickButtonNachinka();

        СheckDone checkDone = new СheckDone(driver);
        Assert.assertTrue("Раздел 'Начинки' не выбран", checkDone.textNachinka());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
