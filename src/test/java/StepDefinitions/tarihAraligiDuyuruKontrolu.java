package StepDefinitions;

import Pages.ElektrikPiyasasiDuyurulariPage;
import Pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class tarihAraligiDuyuruKontrolu {
    WebDriver driver = null;
    HomePage homePage;
    ElektrikPiyasasiDuyurulariPage elektrikPiyasasiDuyurulariPage;
    boolean isDone = false;

    @Given("^anasayfaya yonlenir$")
    public void anasayfaya_yonlenir() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.epias.com.tr/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @When("^duyurular aranir$")
    public void duyurular_aranir() {
        homePage.ara("Elektrik Piyasası Duyuruları");
    }

    @When("^linke tiklanir$")
    public void linke_tiklanir() {
        homePage.duyurulariAc();
        elektrikPiyasasiDuyurulariPage = new ElektrikPiyasasiDuyurulariPage(driver);
    }

    @When("^filtre acilir$")
    public void filtre_acilir() {
        elektrikPiyasasiDuyurulariPage.filtreAc();
    }

    @When("^tarih araligi girilir$")
    public void tarih_araligi_girilir() {
        elektrikPiyasasiDuyurulariPage
                .kategoriSec()
                .tarihYaz()
                .filtrele();
    }

    @Then("^dogru tarihin listelendigi gorulur$")
    public void dogru_tarihin_listelendigi_gorulur() {
        isDone = elektrikPiyasasiDuyurulariPage
                .aramaSonucuOku();
        if (!isDone)
            Assert.fail("Belirlenen tarih aralığı listelenmedi!!");
    }
}
