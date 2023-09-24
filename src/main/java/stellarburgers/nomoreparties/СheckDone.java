package stellarburgers.nomoreparties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class СheckDone {
    private final WebDriver driver;

    // проверка открытия окна для входа
    private By textLogIn = By.xpath(".//div[@class='Auth_login__3hAey']/h2[text()='Вход']");

    // проверка наличия валидации Некорректный пароль
    private By textNoValid = By.xpath(".//p[text()='Некорректный пароль']");

    // проверка текста на кнопке Офрмить заказ
    private By textCreateOrder = By.xpath(".//button[text()='Оформить заказ']");

    // проверка текста "Профиль"
    private By textProfile = By.xpath(".//a[@href='/account/profile']");

    // проверка текста "Соберите бургер"
    private By textCreateBurger = By.xpath(".//h1[text()='Соберите бургер']");

    // Проверка выбора "Булки"
    private By textBulki = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Булки']");

    // Проверка выбора "Соусы"
    private By textSouce = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Соусы']");

    // Проверка выбора "Начинки"
    private By textNachinka = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span[text()='Начинки']");

    public СheckDone(WebDriver driver) {
        this.driver = driver;
    }

    public boolean openWindowWithLogIn() {
        return driver.findElements(textLogIn).size() > 0;
    }

    public boolean textNoValidPassword() {
        return driver.findElements(textNoValid).size() > 0;
    }

    public void proverkaTextCreateOrder() {
        new WebDriverWait(driver, 12)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[@class=\"Modal_modal_overlay__x2ZCr\"]")));
        WebElement textElement = (WebElement) driver.findElement(textCreateOrder);
        String actualText = textElement.getText();
        String expectedText = "Оформить заказ";
        assertEquals("Кнопка 'Оформить заказ' не отобразилась", expectedText, actualText);
    }

    public void proverkaTextLogIn() {
        WebElement textElement = (WebElement) driver.findElement(textLogIn);
        String actualText = textElement.getText();
        String expectedText = "Вход";
        assertEquals("Текст 'Вход' не отобразился", expectedText, actualText);
    }

    public void proverkaTextProfile() {
        WebElement textElement = (WebElement) driver.findElement(textProfile);
        String actualText = textElement.getText();
        String expectedText = "Профиль";
        assertEquals("Текст 'Профиль' не отобразился", expectedText, actualText);
    }

    public void proverkaCreateBurger() {
        WebElement textElement = (WebElement) driver.findElement(textCreateBurger);
        String actualText = textElement.getText();
        String expectedText = "Соберите бургер";
        assertEquals("Текст 'Соберите бургер' не отобразился", expectedText, actualText);
    }

    public boolean textBulki() {
        return driver.findElements(textBulki).size() > 0;
    }

    public boolean textSouce() {
        return driver.findElements(textSouce).size() > 0;
    }

    public boolean textNachinka() {
        return driver.findElements(textNachinka).size() > 0;
    }
}
