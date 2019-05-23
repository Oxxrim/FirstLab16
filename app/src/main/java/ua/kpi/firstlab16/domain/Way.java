package ua.kpi.firstlab16.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "way")
public class Way {
    @DatabaseField(generatedId=true)
    private Integer id;

    @DatabaseField
    private String pathway;

    public Way(String pathway) {
        this.pathway = pathway;
    }

    public String getPathway() {
        return pathway;
    }

    public void setPathway(String pathway) {
        this.pathway = pathway;
    }

    public Way() {
    }
}
