package tests.day13_excelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcell {
    @Test
    public void readExcellTest() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/tests/day13_excelOtomasyon/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim

        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fileInputStream);

                  // Dosya yolu sayesinde dosyaya ulaşıp
                  // FileInputStream ile dosyadaki bilgileri aldık
                  // ve o bilgileri bu class ta kullanabilmek için
                  // kendi oluşturdugumuz Workbook objesine yükledik



        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sayfa1=workbook.getSheet("Sayfa1");

                    // * row ve cell index kullanır yanıo 0 dan başlar (satır ve hücre

        //12. Row objesi olusturun sheet.getRow(index)
                    //*** datalara ulaşabilmek için Önce satıra Sonra satırdan da Dataya gitmemiz gerekiyor
        Row row=sayfa1.getRow(7); // Satır Row

        //13. Cell objesi olusturun row.getCell(index)
                    // şimdide Hücreye gidiyoruz yani dataya
        Cell cell= row.getCell(1); // Hücre Cell

        System.out.println(cell);


    }
}
