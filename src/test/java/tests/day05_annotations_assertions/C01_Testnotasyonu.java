package tests.day05_annotations_assertions;

import org.junit.Ignore;
import org.junit.Test;

public class C01_Testnotasyonu {
    /*
    @Test notasyonu sradan bir methodu
     bagımsız olarak çalıştırılabilen bir test methoduna dönüştürür

     Bir class ta birden fazla test methodu varsa istersek her bir methodu tek başına ,
     istersekte class level dan çalıştırıp toplu olarak çalıştırabiliriz

     JUnitte test methodları toplu çalıştıtıldıgında
     hangi sıralama ile çalışacağını bilemeyiz ve kontrolda edemeyiz

     Eger çalışmasını istemedigimiz bir test methodu varsa @Ignore notasyonunu kullanabiliriz
     */

    @Test
    public void testOtomasyonuTest(){
        System.out.println("Testotomasyonu testi çalıştı");
    }
    @Test @Ignore
    public void wisequaterTest(){
        System.out.println("Wisequarter testi çalıştı");
    }
    @Test
    public void youtubeTest(){
        System.out.println("youtube testi çalıştı");
    }



}
