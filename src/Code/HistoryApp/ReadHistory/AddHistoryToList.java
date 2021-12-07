package Code.HistoryApp.ReadHistory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/*
I creted this class with redFile method because can be used for any type of hire without being modified and i want to respect
the Single-responsibility principle.
This method read the contents of the file and add it to the list.
 */

public class AddHistoryToList {

    public List<String> readFile(String path){

            List<String> historyList = new LinkedList<>();
            try {
                File hist = new File(path);
                FileReader fr = new FileReader(hist);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    historyList.add(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return historyList;
        }
    }

