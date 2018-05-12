package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_WAIT_FOR_BIRTHDAY = "//div[@class=\"_5k_5\"]";
    public static final String XPATH_WAIT_FOR_NAMES = "//div[@class=\"uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput\"]";
    public static final String XPATH_FIRSTNAME = "//div[@class=\"uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput\"]/input[@name=\"firstname\"]";
    public static final String XPATH_LASTNAME = "//div[@class=\"uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput\"]/input[@name=\"lastname\"]";
    public static final String XPATH_EMAIL = "//div[@class=\"uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput\"]/input[@name=\"reg_email__\"]";
    public static final String XPATH_EMAIL_CONFIRM = "//div[@class=\"uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput\"]/input[@name=\"reg_email_confirmation__\"]";
    public static final String XPATH_YEAR_SELECT = "//div[@class=\"_5k_5\"]/span/span/select[1]";
    public static final String XPATH_MONTH_SELECT = "//div[@class=\"_5k_5\"]/span/span/select[2]";
    public static final String XPATH_DAY_SELECT = "//div[@class=\"_5k_5\"]/span/span/select[3]";
    public static final String XPATH_SEX_SELECT = "//div[@class=\"mtm _5wa2 _5dbb\"]/span/span/input[@value=\"2\"]";



    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR_NAMES)).isDisplayed());

        WebElement firstName = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        firstName.sendKeys("Rafał");

        WebElement lastName = driver.findElement(By.xpath(XPATH_LASTNAME));
        lastName.sendKeys("Pijet");

        WebElement email = driver.findElement(By.xpath(XPATH_EMAIL));
        email.sendKeys("stronglopez@wp.pl");

        while (!driver.findElement(By.xpath(XPATH_EMAIL_CONFIRM)).isDisplayed());

        WebElement emailConfirm = driver.findElement(By.xpath(XPATH_EMAIL_CONFIRM));
        emailConfirm.sendKeys("stronglopez@wp.pl");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR_BIRTHDAY)).isDisplayed());

        WebElement selectYearCombo = driver.findElement(By.xpath(XPATH_YEAR_SELECT));
        Select selectYear = new Select(selectYearCombo);
        selectYear.selectByIndex(22);

        WebElement selectMonthCombo = driver.findElement(By.xpath(XPATH_MONTH_SELECT));
        Select selectMonth = new Select(selectMonthCombo);
        selectMonth.selectByIndex(4);

        WebElement selectDayCombo = driver.findElement(By.xpath(XPATH_DAY_SELECT));
        Select selectDay = new Select(selectDayCombo);
        selectDay.selectByIndex(46);

        WebElement selectRadio = driver.findElement(By.xpath(XPATH_SEX_SELECT));
        selectRadio.click();
    }
}
