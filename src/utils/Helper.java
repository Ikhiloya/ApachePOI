package utils;


import org.apache.poi.ss.usermodel.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static List<String> getFile(String filePath) throws IOException {
        BufferedReader br =
                new BufferedReader(new FileReader
                        (filePath));

//        // List to collect Employee objects
//        List<Lang> langs = new ArrayList<Lang>();

        List<String> lines = new ArrayList<String>();

        // Read file line by line
        String line = "";
        while ((line = br.readLine()) != null) {
            // Parse line to extract individual fields
//                String[] data = this.parseLine(line);
            lines.add(line);
        }
        System.out.println("Done Reading from file");

        br.close();
        return lines;
    }



    private ArrayList<String[]> readXcelDocuments(InputStream file) throws Exception {

        ArrayList<String[]> trans = new ArrayList<String[]>();

        Workbook workbook = WorkbookFactory.create(file);

        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

        //Get first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);

        for (int rowIndex = 1; rowIndex < sheet.getLastRowNum(); rowIndex++) {

            Row row = sheet.getRow(rowIndex);
            //creates a string array with the length of the last cell number
            String[] tran = new String[row.getLastCellNum()];

            for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {

                Cell cell = row.getCell(colIndex);

                CellValue cellValue = evaluator.evaluate(cell);

                if (cellValue == null) {
                    tran[colIndex] = "";
                    continue;
                }

                switch (cellValue.getCellTypeEnum()) {
                    case NUMERIC:
                        tran[colIndex] = String.valueOf(cell.getNumericCellValue());
                        break;
                    case STRING:
                        tran[colIndex] = cell.getStringCellValue();
                        break;
                    case BLANK:
                        tran[colIndex] = "";

                    default:
                        throw new Exception("Error in Document at Row " + (rowIndex + 1 + ", Column " + (colIndex + 1)));
                }
            }
            if (tran[0].trim().isEmpty())
                break;
            trans.add(tran);
        }

        return trans;

    }
}
