package ru.practicum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static ru.practicum.FaqTestConstant.*;


@RunWith(Parameterized.class)
public class FaqTest {
    @Rule
    public DriverFactory factory = new DriverFactory();

    private final int questionIndex;
    private final String expectedQuestionText;
    private final String expectedAnswerText;


    public FaqTest(int questionIndex, String expectedQuestionText, String expectedText) {
        this.questionIndex = questionIndex;
        this.expectedQuestionText = expectedQuestionText;
        this.expectedAnswerText = expectedText;
    }

    @Parameterized.Parameters(name =
            "Тест #{index}:  " +
                    "Вопрос: \"{1}\" | " +
                    "Ожидаемый ответ: \"{2}\"")
    public static Object[][] testData() {
        return new Object[][]{
                {INDEX_QUESTION_SCOOTER_PRICE, QUESTION_SCOOTER_PRICE, ANSWER_SCOOTER_PRICE},
                {INDEX_QUESTION_SEVERAL_SCOOTER, QUESTION_SEVERAL_SCOOTER, ANSWER_SEVERAL_SCOOTER},
                {INDEX_QUESTION_RENT_TIME, QUESTION_RENT_TIME, ANSWER_RENT_TIME},
                {INDEX_QUESTION_TODAY_ORDER, QUESTION_TODAY_ORDER, ANSWER_TODAY_ORDER},
                {INDEX_QUESTION_EXTEND_RENT, QUESTION_EXTEND_RENT, ANSWER_EXTEND_RENT},
                {INDEX_QUESTION_SCOOTER_CHARGING, QUESTION_SCOOTER_CHARGING, ANSWER_SCOOTER_CHARGING},
                {INDEX_QUESTION_CANCEL_ORDER, QUESTION_CANCEL_ORDER, ANSWER_CANCEL_ORDER},
                {INDEX_QUESTION_SCOOTER_DELIVERY, QUESTION_SCOOTER_DELIVERY, ANSWER_SCOOTER_DELIVERY},

        };
    }

    @Test
    public void testFaqCorrectTextOnClick() {
        WebDriver driver = factory.getDriver();
        // подключаем MainPage
        MainPage mainPage = new MainPage(driver);
        // открытие главной страницы
        mainPage.openMainPage();
        // скролл до списка
        mainPage.scrollToFaqQuestion(questionIndex);
        // получение тектса вопроса и сравнение
        assertEquals("Текст вопроса не совпадает",
                expectedQuestionText,
                mainPage.getFaqQuestionText(questionIndex));
        // клик по стрелке списка
        mainPage.clickFaqQuestion(questionIndex);
        // получение текста ответа c явным ожиданием и сравнение
        assertEquals("Текст ответа не совпадает",
                expectedAnswerText,
                mainPage.getFaqAnswerText(questionIndex));
    }
}







