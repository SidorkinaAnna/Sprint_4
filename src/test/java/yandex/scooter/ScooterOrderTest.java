package yandex.scooter;

import org.example.pages.OrderFirstPage;
import org.example.pages.OrderSecondPage;
import org.example.pages.ScooterPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class ScooterOrderTest extends BaseTest{

    private String name;
    private String surname;
    private String address;
    private String subwayName;
    private String phone;
    private String date;
    private String rentalPeriodName;
    private String scooterColor;
    private String comment;

    public ScooterOrderTest(String name, String surname, String address, String subwayName, String phone, String date,
                            String rentalPeriodName, String scooterColor, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayName = subwayName;
        this.phone = phone;
        this.date = date;
        this.rentalPeriodName = rentalPeriodName;
        this.scooterColor = scooterColor;
        this.comment = comment;
    }


    @Parameterized.Parameters
    public static Object[][] getQuestionsAndTexts() {
        return new Object[][]{
                {"имя", "фамилия", "адрес 1", "Черкизовская", "89899444445", "26.02.2025", "сутки", "чёрный жемчуг", "коммент1"},
                {"Василий", "Петров", "Красная 1", "Черкизовская", "89899443335", "26.02.2025", "сутки", "чёрный жемчуг", "коммент1"},
        };
    }


    @Test
    public void orderFirstButton(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        ScooterPage scooterPage = new ScooterPage(driver);
        scooterPage.acceptCookiesIfPresent();
        scooterPage.clickOrderFirst();
        OrderFirstPage orderFirstPage = new OrderFirstPage(driver);
        orderFirstPage.selectName(name);
        orderFirstPage.selectSurname(surname);
        orderFirstPage.selectAddress(address);
        orderFirstPage.selectSubway(subwayName);
        orderFirstPage.selectPhone(phone);
        orderFirstPage.clickNext();
        OrderSecondPage orderSecondPage = new OrderSecondPage(driver);
        orderSecondPage.selectData(date);
        orderSecondPage.clickBackground();
        orderSecondPage.selectRentalPeriod(rentalPeriodName);
        orderSecondPage.selectColorOfScooter(scooterColor);
        orderSecondPage.selectCommentForOrder(comment);
        orderSecondPage.clickNext();
        orderSecondPage.clickApplyOrder();
        Assertions.assertTrue(orderSecondPage.isOrderAccepted());
    }

    @Test
    public void orderSecondButton(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        ScooterPage scooterPage = new ScooterPage(driver);
        scooterPage.acceptCookiesIfPresent();
        scooterPage.clickOrderSecond();
        OrderFirstPage orderFirstPage = new OrderFirstPage(driver);
        orderFirstPage.selectName(name);
        orderFirstPage.selectSurname(surname);
        orderFirstPage.selectAddress(address);
        orderFirstPage.selectSubway(subwayName);
        orderFirstPage.selectPhone(phone);
        orderFirstPage.clickNext();
        OrderSecondPage orderSecondPage = new OrderSecondPage(driver);
        orderSecondPage.selectData(date);
        orderSecondPage.clickBackground();
        orderSecondPage.selectRentalPeriod(rentalPeriodName);
        orderSecondPage.selectColorOfScooter(scooterColor);
        orderSecondPage.selectCommentForOrder(comment);
        orderSecondPage.clickNext();
        orderSecondPage.clickApplyOrder();
        Assertions.assertTrue(orderSecondPage.isOrderAccepted());
    }
}
