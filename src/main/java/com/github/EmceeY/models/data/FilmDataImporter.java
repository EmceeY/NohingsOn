package com.github.EmceeY.models.data;

import com.github.EmceeY.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.IOException;

/**
 * Created by User on 4/23/17.
 */
public class FilmDataImporter {

    @Autowired
    private FilmDao filmDao;

    private static final String DATA_FILE = "film_data.csv";
    private static boolean isDataLoaded = false;

    // read in data from a csv and save it to a list (based on LC csv import)

    public void loadData(){
        if (isDataLoaded) {
            return;
        }

        try {
            Resource resource = new ClassPathResource(DATA_FILE);
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            for (CSVRecord record : records){
                String title = record.get("name");
                String rating = record.get("mpaa rating");
                String length = record.get("length");
                int critRec = Integer.parseInt(record.get("critical reception")) ;
                int audRec = Integer.parseInt(record.get("audience reception"));
                String genre = record.get("genre");
                String keywords = record.get("keywords");
                int yrMade = Integer.parseInt(record.get("year made"));
                int yrAcc = Integer.parseInt(record.get("year accessible"));
                String cast = record.get("cast");

                ArrayList<String> keywordsArray = new ArrayList<String>(Arrays.asList(keywords.split(" ")));
                ArrayList<String> castList = new ArrayList<String>(Arrays.asList(cast.split("|")));


                Film newFilm = new Film(title, rating, length, critRec, audRec,
                        genre, keywordsArray, yrMade, yrAcc, castList);

                filmDao.save(newFilm);

            }

            isDataLoaded = true;

        } catch (IOException e){
            System.out.println("Failed to load job data");
        }
    }
}
