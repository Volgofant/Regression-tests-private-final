package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishPage {
    private WebDriver driver;
    public WishPage(WebDriver driver) {
        this.driver = driver;
    }

    private By buttonNewList = By.xpath("//button[text()='Новый список']");
    private By listName = By.xpath("//input[@id=\"blockCreateListOverlay__inputId\"]");
    private By buttonInk = By.xpath("//button[@class=\"btn-primary blockCreateListOverlay__confirm qaBlockCreateListOverlay__confirm\"]");
    private By nameProductWishList = By.xpath("//p[@class=\"blockListProduct__name\"]");
    private By deleteProductWishList = By.xpath("//button[@class=\"blockListProduct__delete qaBlockListProduct__delete\"]");
    private By textDeleteProduct = By.xpath("//div[@class=\"message__text\"]");
    private By productBuy = By.xpath("//button[@class=\"blockListProduct__addToCart qaBlockListProduct__addToCart\"]");
    private By textProductBayed = By.xpath("//div[@class=\"message__text\"]");


    public WishPage clickButtonNewList() {
        driver.findElement(buttonNewList).click();
        return this;
    }
    public WishPage insertListName (String name) {
        driver.findElement(listName).sendKeys(name);
        return this;
    }
    public WishPage clickButtonLink() {
        driver.findElement(buttonInk).click();
        return this;
    }

    public String getTextProductBayed() {
        return driver.findElement(textProductBayed).getText();
    }
    public void clickProductBuy() {
        driver.findElement(productBuy).click();
    }

    public void clickSomeProductBuy(String sku) {
        driver.findElement(By.xpath("//li[@data-sku=\""+ sku +"\"]//button[@class=\"blockListProduct__addToCart qaBlockListProduct__addToCart\"]")).click();
    }
    public String getTextDeleteProduct() {
        return driver.findElement(textDeleteProduct).getText();
    }
    public void clickDeleteProductWishList() {
        driver.findElement(deleteProductWishList).click();
    }
    public String getNameWishList() {
        return driver.findElement(nameProductWishList).getText();
    }

}
