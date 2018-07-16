
import file.ReadAndSaveExcelFile;
import model.Model;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        Workbook wb = WorkbookFactory.create(new File("C:\\original.xlsx"));

        //get first sheet in the workbook
        Sheet sh = wb.getSheetAt(0);

      //no of rows in the excel sheet
        int noOfRows = sh.getLastRowNum();

        List<Model> models = new ArrayList<>();

        System.out.println("Starting to read from Excel file" +"\n");
        //read from excel sheet
        for (int i = 1; i <= noOfRows; i++) {
            Row row = sh.getRow(i);

//            String keyword = row.getCell(0).getStringCellValue();
            String english = row.getCell(1).getStringCellValue();
            String french = row.getCell(2).getStringCellValue();
            String portuguese = row.getCell(3).getStringCellValue();

            models.add(new Model( english, french, portuguese));

        }

        System.out.println("Done reading from Excel file" + "\n" );


        ReadAndSaveExcelFile.openFile();
        ReadAndSaveExcelFile.addRecords(models);
        ReadAndSaveExcelFile.closeFile();

        System.out.println("Done writing to properties file");

    }
}

