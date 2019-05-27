package com.theoremfactory.utils;

import java.util.List;
import java.util.stream.Collectors;

public class TableConverter {

    public static void convert(List<String> content, List<String> table) {

        table.addAll(content.stream().filter(c -> c.contains("&")).collect(Collectors.toList()));
        table.remove(0);
    }

}
