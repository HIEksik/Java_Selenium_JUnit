package tests.day05_annotations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertion {

    WebDriver driver;
    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test01(){
        // Gerekli ayarlamaları yaapıp testotomasyonu sayfasına gidin ve
        // sayfaya gidebildiginizi test edin

        /*
        JUnit in consolda verdigi passed/Faıled raporu
        if else nin sonucuna bakmaz

        JUnit kod sorunsuz çalışıp bitti ise PASSED
              kod çalışırken EXception oluşursa FAİLED olarak degerlendirir
         */

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com/");

        String expectedUrl="https://www.testotomasyonu.com";
        String actualUrl=driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
            throw new RuntimeException();
            // exception fırlatarak if ile kontrol ettiğimiz test failed oldugunda
            // JUnit in de olmasını sağlayabiliriz

        }





    }
}
