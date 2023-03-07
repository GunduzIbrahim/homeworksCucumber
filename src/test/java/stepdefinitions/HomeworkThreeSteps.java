package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomeworkThreePages;
import utilities.CommenSteps;
import utilities.Driver;

public class HomeworkThreeSteps {
    HomeworkThreePages homeworkThreePages = new HomeworkThreePages();
     int count = 0;
    String actualCount;
    String expectedCount;

    @Given("kullanici {string} web sayfasina gider")
    public void kullaniciWebSayfasinaGider(String url) {
        Driver.getDriver().get(url);
    }

    @When("kullanici cookiesi kabul eder")
    public void kullaniciCookiesiKabulEder() {
        try{
            CommenSteps.waitForVisibility(homeworkThreePages.cookiesAccept,5);
            homeworkThreePages.cookiesAccept.click();
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @And("kullanici Pricing linkine tiklar")
    public void kullaniciPricingLinkineTiklar() {
        homeworkThreePages.pricingLink.click();
        homeworkThreePages.otherAcceptAndCloseButton.click();
    }

    @And("kullanici BuyNow butonu ile sepete bir urun ekler")
    public void kullaniciBuyNowButonuIleSepeteBirUrunEkler() {
        homeworkThreePages.buyNowButtonSecond.click();
        count +=1;

    }

    @And("kullanici Pricing sayfasina geri doner")
    public void kullaniciPricingSayfasinaGeriDoner() {
        CommenSteps.waitForVisibility(homeworkThreePages.continueShoppingLink,5);
        homeworkThreePages.continueShoppingLink.click();
    }

    @And("kullanici Buynow butonu ile bir urun daha ekler")
    public void kullaniciBuynowButonuIleBirUrunDahaEkler() {
        homeworkThreePages.buyNowButtonFirst.click();
        count+=1;
    }

    @And("kullanici ana sayfaya geri doner")
    public void kullaniciAnaSayfayaGeriDoner() {
        CommenSteps.waitForVisibility(homeworkThreePages.continueShoppingLink,5);
        homeworkThreePages.goBackHomePage.click();
    }

    @And("kullanici sepete uzerindeki mevcut sayiyi alir")
    public void kullaniciSepeteUzerindekiMevcutSayiyiAlir() {
        actualCount = homeworkThreePages.basketItem.getText();
        expectedCount = String.valueOf(count);
        Assert.assertEquals(actualCount,expectedCount);
    }

    @And("kullanici sepete tekrar gider")
    public void kullaniciSepeteTekrarGider() {
        homeworkThreePages.basketItem.click();
    }

    @And("kullanici sepetteki urunlerden bir tanesini Delete linki ile siler")
    public void kullaniciSepettekiUrunlerdenBirTanesiniDeleteLinkiIleSiler() {
        CommenSteps.waitForVisibility(homeworkThreePages.continueShoppingLink,5);
        homeworkThreePages.deleteLinkFirst.click();
        count-=1;
    }

    @Then("kullanici sepet simgesi uzerindeki sayinin bir eksildigini kontrol eder")
    public void kullaniciSepetSimgesiUzerindekiSayininBirEksildiginiKontrolEder() {
        actualCount = homeworkThreePages.basketItem.getText();
        expectedCount = String.valueOf(count);
        Assert.assertEquals(actualCount,expectedCount);
    }
}
