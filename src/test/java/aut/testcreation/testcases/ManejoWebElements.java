package aut.testcreation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ManejoWebElements {
    static WebDriver driver;

    By dropdownLocator = By.id("dropdown");
    By check = By.xpath("//input [@type=\"checkbox\"][1]");
    By check2 = By.xpath("//input [@type=\"checkbox\"][2]");
    By btnEnabledLocator = By.xpath("//li[@id=\"ui-id-3\"]/a");
    By btnDownloadLocator = By.xpath("//li[@id='ui-id-4']/a");
    By btnPDFLocator = By.xpath("//li[@id='ui-id-5']/a");
    By iframe = By.id("mce_0_ifr");
    By iframeText = By.id("tinymce");

    @BeforeAll
    static void init(){
        WebDriverManager.edgedriver().setup();
    }

    @BeforeEach
    void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //espera implicita -> antes de enviar el timeOut Exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //dropdown
    @Test
    void dropdown(){
        System.out.println("Test Dropdown");
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");


        //WebElement
        WebElement dropdown = driver.findElement(dropdownLocator);
        Select select = new Select(dropdown);

        select.selectByValue("1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
    }
    @Test
    void checkbox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //checkbox -> input
        WebElement checkbox1 = driver.findElement(check);
        WebElement checkbox2 = driver.findElement(check2);
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        if(checkbox2.isSelected()){
            checkbox2.click();
        }
    }

    @Test
    void menuDinamico() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/jqueryui/menu");

        WebElement btnEnabled = driver.findElement(btnEnabledLocator);
        WebElement btnDownload = driver.findElement(btnDownloadLocator);
        WebElement btnPDF = driver.findElement(btnPDFLocator);

        //espera explicita
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(3000));
        if (wait.until(ExpectedConditions.elementToBeSelected(btnPDF))){
            btnPDF.click();
        };

        if (btnPDF.isDisplayed()){
            btnPDF.click();
        }

        if (btnDownload.isDisplayed()){
            btnDownload.click();
        }

        if(btnEnabled.isDisplayed()){
            btnEnabled.click();
            //Thread.sleep(1000);
            btnDownload.click();
            //Thread.sleep(1000);
            btnPDF.click();
        }


    }

    @Test
    void iframes(){

        driver.navigate().to("https://the-internet.herokuapp.com/tinymce");

        //Traernos todos los iframes de la pagina
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(iframes.get(0));
        WebElement iframeTextelement = driver.findElement(iframeText);
        iframeTextelement.clear();
        iframeTextelement.sendKeys("Hola estoy información desde el driver");


    }
    @Test
    void webTable(){

        driver.navigate().to("https://the-internet.herokuapp.com/tables");

        //traer elementos de la tabla
        List<WebElement> webTable = driver.findElements(By.id("table1"));

        //Cuantas columnas tiene webTable
        List<WebElement> columnas = webTable.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));
        System.out.println(columnas.size());



        for(WebElement th : columnas) {               /*WebElement btndue = columnas.get(3);*/
            String text = th.getText();
            if (text.contains("Due")){
                th.click();
                th.click();
                break;
            }

        }
        //Obtener Filas del Webtable
        List<WebElement> filas = webTable.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        String nombre = filas.get(0).findElement(By.xpath("td[2]")).getText();
        String apellido = filas.get(0).findElement(By.xpath("td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("td[4]")).getText();

        System.out.println("el usuario con mayor deuda es: "+nombre+" "+apellido+" "+deuda);

        List<WebElement> webTable2 = driver.findElements(By.id("table2"));
        List<WebElement> columnas2 = webTable2.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));
        for(WebElement th: columnas2)
        {
            String text = th.getText();
            if(text.contains("Last Name"))
            {
                th.click();
                List<WebElement> fila2 = webTable2.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
                for(int i=0; i<fila2.size();i++)
                {
                    String A = fila2.get(i).findElement(By.xpath("td[1]")).getText();
                    String B = fila2.get(i).findElement(By.xpath("td[2]")).getText();
                    String C = fila2.get(i).findElement(By.xpath("td[4]")).getText();
                    System.out.println(A + " " + B + " " + C);
                }
            }
        }

    }



    @AfterEach
    void close(){
        driver.quit();
    }
}

