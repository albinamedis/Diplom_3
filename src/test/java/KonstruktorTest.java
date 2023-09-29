import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgers.nomoreparties.nomoreparties.pageObject.MainObject;
import stellarburgers.nomoreparties.nomoreparties.CheckDone;

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

        CheckDone checkDone = new CheckDone(driver);
        Assert.assertTrue("Раздел 'Булки' не выбран", checkDone.textBulki());
    }

    @Test
    public void clickSouse(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickButtonSouce();

        CheckDone checkDone = new CheckDone(driver);
        Assert.assertTrue("Раздел 'Соусы' не выбран", checkDone.textSouce());
    }

    @Test
    public void clickNachinka(){
        MainObject mainObject = new MainObject(driver);
        mainObject.openMain();
        mainObject.clickButtonNachinka();

        CheckDone checkDone = new CheckDone(driver);
        Assert.assertTrue("Раздел 'Начинки' не выбран", checkDone.textNachinka());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
