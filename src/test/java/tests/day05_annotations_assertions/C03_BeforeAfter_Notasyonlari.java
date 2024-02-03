package tests.day05_annotations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter_Notasyonlari {

    // Uc farklı test methodunda verilen sayfalara gidin
    // o sayfaya gidildigini test edin ve sayfayı kapatın


    /*
    Eger bir class ta her test methodundan önce çalışmasını istediginiz kodlar var ise
    bunu sağlamak için @Before notasyonuna sahip bir method oluşturabiliriz

    Eger bir class ta her test methodu çalıştıktan sonra çalışmasını istediginiz kodlar var ise
    bunu sağlamak için @After notasyonuna sahip bir method oluşturabiliriz
     */
    WebDriver driver;

    @Before

    public void setup(){
        System.out.println("Before çalıştı");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown(){
        System.out.println("After çalıştı");
        driver.quit();
    }

    @Test
    public void testOtomasyonuTest(){

        driver.get("https://www.testotomasyonu.com/");

        String expectedUrl="https://www.testotomasyonu.com/";
        String actualUrl=driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)){
            System.out.println("Test otomasypnu testi PASSED");
        }else System.out.println("Test otomasypnu testi FAILED");



    }
    @Test
    public void wisequaterTest(){

        driver.get("https://wisequarter.com/");

        String expectedUrl="https://wisequarter.com/";
        String actualUrl=driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)){
            System.out.println("Wisequarter testi PASSED");
        }else {
            System.out.println("Wisequarter testi FAILED");
            System.out.println(actualUrl);
        }


    }
    @Test
    public void youtubeTest(){

        driver.get("https://www.youtube.com/");

        String expectedUrl="https://www.youtube.com/";
        String actualUrl=driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)){
            System.out.println("Youtube testi PASSED");
        }else System.out.println("Youtube testi FAILED");


    }
}
