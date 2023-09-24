package stellarburgers.nomoreparties.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainObject {
    private final WebDriver driver;

    // Открыть страницу "Главная"
    private String urlMain = "https://stellarburgers.nomoreparties.site/";

    // Переход в ЛК по кнопке "Войти в аккаунт"
    private By buttonLogIn = By.xpath(".//button[text()='Войти в аккаунт']");

    // Переход в ЛК по кнопке "Личный Кабинет"
    private By buttonLk = By.xpath(".//p[text()='Личный Кабинет']");

    // Кнопка "Конструктор"
    private By buttonKonstruktor = By.xpath(".//p[text()='Конструктор']");

    // Переход на главную по лого
    private By buttonLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']");

    // Кнопка "Булки"
    private By buttonBulka = By.xpath(".//span[text()='Булки']");

    // Кнопка "Соусы"
    private By buttonSouce = By.xpath(".//span[text()='Соусы']");

    // Кнопка "Начинка"
    private By buttonNachinka = By.xpath(".//span[text()='Начинки']");



    public MainObject(WebDriver driver) {
        this.driver = driver;
    }

    // открыть сайт на Главной
    public void openMain() {
        driver.get(urlMain);
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Клик по кнопке "Войти в аккаунт"
    public void clickLogIn() {
        new WebDriverWait(driver, 12)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[@class=\"Modal_modal_overlay__x2ZCr\"]")));
        new WebDriverWait(driver, 12).until(ExpectedConditions.elementToBeClickable(buttonLogIn));;
        driver.findElement(buttonLogIn).click();
    }

    // Клик по кнопке "Личный Кабинет"
    public void clickLogLk() {
        driver.findElement(buttonLk).click();
    }

    // Клик по кнопке "Конструктор"
    public void clickButtonKonstruktor() {
        driver.findElement(buttonKonstruktor).click();
    }

    // Переход на главную по лого
    public void clickButtonLogo() {
        driver.findElement(buttonLogo).click();
    }

    // Кнопка "Булки"
    public void clickButtonBulka() {
        driver.findElement(buttonBulka).click();
    }

    // Кнопка "Соусы"
    public void clickButtonSouce() {
        driver.findElement(buttonSouce).click();
    }

    // Кнопка "Начинка"
    public void clickButtonNachinka() {
        driver.findElement(buttonNachinka).click();
    }
}
