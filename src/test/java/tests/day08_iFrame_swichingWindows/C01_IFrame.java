package tests.day08_iFrame_swichingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_IFrame extends TestBase {
    @Test
    public void iFrameTesti(){

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement anIframeYaziElementi=driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        Assert.assertTrue(anIframeYaziElementi.isEnabled());

        //- Text Box’a “Merhaba Dunya!” yazin.
            //* textbox İframenin içinde oldugundan önce ona geçiş yapmalıyız
        WebElement iframeElementi=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElementi);


        WebElement textboxelementi=driver.findElement(By.xpath("//*[@id='tinymce']"));
        ReusableMethods.bekle(1);// temizleme yapabilmesi için 1 saniye beklettik
        textboxelementi.clear();

        textboxelementi.sendKeys("Merhaba Dunya!");

        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazısını  yazdirin.

                            //* element ana sayfada oldugundan önce geçiş yaptığımız İframeden geri dönmelim
        driver.switchTo().defaultContent();

        WebElement seleniumYazisi= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        Assert.assertTrue(seleniumYazisi.isDisplayed());

        System.out.println(seleniumYazisi.getText());


        ReusableMethods.bekle(2);

    }
}
