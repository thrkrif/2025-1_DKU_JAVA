package kr.ac.dankook.ace.lab3.dao.dataimporter;

import java.util.List;

public interface DataImporter<T> {
    List<T> load(String filepath);
    void save(String filepath, List<T> data);
}
