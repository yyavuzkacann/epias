package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SureclerPage {
    WebDriver driver;

    By BTN_SURECLER = By.xpath("//ul[@class='sub-menu mm-collapse mm-show']//li[contains(@class,'current-menu-item')]//a[text()='Süreçler']");

    public SureclerPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean sureclerKontrolu() {
        if (isElementPresent(BTN_SURECLER))
            return true;
        else
            return false;
    }

    public boolean isElementPresent(By locator) {
        waitElementVisible(locator);
        return driver.findElements(locator).size() > 0;
    }

    public void waitElementVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception ignored) {
        }
    }
}
