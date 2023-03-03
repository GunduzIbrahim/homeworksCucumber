package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomeworkTwoPages;
import utilities.CommenSteps;
import utilities.Driver;

public class HomeworkTwoSteps {

    HomeworkTwoPages homeworkTwoPages = new HomeworkTwoPages();
    @Given("Kullanici anasayfaya gider")
    public void kullaniciAnasayfayaGider() {
        Driver.getDriver().get("https://www.telerik.com/");
    }

    @When("Kullanici cookies ile ilgili onayi kabul eder")
    public void kullaniciCookiesIleIlgiliOnayiKabulEder() {
        try{
            CommenSteps.waitForVisibility(homeworkTwoPages.acceptAndCloseButton, 5);
            homeworkTwoPages.acceptAndCloseButton.click();
        }
        catch (Exception exception){
            exception.getStackTrace();
        }

    }

    @And("Kullanici ust menu bardan pricing linkine tiklar")
    public void kullaniciUstMenuBardanPricingLinkineTiklar() {
        homeworkTwoPages.pricingLink.click();
        homeworkTwoPages.otherAcceptAndCloseButton.click();
    }

    @And("Kullanici bir paketi buy now butonu ile sepete ekler")
    public void kullaniciBirPaketiBuyNowButonuIleSepeteEkler() {

        CommenSteps.waitForVisibility(homeworkTwoPages.buyNowDevCraftButton,2);
        homeworkTwoPages.buyNowDevCraftButton.click();
    }

    @And("Kullanici anasayfaya tekrar geri gider")
    public void kullaniciAnasayfayaTekrarGeriGider() {
        CommenSteps.waitForVisibility(homeworkTwoPages.yourShoppingCartText,3);
        homeworkTwoPages.goBackMainPageLink.click();

    }

    @Then("Kullanici sepet simgesi uzerindeki rakami dogrular")
    public void kullaniciSepetSimgesiUzerindekiRakamiDogrular() {
        String expectedValue = "1";
        String actualValue = homeworkTwoPages.numberOfBasketIcon.getText();
        Assert.assertEquals(actualValue,expectedValue);
    }
}
