package com.theoremfactory.utils;

import java.util.List;

public class ListConverter {

    public static <T> void convert(List<String> table, List<T> functors) {

            table.forEach(t -> t.replace("\\\\ \\hline",""));



    }

}
