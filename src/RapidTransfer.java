import model.Lang;
import model.Word;
import utils.Helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class RapidTransfer {
    private static Formatter formatter_en;


    public static void main(String[] args) throws IOException {
        //get all text in the original file to a List
        List<String> enWords =
                Helper.getFile("C:\\Users\\user\\Documents\\eP\\RapidTransferLangTranslator\\appmessages_en_new.txt");
//        List<String> frWords = Helper.getFile("C:\\Users\\user\\Documents\\eP\\RapidTransferLangTranslator\\appmessages_fr_data.txt");
//        List<String> ptWords = Helper.getFile("C:\\Users\\user\\Documents\\eP\\RapidTransferLangTranslator\\appmessages_pt_data.txt");


        List<Lang> langs = new ArrayList<>();
        for (int i = 0; i < enWords.size(); i++) {
            // employees[i] = new Employee(lines[i]);
            langs.add(new Lang(enWords.get(i)));
        }


        System.out.println("Done writing to object");

//        for (int i = 0; i < langs.size(); i++) {
////            System.out.println(langs.get(i).keyword + " " + langs.get(i).getWord());
////        }

        //read from messages and store as object
        List<String> messages =
                Helper.getFile("C:\\Users\\user\\Documents\\eP\\RapidTransferLangTranslator\\appmessages_en.txt");

        List<Word> words = new ArrayList<>();
        //Employee[] employees = new Employee[lines.length];
        for (int i = 0; i < messages.size(); i++) {
            // employees[i] = new Employee(lines[i]);
            words.add(new Word(messages.get(i)));
        }
        System.out.println("Done writing to object");

        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i).getWord());
        }


        List<String> exceptions = new ArrayList<>();
        List<String> ens = new ArrayList<>();

        //loop to match both texts in the files
        boolean found = false;
        int k = 0;

        System.out.println("******************************Actual**************");

        for (int i = 0; i < langs.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (langs.get(i).getWord().trim().equalsIgnoreCase(words.get(j).getWord().trim())) {
                    //if word is found , append key and save then break and go to next word
                    //ens.add(words.get(i).getWord()+ "=" + langs.get(j).getWord());
                  //  ens.add(langs.get(i) + "=" + words.get(j).getWord());
                    // System.out.println(words.get(i).getWord()+ "=" + langs.get(j).getWord());
                    // System.out.println(langs.get(j)+ "=" + langs.get(i).getWord());
                    System.out.println(words.get(j).getWord());
              ens.add(words.get(j).getWord());
                    found = true;
                    break;
                }
            }
            // if word is not found, just append word and save
            if (!found) {
                //add to the exceptions file
                exceptions.add(langs.get(i).getKeyword() + "=" +langs.get(i).getWord());
                //    System.out.println(langs.get(i).getKeyword().trim() +"="+ langs.get(i).getWord()+ " Not Found");
                System.out.println(langs.get(i).getKeyword() +"="+langs.get(i).getWord() + " Not Found");
            }
            found = false;
//
        }
        System.out.println("*******************************Found**************");

        for (String wd : ens) {
            System.out.println(wd);
        }

//
        System.out.println("*******************************************************");
        System.out.println("********************************************************");
        System.out.println("*******************************Exceptions**************");

        for (String wd : exceptions) {
            System.out.println(wd);
        }


//        Create.openFile();
//        Create.addRecords(exceptions);
//        Create.closeFile();

        Create.openFile();
        Create.addRecords(exceptions);
        Create.closeFile();


    }

    private static class Create {
        private static void openFile() {
            try {

                formatter_en = new Formatter("exceptions_new_found2.txt");


            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        private static void addRecords(List<String> models) {
            String newline = System.getProperty("line.separator");
            for (int i = 0; i < models.size(); i++) {
                formatter_en.format("%s%s", models.get(i), newline);
            }

        }

        private static void closeFile() {
            formatter_en.close();

        }

    }


}
