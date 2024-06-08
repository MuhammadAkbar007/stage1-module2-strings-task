package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ''.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {

        // initialize needed variables to parse object
        String accessModifier;
        String returnType;
        String methodName;
        List<MethodSignature.Argument> arguments = new ArrayList<>();

        // split headers and args at the first '(' from input signature
        int parentIndex = signatureString.indexOf('(');
        String header = signatureString.substring(0, parentIndex).trim();
        String argsString = signatureString.substring(parentIndex + 1, signatureString.length() - 1).trim();

        // split headerParts array into parts and assign values
        String[] headerParts = header.split(" ");
        switch (headerParts.length) {
            case 3:
                accessModifier = headerParts[0];
                returnType = headerParts[1];
                methodName = headerParts[2];
                break;
            case 2:
                accessModifier = "package";
                returnType = headerParts[0];
                methodName = headerParts[1];
                break;
            default:
                throw new IllegalArgumentException("Invalid method signature: " + signatureString);
        }

        // working with argString
        if (!argsString.isEmpty()) {
            String[] argsArray = argsString.split(",");
            for (String arg : argsArray) {
                arg = arg.trim();
                String[] argParts = arg.split(" ");
                if (argParts.length != 2)
                    throw new IllegalArgumentException("Invalid method signature: " + signatureString);
                String argType = argParts[0];
                String argName = argParts[1];
                arguments.add(new MethodSignature.Argument(argType, argName));
            }
        }

        // create object of methodSignature, set variables and return this object
        MethodSignature methodSignature = new MethodSignature(methodName, arguments);
        methodSignature.setAccessModifier(accessModifier);
        methodSignature.setReturnType(returnType);

        return methodSignature;

    }
}
