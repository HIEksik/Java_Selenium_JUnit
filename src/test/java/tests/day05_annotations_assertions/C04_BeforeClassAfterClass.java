package tests.day05_annotations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_BeforeClassAfterClass {
    // Uc test methodu oluşturup aşşağıdaki görevleri tamamlayın
    // 1- Testotomasyonu sayfasına gidip sayfaya gittigimizi test edin
    // 2- phone için arama yapıp urun buluna bildigini test edin
    // 3- İlk urune tıklayıp urun açıklamasında case sensitive olmadan phone getçtiğini test edin

    /*
    Eger başlangıç ayarlarının en başta sadece bir kere yapılmasını
    test methodları bittikten sonrada bitiş ayarlarının yapılmasını
    istiyorsanız

    @Before ve @After YERİNE

    @BeforeClass ve @AfterClass kullanırız

   Bir birine bağlantılı testlerde Clasın başında bir kere @BeforeClass çalışır
   test bittikten sonra bir kere @AfterClass çalışır

   Önemli Not: @BeforeClass ve @AfterClass Kullanan methodlar Static olmak zorundadır


     */
   static WebDriver driver;
     List<WebElement> bulunanUrunlerListesi;

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
    public void test01() throws InterruptedException {
         //  1- Testotomasyonu sayfasına gidip sayfaya gittigimizi test edin
        Thread.sleep(1000);
        driver.get("https://www.testotomasyonu.com/");

        String expectedUrl="https://www.testotomasyonu.com/";
        String actualUrl=driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Testotomasyonu sayfasına gitme testi PASSED");
        }else System.out.println("Testotomasyonu sayfasına gitme testi PASSED");

    }
    @Test
    public   void test02() throws InterruptedException {
        // 2- phone için arama yapıp urun buluna bildigini test edin
        Thread.sleep(1000);
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        bulunanUrunlerListesi=driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        int actualUrunsayisi=bulunanUrunlerListesi.size();

        if (actualUrunsayisi>0){
            System.out.println("Urun bulma testi PASSED");
        }else  System.out.println("Urun bulma testi FAILED");


    }
    @Test
    public  void test03() throws InterruptedException {
        // 3- İlk urune tıklayıp urun açıklamasında case sensitive olmadan phone getçtiğini test edin

        bulunanUrunlerListesi=driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        Thread.sleep(2000);
        bulunanUrunlerListesi.get(0).click();

        WebElement urunAciklamaElementi=driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String exceptedIcerik="phone";
        String actualAciklamaKucukhar=urunAciklamaElementi.getText().toLowerCase();

        if (actualAciklamaKucukhar.contains(exceptedIcerik)){
            System.out.println("Ilk urun testi PASSED");
        }else System.out.println("Ilk urun testi FAILED");

    }


}
