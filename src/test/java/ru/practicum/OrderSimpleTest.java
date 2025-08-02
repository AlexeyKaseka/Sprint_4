package ru.practicum;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderSimpleTest {
    @Test
    public void testCorrectPathOrderFirstButton() {
        // веб драйвер для Google Chrome
        WebDriver driver = new FirefoxDriver();
        // открытие главной страницы
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Поиск кнопки заказать и кликнуть
        driver.findElement(By.className("Button_Button__ra12g")).click();
        // Поиск поля Имя с ожиданием и заполнение поля
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(".//div/input[contains(@placeholder,'Имя')]")
                )).sendKeys("Иван");
        // Поиск поля Фамилия  и заполнение поля
        driver.findElement(By.xpath(".//div/input[contains(@placeholder,'Фамилия')]")
        ).sendKeys("Иванов");
        // Поиск поля Адрес  и заполнение поля
        driver.findElement(By.xpath(".//div/input[contains(@placeholder,'Адрес')]")
        ).sendKeys("Фрунзе, 8");
        // Поиск поля Станция метро  и заполнение поля
        driver.findElement(By.xpath(".//div/input[contains(@placeholder,'Станция метро')]")
        ).sendKeys("Рижская");
        // Ждем появления элементов списка и кликаем
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.className("Order_Text__2broi"))).click();
        // Поиск поля Телефон и заполнение поля
        driver.findElement(By.xpath(".//div/input[contains(@placeholder,'* Телефон: на него позвонит курьер')]")
        ).sendKeys("89155151551");
        // Ищем и жмем кнопку куки
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        // Ищем и жмем кнопку далее
        driver.findElement(By.xpath(".//div[starts-with(@class, 'Order_NextButton')]/button")).click();
        // Ищем поля Календаря и вводим дату
        WebElement dateField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath(".//div[starts-with(@class, 'react-datepicker__input-container')]//input")));
        dateField.sendKeys("27.08.2025");
        driver.findElement(By.className("Header_Header__214zg")).click();
        // Ищем поле Срок аренды
        driver.findElement(By.className("Dropdown-root")).click();
        // выбираем срок аренды
        driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='трое суток']")).click();
        // Поле цвет самоката, выбираем цвет
        driver.findElement(By.id("black")).click();
        // Нажимаем на кнопку заказать
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']")).click();
        // Подтверждаем заказ
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']"))).click();
// Проверяем текст заголовка напрямую
        assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("Order_Modal__YZ-d3")
                )).isDisplayed());
    }

    @Test
    public void testCorrectPathOrderSecondButton() {
        // веб драйвер для Google Chrome
        WebDriver driver = new FirefoxDriver();
        // открытие главной страницы
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Находим кнопку
        WebElement button = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"));

        // Скроллим к кнопке
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", button);

        // Ждем и кликаем
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(button)).click();
        // Поиск поля Имя с ожиданием и заполнение поля
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath(".//div/input[contains(@placeholder,'Имя')]")
                )).sendKeys("Иван");
        // Поиск поля Фамилия  и заполнение поля
        driver.findElement(By.xpath(".//div/input[contains(@placeholder,'Фамилия')]")
        ).sendKeys("Иванов");
        // Поиск поля Адрес  и заполнение поля
        driver.findElement(By.xpath(".//div/input[contains(@placeholder,'Адрес')]")
        ).sendKeys("Фрунзе, 8");
        // Поиск поля Станция метро  и заполнение поля
        driver.findElement(By.xpath(".//div/input[contains(@placeholder,'Станция метро')]")
        ).sendKeys("Рижская");
        // Ждем появления элементов списка и кликаем
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.className("Order_Text__2broi"))).click();
        // Поиск поля Телефон и заполнение поля
        driver.findElement(By.xpath(".//div/input[contains(@placeholder,'* Телефон: на него позвонит курьер')]")
        ).sendKeys("89155151551");
        // Ищем и жмем кнопку куки
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        // Ищем и жмем кнопку далее
        driver.findElement(By.xpath(".//div[starts-with(@class, 'Order_NextButton')]/button")).click();
        // Ищем поля Календаря и вводим дату
        WebElement dateField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath(".//div[starts-with(@class, 'react-datepicker__input-container')]//input")));
        dateField.sendKeys("27.08.2025");
        driver.findElement(By.className("Header_Header__214zg")).click();
        // Ищем поле Срок аренды
        driver.findElement(By.className("Dropdown-root")).click();
        // выбираем срок аренды
        driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='трое суток']")).click();
        // Поле цвет самоката, выбираем цвет
        driver.findElement(By.id("black")).click();
        // Нажимаем на кнопку заказать
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']")).click();
        // Подтверждаем заказ
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']"))).click();
// Проверяем текст заголовка напрямую
        assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("Order_Modal__YZ-d3")
                )).isDisplayed());
    }


}
