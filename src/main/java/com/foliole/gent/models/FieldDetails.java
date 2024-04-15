package com.foliole.gent.models;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FieldDetails extends CSVBean {

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "type")
    private String type;

    @CsvBindByName(column = "is_pk")
    private boolean isPrimaryKey;

    @CsvBindByName(column = "is_fk")
    private boolean isForeignKey;

    @CsvBindByName(column = "fk_name")
    private String foreignKeyName;
}
