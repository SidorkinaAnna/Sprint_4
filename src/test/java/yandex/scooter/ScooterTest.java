package yandex.scooter;

import org.example.pages.OrderFirstPage;
import org.example.pages.Scooter;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Parameterized.class)
public class ScooterTest extends BaseTest {

    private WebDriver driver;

    private String questionHeader;

    private String questionText;

    public ScooterTest(WebDriver driver, String questionHeader, String questionText) {
        super();
        this.driver = driver;
        this.questionHeader = questionHeader;
        this.questionText = questionText;
    }



    @Parameterized.Parameters
    public static Object[][] getQuestionsAndTexts() {
        return new Object[][]{
                {new ChromeDriver(),"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {new ChromeDriver(),"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {new ChromeDriver(),"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {new ChromeDriver(),"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {new ChromeDriver(),"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {new ChromeDriver(),"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {new ChromeDriver(),"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {new ChromeDriver(),"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Test
    public void importantQuestionsTest(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        Scooter scooter = new Scooter(driver);
        scooter.acceptCookiesIfPresent();
        scooter.clickQuestionHeaderByText(questionHeader);
        String openedText = scooter.getOpenedText();
        Assertions.assertEquals(questionText, openedText, "Текст не соответствует");
    }

    @Test
    public void orderFirstPage(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        Scooter scooter = new Scooter(driver);
        scooter.clickOrderFirst();
        OrderFirstPage orderFirstPage = new OrderFirstPage(driver);
        orderFirstPage.selectSubway("Черкизовская");

    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
