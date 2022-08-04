package aut.testcreation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import java.time.Duration;
public class ejercicioTraductor
{
    static WebDriver driver;
    By areaText = By.xpath("//div[@class='QFw9Te']/textarea");
    By traduccion = By.xpath("//div[@class='J0lOec']/span[@class='VIiyi']");
    By btnMasIdiomas = By.xpath("//c-wiz[@class=\"kHGNJd\"]/descendant::button[@class=\"VfPpkd-Bz112c-LgbsSe VfPpkd-Bz112c-LgbsSe-OWXEXe-e5LLRc-SxQuSe yHy1rc eT1oJ mN1ivc qiN4Vb KY3GZb szLmtb\"][2]/descendant::div[@class=\"VfPpkd-Bz112c-RLmnJb\"]");
    By ingles = By.id("i12");
    By portugues = By.id("i13");
    By buscarfrances = By.xpath("//c-wiz[@class=\"bvzp8c DlHcnf\"]/div[@class=\"ykTHSe\"]/div[@class=\"pEyuac X4hZJc\"]/div[@class=\"fMHXgc qkH7ie\"]/input");
    By frances = By.xpath("//c-wiz[@class=\"bvzp8c DlHcnf\"]/div[@class=\"ykTHSe\"]/div[@class=\"pEyuac X4hZJc i6oIBe\"]/div[@class=\"dykxn C96yib j33Gae\"]/div[@class=\"vSUSRc\"]/div/div[2]/span");

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
    void traduccion() throws InterruptedException {
        driver.navigate().to("https://translate.google.com/?hl=es-419");
        WebElement areaTextElement = driver.findElement(areaText);
        WebElement inglesElement = driver.findElement(ingles);
        WebElement portuguesElement = driver.findElement(portugues);
        WebElement btnMasIdiomasElement = driver.findElement(btnMasIdiomas);

        areaTextElement.sendKeys("La teoría del caos es la rama de la matemática, la física y otras ciencias (biología, meteorología, economía, entre otras) que trata ciertos tipos de sistemas complejos y sistemas dinámicos no lineales muy sensibles a las variaciones en las condiciones iniciales.");
        inglesElement.click();
        WebElement traduccionElement = driver.findElement(traduccion);
        System.out.println(traduccionElement.getText());
        portuguesElement.click();
        Thread.sleep(3000);
        WebElement traduccionElement2 = driver.findElement(traduccion);
        System.out.println(traduccionElement2.getText());

        btnMasIdiomasElement.click();
        WebElement buscarFrancesElement = driver.findElement(buscarfrances);
        buscarFrancesElement.sendKeys("francés");
        WebElement francesElement = driver.findElement(frances);
        francesElement.click();
        Thread.sleep(3000);
        WebElement traduccionElement3 = driver.findElement(traduccion);
        System.out.println(traduccionElement3.getText());


    }


    @AfterEach
    void close()
    {
        driver.quit();
    }
}