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

public class C01_YouTube_Testi {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static   void teardown(){
        driver.quit();
    }

    @Test
    public void titleTest(){
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin

        String expectedtedTitle="YouTube";
        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedtedTitle));

    }

    @Test
    public void imgTest(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin

        WebElement youtubeResim=driver.findElement(By.xpath("(//*[@class='style-scope ytd-logo'])[1]"));

        Assert.assertTrue(youtubeResim.isDisplayed());

    }
    @Test
    public void searhBoxTest(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searcBoxkutusu=driver.findElement(By.xpath("//input[@name='search_query']"));

        Assert.assertTrue(searcBoxkutusu.isEnabled());
    }
    @Test
    public void  wrongTitleTest(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

        String expectedsayfaBasligi="youtube";

        String actualSayfaBasligi=driver.getTitle();

        Assert.assertFalse(actualSayfaBasligi.contains(expectedsayfaBasligi));

    }


}
