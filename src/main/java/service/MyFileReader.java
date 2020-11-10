package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.Configurations;
import lombok.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class MyFileReader {

    IFileParser fileParser;

    public MyFileReader(IFileParser fileParser) {
        this.fileParser = fileParser;
    }

    public List<String> readTextFile(String fileName) throws IOException {

        File file = fileParser.parseFile(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> inputList = new ArrayList<String>();
        String st;
        while ((st = br.readLine()) != null) inputList.add(st);
        return inputList;


    }

    public config.Configurations readYmlFile(String filename) throws IOException {
        File file = fileParser.parseFile(filename);
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        Configurations configurations = om.readValue(file, Configurations.class);
        return configurations;
    }

}
