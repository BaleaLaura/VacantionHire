package Code.HistoryApp;

import java.io.*;

public class ManagedFile {

/*
In this class i added methods which managed the file in cas of return, find the line which i want to delete from
reservation->delete the line.
 */
    public static boolean findLine(String formatReservation, String path) throws IOException {

        File inputFile = new File(path);

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(formatReservation)) {
                return true;
            }

        }
        return false;
    }
    public static void deleteLine(String formatReservation, String path1, String path2) throws IOException {
        File inputFile = new File(path1);
        File tempFile = new File(path2);

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if (trimmedLine.equals(formatReservation)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();
        inputFile.delete();
        reFile(path2,path1);

    }

    public static void reFile(String path2, String path1) throws IOException {

        File inputFile = new File(path2);
        File tempFile = new File(path1);

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            writer.write(trimmedLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();
        inputFile.delete();
    }


}
