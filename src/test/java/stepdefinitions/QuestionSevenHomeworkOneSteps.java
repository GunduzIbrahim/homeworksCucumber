package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.QuestionSevenHomeworkOnePages;
import utilities.CommenSteps;
import utilities.Driver;

public class QuestionSevenHomeworkOneSteps {

    QuestionSevenHomeworkOnePages questionSevenPages = new QuestionSevenHomeworkOnePages();
    @Given("Kullanici belirtilen siteye gider")
    public void kullaniciBelirtilenSiteyeGider() throws InterruptedException {
        Driver.getDriver().get("https://www.telerik.com/support/demos");
        Thread.sleep(2000);

    }

    @And("Kullanici cookie seceneklerinden accept and close a tiklar")
    public void kullaniciCookieSeceneklerindenAcceptAndCloseATiklar() {

        try {
            CommenSteps.waitForVisibility(questionSevenPages.acceptAndCloseButton, 5);
            questionSevenPages.acceptAndCloseButton.click();
        }
        catch (Exception e){e.getStackTrace();
        }
    }

    @And("Kullanici ust menu bardaki arama simgesine tiklar")
    public void kullaniciUstMenuBardakiAramaSimgesineTiklar() {
        questionSevenPages.searchIcon.click();
    }

    @And("Kuulanici search box kutusuna {string} aranacak kelime yazar")
    public void kuulaniciSearchBoxKutusunaAranacakKelimeYazar(String kelime) {
        questionSevenPages.searchBox.sendKeys(kelime);
    }

    @And("Kullanici arama butonuna tiklar")
    public void kullaniciAramaButonunaTiklar() throws InterruptedException {
        questionSevenPages.searchButton.click();
    }

    @Then("Kullanici cikan ilk secenegin {string} aranan kelimeleri icerdigini kontrol eder")
    public void kullaniciCikanIlkSeceneginArananKelimeleriIcerdiginiKontrolEder(String kelime) {

        String kelimeler[]=kelime.split(" ");
        for (String arananKelime : kelimeler) {
            Assert.assertTrue(questionSevenPages.firstResult.getText().toLowerCase().contains(arananKelime));
        }
    }

    @And("Kullanici close page")
    public void kullaniciClosePage() {
        Driver.closeDriver();
    }
}
