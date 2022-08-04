package aut.testcreation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class calculadoraTest
{
    static WebDriver driver;
    By buscador = By.xpath("//div[@class='a4bIc']/input[@name='q']");
    // btnbuscar = By.name("btnK");
    By resultado = By.id("cwos");
    By btnIgual = By.xpath("//div [@aria-label='igual']");
    By btnDiv = By.xpath("//div [@aria-label='dividir']");
    By btnSuma = By.xpath("//div [@aria-label='más']");
    By btnResta = By.xpath("//div [@aria-label='menos']");
    By btnMult = By.xpath("//div [@aria-label='multiplicar']");
    By btn0 = By.xpath("//table [@class='ElumCf']/tbody/tr[5]/td[1]/div/div");
    By btn1 = By.xpath("//table [@class='ElumCf']/tbody/tr[4]/td[1]/div/div");
    By btn2 = By.xpath("//table [@class='ElumCf']/tbody/tr[4]/td[2]/div/div");
    By btn3 = By.xpath("//table [@class='ElumCf']/tbody/tr[4]/td[3]/div/div");
    By btn4 = By.xpath("//table [@class='ElumCf']/tbody/tr[3]/td[1]/div/div");
    By btn5 = By.xpath("//table [@class='ElumCf']/tbody/tr[3]/td[2]/div/div");
    By btn6 = By.xpath("//table [@class='ElumCf']/tbody/tr[3]/td[3]/div/div");
    By btn7 = By.xpath("//table [@class='ElumCf']/tbody/tr[2]/td[1]/div/div");
    By btn8 = By.xpath("//table [@class='ElumCf']/tbody/tr[2]/td[2]/div/div");
    By btn9 = By.xpath("//table [@class='ElumCf']/tbody/tr[2]/td[3]/div/div");

    @BeforeAll
    static void init()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    void calculadora() throws InterruptedException
    {
        Assertions.assertEquals(13,calculo(11,2,"+"));
        Assertions.assertEquals(10,calculo(30,20,"-"));
        Assertions.assertEquals(25,calculo(5,5,"*"));
        Assertions.assertEquals(10,calculo(100,10,"/"));
    }

    private int calculo(int n1, int n2, String operador)
    {
        String caracter = String.valueOf(n1);
        String caracter2 = String.valueOf(n2);
        int result = 0;
        driver.navigate().to("https://www.google.com");
        WebElement buscadorElement = driver.findElement(buscador);
        buscadorElement.click();
        buscadorElement.sendKeys("calculadora"+ Keys.ENTER);

        WebElement btn0Element = driver.findElement(btn0);
        WebElement btn1Element = driver.findElement(btn1);
        WebElement btn2Element = driver.findElement(btn2);
        WebElement btn3Element = driver.findElement(btn3);
        WebElement btn4Element = driver.findElement(btn4);
        WebElement btn5Element = driver.findElement(btn5);
        WebElement btn6Element = driver.findElement(btn6);
        WebElement btn7Element = driver.findElement(btn7);
        WebElement btn8Element = driver.findElement(btn8);
        WebElement btn9Element = driver.findElement(btn9);

        WebElement btnSumaElement = driver.findElement(btnSuma);
        WebElement btnRestaElement = driver.findElement(btnResta);
        WebElement btnDivElement = driver.findElement(btnDiv);
        WebElement btnMultElement = driver.findElement(btnMult);
        WebElement btnIgualElement = driver.findElement(btnIgual);


        switch (operador)
        {
            case "+":
            {
                for (int i=0;i<caracter.length();i++)
                {
                    if (caracter.charAt(i) == '0')
                    {
                        btn0Element.click();
                    }
                    if (caracter.charAt(i) == '1')
                    {
                        btn1Element.click();
                    }
                    if (caracter.charAt(i) == '2')
                    {
                        btn2Element.click();
                    }
                    if (caracter.charAt(i) == '3')
                    {
                        btn3Element.click();
                    }
                    if (caracter.charAt(i) == '4')
                    {
                        btn4Element.click();
                    }
                    if (caracter.charAt(i) == '5')
                    {
                        btn5Element.click();
                    }
                    if (caracter.charAt(i) == '6')
                    {
                        btn6Element.click();
                    }
                    if (caracter.charAt(i) == '7')
                    {
                        btn7Element.click();
                    }
                    if (caracter.charAt(i) == '8')
                    {
                        btn8Element.click();
                    }
                    if (caracter.charAt(i) == '9')
                    {
                        btn9Element.click();
                    }

                }
                btnSumaElement.click();
                for (int i=0;i<caracter2.length();i++)
                {
                    if (caracter2.charAt(i) == '0')
                    {
                        btn0Element.click();
                    }
                    if (caracter2.charAt(i) == '1')
                    {
                        btn1Element.click();
                    }
                    if (caracter2.charAt(i) == '2')
                    {
                        btn2Element.click();
                    }
                    if (caracter2.charAt(i) == '3')
                    {
                        btn3Element.click();
                    }
                    if (caracter2.charAt(i) == '4')
                    {
                        btn4Element.click();
                    }
                    if (caracter2.charAt(i) == '5')
                    {
                        btn5Element.click();
                    }
                    if (caracter2.charAt(i) == '6')
                    {
                        btn6Element.click();
                    }
                    if (caracter2.charAt(i) == '7')
                    {
                        btn7Element.click();
                    }
                    if (caracter2.charAt(i) == '8')
                    {
                        btn8Element.click();
                    }
                    if (caracter2.charAt(i) == '9')
                    {
                        btn9Element.click();
                    }

                }
                btnIgualElement.click();

                WebElement ResultElement = driver.findElement(resultado);
                result = Integer.parseInt(ResultElement.getText());
                break;
            }
            case "-":
            {
                for (int i=0;i<caracter.length();i++)
                {
                    if (caracter.charAt(i) == '0')
                    {
                        btn0Element.click();
                    }
                    if (caracter.charAt(i) == '1')
                    {
                        btn1Element.click();
                    }
                    if (caracter.charAt(i) == '2')
                    {
                        btn2Element.click();
                    }
                    if (caracter.charAt(i) == '3')
                    {
                        btn3Element.click();
                    }
                    if (caracter.charAt(i) == '4')
                    {
                        btn4Element.click();
                    }
                    if (caracter.charAt(i) == '5')
                    {
                        btn5Element.click();
                    }
                    if (caracter.charAt(i) == '6')
                    {
                        btn6Element.click();
                    }
                    if (caracter.charAt(i) == '7')
                    {
                        btn7Element.click();
                    }
                    if (caracter.charAt(i) == '8')
                    {
                        btn8Element.click();
                    }
                    if (caracter.charAt(i) == '9')
                    {
                        btn9Element.click();
                    }

                }
                btnRestaElement.click();
                for (int i=0;i<caracter2.length();i++)
                {
                    if (caracter2.charAt(i) == '0')
                    {
                        btn0Element.click();
                    }
                    if (caracter2.charAt(i) == '1')
                    {
                        btn1Element.click();
                    }
                    if (caracter2.charAt(i) == '2')
                    {
                        btn2Element.click();
                    }
                    if (caracter2.charAt(i) == '3')
                    {
                        btn3Element.click();
                    }
                    if (caracter2.charAt(i) == '4')
                    {
                        btn4Element.click();
                    }
                    if (caracter2.charAt(i) == '5')
                    {
                        btn5Element.click();
                    }
                    if (caracter2.charAt(i) == '6')
                    {
                        btn6Element.click();
                    }
                    if (caracter2.charAt(i) == '7')
                    {
                        btn7Element.click();
                    }
                    if (caracter2.charAt(i) == '8')
                    {
                        btn8Element.click();
                    }
                    if (caracter2.charAt(i) == '9')
                    {
                        btn9Element.click();
                    }

                }
                btnIgualElement.click();

                WebElement ResultElement = driver.findElement(resultado);
                result = Integer.parseInt(ResultElement.getText());
                break;
            }
            case "*":
            {
                for (int i=0;i<caracter.length();i++)
                {
                    if (caracter.charAt(i) == '0')
                    {
                        btn0Element.click();
                    }
                    if (caracter.charAt(i) == '1')
                    {
                        btn1Element.click();
                    }
                    if (caracter.charAt(i) == '2')
                    {
                        btn2Element.click();
                    }
                    if (caracter.charAt(i) == '3')
                    {
                        btn3Element.click();
                    }
                    if (caracter.charAt(i) == '4')
                    {
                        btn4Element.click();
                    }
                    if (caracter.charAt(i) == '5')
                    {
                        btn5Element.click();
                    }
                    if (caracter.charAt(i) == '6')
                    {
                        btn6Element.click();
                    }
                    if (caracter.charAt(i) == '7')
                    {
                        btn7Element.click();
                    }
                    if (caracter.charAt(i) == '8')
                    {
                        btn8Element.click();
                    }
                    if (caracter.charAt(i) == '9')
                    {
                        btn9Element.click();
                    }

                }
                btnMultElement.click();
                for (int i=0;i<caracter2.length();i++)
                {
                    if (caracter2.charAt(i) == '0')
                    {
                        btn0Element.click();
                    }
                    if (caracter2.charAt(i) == '1')
                    {
                        btn1Element.click();
                    }
                    if (caracter2.charAt(i) == '2')
                    {
                        btn2Element.click();
                    }
                    if (caracter2.charAt(i) == '3')
                    {
                        btn3Element.click();
                    }
                    if (caracter2.charAt(i) == '4')
                    {
                        btn4Element.click();
                    }
                    if (caracter2.charAt(i) == '5')
                    {
                        btn5Element.click();
                    }
                    if (caracter2.charAt(i) == '6')
                    {
                        btn6Element.click();
                    }
                    if (caracter2.charAt(i) == '7')
                    {
                        btn7Element.click();
                    }
                    if (caracter2.charAt(i) == '8')
                    {
                        btn8Element.click();
                    }
                    if (caracter2.charAt(i) == '9')
                    {
                        btn9Element.click();
                    }

                }
                btnIgualElement.click();

                WebElement ResultElement = driver.findElement(resultado);
                result = Integer.parseInt(ResultElement.getText());
                break;
            }
            case "/":
            {
                for (int i=0;i<caracter.length();i++)
                {
                    if (caracter.charAt(i) == '0')
                    {
                        btn0Element.click();
                    }
                    if (caracter.charAt(i) == '1')
                    {
                        btn1Element.click();
                    }
                    if (caracter.charAt(i) == '2')
                    {
                        btn2Element.click();
                    }
                    if (caracter.charAt(i) == '3')
                    {
                        btn3Element.click();
                    }
                    if (caracter.charAt(i) == '4')
                    {
                        btn4Element.click();
                    }
                    if (caracter.charAt(i) == '5')
                    {
                        btn5Element.click();
                    }
                    if (caracter.charAt(i) == '6')
                    {
                        btn6Element.click();
                    }
                    if (caracter.charAt(i) == '7')
                    {
                        btn7Element.click();
                    }
                    if (caracter.charAt(i) == '8')
                    {
                        btn8Element.click();
                    }
                    if (caracter.charAt(i) == '9')
                    {
                        btn9Element.click();
                    }

                }
                btnDivElement.click();
                for (int i=0;i<caracter2.length();i++)
                {
                    if (caracter2.charAt(i) == '0')
                    {
                        btn0Element.click();
                    }
                    if (caracter2.charAt(i) == '1')
                    {
                        btn1Element.click();
                    }
                    if (caracter2.charAt(i) == '2')
                    {
                        btn2Element.click();
                    }
                    if (caracter2.charAt(i) == '3')
                    {
                        btn3Element.click();
                    }
                    if (caracter2.charAt(i) == '4')
                    {
                        btn4Element.click();
                    }
                    if (caracter2.charAt(i) == '5')
                    {
                        btn5Element.click();
                    }
                    if (caracter2.charAt(i) == '6')
                    {
                        btn6Element.click();
                    }
                    if (caracter2.charAt(i) == '7')
                    {
                        btn7Element.click();
                    }
                    if (caracter2.charAt(i) == '8')
                    {
                        btn8Element.click();
                    }
                    if (caracter2.charAt(i) == '9')
                    {
                        btn9Element.click();
                    }

                }
                btnIgualElement.click();

                WebElement ResultElement = driver.findElement(resultado);
                result = Integer.parseInt(ResultElement.getText());
                break;
            }
        }
        return result;

    }


    @AfterEach
    void close()
    {
        driver.quit();
    }
}