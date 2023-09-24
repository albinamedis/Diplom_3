package stellarburgers.nomoreparties.nomoreparties.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordObject {
    private final WebDriver driver;
    // Страница авторизации
    private String urlForgotPassword = "https://stellarburgers.nomoreparties.site/forgot-password";

    // гиперссылка "Войти"
    private By linkLogIn = By.xpath(".//a[@href='/login']");

    public ForgotPasswordObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openForgotPassword() {
        driver.get(urlForgotPassword);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickLinkLogIn() {
        driver.findElement(linkLogIn).click();
    }
}
