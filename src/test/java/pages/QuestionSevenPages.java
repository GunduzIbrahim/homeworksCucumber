package pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QuestionSevenPages {
    public QuestionSevenPages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "onetrust-accept-btn-handler")
    public WebElement acceptAndCloseButton;

    @FindBy (xpath = "//a[@class='TK-Aside-Menu-Link']")
    public WebElement searchIcon;

    @FindBy (xpath = "//input[@class='TK-Tag-Input']")
    public WebElement searchBox;

    @FindBy (xpath = "//button[@class='TK-Tag-Input-Button']")
    public WebElement searchButton;

    @FindBy (xpath = "(//h4[@class='TK-Search-Results-List-Item-H'])[1]")
    public WebElement firstResult;


}
