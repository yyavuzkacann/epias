package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.plaf.PanelUI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ElektrikPiyasasiDuyurulariPage {
    WebDriver driver;

    By BTN_FILTRE = By.xpath("//p[@class='filtre-title']");
    By INP_BASLANGIC = By.xpath("//input[@id='from']");
    By INP_BITIS = By.xpath("//input[@id='to']");
    By CMB_KATEGORI = By.xpath("//select[@id='category']");
    By BTN_SUBMIT = By.xpath("//button[@class='btn btn-primary btn-sm']");
    By LBL_ARAMA_SONUCU = By.xpath("//div[@class='alert alert-primary alert-xs']");

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDateTime past = LocalDateTime.now().minusDays(7);
    LocalDateTime now = LocalDateTime.now();

    public ElektrikPiyasasiDuyurulariPage(WebDriver driver) {
        this.driver = driver;
    }

    public void filtreAc() {
        driver.findElement(BTN_FILTRE).click();
    }

    public ElektrikPiyasasiDuyurulariPage kategoriSec() {
        final Select selectBox = new Select(driver.findElement(CMB_KATEGORI));
        selectBox.selectByValue("73");
        return this;
    }

    public ElektrikPiyasasiDuyurulariPage tarihYaz() {
        dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        past = LocalDateTime.now().minusDays(7);
        now = LocalDateTime.now();
        driver.findElement(INP_BASLANGIC).sendKeys(dtf.format(past));
        driver.findElement(INP_BASLANGIC).sendKeys(Keys.ENTER);
        driver.findElement(INP_BITIS).sendKeys(dtf.format(now));
        driver.findElement(INP_BITIS).sendKeys(Keys.ENTER);
        return this;
    }

    public void filtrele() {
        driver.findElement(BTN_SUBMIT).click();
    }

    public boolean aramaSonucuOku() {
        String mesaj = driver.findElement(LBL_ARAMA_SONUCU).getText();
        if(mesaj.contains(dtf.format(past)) && mesaj.contains(dtf.format(now)))
            return true;
        else
            return false;
    }
}
