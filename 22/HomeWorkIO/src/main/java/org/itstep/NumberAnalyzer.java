package org.itstep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NumberAnalyzer {

    public EvenNumberInfo evenNumbers(String fileName) {
        List<Integer> numbers = parseNumbers(fileName);
        EvenNumberInfo info = new EvenNumberInfo(numbers.size(), calculateSum(numbers), countEvenNumbers(numbers));

        System.out.printf("%d чисел, сумма %d\n", info.getTotalNumbers(), info.getSummation());

        System.out.printf("%d четных (%.2f%%)", info.getTotalEvenNumbersCount(), info.getEvenNumberPercentage());
        System.out.println();

        return info;

    }

    private int countEvenNumbers(List<Integer> numbers) {
        int counter = 0;
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    private BigInteger calculateSum(List<Integer> numbers) {
        BigInteger summ = BigInteger.ZERO;
        for (Integer number : numbers) {
            summ = summ.add(BigInteger.valueOf(number));
        }
        return summ;
    }

    private List<Integer> parseNumbers(String fileName) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.getClass().getClassLoader().getResource(fileName).getFile()))) {

            String currentLine;

            while ((currentLine = br.readLine()) != null) {

                String[] arrayNumbers = currentLine.split(" ");

                for (String arrayNumber : arrayNumbers) {
                    try {
                        numbers.add(Integer.valueOf(arrayNumber));
                    } catch (NumberFormatException e) {
                        System.out.println("Error reading file, not a number: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
        return numbers;
    }

}