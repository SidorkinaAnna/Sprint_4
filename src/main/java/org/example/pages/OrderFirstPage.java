package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderFirstPage {
    private WebDriver driver;

    private By nameOfCustomerInput = By.xpath("//input[@placeholder=\"* Имя\"]"); //имя заказчика
    private By surnameOfCustomerInput = By.xpath("//input[@placeholder=\"* Фамилия\"]"); //фамилия заказчика
    private By addressInput = By.xpath("//input[@placeholder=\"* Адрес: куда привезти заказ\"]"); //адрес: куда привезти заказ
    private By subwayInput = By.xpath("//input[@placeholder=\"* Станция метро\"]"); //нажать на выпадающий список станций метро
    private By phoneNumberInput = By.xpath("//input[@placeholder=\"* Телефон: на него позвонит курьер\"]"); //телефон заказчика

    private By subwayItems = By.xpath("//ul[@class=\"select-search__options\"]//li[@class=\"select-search__row\"]//div[contains(@class, \"Text\")]"); //станции метро

    private By nextButton = By.xpath("//button[text()=\"Далее\"]"); //кнопка Далее

    public OrderFirstPage(WebDriver driver) {
        this.driver = driver;
    }


    public void selectName(String name){
        WebElement element = driver.findElement(nameOfCustomerInput);
        element.click();
        element.sendKeys(name);
    }

    public void selectSurname(String surname){
        WebElement element = driver.findElement(surnameOfCustomerInput);
        element.click();
        element.sendKeys(surname);
    }

    public void selectAddress(String address){
        WebElement element = driver.findElement(addressInput);
        element.click();
        element.sendKeys(address);
    }

    public void selectSubway(String subwayName){
        driver.findElement(subwayInput).click();

        List<WebElement> elements = driver.findElements(subwayItems);
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if (element.getText().equals(subwayName)) {
                element.click();
                return;
            }
        }
    }

    public void selectPhone(String phone){
        WebElement element = driver.findElement(phoneNumberInput);
        element.click();
        element.sendKeys(phone);
    }

    public void clickNext(){
        driver.findElement(nextButton).click();
    }



}
