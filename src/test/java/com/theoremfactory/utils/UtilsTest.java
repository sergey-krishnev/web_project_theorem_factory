package com.theoremfactory.utils;

import com.theoremfactory.model.Functor;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UtilsTest {

    @Test
    public void testLoadingFile() {
        String nameFile = "functors.txt";
        FileReader fileReader = new FileReaderImpl();
        Assert.assertNotNull(fileReader.read(nameFile));
    }

    @Test
    public void testLoadingContent() {
        String nameFile = "functors.txt";
        List<String> testContent = new ArrayList<>();
        ListAggregator.aggregateFunctors(testContent);
        FileReader fileReader = new FileReaderImpl();
        List<String> content = fileReader.read(nameFile);
        Assert.assertEquals(content.size(), testContent.size());
    }

    @Test
    public void testGetTable() {
        String nameFile = "functors.txt";
        List<String> testTable = new ArrayList<>();
        ListAggregator.aggregateTableFunctors(testTable);
        FileReader fileReader = new FileReaderImpl();
        List<String> content = fileReader.read(nameFile);
        List<String> table = new ArrayList<>();
        TableConverter.convert(content, table);
        Assert.assertEquals(table.size(), testTable.size());

    }

    @Test
    public void testGetListFunctors() {
        String nameFile = "functors.txt";
        List<Functor> testFunctors = new ArrayList<>();
        ListAggregator.aggregateListFunctors(testFunctors);
        FileReader fileReader = new FileReaderImpl();
        List<String> content = fileReader.read(nameFile);
        List<String> table = new ArrayList<>();
        List<Functor> functors = new ArrayList<>();
        TableConverter.convert(content, table);
        ListConverter.convert(table, functors);
        Assert.assertEquals(functors,testFunctors);
    }

}
