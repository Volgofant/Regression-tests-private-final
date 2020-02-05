package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By headerMenuLinkAccount = By.xpath("//li[@class=\"l-header__bottom-menu-item\"]/a[text()='Аккаунт']");
    By headerMenuLinkWishlist = By.xpath("//li[@class=\"l-header__bottom-menu-item\"]/a[text()='Список желаний']");
    By headerMenuLinkOrders = By.xpath("//li[@class=\"l-header__bottom-menu-item\"]/a[text()='Заказы']");
    By headerMenuLinkReview = By.xpath("//li[@class=\"l-header__bottom-menu-item\"]/a[text()='Мои отзывы']");
    By headerMenuLinkVouchers = By.xpath("//li[@class=\"l-header__bottom-menu-item\"]/a[text()='Сертификаты']");
    By headerMenuLinkEdit = By.xpath("//li[@class=\"l-header__bottom-menu-item\"]/a[text()='Данные для доступа']");
    By headerMenuLinkMyAddress = By.xpath("//li[@class=\"l-header__bottom-menu-item\"]/a[text()='Мои адреса']");
    By headerMenuLinkMailSpam = By.xpath("//li[@class=\"l-header__bottom-menu-item\"]/a[text()='Рассылки']");
    By headerMenuLinkExit = By.xpath("//li[@class=\"l-header__bottom-menu-item\"]/a[text()='Выход']");

    private By searchInput = By.xpath("//input[@id=\"searchInput\"]");
    private By registration = By.xpath("//span[@class=\"l-header__bottom-item-subline\"]");
    private By myAccount = By.xpath("//span[@class=\"l-header__bottom-item-subline\"]");
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
    private By logInMailForWishList = By.xpath("//input[@id=\"loginForm_email\"]");
    private By logInPassForWishList = By.xpath("//input[@id=\"loginForm_password\"]");
    private By buttonLoginWishList = By.xpath("//div[@class=\"blockLoginForm__submit qa-blockLoginForm__submit\"]");
    private By fuckingCoockie = By.xpath("//span[@class=\"cookiePolicyOverlay__close qa-cookiePolicyOverlay__close\"]");
    private By westwingClub = By.xpath("//li[@title=\"Westwing\"]//a");

    public MainPage closeFuckingCoockie() {
        try {
            driver.findElement(fuckingCoockie).click();
            return this;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public MainPage inputLogInMailForWishList(String mail) {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        driver.findElement(logInMailForWishList).sendKeys(mail);
        return new MainPage(driver);
    }

    public MainPage inputLogInPassForWishList(String pass) {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.findElement(logInPassForWishList).sendKeys(pass);
        return new MainPage(driver);
    }

    public MainPage clickButtonLoginWishList() {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.findElement(buttonLoginWishList).click();
        return new MainPage(driver);
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

    public void setWestwingClub() {
        driver.findElement(westwingClub).click();
    }

    void clickMyAccount() {
        driver.findElement(myAccount).click();
    }

    public void clickRegistration() {
        driver.findElement(registration).click();
        new RegistrationPage(driver);
    }

    public String getNameLogin() {
        return driver.findElement(registration).getText();
    }

    public void clickWishSpan() {
        driver.findElement(wishSpan).click();
        new MainPage(driver);
    }

    public void clickBasketSpan() {
        driver.findElement(basketSpan).click();
        new BasketPage(driver);
    }

    public void sendSearchInput(String SearchValue) {
        driver.findElement(searchInput).sendKeys(SearchValue);
        new SearchPage(driver);
    }

    public void clickEnter() {
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
        new MainPage(driver);
    }
}
