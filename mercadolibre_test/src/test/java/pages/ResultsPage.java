package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends BasePage {
    private By firstResultTitle = By.xpath("(//ol[contains(@class, 'search-layout')]//h2)[1]");

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstResultText() {
        return getText(firstResultTitle);
    }
}