package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {


    @Test
    public void test01(){
        // projemiz altında deneme.txt dosyasının var oldugunu test edin

        String dosyaYolu="src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // C:\Users\LENOVO\OneDrive\Masaüstü\Git\Team130_JUnit\
                            // src\test\java\tests\day10_actionsClass_fileTestleri\deneme.txt

        System.out.println(System.getProperty("user.dir"));

        // Absolut dosya yolumuzu dinamik yapmak istersek

        String absolutDosyaYolu=System.getProperty("user.dir")+"/src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(absolutDosyaYolu)));

    }
}
