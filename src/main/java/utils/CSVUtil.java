package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static constants.TestConstants.RESOURCES_PATH;

public class CSVUtil {

    public Object[][] getDataAsArray(String filePath) {

        List<String[]> listOfRows = new ArrayList<>();
        String[] line = null;
        Object[][] arrayToReturn = null;

        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVReader csvReader = new CSVReader(reader);
            while ((line = csvReader.readNext()) != null) {
                listOfRows.add(line);
            }
            reader.close();
            csvReader.close();
            arrayToReturn = new Object[listOfRows.size()][listOfRows.size()];
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < listOfRows.size(); i++) {
            arrayToReturn[i] = listOfRows.get(i);
        }
        return arrayToReturn;
    }

    public static void main(String[] args) {
        CSVUtil csvUtil = new CSVUtil();
        csvUtil.getDataAsArray(RESOURCES_PATH + "/data.csv");
    }
}


