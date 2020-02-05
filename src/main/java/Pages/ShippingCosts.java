package Pages;

public enum ShippingCosts {
    PRICE1("0.00 руб."),
    PRICE2("199.00 руб."),
    PRICE3("290.00 руб."),
    PRICE4("299.00 руб."),
    PRICE5("349.00 руб."),
    PRICE6("379.00 руб."),
    PRICE7("399.00 руб."),
    PRICE8("449.00 руб."),
    PRICE9("499.00 руб."),
    PRICE10("549.00 руб."),
    PRICE11("599.00 руб."),
    PRICE12("649.00 руб."),
    PRICE13("666.00 руб."),
    PRICE14("699.00 руб."),
    PRICE15("749.00 руб."),
    PRICE16("776.00 руб."),
    PRICE17("799.00 руб."),
    PRICE18("800.00 руб."),
    PRICE19("849.00 руб."),
    PRICE20("879.00 руб."),
    PRICE21("892.00 руб."),
    PRICE22("899.00 руб."),
    PRICE23("945.00 руб."),
    PRICE24("949.00 руб."),
    PRICE25("979.00 руб."),
    PRICE26("999.00 руб."),
    PRICE27("1000.00 руб."),
    PRICE28("1009.00 руб."),
    PRICE29("1043.00 руб."),
    PRICE30("1049.00 руб."),
    PRICE31("1079.00 руб."),
    PRICE32("1099.00 руб."),
    PRICE33("1179.00 руб."),
    PRICE34("1199.00 руб."),
    PRICE35("1225.00 руб."),
    PRICE36("1279.00 руб."),
    PRICE37("1299.00 руб."),
    PRICE38("1300.00 руб."),
    PRICE39("1349.00 руб."),
    PRICE40("1379.00 руб."),
    PRICE41("1399.00 руб."),
    PRICE42("1499.00 руб."),
    PRICE43("1536.00 руб."),
    PRICE44("1549.00 руб."),
    PRICE45("1599.00 руб."),
    PRICE46("1699.00 руб."),
    PRICE47("1799.00 руб."),
    PRICE48("1800.00 руб."),
    PRICE49("1899.00 руб."),
    PRICE50("1979.00 руб."),
    PRICE51("1999.00 руб."),
    PRICE52("2099.00 руб."),
    PRICE53("2199.00 руб."),
    PRICE54("2299.00 руб."),
    PRICE55("2399.00 руб."),
    PRICE56("2499.00 руб."),
    PRICE57("2599.00 руб."),
    PRICE58("2699.00 руб."),
    PRICE59("2700.00 руб."),
    PRICE60("2799.00 руб."),
    PRICE61("2999.00 руб."),
    PRICE62("3000.00 руб."),
    PRICE63("3199.00 руб."),
    PRICE64("3299.00 руб."),
    PRICE65("3399.00 руб."),
    PRICE66("3499.00 руб."),
    PRICE67("4699.00 руб."),
    PRICE68("4999.00 руб."),
    PRICE69("5000.00 руб."),
    PRICE70("5199.00 руб."),
    PRICE71("7699.00 руб."),
    PRICE72("60000.00 руб.")
    ;

    private final String text;

    ShippingCosts(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
