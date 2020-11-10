package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class YmlFileParser implements IFileParser {

    public File parseFile(String fileName) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

// Instantiating a new ObjectMapper as a YAMLFactory
        ObjectMapper om = new ObjectMapper(new YAMLFactory());

// Mapping the employee from the YAML file to the Employee class
        // Employee employee = om.readValue(file, Employee.class);

// Printing out the information
        //System.out.println("Employee info " + employee.toString());
        return file;
    }
}
