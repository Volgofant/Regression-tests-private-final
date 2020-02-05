package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainLoginedPage {
    private WebDriver driver;

    MainLoginedPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchInput = By.xpath("//input[@id=\"searchInput\"]");
    private By registration = By.xpath("//span[text()='Зарегистрироваться']");
    private By wishSpan = By.xpath("//span[text()='Список желаний']");
    private By basketSpan = By.xpath("//span[text()='Корзина']");
    private By novelties = By.xpath("//a[text()='\n" +
            "                    Новинки                ']");
    private By collectAnImage = By.xpath("//a[text()='                        Собери образ                    ']");
    private By furniture = By.xpath("//a[text()='\n" +
            "                    Мебель                ']");
    private By decor = By.xpath("//a[text()='                    Декор                ']");
    private By lightning = By.xpath("//a[text()='\n" +
            "                    Освещение                ']");
    private By textiles = By.xpath("//a[text()='\n" +
            "                    Текстиль и ковры                ']");
    private By wareAndAccessories = By.xpath("//a[text()='\n" +
            "                    Посуда и аксессуары                ']");


    public RegistrationPage clickRegistration() {
        driver.findElement(registration).click();
        return new RegistrationPage(driver);
    }

    public WishPage clickWishSpan() {
        driver.findElement(wishSpan).click();
        return new WishPage(driver);
    }

    public BasketPage clickBasketSpan() {
        driver.findElement(basketSpan).click();
        return new BasketPage(driver);
    }

    public SearchPage sendSearchInput(String SearchValue) {
        driver.findElement(searchInput).sendKeys(SearchValue);
        return new SearchPage(driver);
    }

    public NoveltiesPage clickNovelties() {
        driver.findElement(novelties).click();
        return new NoveltiesPage(driver);
    }

    public CollectAnImagePage clickCollectAnImage() {
        driver.findElement(collectAnImage).click();
        return new CollectAnImagePage(driver);
    }

    public FurniturePage clickFurniture() {
        driver.findElement(furniture).click();
        return new FurniturePage(driver);
    }

    public DekorPage clickDecor() {
        driver.findElement(decor).click();
        return new DekorPage(driver);
    }

    public LightningPage clickLightning() {
        driver.findElement(lightning).click();
        return new LightningPage(driver);
    }

    public TextilesPage clickTextiles() {
        driver.findElement(textiles).click();
        return new TextilesPage(driver);
    }

    public WareAndAccessoriesPage clickWareAndAccessories() {
        driver.findElement(wareAndAccessories).click();
        return new WareAndAccessoriesPage(driver);
    }
}

