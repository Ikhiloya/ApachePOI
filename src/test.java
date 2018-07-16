import model.Lang;
import model.Word;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) throws IOException {


        List<String> lines = getFile("C:\\Users\\user\\Documents\\eP\\RapidTransferLangTranslator\\appmessages_en_data.txt");

        List<Lang> langs = new ArrayList<>();
        //Employee[] employees = new Employee[lines.length];
        for (int i = 0; i < lines.size(); i++) {
            // employees[i] = new Employee(lines[i]);
            langs.add(new Lang(lines.get(i)));
        }
        System.out.println("Done writing to object");

        for (int i = 0; i < langs.size(); i++) {
            System.out.println(langs.get(i).keyword + " " + langs.get(i).getWord());

        }


        System.out.println("******************************************************************************************");
        System.out.println("******************************************************************************************");
        System.out.println("******************************************************************************************");


        //read from messages and store as object
        List<String> messages = getFile("C:\\Users\\user\\Documents\\eP\\RapidTransferLangTranslator\\appmessages_en.txt");

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


        System.out.println("******************************************************************************************");
        System.out.println("******************************************************************************************");
        System.out.println("******************************************************************************************");

        List<String> exceptions= new ArrayList<>();
        //loop to match both texts in the files
        boolean found = false;
        for(int i= 0; i<words.size(); i++){
            for (int j =0;j<langs.size(); j++){
                if(langs.get(j).getWord().trim().equalsIgnoreCase(words.get(i).getWord().trim())){
                    //if word is found , append key and save then break and go to next word
                    System.out.println(langs.get(i).getKeyword() + " = " + langs.get(i).getWord());
                    found = true;
                    break;
                }
            }
            // if word is not found, just append word and save
            if (!found){
                //add to the exceptions file
                System.out.println(words.get(i).getWord().trim()+ " Not Found");
            }
            found=false;
        }

        System.out.println("******************************Exception**************************************************");
        System.out.println("******************************************************************************************");
        for(int i= 0; i< exceptions.size(); i++){
            System.out.println(exceptions.get(i));
        }

    }

    private static List<String> getFile(String filePath) throws IOException {
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
}
