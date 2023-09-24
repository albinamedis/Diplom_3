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

}
