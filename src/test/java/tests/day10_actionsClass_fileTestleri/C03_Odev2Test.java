package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_Odev2Test extends TestBase {
    @Test
    public void odev2Testi(){
        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);

        for (int i = 0; i < 27; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();

        }

        ReusableMethods.bekle(3);
        //4- videoyu izlemek icin Play tusuna basin
        WebElement iFramevideo= driver.findElement(By.xpath("//iframe[@frameborder='0']"));
        driver.switchTo().frame(iFramevideo);
         WebElement videoPlay=driver.findElement(By.xpath("//*[@id='movie_player']"));
         videoPlay.click();

         ReusableMethods.bekle(3);

         //5- videoyu calistirdiginizi test edin

        WebElement videoCalisiyor=driver.findElement(By.xpath("//*[@*='ytp-time-current']"));

        String saniye=""+videoCalisiyor.getText().charAt(videoCalisiyor.getText().length()-1);


        int degisenSaniye=Integer.parseInt(saniye);

        Assert.assertTrue(degisenSaniye>0);


        ReusableMethods.bekle(2);




    }
}
