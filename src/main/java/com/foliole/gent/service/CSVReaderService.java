package com.foliole.gent.service;

import com.foliole.gent.models.CSVBean;
import com.foliole.gent.models.FieldDetails;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CSVReaderService {

    List<CSVBean> read(String path, int linesToSkip, Class<? extends CSVBean> clazz);
}
