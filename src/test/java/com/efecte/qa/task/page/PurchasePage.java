package com.efecte.qa.task.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends Page {

    @FindBy(id = "inputName")
    private WebElement nameField;
    @FindBy(id = "address")
    private WebElement addressField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "state")
    private WebElement stateField;
    @FindBy(id = "zipCode")
    private WebElement zipCodeField;
    @FindBy(id = "cardType")
    private WebElement cardTypeField;
    @FindBy(id = "creditCardNumber")
    private WebElement creditCardNumberField;
    @FindBy(id = "creditCardMonth")
    private WebElement creditCardMonthField;
    @FindBy(id = "creditCardYear")
    private WebElement creditCardYearField;
    @FindBy(id = "nameOnCard")
    private WebElement nameOnCardField;
    @FindBy(id = "rememberMe")
    private WebElement rememberMeField;
    @FindBy(xpath = "//*[contains(@value, 'Purchase Flight')]")
    private WebElement purchaseFlightButton;

    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    public void inputName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void inputAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void inputCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void inputState(String state) {
        stateField.clear();
        stateField.sendKeys(state);
    }

    public void inputZipCode(String zipCode) {
        zipCodeField.clear();
        zipCodeField.sendKeys(zipCode);
    }

    public void inputCardType(String cardType) {
        cardTypeField.sendKeys(cardType);
    }

    public void inputCreditCardNumber(String creditCardNumber) {
        creditCardNumberField.clear();
        creditCardNumberField.sendKeys(creditCardNumber);
    }

    public void inputCreditCardMonthField(String creditCardMonth) {
        creditCardMonthField.clear();
        creditCardMonthField.sendKeys(creditCardMonth);
    }

    public void inputCreditCardYear(String creditCardYear) {
        creditCardYearField.clear();
        creditCardYearField.sendKeys(creditCardYear);
    }

    public void inputNameOnCard(String nameOnCard) {
        nameOnCardField.clear();
        nameOnCardField.sendKeys(nameOnCard);
    }

    public void clickRememberMe() {
        rememberMeField.click();
    }

    public void clickPurchaseFlightButton() {
        purchaseFlightButton.click();
    }

}
