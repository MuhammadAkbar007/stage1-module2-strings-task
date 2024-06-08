package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MainStringSplitter {
    public static void main(String[] args) {
        StringSplitter splitter = new StringSplitter();
        ArrayList<String> delimiters = new ArrayList<>();
        delimiters.add("illah");
        delimiters.add("allah");
        List<String> strings = splitter.splitByDelimiters("Bismillah biiznillah subhanallah alhamdulillah, allah", delimiters);
        System.out.println(strings);
    }
}
