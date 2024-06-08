package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {

        // validate args are coming
        if (source == null || delimiters == null || delimiters.isEmpty()) {
            throw new IllegalArgumentException("Source and delimiters cannot be null or empty");
        }

        // Create a regular expression from the delimiters
        StringBuilder regexBuilder = new StringBuilder();
        for (String delimiter : delimiters) {
            if (regexBuilder.length() > 0) {
                regexBuilder.append("|");
            }
            regexBuilder.append("\\Q").append(delimiter).append("\\E");
        }
        String regex = regexBuilder.toString();

        // Split the source string using the constructed regular expression
        String[] splitArray = source.split(regex);

        // Convert the split array to a list and return
        List<String> result = new ArrayList<>();
        for (String s : splitArray) {
            if (!s.isEmpty()) { // Optionally, skip empty strings
                result.add(s);
            }
        }

        return result;
    }
}
