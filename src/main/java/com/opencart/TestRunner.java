package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        // New Window Code
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.andreisecuqa.host/");

        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));

        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));

        registerOption.click();

        System.out.println(driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));

        String firstName = RandomDataManager.generateFirstName();
        firstNameInput.sendKeys(firstName);
        System.out.println(firstName);

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));

        String lastName = RandomDataManager.generateLastName();
        lastNameInput.sendKeys(lastName);
        System.out.println(lastName);

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        String randomEmail = RandomDataManager.generateRandomEmail();
        emailInput.sendKeys(randomEmail);
        System.out.println(randomEmail);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));

        String password = RandomDataManager.generatePassword();
        passwordInput.sendKeys(password);
        System.out.println(password);


        WebElement termsAndConditionToggleBar = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", termsAndConditionToggleBar);
        Thread.sleep(1000);
        termsAndConditionToggleBar.click();

        WebElement registerBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        registerBtn.click();

        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(currentWindowName);
        driver.get("https://tekwill.md/");
        System.out.println(driver.getTitle());
        driver.quit();

        System.out.println("The execution is over");
    }
}