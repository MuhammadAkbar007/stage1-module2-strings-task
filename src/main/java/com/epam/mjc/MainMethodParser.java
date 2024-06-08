package com.epam.mjc;

public class MainMethodParser {
    public static void main(String[] args) {
        String prompt1 = "private void log(String value)";
        String prompt2 = "Vector3 distort(int x, int y, int z, float magnitude)";
        String prompt3 = "public DateTime getCurrentDateTime()";

        MethodParser parser = new MethodParser();
        MethodSignature methodSignature1 = parser.parseFunction(prompt1);
        MethodSignature methodSignature2 = parser.parseFunction(prompt2);
        MethodSignature methodSignature3 = parser.parseFunction(prompt3);

        System.out.println(methodSignature1.toString());
        System.out.println(methodSignature2);
        System.out.println(methodSignature3);
    }
}
