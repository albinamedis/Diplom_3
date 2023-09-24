package stellarburgers.nomoreparties.nomoreparties.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RegObject {
    private final WebDriver driver;
    // Открыть страницу "Регистрация"
    private String urlReg= "https://stellarburgers.nomoreparties.site/register";
    // кнопка Зарегистрироваться
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // ввод Имени
    private By textName = By.xpath(".//label[text()='Имя']/parent::div/input[@name='name']");
    // ввод Email
    private By textEmail = By.xpath(".//label[text()='Email']/parent::div/input[@name='name']");
    // ввод Пароля
    private By textPassword = By.xpath(".//label[text()='Пароль']/parent::div/input[@name='Пароль']");
    // гиперссылка "Войти"
    private By linkLogIn = By.xpath(".//a[@href='/login']");

    public RegObject(WebDriver driver) {
        this.driver = driver;
    }

    // открыть сайт на странице регистрации
    public void openReg() {
        driver.get(urlReg);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Ввести Имя
    public void inputName(String name) {
        driver.findElement(textName).sendKeys(name);
    }

    // Ввести Email
    public void inputEmail(String email) {
        driver.findElement(textEmail).sendKeys(email);
    }

    // Ввести Пароль
    public void inputPassword(String password) {
        driver.findElement(textPassword).sendKeys(password);
    }

    // Ввести Имя, Email и Пароль
    public void inputReg(String name, String email, String password) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputName(name);
        inputEmail(email);
        inputPassword(password);
    }

    // Нажать на кнопку "Зарегистрироваться"
    public void clickButtonReg() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.button_button__33qZ0")));
        driver.findElement(registerButton).click();
    }

    // Нажать на гиперссылку "Войти"
    public void clickLinkLogIn() {
        driver.findElement(linkLogIn).click();
    }

}
