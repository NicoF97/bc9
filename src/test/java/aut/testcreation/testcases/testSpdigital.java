package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testSpdigital extends SeleniumTestBase {
    WebDriver driver;
    @Test
    public void testSpDigital() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.navigate().to("http://www.spdigital.cl/");
        Thread.sleep(20000);
        By buscador = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/span[1]/form/div/input");
        By btnBuscar = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/span[1]/form/div/button");

        WebElement webElementbuscador = driver.findElement(buscador);
        WebElement webElementbtnBuscar = driver.findElement(btnBuscar);

        webElementbuscador.sendKeys("   a   ");
        Thread.sleep(5000);
        Assertions.assertEquals("","");
    }
}
