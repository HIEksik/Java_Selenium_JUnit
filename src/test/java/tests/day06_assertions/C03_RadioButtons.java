package tests.day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButtons {

    //a. Verilen web sayfasına gidin.
    //https://testotomasyonu.com/form
    //b. Cinsiyet Radio button elementlerini locate edin
    //c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    //d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

   static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void yazidanSecmeTesti(){
        driver.get("https://testotomasyonu.com/form");

        WebElement kadinRadioButton= driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton= driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton= driver.findElement(By.id("inlineRadio3"));

        // yazıdan Erkek radio buttonu seçelim

        WebElement erkekRadioYaziElementi=driver.findElement(By.xpath("//*[@for='inlineRadio2']"));
        erkekRadioYaziElementi.click();

        //d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        // erkekradio butonun seçili oldugunu test edecegiz seçtiğimiz için

        Assert.assertTrue(erkekRadioButton.isSelected());

        // kadın ve diger radio buttonlarının secili olmadıgını test edecegiz

        Assert.assertFalse(kadinRadioButton.isSelected());

        Assert.assertFalse(digerRadioButton.isSelected());

    }

    @Test
    public void buttondanSecmeTesti(){
        driver.get("https://testotomasyonu.com/form");

        WebElement kadinRadioButton= driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton= driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton= driver.findElement(By.id("inlineRadio3"));

        // RadioButtonu kullanarak Erkek radio buttonu seçelim
        erkekRadioButton.click();



        // erkekradio butonun seçili oldugunu test edecegiz -  seçtiğimiz için
        Assert.assertTrue(erkekRadioButton.isSelected());



        // kadın ve diger radio buttonlarının secili olmadıgını test edecegiz
        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());


    }
}
