package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderSecondPage {
    private WebDriver driver;
    private By dateOfOrderInput = By.xpath("//input[@placeholder=\"* Когда привезти самокат\"]"); //дата когда привезти самокат
    private By rentalPeriod = By.xpath("//div[text()=\"* Срок аренды\"]"); //срока аренды
    private By scooterColorCheckboxes = By.xpath("//div[text()=\"Цвет самоката\"]//../label"); //цвет самоката
    private By commentInput = By.xpath("//input[@placeholder=\"Комментарий для курьера\"]"); //комментарий для курьера


    private By rentalPeriodItems = By.xpath("//div[@class=\"Dropdown-option\"]"); //выбрать срок аренды

    private By nextButton = By.xpath("//div[contains(@class, \"Order_Content\")]//button[text()=\"Заказать\"]"); //кнопка Заказать
    private By root = By.xpath("//div[contains(@class,\"Header_Header\")]"); //кнопка Далее

    private By buttonApplyOrder = By.xpath("//div[contains(@class, \"Order_Modal\")]//button[text() = \"Да\"]"); //кнопка Да на всплывающем окне "Хотите оформить заказ?"
    private By orderAcceptedHeader = By.xpath("//div[contains(@class, \"Order_Modal\")]//div[text() = \"Заказ оформлен\"]"); //кнопка Да на всплывающем окне "Хотите оформить заказ?"

    public OrderSecondPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectData(String data) {
        WebElement element = driver.findElement(dateOfOrderInput);
        element.click();
        element.sendKeys(data);
    }

    public void selectRentalPeriod(String rentalPeriodName){
        driver.findElement(rentalPeriod).click();

        List<WebElement> elements = driver.findElements(rentalPeriodItems);
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if (element.getText().equals(rentalPeriodName)) {
                element.click();
                return;
            }
        }
    }

    public void selectColorOfScooter(String colorOfScooter){
        List<WebElement> elements = driver.findElements(scooterColorCheckboxes);
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if (element.getText().equals(colorOfScooter)) {
                element.click();
                return;
            }
        }
    }

    public void selectCommentForOrder(String comment) {
        WebElement element = driver.findElement(commentInput);
        element.click();
        element.sendKeys(comment);
    }

    public void clickNext(){
        driver.findElement(nextButton).click();
    }

    public void clickBackground(){
        driver.findElement(root).click();
    }

    public void clickApplyOrder(){
        driver.findElement(buttonApplyOrder).click();
    }

    public boolean isOrderAccepted(){
        return !driver.findElements(orderAcceptedHeader).isEmpty();
    }



}
