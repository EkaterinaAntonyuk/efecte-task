package com.efecte.qa.task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectionsPage extends Page {
    @FindBy(name = "fromPort")
    private WebElement departureField;
    @FindBy(name = "toPort")
    private WebElement destinationField;
    @FindBy(xpath = "//*[contains(@value, 'Find Flights')]")
    private WebElement searchButton;

    public DirectionsPage(WebDriver driver) {
        super(driver);
    }

    public void inputDeparture(String departure) {
        departureField.sendKeys(departure);
    }

    public void inputDestination(String destination) {
        destinationField.sendKeys(destination);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
