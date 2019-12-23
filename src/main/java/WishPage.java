import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishPage {
    private WebDriver driver;
    WishPage(WebDriver driver) {
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

    String getTextProductBayed() {
        return driver.findElement(textProductBayed).getText();
    }
    void clickProductBuy() {
        driver.findElement(productBuy).click();
    }
    String getTextDeleteProduct() {
        return driver.findElement(textDeleteProduct).getText();
    }
    void clickDeleteProductWishList() {
        driver.findElement(deleteProductWishList).click();
    }
    String getNameWishList() {
        return driver.findElement(nameProductWishList).getText();
    }

}
