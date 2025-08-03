package ru.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static ru.practicum.EnvConfig.BASE_URL;
import static ru.practicum.EnvConfig.IMPLICITY_TIMEOUT;

// Класс Page Object для главной страницы
public class MainPage {
    private final WebDriver driver;

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    // Локатор кнопки заказа в шапке
    private static final By BUTTON_HEAD_ORDER = By.className("Button_Button__ra12g");
    // Локатор кнопки заказа в теле
    private static final By BUTTON_BODY_ORDER = By.xpath(".//div[starts-with(@class, 'Home_RoadMap')]//button[starts-with(@class, 'Button_Button')]");


    // Локатор вопроса
    private static final By FAQ_QUESTION = By.xpath("//div[contains(@id, 'accordion__heading-')]");
    // Локатор ответа
    private static final By FAQ_ANSWER = By.xpath("//div[contains(@id, 'accordion__panel-')]");

    // Открываем главную страницу
    public void openMainPage() {
        driver.get(BASE_URL);
    }

    // Находим кнопку в шапке и нажимаем на нее
    public void clickHeaderOrderButton() {
        driver.findElement(BUTTON_HEAD_ORDER).click();
        // Скролим до кнопки и жмем в теле страницы
    }

    public void clickBodyOrderButton() {
        WebElement button = driver.findElement(BUTTON_BODY_ORDER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICITY_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    // Метод для скролла к вопросу
    public void scrollToFaqQuestion(int index) {
        WebElement element = driver.findElements(FAQ_QUESTION).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Метод для получения текста вопроса
    public String getFaqQuestionText(int index) {
        return driver.findElements(FAQ_QUESTION).get(index).getText();
    }

    // Метод для клика по стрелке
    public void clickFaqQuestion(int index) {
        driver.findElements(FAQ_QUESTION).get(index).click();
    }

    // Метод для получения текста ответа с ожиданием
    public String getFaqAnswerText(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITY_TIMEOUT));

        WebElement answer = wait.until(
                ExpectedConditions.visibilityOf(
                        driver.findElements(FAQ_ANSWER).get(index)
                ));
        return answer.getText();
    }


}
