package com.theoremfactory.utils;

import com.theoremfactory.model.Functor;
import com.theoremfactory.model.FunctorProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregator {

    public static void aggregateFunctors(List<String> content) {
        String[] arr = {"\\documentclass[a4paper,14pt]{extarticle}",
        "\\usepackage{cmap}",
        "\\usepackage[cp1251]{inputenc}",
        "\\usepackage[english]{babel}",
        "\\usepackage[left=3cm,right=2cm,top=2cm,bottom=2cm]{geometry}",
        "\\usepackage{amssymb}",
        "\\usepackage{amsmath, amsthm}",
        "\\usepackage{indentfirst}",
        "\\usepackage{amssymb}",
        "\\begin{document}",
        "\\begin{table}[]",
        "\\centering",
        "\\caption{Functors}",
        "\\label{my-label}",
        "\\begin{tabular}{|l|l|l|} \\hline",
        "NameSpecificFunctor    & DescFunctor                          & PropertiesFunctor          \\ \\hline",
        " $T_1$                  & group                                & LowerRegular               \\ \\hline",
        "$T_2$                  & subgroups                            & LowerRegular               \\ \\hline",
        "$T_3$                  & 1                                    & LowerRegular               \\ \\hline",
        "\\end{tabular}",
        "\\end{table}",
        "\\end{document}"};
        content.addAll(Arrays.asList(arr));
    }

    public static void aggregateTableFunctors(List<String> content) {

        String[] table = {
                " $T_1$                  & group                                & LowerRegular               \\ \\hline",
                "$T_2$                  & subgroups                            & LowerRegular               \\ \\hline",
                "$T_3$                  & 1                                    & LowerRegular               \\ \\hline",
        };
        content.addAll(Arrays.asList(table));

    }

    public static void aggregateListFunctors(List<Functor> functors) {
        List<FunctorProperty> properties = new ArrayList<>();
        properties.add(new FunctorProperty("LowerRegular"));
        functors.add(new Functor("$T_1","group", properties));
        functors.add(new Functor("$T_2","subgroup", properties));
        functors.add(new Functor("$T_3","1", properties));
    }
}
