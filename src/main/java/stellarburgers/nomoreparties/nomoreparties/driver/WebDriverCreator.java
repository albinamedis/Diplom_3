package stellarburgers.nomoreparties.nomoreparties.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

    /*
    Переменные окружения, прописанные в системе:
    Проверить версию браузера browser://version/
    BROWSER_DRIVERS - путь к папке с драйверами для браузера
    YANDEX_BROWSER_DRIVER_FILENAME - имя файла драйвера Яндекс браузера (Хромдрайвера нужной версии)
    YANDEX_BROWSER_PATH - путь к исполняемому файлу Яндекс браузера в системе
    */

public class WebDriverCreator {

    private static String BROWSER_DRIVERS = "C:\\Users\\79022\\WebDriver\\bin\\yandex";
    private static String YANDEX_BROWSER_DRIVER_FILENAME = "chromedriver-yandex";
    private static String YANDEX_BROWSER_PATH = "C:\\Users\\79022\\WebDriver\\bin\\yandex";

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return createChromeDriver();
        }

        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver(){
        System.setProperty("webdriver.chrome.drive", String.format("%s/%s", System.getenv("BROWSER_DRIVERS")));
                System.getenv("YANDEX_BROWSER_DRIVER_FILENAME");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getenv("YANDEX_BROWSER_PATH"));
        return new ChromeDriver(options);
    }
}
