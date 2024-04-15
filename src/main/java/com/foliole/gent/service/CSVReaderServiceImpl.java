package com.foliole.gent.service;

import com.foliole.gent.models.CSVBean;
import com.foliole.gent.models.FieldDetails;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderServiceImpl implements CSVReaderService {

    public List<CSVBean> read(String path, int linesToSkip, Class<? extends CSVBean> clazz) {
        List<FieldDetails> fields = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(path))) {
            CsvToBean<CSVBean> cb = new CsvToBeanBuilder<CSVBean>(reader)
                    .withSkipLines(linesToSkip)
                    .withType(clazz)
                    .build();

            return cb.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
