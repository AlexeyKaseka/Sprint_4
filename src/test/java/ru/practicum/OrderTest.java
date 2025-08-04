package ru.practicum;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;


@RunWith(Parameterized.class)
public class OrderTest {
    @Rule
    public DriverFactory factory = new DriverFactory();

    private final String name;
    private final String secondName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final int rate;
    private final String color;
    private final String comment;
    private final String expectedOrderText;

    public OrderTest(String name, String secondName, String address, String metro,
                     String phone, String date, int rate, String color, String comment, String expectedOrderText) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.rate = rate;
        this.color = color;
        this.comment = comment;
        this.expectedOrderText = expectedOrderText;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Петя", "Петров", "Пролетарская, 8", "Рижская", "89166166116", "15.08.2025", 2, "black", "Все ок", "Заказ оформлен"},
                {"Иван", "Иванов", "Мичурина, 16", "Комсомольская", "89156155116", "10.08.2025", 4, "grey", "Норм", "Заказ оформлен"},
        };
    }

    @Test
    public void testCorrectPathOrderFirstButton() {
        WebDriver driver = factory.getDriver();
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        // открытие главной страницы
        mainPage.openMainPage();
        // Кликаем кнопку Заказать
        mainPage.clickHeaderOrderButton();
        // Пишем Имя
        orderPage.setName(name);
        // Пишем Фамилию
        orderPage.setSecondName(secondName);
        // Пишем адрес
        orderPage.setAddress(address);
        // Выбираем станцию Метро
        orderPage.setMetro(metro);
        // Пишем номер
        orderPage.setPhone(phone);
        // Жмем кнопку куки
        orderPage.clickCookie();
        // Жмем кнопку далее
        orderPage.clickGo();
        // Пишем дату
        orderPage.setData(date);
        // Ищем поле Срок аренды
        orderPage.setRent(rate);
        // Выбор цвета
        orderPage.setColor(color);
        // Пишем комментарий
        orderPage.setComment(comment);
        // Нажимаем на кнопку заказать
        orderPage.clickOrder();
        // Подтверждаем заказ
        orderPage.clickConfirmOrder();
        // Проверяем что заказ оформлен
        orderPage.checkingOrderPage(expectedOrderText);
        Assert.assertTrue(orderPage.checkingOrderPage(expectedOrderText));
    }

    @Test
    public void testCorrectPathOrderSecondButton() {
        WebDriver driver = factory.getDriver();
        // открытие главной страницы
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        // Находим кнопку
        mainPage.clickBodyOrderButton();
        // Пишем Имя
        orderPage.setName(name);
        // Пишем Фамилию
        orderPage.setSecondName(secondName);
        // Пишем адрес
        orderPage.setAddress(address);
        // Выбираем станцию Метро
        orderPage.setMetro(metro);
        // Пишем номер
        orderPage.setPhone(phone);
        // Жмем кнопку куки
        orderPage.clickCookie();
        // Жмем кнопку далее
        orderPage.clickGo();
        // Пишем дату
        orderPage.setData(date);
        // Ищем поле Срок аренды
        orderPage.setRent(rate);
        // Выбор цвета
        orderPage.setColor(color);
        // Пишем комментарий
        orderPage.setComment(comment);
        // Нажимаем на кнопку заказать
        orderPage.clickOrder();
        // Подтверждаем заказ
        orderPage.clickConfirmOrder();
        // Проверяем что заказ оформлен
        orderPage.checkingOrderPage(expectedOrderText);
        Assert.assertTrue(orderPage.checkingOrderPage(expectedOrderText));
    }
}



