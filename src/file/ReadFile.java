//package file;
//
//import model.Lang;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ReadFile {
//    public void readFromFile() {
//
//
//        try {
//            BufferedReader br =
//                    new BufferedReader(new FileReader
//                            ("C:\\Users\\user\\Documents\\eP\\RapidTransferLangTranslator\\appmessages.txt"));
//
//            // List to collect Employee objects
//            List<Lang> langs = new ArrayList<Lang>();
//
//            // Read file line by line
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                // Parse line to extract individual fields
//                String[] data = parseLine(line);
//
//                // Create new Employee object
//                Employee employee = new Employee();
//                employee.id = Integer.valueOf(data[0]);
//                employee.fName = data[1];
//                employee.mName = data[2];
//
//                // Add object to list
//                employees.add(employee);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//}
