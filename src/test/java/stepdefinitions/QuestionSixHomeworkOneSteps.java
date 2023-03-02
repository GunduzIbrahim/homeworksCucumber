package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.QuestionSixHomeworkOnePages;
import utilities.Driver;

public class QuestionSixHomeworkOneSteps {

    QuestionSixHomeworkOnePages questionSixPages = new QuestionSixHomeworkOnePages();
    @When("Kullanici belirtilen sayfaya gider")
    public void kullaniciBelirtilenSayfayaGider() {
        Driver.getDriver().get("https://www.ebay.de/");
    }

    @And("Kullainci cookies secenegini accept all seçenegi ile kabul eder")
    public void kullaniciCookiesSeceneginiAcceptAllSecenegiIleKabulEder() {
        try {
            questionSixPages.acceptAllButton.click();
        }
        catch (Exception e){e.printStackTrace();}
    }

    @And("Kullanici serarchbox kutusuna computer kelimesini yazar")
    public void kullaniciSerarchboxKutusunaComputerKelimesiniYazar() {
        questionSixPages.searchBox.sendKeys("computer");
    }

    @And("Kullanici arama butonuna basar")
    public void kullaniciAramaButonunaBasar() {
        questionSixPages.searchButton.click();
    }

    @And("Kullanici filtre bolumunden windows ten secenegine tiklar")
    public void kullaniciFiltreBolumundenWindowsTenSecenegineTiklar() {
        questionSixPages.windowsTenLink.click();
    }

    @Then("Cikan seceneklerin en usttekinin windows ten ozeligini barindirdigi dogrulanir")
    public void cikanSeceneklerinEnUsttekininWindowsTenOzeliginiBarindirdigiDogrulanir() {
        Assert.assertTrue(questionSixPages.validateText.getText().contains("Windows 10"));
    }

    @And("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }
}
