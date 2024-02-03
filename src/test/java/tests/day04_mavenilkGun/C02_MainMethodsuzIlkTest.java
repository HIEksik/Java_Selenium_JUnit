package tests.day04_mavenilkGun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MainMethodsuzIlkTest {

    @Test
    public void mainsizTest() throws InterruptedException {
        // gerekli ayarları yapın

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        // testotomasyonu sayfasına gidin
        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test02(){


    }
    @Test
    public void test03(){

    }

}
