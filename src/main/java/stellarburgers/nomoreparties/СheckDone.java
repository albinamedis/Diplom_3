package stellarburgers.nomoreparties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public boolean textCreateOrder() {
        return driver.findElements(textCreateOrder).size() > 0;
    }

}
