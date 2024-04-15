package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage extends BasePage {

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle() {
        driver.get("https://www.google.co.uk");
    }

    public void rejectCookies() {
        WebElement rejectAllButton = driver.findElement(By.id("W0wltc"));
        rejectAllButton.click();
    }

    public void submitSearchTerm(String searchTerm) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.RETURN);
    }

    public boolean pageContains(String searchString) {
        List<WebElement> searchResults = driver.findElements(By.cssSelector("h3"));
        for (WebElement result : searchResults) {
            if (result.getText().contains(searchString)) {
                return true;
            }
        }
        return false;
    }
}
