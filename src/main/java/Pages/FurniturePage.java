package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FurniturePage {
    private WebDriver driver;
    public FurniturePage(WebDriver driver) {
        this.driver = driver;
    }

    private By product = By.xpath("//button[@data-sku=\"RUQ19TES260008-160759\"]/parent::article");

    public void clickProduct() {
        driver.findElement(product).click();
    }
}
