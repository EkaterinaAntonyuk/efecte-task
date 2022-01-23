package com.efecte.qa.task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage extends Page {

    public ReservePage(WebDriver driver) {
        super(driver);
    }

    public void clickFlightButton(int flightNumber) {
        driver.findElement(By.xpath("//table/tbody/tr[" + flightNumber
                + "]/td/input[contains(@value, 'Choose This Flight')]")).click();
    }
}
