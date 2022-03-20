package StepDefinitions;

import Pages.HomePage;
import Pages.SeffaflikPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SeffaflikEkranMenuKontrolu {
    WebDriver driver = null;
    HomePage homePage;
    SeffaflikPage seffaflikPage;
    boolean isDone = false;

    @Given("^anasayfaya gidilir$")
    public void anasayfaya_gidilir() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.epias.com.tr/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }

    @When("^seffaflik menusu tiklanir$")
    public void seffaflik_menusu_tiklanir() {
        homePage.clickSeffaflikMenu();
        seffaflikPage = new SeffaflikPage(driver);
    }

    @When("^title kontrol edilir$")
    public void title_kontrol_edilir() {
        seffaflikPage.checkTitle();
    }

    @When("^sayfa maximize edilir$")
    public void sayfa_maximize_edilir() {
        driver.manage().window().maximize();
    }

    @When("^menuler kontrol edilir$")
    public void menuler_kontrol_edilir() {
        List<String> menuListe = Arrays.asList("PLATFORM HAKKINDA", "ELEKTRİK PİYASALARI",
                "ELEKTRİK ÜRETİM", "ELEKTRİK TÜKETİM", "YEKDEM", "ELEKTRİK İLETİM", "DOĞAL GAZ PİYASALARI",
                "DOĞAL GAZ İLETİM", "BARAJLAR", "PİYASA MESAJ SİSTEMİ", "WEB SERVİS", "KURUL KARARI");
        isDone = seffaflikPage.checkMenu(menuListe);
    }

    @Then("^sayfanin eksiksiz yuklendigi gorulur$")
    public void sayfanin_eksiksiz_yuklendigi_gorulur() {
        if (!isDone)
            Assert.fail("Sayfa tam olarak yüklenemedi");
    }

}
