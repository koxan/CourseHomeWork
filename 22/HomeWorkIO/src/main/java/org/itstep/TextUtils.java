package org.itstep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class TextUtils {

    private TextUtils() {}

    public static void collapseSpaces(String fileName) {
        List<String> lines = parseFile(fileName);
        for (String line : lines) {
            line = line.replaceAll("\\s+", " ");
            line = line.replaceAll("\\t+", " ");
            System.out.println(line);
        }
    }

    public static String getContent(String fileName) {
        List<String> lines = parseFile(fileName);
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
        }
        return sb.toString();
    }

    private static List<String> parseFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(TextUtils.class.getClassLoader().getResource(fileName).getFile()))) {

            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                lines.add(currentLine);
            }
        } catch (IOException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static void main(String[] args) {
        TextUtils.collapseSpaces("text1.txt");
        String result = TextUtils.getContent("text1.txt");
        System.out.println(result);
    }
}
