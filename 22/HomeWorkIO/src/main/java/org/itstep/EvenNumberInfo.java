package org.itstep;

import java.math.BigInteger;


    public class EvenNumberInfo {
        private int totalNumbers;
        private BigInteger summation;
        private int totalEvenNumbersCount;
        private double evenNumberPercentage;

        public EvenNumberInfo(int totalNumbers, BigInteger summation, int totalEvenNumbersCount) {
            this.totalNumbers = totalNumbers;
            this.summation = summation;
            this.totalEvenNumbersCount = totalEvenNumbersCount;
            this.evenNumberPercentage = (double) totalEvenNumbersCount / (double) totalNumbers * 100;
        }

        public int getTotalNumbers() {
            return totalNumbers;
        }

        public BigInteger getSummation() {
            return summation;
        }

        public int getTotalEvenNumbersCount() {
            return totalEvenNumbersCount;
        }

        public double getEvenNumberPercentage() {
            return evenNumberPercentage;
        }

    }


