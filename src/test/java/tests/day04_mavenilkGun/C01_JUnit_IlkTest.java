package tests.day04_mavenilkGun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class C01_JUnit_IlkTest {
    public static void main(String[] args) throws InterruptedException {
        // ilk ayarları ayapın
        WebDriverManager.edgedriver().setup();
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu ana sayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // chair için arama yapın
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("chair"+ Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunlerlisti=driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        int actualUrunsayisi=bulunanUrunlerlisti.size();

        if (actualUrunsayisi>0){
            System.out.println("Chair testi PASSED");
        }else System.out.println("Chair testi FAILED");

        // Java için arama yapın

        aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Java"+Keys.ENTER);

        // arama sonucunda urun bulunamadıgını test edin

        bulunanUrunlerlisti=driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        actualUrunsayisi=bulunanUrunlerlisti.size();

        if (actualUrunsayisi==0){
            System.out.println("Java testi PASSED");
        }else  System.out.println("Java testi FAILED");

        // sayfayı kapatın

        Thread.sleep(3000);
        driver.quit();

    }
}
