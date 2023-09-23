package stellarburgers.nomoreparties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageObject {
    private final WebDriver driver;
    private String url = "https://stellarburgers.nomoreparties.site/";
    // Переход в ЛК по кнопке "Войти в аккаунт"
    private By logIn = By.xpath(".//button[text()='Войти в аккаунт']");
    // Переход в ЛК по кнопке "Личный Кабинет"
    private By logInLk = By.xpath(".//p[text()='Личный Кабинет']");
    // гиперссылка Зарегистрироваться
    private By registerOpenWindow = By.xpath(".//a[text()='Зарегистрироваться']");
    // кнопка Зарегистрироваться
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // ввод Имени
    private By textName = By.xpath(".//label[text()='Имя']/parent::div/input[@name='name']");
    // ввод Email
    private By textEmail = By.xpath(".//label[text()='Email']/parent::div/input[@name='name']");
    // ввод Пароля
    private By textPassword = By.xpath(".//label[text()='Пароль']/parent::div/input[@name='Пароль']");

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    // открыть сайт
    public void open() {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickLogIn() {
        new WebDriverWait(driver, 12).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[@class=\"Modal_modal_overlay__x2ZCr\"]")));
        new WebDriverWait(driver, 12).until(ExpectedConditions.elementToBeClickable(logIn));;
        driver.findElement(logIn).click();
    }

    public void clickLogLk() {
        driver.findElement(logInLk).click();
       // waitForStationVisibility("Вход");
    }

    public void clickRegOpenWindow() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(registerOpenWindow).click();
    }

    public void clickRegButton() {
        driver.findElement(registerButton).click();
    }

    public void inputName(String name) {
        driver.findElement(textName).sendKeys(name);
    }

    public void inputEmail(String email) {
        driver.findElement(textEmail).sendKeys(email);
    }

    public void inputPassword(String password) {
       driver.findElement(textPassword).sendKeys(password);
    }

    public void inputReg(String name, String email, String password) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        inputName(name);
        inputEmail(email);
        inputPassword(password);
    }

   /* public void waitForStationVisibility(String text) {
        // ждем видимости элемента с нужным текстом из параметра в течение 8 секунд
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.elementToBeClickable(loginButton));;
    }*/

}
