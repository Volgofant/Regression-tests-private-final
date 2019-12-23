import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestMainClass {
    private WebDriver driver;
    private MainPage mainPage;
    private AccountPage accountPage;
    private BasketPage basketPage;
    private RegistrationPage registrationPage;
    private FurniturePage furniturePage;
    private WishPage wishPage;
    private ProductPage productPage;
    private BillPages billPages;

    private Date dateNow = new Date();
    private SimpleDateFormat format = new SimpleDateFormat("hhч mmмин ssсек");
    private String fileName = format.format(dateNow) + ".png";

    private void screenshot() {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("C:\\Users\\viktor.nenashev\\screenshots\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\viktor.nenashev\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
//        mainPage.closeFuckingCoockie();
        registrationPage = new RegistrationPage(driver);
        accountPage = new AccountPage(driver);
        basketPage = new BasketPage(driver);
        furniturePage = new FurniturePage(driver);
        wishPage = new WishPage(driver);
        productPage = new ProductPage(driver);
        billPages = new BillPages(driver);

    }

    @Test
    public void SkuTransferService() {
        driver.get("http://192.168.50.166:3200/get-sku?sku[]=RUQ19JOS880712");
        Assert.assertEquals("{\"RUQ19JOS880712\":[\"AR600WWAVSXJRU\",\"HA958WWBFXAORU\",\"HA958WWBIELBRU\",\"XX785WWAKSYNRU\"]}", driver.findElement(By.xpath("//pre")).getText());
        driver.get("http://192.168.50.166:3200/get-sku?sku[]=RUQ19ZOK960890");
        Assert.assertEquals("{\"RUQ19ZOK960890\":[\"ZO700WWBB6PORU\",\"ZO700WWBHN19RU\",\"ZO700WWBJYEPRU\"]}", driver.findElement(By.xpath("//pre")).getText());
        driver.get("http://192.168.50.166:3200/get-sku?sku[]=RUQ19TOM111180");
        Assert.assertEquals("{\"RUQ19TOM111180\":[\"TO639WWBAQJIRU\",\"TO639WWBDLOTRU\",\"TO639WWBFH8IRU\",\"TO639WWBI087RU\"]}", driver.findElement(By.xpath("//pre")).getText());
        driver.get("http://192.168.50.166:3200/get-sku?sku[]=RUQ19TOM339702");
        Assert.assertEquals("{\"RUQ19TOM339702\":[\"TO639WWBDLO6RU\",\"TO639WWBFH7VRU\",\"TO639WWBI07KRU\"]}", driver.findElement(By.xpath("//pre")).getText());
        driver.get("http://192.168.50.166:3200/get-sku?sku[]=RUQ19TOM610891");
        Assert.assertEquals("{\"RUQ19TOM610891\":[\"TO639WWBDLO3RU\",\"TO639WWBFH7SRU\",\"TO639WWBI07HRU\"]}", driver.findElement(By.xpath("//pre")).getText());
    }

    @Test
    public void registrationNullNameTest() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            Integer element = registrationPage.i;
            String let = Integer.toString(element);
            String str = "a" + let;
            mainPage.clickRegistration();
            registrationPage.insertSignInName("");
            registrationPage.insertSignInSurname("Ненашев");
            registrationPage.insertSignInMail("nenashev" + str + "@mail.ru");
            registrationPage.insertSignInPass("1q2w3e4r");
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            Assert.assertEquals("Обязательное поле", registrationPage.getErrorMessageNullName());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }

    }

    @Test
    public void registrationNullSurNameTest() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            Integer element = registrationPage.i;
            String let = Integer.toString(element);
            String str = "a" + let;
            mainPage.clickRegistration();
            registrationPage.insertSignInName("Виктор");
            registrationPage.insertSignInSurname("");
            registrationPage.insertSignInMail("nenashev" + str + "@mail.ru");
            registrationPage.insertSignInPass("1q2w3e4r");
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            Assert.assertEquals("Обязательное поле", registrationPage.getErrorMessageNullSurName());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void registrationNullMail() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            mainPage.clickRegistration();
            registrationPage.insertSignInName("Виктор");
            registrationPage.insertSignInSurname("Ненашев");
            registrationPage.insertSignInMail("");
            registrationPage.insertSignInPass("1q2w3e4r");
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            Assert.assertEquals("Поле обязательно для заполнения", registrationPage.getErrorMessageNullMail());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void registrationRepeatMail() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            mainPage.clickRegistration();
            registrationPage.insertSignInName("Виктор");
            registrationPage.insertSignInSurname("Ненашев");
            registrationPage.insertSignInMail("borcuha64@mail.ru");
            registrationPage.insertSignInPass("1q2w3e4r");
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            Assert.assertEquals("Пользователь с таким адресом уже зарегистрирован", registrationPage.getErrorMessageRepeatMail());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void registrationWrongMail() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            mainPage.clickRegistration();
            registrationPage.insertSignInName("Виктор");
            registrationPage.insertSignInSurname("Ненашев");
            registrationPage.insertSignInMail("borcuha64@s");
            registrationPage.insertSignInPass("1q2w3e4r");
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            Assert.assertEquals("Неверный адрес электронной почты", driver.findElement(By.xpath("//div[@class=\"s-error msg\"]")).getText());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void registrationNullPassword() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            Integer element = registrationPage.i;
            String let = Integer.toString(element);
            String str = "a" + let;
            mainPage.clickRegistration();
            registrationPage.insertSignInName("nenashev" + str);
            registrationPage.insertSignInSurname("nenashev" + str);
            registrationPage.insertSignInMail("nenashev" + str + "@mail.ru");
            registrationPage.insertSignInPass("");
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            Assert.assertEquals("Поле обязательно для заполнения", registrationPage.getNullPassNo());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void registrationSmallPassword() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            Integer element = registrationPage.i;
            String let = Integer.toString(element);
            String str = "a" + let;
            mainPage.clickRegistration();
            registrationPage.insertSignInName("nenashev" + str);
            registrationPage.insertSignInSurname("nenashev" + str);
            registrationPage.insertSignInMail("nenashev" + str + "@mail.ru");
            registrationPage.insertSignInPass("12345");
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            Assert.assertEquals("Пароль поле слишком короткое (не менее 6 знаков)", registrationPage.getNullPassNo());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void registrationBigPassword() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            Integer element = registrationPage.i;
            String let = Integer.toString(element);
            String str = "a" + let;
            mainPage.clickRegistration();
            registrationPage.insertSignInName("nenashev" + str);
            registrationPage.insertSignInSurname("nenashev" + str);
            registrationPage.insertSignInMail("nenashev" + str + "@mail.ru");
            registrationPage.insertSignInPass("123451234512345123451234512345123451234512345123451");
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            Assert.assertEquals("Максимум 50 символов", registrationPage.getThisPageWrongPass());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void registrationOkFemale() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            Integer element = registrationPage.i;
            String let = Integer.toString(element);
            String str = "a" + let;
            mainPage.clickRegistration();
            registrationPage.choiceMaleGender();
            registrationPage.choiceFemaleGender();
            registrationPage.insertSignInName("nenashev" + str);
            registrationPage.insertSignInSurname("nenashev" + str);
            registrationPage.insertSignInMail("nenashev" + str + "@mail.ru");
            registrationPage.insertSignInPass("nenashev" + str);
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            Thread.sleep(3000);
            Assert.assertEquals("nenashev" + str, mainPage.getNameLogin());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void registrationOkMale() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            Integer element = registrationPage.i;
            String let = Integer.toString(element);
            String str = "a" + let;
            mainPage.clickRegistration();
            String constant = "nenashev" + str;
            registrationPage.choiceMaleGender();
            registrationPage.insertSignInName(constant);
            registrationPage.insertSignInSurname(constant);
            registrationPage.insertSignInMail(constant + "@mail.ru");
            registrationPage.insertSignInPass(constant);
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Assert.assertEquals(constant, mainPage.getNameLogin());
//        driver.get("https://crm-app-stage.ww-ru.ru/ru/messages?created_at=&ecircle_response=&email=&message_type=&origin=&state=");
//        driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("viktor.nenashev@westwing.ru");
//        driver.findElement(By.xpath("//input[@id=\"next\"]")).click();
//        driver.findElement(By.xpath("//input[@id=\"Passwd\"]")).sendKeys("9112146104");
//        driver.findElement(By.xpath("//input[@id=\"signIn\"]")).click();
//        Assert.assertEquals(constant + "@mail.ru", driver.findElement(By.xpath("//td[text()='" + constant + "@mail.ru" + "']")).getText());
//        Assert.assertEquals("customer_successfulregistration", driver.findElement(By.xpath("//tbody/tr/td[7]")).getText());
//        Thread.sleep(20000);
//        Assert.assertEquals("executed" , driver.findElement(By.xpath("//tbody/tr/td[3]")).getText());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void registrationNullAll() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            mainPage.clickRegistration();
            registrationPage.clickSignInButton();
            Assert.assertEquals("Обязательное поле", registrationPage.getErrorMessageNullName());
            Assert.assertEquals("Обязательное поле", registrationPage.getErrorMessageNullSurName());
            Assert.assertEquals("Поле обязательно для заполнения", registrationPage.getErrorMessageNullMail());
            Assert.assertEquals("Поле обязательно для заполнения", registrationPage.getErrorMessageMailOnPass());
            Assert.assertEquals("Обязательное поле", registrationPage.getNullAgreements());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }

    }

    @Test
    public void registrationOnFacebook() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            mainPage.clickRegistration();
            String mainWindow = driver.getWindowHandle();
            registrationPage.clickSingInFacebook();
            registrationPage.inputFacebookInfo();
            driver.switchTo().window(mainWindow);
            WebElement dunamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("accountStep1__header__text")));
            Assert.assertEquals("Из обзора учетной записи пользователя можно просматривать последние операции и редактировать данные учетной записи. Для этого выберите одну из ссылок ниже для просмотра или редактирования.", accountPage.getHelloMessage());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void logIngOnFacebook() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            mainPage.clickRegistration();
            String mainWindow = driver.getWindowHandle();
            Thread.sleep(500);
            registrationPage.loginInFacebook();
            registrationPage.inputFacebookInfo();
            driver.switchTo().window(mainWindow);
            Thread.sleep(4000);
            Assert.assertEquals("Виктор", mainPage.getNameLogin());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void WishList() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            mainPage.clickRegistration();
            registrationPage.insertLogInMail("kpamel@bk.ru");
            registrationPage.insertLogInPass("1q2w3e4r");
            registrationPage.clickLogInButton();
            mainPage.sendSearchInput("Ковер Hippy от Lorena Canals");
            mainPage.clickEnter();
            furniturePage.clickProduct();
            String product = productPage.getProductName();
            try {
                productPage.clickButtonInWishList();
                productPage.clickButtonChoiceWishList();
            } catch (Exception e) {
                productPage.clickButtonChoiceWishList();
            } finally {
                Thread.sleep(1000);
                mainPage.clickWishSpan();
                Assert.assertEquals(product, wishPage.getNameWishList());
                wishPage.clickDeleteProductWishList();
                Assert.assertEquals("Продукт был удален из Вашего списка Список желаний", wishPage.getTextDeleteProduct());
            }
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void WishListProductInBasket() throws InterruptedException {
        driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
        mainPage.clickRegistration();
        registrationPage.insertLogInMail("kpamel@bk.ru");
        registrationPage.insertLogInPass("1q2w3e4r");
        registrationPage.clickLogInButton();
        mainPage.sendSearchInput("Ковер Hippy от Lorena Canals");
        mainPage.clickEnter();
        furniturePage.clickProduct();
        String product = productPage.getProductName();
        try {
            productPage.clickButtonInWishList();
            productPage.clickButtonChoiceWishList();
        } catch (Exception e) {

        } finally {
            Thread.sleep(1000);
            mainPage.clickWishSpan();
            wishPage.clickProductBuy();
            Thread.sleep(500);
            Assert.assertEquals("Товар успешно добавлен в корзину", wishPage.getTextProductBayed());
            mainPage.clickBasketSpan();
            Assert.assertEquals(product, basketPage.getProductName());
            basketPage.clickProductDelete();
//                basketPage.clickConfirmProductDelete();
            mainPage.clickWishSpan();
            wishPage.clickDeleteProductWishList();
            Assert.assertEquals("Продукт был удален из Вашего списка Список желаний", wishPage.getTextDeleteProduct());
        }
    }

    @Test
    public void doOrderFirstTime() {
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            Integer element = registrationPage.i;
            String let = Integer.toString(element);
            String str = "a" + let;
            mainPage.clickRegistration();
            registrationPage.choiceMaleGender();
            registrationPage.insertSignInName("nenashev" + str);
            registrationPage.insertSignInSurname("nenashev" + str);
            registrationPage.insertSignInMail("nenashev" + str + "@mail.ru");
            registrationPage.insertSignInPass("nenashev" + str);
            registrationPage.checkBoxAgreement();
            registrationPage.checkBoxMailSpam();
            registrationPage.clickSignInButton();
            mainPage.sendSearchInput("Ковер Hippy от Lorena Canals");
            mainPage.clickEnter();
            furniturePage.clickProduct();
            productPage.clickButtonInBasket();
            mainPage.clickBasketSpan();
            basketPage.clickPayButton();
            billPages.inputName();
            billPages.inputSurname();
            billPages.inputCity();
            billPages.choiceDeliveryMethodExpress();
            billPages.inputStreetNumber();
            billPages.inputMailIndex();
            billPages.inputPhone();
            billPages.clickButtonNextStep();
            billPages.clickButtonNextStep2();
            billPages.clickCheckoutBtn();

            Assert.assertEquals("Спасибо за покупку!", billPages.getTextCheckreadyOrder());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void doOrderRepeatedlyTimeCash() {
        String mail = "tovaro@mail.ru";
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            mainPage.clickRegistration();
            registrationPage.insertLogInMail(mail);
            registrationPage.insertLogInPass("westwingpas");
            registrationPage.clickLogInButton();
            mainPage.sendSearchInput("Ковер Hippy от Lorena Canals");
            mainPage.clickEnter();
            furniturePage.clickProduct();
            productPage.clickButtonInBasket();
            mainPage.clickBasketSpan();
            basketPage.clickPayButton();
            billPages.choiceDeliveryMethodExpress();
            billPages.clickButtonNextStep();
            if (driver.findElement(billPages.getCash()).isSelected()) {
                billPages.clickButtonNextStep();
                billPages.clickCheckoutBtn();
            } else {
                billPages.choiceCash();
                billPages.clickButtonNextStep();
                billPages.clickCheckoutBtn();
            }
            Assert.assertEquals("Спасибо за покупку!", billPages.getTextCheckreadyOrder());
//            driver.get("https://crm-app-stage.ww-ru.ru/ru/messages?created_at=&ecircle_response=&email=&message_type=&origin=&state=");
//            driver.findElement(By.xpath("//input[@id=\"Email\"]")).sendKeys("viktor.nenashev@westwing.ru");
//            driver.findElement(By.xpath("//input[@id=\"next\"]")).click();
//            driver.findElement(By.xpath("//input[@id=\"Passwd\"]")).sendKeys("9112146104");
//            driver.findElement(By.xpath("//input[@id=\"signIn\"]")).click();
//            Assert.assertEquals(mail, driver.findElement(By.xpath("//tbody/tr/td[2]")).getText());
//            Assert.assertEquals("executed", driver.findElement(By.xpath("//tbody/tr/td[3]")).getText());
//            Assert.assertEquals("sales_orderconfirmation", driver.findElement(By.xpath("//tbody/tr/td[7]")).getText());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }
    }

    @Test
    public void doOrderRepeatedlyTimeCreditCard() {
        String mail = "tovaro@mail.ru";
        try {
            driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
            mainPage.clickRegistration();
            registrationPage.insertLogInMail(mail);
            registrationPage.insertLogInPass("westwingpas");
            registrationPage.clickLogInButton();
            mainPage.sendSearchInput("Ковер Hippy от Lorena Canals");
            mainPage.clickEnter();
            furniturePage.clickProduct();
            productPage.clickButtonInBasket();
            mainPage.clickBasketSpan();
            basketPage.clickPayButton();
            billPages.choiceDeliveryMethodExpress();
            billPages.clickButtonNextStep();
            if (driver.findElement(billPages.getCreditCard()).isSelected()) {
                billPages.clickButtonNextStep2();
                billPages.clickCheckoutBtn();
            } else {
                billPages.choiceCreditCard();
                billPages.clickButtonNextStep2();
                billPages.clickCheckoutBtn();
            }
            Assert.assertEquals("ООО \"ВЕСТВИНГ РАША\"", billPages.getTextYandexPayService());
            driver.findElement(By.xpath("//input[@id=\"cardNumber\"]")).sendKeys("4444 4444 4444 4448");
            driver.findElement(By.xpath("//input[@name=\"skr_month\"]")).sendKeys("12");
            driver.findElement(By.xpath("//input[@name=\"skr_year\"]")).sendKeys("20");
            driver.findElement(By.xpath("//input[@name=\"skr_cardCvc\"]")).sendKeys("444");
            driver.findElement(By.xpath("//button[@class=\"button button_size_m button_theme_action payment-contract__pay-button i-bem button_js_inited\"]")).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Assert.assertEquals("Спасибо за покупку!", driver.findElement(By.xpath("//div[@class=\"checkout__finish__left__header\"]/p[@class=\"checkout__finish__left__text\"]")).getText());
        } catch (Exception e) {
            System.out.println(e);
            screenshot();
            Assert.fail();
        }

    }

    @Test
    public void changePass() throws InterruptedException {
        driver.get("https://alice-ru.shop-stage.ww-ru.ru/");
        Integer element = registrationPage.i;
        String let = Integer.toString(element);
        String str = "a" + let;
        mainPage.clickRegistration();
        registrationPage.choiceMaleGender();
        registrationPage.insertSignInName("nenashev" + str);
        registrationPage.insertSignInSurname("nenashev" + str);
        registrationPage.insertSignInMail("nenashev" + str + "@mail.ru");
        registrationPage.insertSignInPass("westwingpas");
        registrationPage.checkBoxAgreement();
        registrationPage.checkBoxMailSpam();
        registrationPage.clickSignInButton();
        mainPage.clickMyAccount();
        accountPage.clickChangeDate();
        accountPage.clickButtonChangePass();
        accountPage.inputActualPass("westwingpas");
        accountPage.inputNewPass("newwestwingpas");
        accountPage.inputNewPassConfirm("newwestwingpas");
        accountPage.clickSaveNewPass();
        Thread.sleep(3000);
        String OkPassChange = accountPage.getTextPassChange();
        Assert.assertEquals("Пароль успешно изменен", OkPassChange);
    }

    //    @Test
//    public void forgetPass() throws InterruptedException {
//        mainPage.clickRegistration();
//        driver.findElement(By.xpath("//a[@class=\"jsCheckout__forms__checkout__link checkout__forms__checkout__link\"]")).click();
//        driver.findElement(By.xpath("//input[@class=\"passwordForgot__email\"]")).sendKeys("ovetstrahaev@yandex.ru");
//        driver.findElement(By.xpath("//button[@class=\"passwordForgot__button btn-primary ga-forgot-password\"]")).click();
//        Assert.assertEquals("Пожалуйста, проверьте свои входящие", driver.findElement(By.xpath("//div[@class=\"passwordConfirm__headline\"]")).getText());
//        driver.get("https://mail.yandex.ru/?addMultiUserFromDropdownButton=true&uid=928663549#inbox");
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//a[@class=\"button2 button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow\"]")).click();
//        driver.findElement(By.xpath("//input[@id=\"passp-field-login\"]")).sendKeys("ovetstrahaev@yandex.ru\n");
//        driver.findElement(By.xpath("//input[@id=\"passp-field-passwd\"]")).sendKeys("westwingpas");
//        driver.findElement(By.xpath("//button[@class=\"control button2 button2_view_classic button2_size_l button2_theme_action button2_width_max button2_type_submit passp-form-button\"]")).click();
////        driver.findElement(By.xpath("//button[@class=\"control button2 button2_view_classic button2_size_l button2_theme_normal button2_width_max passp-form-button\"]")).click();
//        driver.findElement(By.xpath("//span[text()='Смена вашего пароля на Westwing.ru']")).click();
//        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div[3]/div/div[1]/table/tbody/tr[1]/td[2]/table[1]/tbody/tr/td/table[2]/tbody/tr/td/table[3]/tbody/tr/td/div/table/tbody/tr/td/a")).click();
//        for (String winHandle : driver.getWindowHandles()) {
//            System.out.println(winHandle);
//            driver.switchTo().window(winHandle);
//        }
//        driver.findElement(By.xpath("//input[@id=\"PasswordForm_password\"]")).sendKeys("westwingpas");
//        driver.findElement(By.xpath("//button[@class=\"btn-primary restorePassword__form__btn ga-reset-password\"]")).click();
//        Assert.assertEquals("Овец Трахаев", driver.findElement(By.xpath("//p[@class=\"accountStep1__row__box__main__text\"]")).getText());
//        Assert.assertEquals("Пароль успешно изменен", driver.findElement(By.xpath("//div[@class=\"message__text\"]")).getText());
//    }
    @Test
    public void stockUploadOnLive() throws InterruptedException {
        String urlLive = "http://bob-shop.westwing.ru/stock/upload";
        String urlProduct = "http://bob-shop.westwing.ru/pet/product#129104/creation/simples";
        driver.get(urlLive);
        driver.findElement(By.xpath("//a[@href=\"http://bob-shop.westwing.ru/stock/upload?setWebsite=8\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("nenashev");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("nenashev4321");
        driver.findElement(By.xpath("//input[@id=\"login\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"doc_path\"]")).sendKeys("C:\\автозагрузка стока Лайв\\First test upload.csv");
        driver.findElement(By.xpath("//input[@id=\"submitbutton\"]")).click();
        driver.get(urlProduct);
        Thread.sleep(15000);
        Assert.assertEquals("41", driver.findElement(By.xpath("//div[@class=\"x-list-body-inner\"]/dl/dt[8]/em")).getText());
        driver.get(urlLive);
        driver.findElement(By.xpath("//input[@id=\"doc_path\"]")).sendKeys("C:\\автозагрузка стока Лайв\\secondarily test upload.csv");
        driver.findElement(By.xpath("//input[@id=\"submitbutton\"]")).click();
        driver.get(urlProduct);
        Thread.sleep(15000);
        Assert.assertEquals("91", driver.findElement(By.xpath("//div[@class=\"x-list-body-inner\"]/dl/dt[8]/em")).getText());
    }

    @Test
    public void stockUploadOnStage() throws InterruptedException {
        String urlProduct = "https://bob.shop-stage.ww-ru.ru/pet/product/#130471/creation/simples";
        String urlStage = "https://bob.shop-stage.ww-ru.ru/stock/upload/";
        driver.get(urlStage);
        driver.findElement(By.xpath("//a[@href=\"http://bob.shop-stage.ww-ru.ru/stock/upload/?setWebsite=8\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("nenashev");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("nenashev4321");
        driver.findElement(By.xpath("//input[@id=\"login\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"doc_path\"]")).sendKeys("C:\\автозагрузка стока Стейдж\\first.csv");
        driver.findElement(By.xpath("//input[@id=\"submitbutton\"]")).click();
        driver.get(urlProduct);
        Thread.sleep(15000);
        Assert.assertEquals("421", driver.findElement(By.xpath("//div[@class=\"x-list-body-inner\"]/dl/dt[8]/em")).getText());
        driver.get(urlStage);
        driver.findElement(By.xpath("//input[@id=\"doc_path\"]")).sendKeys("C:\\автозагрузка стока Стейдж\\second.csv");
        driver.findElement(By.xpath("//input[@id=\"submitbutton\"]")).click();
        driver.get(urlProduct);
        Thread.sleep(15000);
        Assert.assertEquals("936", driver.findElement(By.xpath("//div[@class=\"x-list-body-inner\"]/dl/dt[8]/em")).getText());
    }

    @Test
    public void SynchronizedShopClub() {
        String controlName;
        driver.get("https://shop.westwing.ru/customer/account/login/");
        registrationPage.insertLogInMail("vito777@mail.ru");
        registrationPage.insertLogInPass("westwingpas");
        registrationPage.clickLogInButton();
        WebElement accountName = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Витольд']")));
        controlName = accountName.getText();
        mainPage.setWestwingClub();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Assert.assertEquals(controlName, driver.findElement(By.xpath("//span[@class=\"l-header__bottom-item-subline\"]")).getText());
    }

    @After
    public void tierDown() {
        driver.quit();
    }
}
