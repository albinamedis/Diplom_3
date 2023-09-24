package stellarburgers.nomoreparties.nomoreparties.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileObject {

    private final WebDriver driver;

    // Кнопка выйти
    private By buttonLogOut = By.xpath(".//button[text()='Выход']");

    public ProfileObject(WebDriver driver) {
        this.driver = driver;
    }

    // Клик по кнопке "Выход"
    public void clickLogOut() {
        driver.findElement(buttonLogOut).click();
    }
}
