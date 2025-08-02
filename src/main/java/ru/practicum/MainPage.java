package ru.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс Page Object для главной страницы
public class MainPage {
    private final WebDriver driver;
    // Локатор вопроса
    private static final By FAQ_QUESTION = By.xpath("//div[contains(@id, 'accordion__heading-')]");
    // Локатор ответа
    private static final By FAQ_ANSWER = By.xpath("//div[contains(@id, 'accordion__panel-')]");
    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement answer = wait.until(
                ExpectedConditions.visibilityOf(
                        driver.findElements(FAQ_ANSWER).get(index)
        ));
        return answer.getText();
    }


}
