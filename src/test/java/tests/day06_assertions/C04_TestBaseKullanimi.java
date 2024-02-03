package tests.day06_assertions;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C04_TestBaseKullanimi extends TestBase {

    @Test
    public void Test01(){

        // Testotomasyonu yasfasına gidin
        driver.get("https://www.testotomasyonu.com");
        // sayfaya gittiginizi test edin
        String expectedUrl="https://www.testotomasyonu.com/";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
