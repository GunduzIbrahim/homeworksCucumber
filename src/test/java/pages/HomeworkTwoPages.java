package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomeworkTwoPages {
    public HomeworkTwoPages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "onetrust-accept-btn-handler")
    public WebElement acceptAndCloseButton;

    @FindBy (xpath = "(//a[@class='TK-Menu-Item-Link'])[5]")
    public WebElement pricingLink;

    @FindBy (id ="onetrust-accept-btn-handler")
    public WebElement otherAcceptAndCloseButton;

    @FindBy (xpath = "(//a[@class='Btn Btn--prim4 u-db'])[2]")
    public WebElement buyNowDevCraftButton;

    @FindBy (xpath = "//h1[@class='u-mb20 sm-hidden page-title']")
    public WebElement yourShoppingCartText;

    @FindBy (xpath = "//a[@class='TK-TLRK-Logo']")
    public WebElement goBackMainPageLink;

    @FindBy (xpath = "//span[@class='TK-Counter TK-Counter--SC TK-Counter--Visible']")
    public WebElement numberOfBasketIcon;
}
