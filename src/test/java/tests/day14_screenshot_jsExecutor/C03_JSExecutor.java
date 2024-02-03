package tests.day14_screenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_JSExecutor extends TestBase {

    @Test
    public void test01(){

        // testotomasyonu sayfasına gidelim
        driver.get("https:/www.testotomasyonu.com");

        // Alt kısımda bulunan "Best Sport Shoes For Multi Gender." bölümüne kadar aşşağı inin

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        // başlıgın "Best Sport Shoes For Multi Gender." olgunu test edin
        WebElement bestSportElementi=driver.findElement(By.xpath("(//*[@class='blog-heading'])[2]"));

                    //**** JVS ile istedigimiz best spor elementine kadar aşşagı inelim
        jse.executeScript("arguments[0].scrollIntoView();",bestSportElementi);

        ReusableMethods.bekle(3);



        String expectedBaslik="Best Sport Shoes For Multi Gender.";
        String actualBaslik=bestSportElementi.getText();

        ReusableMethods.webelementScreenshot(bestSportElementi,"best");
        Assert.assertEquals(expectedBaslik,actualBaslik);


        //******* Alert vermek için

        jse.executeScript("alert('Bu iş bu kadar ');");

        ReusableMethods.bekle(5);


    }
}
