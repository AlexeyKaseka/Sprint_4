package ru.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static ru.practicum.EnvConfig.IMPLICITY_TIMEOUT;

public class OrderPage {
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;
    //Локатор поля Имя
    private static final By NAME_FIELD = By.xpath(".//div/input[contains(@placeholder,'Имя')]");
    // Локатор поля Фамилия
    private static final By SECOND_NAME = By.xpath(".//div/input[contains(@placeholder,'Фамилия')]");
    // Локатор поля адрес
    private static final By ADDRESS = By.xpath(".//div/input[contains(@placeholder,'Адрес')]");
    // Локатор поля Метро
    private static final By METRO = By.xpath(".//div/input[contains(@placeholder,'Станция метро')]");
    // Локатор выбранной станции метро
    private static final By CLICK_STATION_METRO = By.className("Order_Text__2broi");
    // Локатор поля Телефон
    private static final By PHONE = By.xpath(".//div/input[contains(@placeholder,'* Телефон: на него позвонит курьер')]");
    //Локатор куки
    private static final By COOKIE = By.className("App_CookieButton__3cvqF");
    // Локатор кнопки далее
    private static final By GO_BUTTON = By.xpath(".//div[starts-with(@class, 'Order_NextButton')]/button");
    // Локатор поля дата
    private static final By DATA = By.xpath(".//div[starts-with(@class, 'react-datepicker__input-container')]//input");
    // Локатор даты в календаре
    private static final By CLICK_DATA = By.className("react-datepicker__day--selected");
    // Локатор поля аренды
    private static final By RENT = By.className("Dropdown-control");
    // Локатор массива вариантов аренды
    private static final By RENT_OPTION = By.className("Dropdown-option");
    // Локатор поля Комментарий
    private static final By COMMENT = By.xpath("//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Комментарий')]");
    // Локатор  кнопки Заказать
    private static final By ORDER_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    // Локатор кнопки подтверждения заказа
    private static final By CONFIRM_ORDER_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    // Локатор страницы подтверждения заказа
    private static final By CONFIRM_ORDER_PAGE = By.className("Order_Modal__YZ-d3");
    // Локатор заголовка заказа
    private static final By HEADER_ORDER_PAGE = By.xpath(".//div[starts-with(@class, 'Order_Modal')]//div[(starts-with(@class,'Order_ModalHeader'))]");

    // Поиск поля Имя с ожиданием и заполнение поля
    public void setName(String name) {
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICITY_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(
                        NAME_FIELD)).sendKeys(name);
    }

    // Поиск поля Фамилия и заполнение поля
    public void setSecondName(String secondName) {
        driver.findElement(SECOND_NAME).sendKeys(secondName);
    }

    // Поиск поля адрес и заполнение поля
    public void setAdrdess(String address) {
        driver.findElement(ADDRESS).sendKeys(address);
    }

    // Поиск поля метро его заполнение и выбор из всплывающего списка
    public void setMetro(String metro) {
        driver.findElement(METRO).sendKeys(metro);
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICITY_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(CLICK_STATION_METRO)).click();
    }

    // Поиск поля телефон и заполнение поля
    public void setPhone(String phone) {
        driver.findElement(PHONE).sendKeys(phone);
    }

    // Клик по куки
    public void clickCookie() {
        driver.findElement(COOKIE).click();
    }

    // Клик по кнопке Далее
    public void clickGo() {
        driver.findElement(GO_BUTTON).click();
    }

    // Выбор Даты
    public void setData(String data) {
        WebElement dateField = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITY_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable
                        (DATA));
        dateField.sendKeys(data);
        driver.findElement(CLICK_DATA).click();
    }

    // Выбор количества дней аренды
    public void setRent(int daysOfRent) {
        driver.findElement(RENT).click();
        List<WebElement> options = driver.findElements(RENT_OPTION);
        if (daysOfRent < 1 || daysOfRent >= options.size()) {
            return; // Просто выходим если индекс невалидный
        }
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICITY_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(options.get(daysOfRent - 1)))
                .click();
        // Выбор цвета
    }

    public void setColor(String color) {
        driver.findElement(By.id(color)).click();
    }

    // Пишем комментарий
    public void setComment(String comment) {
        driver.findElement(COMMENT).sendKeys(comment);
    }

    // Кликаем кнопку заказть
    public void clickOrder() {
        driver.findElement(ORDER_BUTTON).click();
    }

    // Кликаем кнопку подтверждения заказа
    public void clickConfirmOrder() {

        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(CONFIRM_ORDER_BUTTON));
        button.click();
        new WebDriverWait(driver, Duration.ofSeconds(IMPLICITY_TIMEOUT))
                .until(ExpectedConditions.invisibilityOf(button));
    }

    // Проверяем наличие заказа
    public boolean checkingOrderPage(String confirmText) {

        WebElement header = new WebDriverWait(driver, Duration.ofSeconds(IMPLICITY_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(HEADER_ORDER_PAGE));


        String actualText = header.getText();

        return actualText.equals(confirmText);
    }
}



