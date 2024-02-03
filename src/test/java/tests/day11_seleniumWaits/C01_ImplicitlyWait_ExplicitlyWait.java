package tests.day11_seleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.time.Duration;

public class C01_ImplicitlyWait_ExplicitlyWait  {

    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    WebDriver driver;
    @Test
    public void impilicitWaitTest(){

        // Implicit wait in görevini ve isleyisini daha iyi anlaya bilmek için
        // Test base Class ta yaptıgımız ayarları burada yapalım

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itSgoneElementi= driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        Assert.assertTrue(itSgoneElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement iTsBackElementi= driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));

        Assert.assertTrue(iTsBackElementi.isDisplayed());


        driver.quit();

    }

    @Test
    public void explicitWaitTesti(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // implicitly wait süresini 1 saniyeye indirmemizin sebebi
        // impilicitli wait i tolere edemeyecegi durumların oluşması
        // ve bu durumları explicitWait ile nasıl aşacağımızı göstermek

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

                // ** İmlicitli wait in tolere edemedigi durumnlarda
                // ** explicitlyWait için Web driver wait objesi oluştururuz

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

        /* wait objesinde bir elementi bekletmek istedigimizde iki durum karşımıza çıkar

        1 - Ürzerinde çalıştıgımız web elelemnt locate edile biliyorsa önce locate edip sonra
        wait objesine istedigimiz durum gerçekleşene kardar
        locate edilmiş webelementi beklemesini söyleye biliriz


        2- Belirli bir zaman sonra hangi Locater ile locate edebilecegimizi bildigimiz ama
        henüz görünmedigi için locate edemedigimiz webelementlerde
        bekleme ve locate ı birlikle yapabiliriz


         WebElement itSgoneElementi= driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

        wait.until(ExpectedConditions.visibilityOf(itSgoneElementi));

         */

        WebElement itSgoneElementi=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        Assert.assertTrue(itSgoneElementi.isDisplayed());


        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();


        //7. It’s back mesajinin gorundugunu test edin

        //WebElement iTsBackElementi= driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));

        WebElement iTsBackElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));

        Assert.assertTrue(iTsBackElementi.isDisplayed());


        driver.quit();

    }
}
