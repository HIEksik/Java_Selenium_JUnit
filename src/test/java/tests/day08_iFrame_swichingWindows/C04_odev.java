package tests.day08_iFrame_swichingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C04_odev extends TestBase {

    @Test
    public void odevTest(){

        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement textOpening=driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        String expectedOpening="Opening a new window";
        String actualOpening=textOpening.getText();

        Assert.assertEquals(expectedOpening,actualOpening);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        String ilkWindowdegeri=driver.getWindowHandle();
        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> windowHDSeti=driver.getWindowHandles();
        String ikinciHandle="";

        for (String aechHandle:windowHDSeti
             ) {
            if (!aechHandle.equals(ilkWindowdegeri)){
                ikinciHandle=aechHandle;
            }
        }

        driver.switchTo().window(ikinciHandle);

        String expectedikinciWindowTitle="New Window";
        String actualikinciWindowTitle=driver.getTitle();

        Assert.assertEquals(expectedikinciWindowTitle,actualikinciWindowTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfawindowTexti=driver.findElement(By.xpath("//*[@class='example']"));
        String exceptednew="New Window";
        String actualnew=ikinciSayfawindowTexti.getText();

        Assert.assertEquals(exceptednew,actualnew);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkWindowdegeri);

         expectedTitle="The Internet";
         actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);


        ReusableMethods.bekle(3);



    }
}
