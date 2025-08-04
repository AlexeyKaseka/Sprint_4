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
                {QUESTION_INDEX_1, QUESTION_1, ANSWER_1},
                {QUESTION_INDEX_2, QUESTION_2, ANSWER_2},
                {QUESTION_INDEX_3, QUESTION_3, ANSWER_3},
                {QUESTION_INDEX_4, QUESTION_4, ANSWER_4},
                {QUESTION_INDEX_5, QUESTION_5, ANSWER_5},
                {QUESTION_INDEX_6, QUESTION_6, ANSWER_6},
                {QUESTION_INDEX_7, QUESTION_7, ANSWER_7},
                {QUESTION_INDEX_8, QUESTION_8, ANSWER_8},

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







