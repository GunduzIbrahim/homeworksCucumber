package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomeworkThreePages {
    public HomeworkThreePages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id="onetrust-accept-btn-handler")
    public WebElement cookiesAccept;
    @FindBy (xpath = "(//a[@class='TK-Menu-Item-Link'])[5]")
    public WebElement pricingLink;
    @FindBy (id ="onetrust-accept-btn-handler")
    public WebElement otherAcceptAndCloseButton;
    @FindBy (xpath = "(//a[@class='Btn Btn--prim4 u-db'])[1]")
    public WebElement buyNowButtonFirst;
    @FindBy (xpath = "(//a[@class='Btn Btn--prim4 u-db'])[2]")
    public WebElement buyNowButtonSecond;
    @FindBy(xpath = "//a[@class='referrer-link']")
    public WebElement continueShoppingLink;
    @FindBy (xpath = "//a[@class='TK-TLRK-Logo']")
    public WebElement goBackHomePage;
    @FindBy (xpath = "//a[@title='Shopping cart']")
    public WebElement basketItem;
    @FindBy (xpath = "(//a[@class='e2e-delete-item btn-delete-item ng-star-inserted'])[1]")
    public WebElement deleteLinkFirst;

}
