package com.theoremfactory.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        List<String> list = new ArrayList<>();
        Scanner s = null;
        try {
            URL resourceURL = classLoader.getResource(fileName);
            if (resourceURL == null) {
                throw new FileNotFoundException(fileName + " not found");
            } else {
                File configFile = new File(resourceURL.getFile());
                s = new Scanner(configFile);
                s.useDelimiter("\n");
            }
        } catch (FileNotFoundException e) {
           return list;
        }
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        return list;
    }
}
