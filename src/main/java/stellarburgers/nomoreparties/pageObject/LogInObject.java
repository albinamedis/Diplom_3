package stellarburgers.nomoreparties.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LogInObject {
    private final WebDriver driver;
    // Страница авторизации
    private String urlLogIn= "https://stellarburgers.nomoreparties.site/login";

    // Страница Профиля
    private String urlProfile = "https://stellarburgers.nomoreparties.site/account/profile";

    // ввод Email на старнице авторизации
    private By vvEmail = By.xpath(".//input[@type='text' and @name='name']");

    // ввод пароля на странице авторизации
    private By vvPassword = By.xpath(".//input[@type='password']");

    // кнопка Войти
    private By buttonLogIn = By.xpath(".//button[text()='Войти']");

    // гиперссылка Зарегистрироваться
    private By linkRegister = By.xpath(".//a[text()='Зарегистрироваться']");

    public LogInObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openLogIn() {
        driver.get(urlLogIn);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void openProfile() {
        driver.get(urlProfile);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void inputLogIn(String email, String password) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(vvEmail).sendKeys(email);
        driver.findElement(vvPassword).sendKeys(password);
    }

    public void clickAuth() {
        driver.findElement(buttonLogIn).click();
    }

    // клик на гиперссылку "Зарегистрироваться"
    public void clickRegOpenWindow() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(linkRegister).click();
    }
}
