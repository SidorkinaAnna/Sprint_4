package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ScooterPage {

    private WebDriver driver;
    private By importantQuestionsSectionElementHeaders = By.xpath("//div[@class=\"accordion__button\"]/.."); //текст вопросов о важном
    private By importantQuestionsSectionElementTexts = By.xpath("//div[contains(@id,\"accordion__panel\")]/p"); //текст ответов на вопросы о важном
    private By rccButtonConfirm = By.xpath("//button[@id=\"rcc-confirm-button\"]"); //кнопка закрытия куки
    private By buttonOrderFirst = By.xpath("(//button[text()=\"Заказать\"])[1]"); //кнопка Заказать верхняя
    private By buttonOrderSecond = By.xpath("(//button[text()=\"Заказать\"])[2]"); //кнопка Заказать нижняя



    public ScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookiesIfPresent(){
        List<WebElement> elements = driver.findElements(rccButtonConfirm);
        if(elements.isEmpty()) return;
        elements.get(0).click();
    }


    public void clickQuestionHeaderByText(String text){
        List<WebElement> elements = driver.findElements(importantQuestionsSectionElementHeaders);
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if (element.getText().equals(text)) {
                new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element))
                        .click();
                return;
            }
        }
    }

    public String getOpenedText(){
        List<WebElement> elements = driver.findElements(importantQuestionsSectionElementTexts);
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if (element.isDisplayed()) {
                return element.getText();
            }
        }
        return null;
    }


    public void clickOrderFirst(){
        driver.findElement(buttonOrderFirst).click();
    }


    public void clickOrderSecond(){
        driver.findElement(buttonOrderSecond).click();
    }



}
