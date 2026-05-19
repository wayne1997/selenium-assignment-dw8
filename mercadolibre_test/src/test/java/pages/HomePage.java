package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By purchasesCategory = By.xpath("//*[contains(text(), 'Compras')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToPurchasesCategory() {
        jsClick(purchasesCategory);
    }
}