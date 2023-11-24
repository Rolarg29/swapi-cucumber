package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WikipediaHomePage extends BasePage{
    public WikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search Wikipedia']")
    private WebElement searchInput;

    public WikipediaResultsPage searchValue(String name) {
        searchInput.sendKeys(name);
        try{
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new WikipediaResultsPage(driver);
    }

}
