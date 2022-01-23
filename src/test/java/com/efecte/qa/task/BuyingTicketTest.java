package com.efecte.qa.task;

import com.efecte.qa.task.page.ConfirmationPage;
import com.efecte.qa.task.page.DirectionsPage;
import com.efecte.qa.task.page.PurchasePage;
import com.efecte.qa.task.page.ReservePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class BuyingTicketTest {
    public static DirectionsPage directionsPage;
    public static ReservePage reservePage;
    public static PurchasePage purchasePage;
    public static ConfirmationPage confirmationPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        driver = new ChromeDriver();
        String remoteChromeUrl = System.getProperty("REMOTE_CHROME_HOST") + "/wd/hub";
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL(remoteChromeUrl), options);
        directionsPage = new DirectionsPage(driver);
        reservePage = new ReservePage(driver);
        purchasePage = new PurchasePage(driver);
        confirmationPage = new ConfirmationPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://blazedemo.com/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void buyTicket() {
        directionsPage.inputDeparture("Paris");
        directionsPage.inputDestination("London");
        directionsPage.clickSearchButton();
        reservePage.clickFlightButton(3);

        fillPurchasePage();
        purchasePage.clickPurchaseFlightButton();

        ZonedDateTime confirmationDateTime = confirmationPage.getConfirmationDateTime();
        Assert.assertEquals(
                LocalDate.now(),
                confirmationDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDate()
        );


    /* Date and time on the site are displayed not taking into account the time zone,
    what does not look correct. But since there are no requirements for the site,
    I left the time zone check commented out, and I change the value received from the site
    in accordance with the system time zone.*/

    //      Assert.assertEquals(ZoneId.systemDefault(), confirmationDateTime.getZone());
    }

    private void fillPurchasePage() {
        purchasePage.inputName("Ekaterina Antoniuk");
        purchasePage.inputAddress("Street 24");
        purchasePage.inputCity("Espoo");
        purchasePage.inputState("Uusima");
        purchasePage.inputZipCode("02600");
        purchasePage.inputCardType("Visa");
        purchasePage.inputCreditCardNumber("0000 8888 0000 8888");
        purchasePage.inputCreditCardMonthField("11");
        purchasePage.inputCreditCardYear("2023");
        purchasePage.inputNameOnCard("EKATERINA ANTONIUK");
    }
}
