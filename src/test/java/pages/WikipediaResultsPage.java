package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class WikipediaResultsPage extends BasePage {
    public WikipediaResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstHeading")
    private WebElement pageTitle;

    @FindBy(id = "mw-panel-toc")
    private WebElement sidebar;

    @FindBy(id = "ca-edit")
    private WebElement editBtn;

    @FindBy(className = "vector-header-container")
    private WebElement navbar;

    @FindBy(className = "mw-headline")
    private List<WebElement> h2List;

    public boolean titleIsDisplayed(){
        wait.until(ExpectedConditions.elementToBeClickable(pageTitle));
       return pageTitle.isDisplayed();
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public WikipediaEditPage clickOnEditBtn(){
        editBtn.click();
        return new WikipediaEditPage(driver);
    }

    public boolean sidebarIsPresent(){
        return sidebar.isDisplayed();
    }

    public boolean navbarIsPresent(){
        return navbar.isDisplayed();
    }

}
