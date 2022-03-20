package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SeffaflikPage {
    WebDriver driver = null;

    public SeffaflikPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkTitle() {
        openLastPage();
        String title = driver.getTitle();
        Assert.assertEquals(title, "EPİAŞ ŞEFFAFLIK PLATFORMU - ANASAYFA");
    }

    public boolean checkMenu(List<String> menuler) {
        for (String menu : menuler) {
            By menuElement = By.xpath("//ul[@class='layout-menu']//a[contains(text(),'" + menu + "')]");
            if (!isElementPresent(menuElement))
                Assert.fail(menu + " menüsü ekranda görüntülenemedi");
        }
        return true;
    }

    public void openLastPage() {
        Set<String> windows = driver.getWindowHandles();
        int i = 0;
        for (String handle : windows) {
            i++;
            if (i == windows.size())
                driver.switchTo().window(handle);
        }
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
