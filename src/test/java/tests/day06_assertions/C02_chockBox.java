package tests.day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C02_chockBox {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @After
    public void teardown(){
    driver.quit();
    }

    @Test
    public void checkboxTesti(){
        //a. Verilen web sayfasına gidin.
        //https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        //b. Sirt Agrisi ve Carpinti checkbox’larini secin
        Actions actions=new Actions(driver);

        for (int i = 0; i < 10 ; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }


        WebElement sirtAgrisiCheckbox=driver.findElement(By.id("gridCheck5"));
        WebElement sirtAgrisiYaziElementi=driver.findElement(By.xpath("//label[@for='gridCheck5']"));



        WebElement carpintiCheckbox=driver.findElement(By.id("gridCheck4"));
        WebElement carpintiYaziElementi=driver.findElement(By.xpath("//label[@for='gridCheck4']"));

                     // Sırt agrısını yazıdan seçelim , Çarpıntıyı ise CheckBox tan seçelim

        sirtAgrisiYaziElementi.click();
        carpintiCheckbox.click();



        //c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin

        Assert.assertTrue(sirtAgrisiCheckbox.isSelected());
        Assert.assertTrue(carpintiCheckbox.isSelected());

        //d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        WebElement sekeChecbox= driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckbox= driver.findElement(By.id("hastalikCheck7"));

        Assert.assertFalse(sekeChecbox.isSelected());
        Assert.assertFalse(epilepsiCheckbox.isSelected());


    }

}
