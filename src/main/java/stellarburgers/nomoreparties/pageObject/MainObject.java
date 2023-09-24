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
    private By buttonKonstruktor = By.xpath("");

    // Кнопка "Оформить заказ"
    private By buttonCreateOrder = By.xpath("");


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


}
