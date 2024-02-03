package tests.day08_iFrame_swichingWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.*;
import java.util.List;

public class C01_Odev extends TestBase {

    @Test
    public void odevTest(){

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) Cookies kabul edin

        //3) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iFrameSayisi=driver.findElements(By.xpath("//iframe[@*='']"));
        System.out.println(iFrameSayisi.size());
        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iFrameyoutube1=driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(iFrameyoutube1);

        WebElement youtubeButonu=driver.findElement(By.xpath("//*[@id='player']"));
       ReusableMethods.bekle(1);
        youtubeButonu.click();


        //5) ilk iframe'den çıkıp ana sayfaya dönünüz

        driver.switchTo().defaultContent();

        //6) ikinci iframe'deki (Jmeter Made Easy) linke
        WebElement ifame2= driver.findElement(By.xpath("//*[@name='a077aa5e']"));
        driver.switchTo().frame(ifame2);

        Actions actions=new Actions(driver);

        for (int i = 0; i < 49; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        WebElement jmeterlinki= driver.findElement(By.xpath("//a[@*='http://www.guru99.com/live-selenium-project.html']"));
        jmeterlinki.click();
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız

        ReusableMethods.bekle(3);





    }
}
