package org.alexandraavendano.printerstore.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SeleniumTest {

    private final WebDriver driver;

    @Autowired
    public SeleniumTest(WebDriver driver) {
        this.driver = driver;
    }

    @Test
    void testLoginPageTitle() throws InterruptedException {
        driver.get("http://localhost:3000/login");
        Thread.sleep(3000);
        assertEquals("React App", driver.getTitle());
    }

    @Test
    void testLoginPage() throws InterruptedException {
        driver.get("http://localhost:3000/login");
        WebElement usernameInput = driver.findElement(By.cssSelector("#inputEmail"));
        usernameInput.sendKeys("employee@test.com");
        WebElement passwordInput = driver.findElement(By.cssSelector("#inputPassword"));
        passwordInput.sendKeys("password_test");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#root > div > div > div.content-container > div > div > div.container.bg-light.border > form > button")).click();

        WebElement welcomeMessage = driver.findElement(By.cssSelector("#root > div > div > div.Header > nav > ul > div > li:nth-child(1) > a"));
        passwordInput.sendKeys("Orders");

        assertEquals("React App", driver.getTitle());
    }
}
