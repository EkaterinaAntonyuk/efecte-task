package com.efecte.qa.task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ConfirmationPage extends Page{

    @FindBy(xpath = "//td[contains(text(), 'Date')]/following-sibling::td")
    private WebElement confirmationDateTime;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public ZonedDateTime getConfirmationDateTime() {
        return ZonedDateTime.parse(confirmationDateTime.getText(), DateTimeFormatter.RFC_1123_DATE_TIME);
    }

}
