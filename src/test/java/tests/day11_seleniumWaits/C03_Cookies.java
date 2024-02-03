package tests.day11_seleniumWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void test01(){

       //1- amazon anasayfaya gidin
        driver.get("https://www.walmart.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSeti = driver.manage().getCookies();

        int siraNo=1;
        for (Cookie eachCookie:cookieSeti
             ) {
            System.out.println(siraNo+" -------- "+eachCookie);
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookieSeti.size()>5);

        //4- ismi mobileweb olan cookie degerinin 0 oldugunu test edin
        Assert.assertEquals(driver.manage().getCookieNamed("mobileweb").getValue(),"0");

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");


        //olusturun ve sayfaya ekleyin
        driver.manage().addCookie(cookie);


        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSeti = driver.manage().getCookies();

        System.out.println("==================================================");
       siraNo=1;
        for (Cookie eachCookie:cookieSeti
        ) {
            System.out.println(siraNo+" -------- "+eachCookie);
            siraNo++;
        }

        Assert.assertEquals(driver.manage().getCookieNamed("en sevdigim cookie").getValue(),"cikolatali");

        //7- ismi TBV olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("en sevdigim cookie");

        System.out.println("==================================================");
        siraNo=1;

        Boolean mobilWebVarmi=false;
        for (Cookie eachCookie:cookieSeti
        ) {
            System.out.println(siraNo+" -------- "+eachCookie);
            siraNo++;

            if (eachCookie.getName().equals("en sevdigim cookie")){
                mobilWebVarmi=true;
            }
        }

        // Eger mobileweb silindi ise mobileweb varmı false olmalı

        Assert.assertTrue(mobilWebVarmi);


        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();
         cookieSeti = driver.manage().getCookies();

         Assert.assertTrue(cookieSeti.isEmpty());


    }

}
