package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    By BTN_HIZLI_OPEN = By.xpath("//a[@class='hizli-open']");
    By BTN_SEFFAFLIK_PLATFORMU = By.xpath("//a[contains(text(),'ŞEFFAFLIK PLATFORMU')]");
    By BTN_BULTEN_KAPA = By.xpath("//a[@class='bulten-tip-kapa']");
    By BTN_SURECLER_MENU = By.xpath("(//div[@class='anamenu']//ul[@class='menu transition']//a[contains(text(),'ELEKTRİK PİYASASI')])[1]");
    By BTN_SPOT_ELEKTRIK_PIYASALARI = By.xpath("//div[@class='anamenu']//a[text()='SPOT ELEKTRİK PİYASALARI']");
    By BTN_GUN_ICI_PIYASASI = By.xpath("//div[@class='anamenu']//a[text()='GÜN İÇİ PİYASASI']");
    By BTN_SURECLER = By.xpath("//div[@class='anamenu']//a[text()='GÜN İÇİ PİYASASI']/..//a[text()='Süreçler']");
    By INP_ARAMA = By.xpath("(//input[@class='arama-input'])[2]");
    By BTN_ELEKTRIK_PIYASASI_DUYURULARI = By.xpath("//a[contains(text(),'Elektrik Piyasası Duyuruları')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSeffaflikMenu() {
        if (isElementPresent(BTN_BULTEN_KAPA))
            driver.findElement(BTN_BULTEN_KAPA).click();
        driver.findElement(BTN_HIZLI_OPEN).click();
        waitUntilElementClickable(BTN_SEFFAFLIK_PLATFORMU);
        driver.findElement(BTN_SEFFAFLIK_PLATFORMU).click();
    }

    public void goToSurecler() {
        mouseHover(driver.findElement(BTN_SURECLER_MENU));
        mouseHover(driver.findElement(BTN_SPOT_ELEKTRIK_PIYASALARI));
        mouseHover(driver.findElement(BTN_GUN_ICI_PIYASASI));
        driver.findElement(BTN_SURECLER).click();
    }

    public void ara(String text) {
        driver.findElement(INP_ARAMA).sendKeys(text);
        driver.findElement(INP_ARAMA).sendKeys(Keys.ENTER);
    }

    public void duyurulariAc(){
        driver.findElement(BTN_ELEKTRIK_PIYASASI_DUYURULARI).click();
    }

    public void mouseHover(WebElement locator) {
        Actions action = new Actions(driver);
        action.moveToElement(locator).perform();
    }

    public void waitUntilElementClickable(By locator) {
        try {
            WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
            wt.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception exception) {
            System.out.print("Element ekranda görüntülenemedi.");
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
