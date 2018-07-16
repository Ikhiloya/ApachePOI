package file;

import model.Model;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;

public class ReadAndSaveExcelFile {
    private static Formatter formatter_en;
    private static Formatter formatter_fr;
    private static Formatter formatter_pt;
    private static Formatter formatter_exception_en;
    private static Formatter formatter_exception_fr;
    private static Formatter formatter_exception_pt;

    public static void openFile() {
        try {

            formatter_en = new Formatter("appmessages_en.txt");
            formatter_fr = new Formatter("appmessages_fr.txt");
            formatter_pt = new Formatter("appmessages_pt.txt");
//            formatter_pt = new Formatter("exceptions_en.txt");
//            formatter_pt = new Formatter("exceptions_fr.txt");
//            formatter_pt = new Formatter("exceptions_pt.txt");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addRecords(List<Model> models) {
        String newline = System.getProperty("line.separator");
        for (int i = 0; i < models.size(); i++) {
            formatter_en.format("%s", models.get(i).getEnglish() + newline);
            formatter_fr.format("%s", models.get(i).getFrench() + newline);
            formatter_pt.format("%s",models.get(i).getPortuguese() + newline);
//            formatter_exception_en.format("%s", models.get(i).getKeyword(), "=", models.get(i).getPortuguese() + newline);
//            formatter_exception_fr.format("%s%s%s", models.get(i).getKeyword(), "=", models.get(i).getPortuguese() + newline);
//            formatter_exception_pt.format("%s%s%s", models.get(i).getKeyword(), "=", models.get(i).getPortuguese() + newline);

        }

    }

    public static void closeFile() {
        formatter_en.close();
        formatter_fr.close();
        formatter_pt.close();
//        formatter_exception_en.close();
//        formatter_exception_fr.close();
//        formatter_exception_pt.close();

    }

}
