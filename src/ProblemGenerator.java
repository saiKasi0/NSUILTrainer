import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ProblemGenerator {
    private final Random random = new Random();

    public Problem generateProblem(ProblemType type) {
        return switch (type) {
            // Problems 1-20
            case ARITHMETIC_BASICS -> generateBasicArithmetic();
            case MULTIPLICATION_SHORTCUTS -> generateMultiplicationShortcut();
            case SQUARING_NUMBERS -> generateSquaringProblem();
            case UNIT_CONVERSION -> generateUnitConversion();
            case GCD_LCM -> generateGcdLcmProblem();
            case PERCENTAGE -> generatePercentProblem();
            case STATISTICS -> generateStatisticsProblem();
            case INTEGER_SUMS -> generateIntegerSumsProblem();
            case REMAINDER -> generateRemainderProblem();
            case CONSUMER_MATH -> generateConsumerMathProblem();
            case NUMBER_THEORY -> generateNumberTheoryProblem();

            // Problems 21-40
            case POWERS -> generatePowersProblem();
            case WORD_PROBLEMS -> generateWordProblem();
            case ABSOLUTE_VALUE -> generateAbsoluteValueProblem();
            case RATIO_PROPORTION -> generateRatioProblem();
            case ROOTS -> generateRootsProblem();
            case SETS -> generateSetsProblem();
            case BASE_CONVERSION -> generateBaseConversion();
            case SIMPLE_EQUATIONS -> generateSimpleEquation();
            case SYSTEM_EQUATIONS -> generateSystemEquations();
            case REPEATING_DECIMALS -> generateRepeatingDecimal();
            case GEOMETRY_BASIC -> generateBasicGeometry();
            case SEQUENCES_BASIC -> generateBasicSequence();

            // Default case
            default -> generateBasicArithmetic();
        };
    }

    // Basic Arithmetic and Number Theory (Problems 1-20)
    private Problem generateBasicArithmetic() {
        int operation = random.nextInt(4);
        int num1 = random.nextInt(100) + 1;
        int num2 = random.nextInt(100) + 1;
        String operationSymbol;
        double result;
        String explanation;

        switch (operation) {
            case 0: // Addition
                result = num1 + num2;
                operationSymbol = "+";
                explanation = "Break into tens and ones:\n" +
                        "Tens: " + (num1/10) + "0 + " + (num2/10) + "0 = " + ((num1/10 + num2/10)*10) + "\n" +
                        "Ones: " + (num1%10) + " + " + (num2%10) + " = " + (num1%10 + num2%10);
                break;
            case 1: // Subtraction
                result = num1 - num2;
                operationSymbol = "-";
                explanation = "Break into tens and ones:\n" +
                        "Tens: " + (num1/10) + "0 - " + (num2/10) + "0 = " + ((num1/10 - num2/10)*10) + "\n" +
                        "Ones: " + (num1%10) + " - " + (num2%10) + " = " + (num1%10 - num2%10);
                break;
            case 2: // Multiplication
                num1 = random.nextInt(12) + 1; // Smaller numbers for multiplication
                num2 = random.nextInt(12) + 1;
                result = num1 * num2;
                operationSymbol = "×";
                explanation = "Use multiplication table or break down:\n" +
                        num1 + " × " + num2 + " = " + result;
                break;
            default: // Division
                num2 = random.nextInt(12) + 1; // Smaller numbers for division
                result = num1;
                num1 = num2 * (int)result; // Ensure clean division
                operationSymbol = "÷";
                explanation = "Think of it as: What times " + num2 + " equals " + num1 + "?\n" +
                        num1 + " ÷ " + num2 + " = " + result;
                break;
        }

        return new Problem(
                "Calculate: " + num1 + " " + operationSymbol + " " + num2,
                result,
                explanation,
                1,
                "Basic Arithmetic"
        );
    }

    private Problem generateMultiplicationShortcut() {
        int type = random.nextInt(3);
        int num;
        int multiplier;
        double result;
        String explanation;

        switch (type) {
            case 0: // Multiply by 11
                num = random.nextInt(90) + 10;
                multiplier = 11;
                result = num * multiplier;
                explanation = "11 multiplication trick:\n" +
                        "For " + num + " × 11:\n" +
                        "1. Add the digits: " + (num/10) + " + " + (num%10) + " = " + (num/10 + num%10) + "\n" +
                        "2. Place sum between original digits";
                break;
            case 1: // Multiply by 25
                num = random.nextInt(40) + 1;
                multiplier = 25;
                result = num * multiplier;
                explanation = "25 multiplication trick:\n" +
                        "Divide by 4 and multiply by 100:\n" +
                        num + " ÷ 4 = " + (num/4.0) + " × 100 = " + result;
                break;
            default: // Multiply by 5
                num = random.nextInt(200) + 1;
                multiplier = 5;
                result = num * multiplier;
                explanation = "5 multiplication trick:\n" +
                        "Divide by 2 and multiply by 10:\n" +
                        num + " ÷ 2 = " + (num/2.0) + " × 10 = " + result;
                break;
        }

        return new Problem(
                "Calculate quickly: " + num + " × " + multiplier,
                result,
                explanation,
                2,
                "Multiplication Shortcuts"
        );
    }

    private Problem generateSquaringProblem() {
        int type = random.nextInt(2);
        int num;
        double result;
        String explanation;

        if (type == 0) { // Numbers ending in 5
            num = random.nextInt(9) * 10 + 5;
            result = num * num;
            int tens = num / 10;
            explanation = "Square numbers ending in 5:\n" +
                    "1. Take the tens digit (" + tens + ")\n" +
                    "2. Multiply it by next number (" + (tens + 1) + ")\n" +
                    "3. Append 25\n" +
                    tens + " × " + (tens + 1) + " = " + (tens * (tens + 1)) + "\n" +
                    "Result: " + (tens * (tens + 1)) + "25";
        } else { // Perfect squares near 100
            num = 90 + random.nextInt(20);
            result = num * num;
            explanation = "Square numbers near 100:\n" +
                    "1. Difference from 100: " + (num - 100) + "\n" +
                    "2. 100² + 2(100)(diff) + diff²\n" +
                    "= 10000 + " + (2 * 100 * (num - 100)) + " + " + ((num - 100) * (num - 100));
        }

        return new Problem(
                "Square this number: " + num,
                result,
                explanation,
                2,
                "Squaring Numbers"
        );
    }

    private Problem generateUnitConversion() {
        String[][] conversions = {
                {"meters", "feet", "3.28084"},
                {"kilometers", "miles", "0.621371"},
                {"pounds", "kilograms", "0.453592"},
                {"liters", "gallons", "0.264172"},
                {"celsius", "fahrenheit", "Multiply by 9/5 and add 32"}
        };

        int conversionType = random.nextInt(conversions.length);
        int value = random.nextInt(20) + 1;
        double result;
        String explanation;

        if (conversionType == 4) { // Temperature conversion
            result = value * 9.0/5.0 + 32;
            explanation = "Temperature conversion:\n" +
                    "1. Multiply by 9/5 (" + value + " × 9/5 = " + (value * 9.0/5.0) + ")\n" +
                    "2. Add 32";
        } else {
            double factor = Double.parseDouble(conversions[conversionType][2]);
            result = value * factor;
            explanation = String.format("Conversion factor: 1 %s = %s %s\n%d × %s = %.2f",
                    conversions[conversionType][0],
                    conversions[conversionType][2],
                    conversions[conversionType][1],
                    value,
                    conversions[conversionType][2],
                    result);
        }

        return new Problem(
                String.format("Convert %d %s to %s", value,
                        conversions[conversionType][0],
                        conversions[conversionType][1]),
                result,
                explanation,
                2,
                "Unit Conversion"
        );
    }

    private Problem generateGcdLcmProblem() {
        boolean isGcd = random.nextBoolean();
        int num1 = random.nextInt(20) + 1;
        int num2 = random.nextInt(20) + 1;

        int gcd = calculateGCD(num1, num2);
        int lcm = (num1 * num2) / gcd;

        String question = isGcd ?
                "Find the GCD of " + num1 + " and " + num2 :
                "Find the LCM of " + num1 + " and " + num2;

        String explanation = isGcd ?
                "Using Euclidean algorithm:\n" +
                        "Divide larger by smaller and take remainder until 0" :
                "LCM = (num1 × num2) ÷ GCD\n" +
                        "First find GCD = " + gcd + "\n" +
                        "Then " + num1 + " × " + num2 + " ÷ " + gcd + " = " + lcm;

        return new Problem(
                question,
                isGcd ? gcd : lcm,
                explanation,
                2,
                "GCD/LCM"
        );
    }

    private Problem generatePercentProblem() {
        int[] commonPercentages = {25, 75, 10, 20, 50};
        int percentage = commonPercentages[random.nextInt(commonPercentages.length)];
        int number = (random.nextInt(20) + 1) * 4;
        double result = (percentage * number) / 100.0;

        String explanation = switch(percentage) {
            case 25 -> "25% = ÷4\n" + number + " ÷ 4 = " + result;
            case 75 -> "75% = subtract 25% from 100%\n" +
                    number + " - (" + number + " ÷ 4) = " + result;
            case 10 -> "10% = ÷10\n" + number + " ÷ 10 = " + result;
            case 20 -> "20% = 10% × 2\n" +
                    "10% = " + (number/10) + "\n" +
                    "20% = " + result;
            default -> "50% = ÷2\n" + number + " ÷ 2 = " + result;
        };

        return new Problem(
                "Calculate " + percentage + "% of " + number,
                result,
                explanation,
                1,
                "Percentages"
        );
    }

    private Problem generateStatisticsProblem() {
        int size = random.nextInt(3) + 4; // 4-6 numbers
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;

        // Generate numbers and calculate sum
        for (int i = 0; i < size; i++) {
            int num = random.nextInt(20) + 1;
            numbers.add(num);
            sum += num;
        }

        // Sort for median
        numbers.sort(null);

        double mean = (double) sum / size;
        double median;
        if (size % 2 == 0) {
            median = (numbers.get(size/2 - 1) + numbers.get(size/2)) / 2.0;
        } else {
            median = numbers.get(size/2);
        }

        boolean findMean = random.nextBoolean();
        String numList = numbers.toString().replaceAll("[\\[\\]]", "");

        return new Problem(
                "Find the " + (findMean ? "mean" : "median") + " of: " + numList,
                findMean ? mean : median,
                "Mean = sum ÷ count = " + sum + " ÷ " + size + " = " + mean + "\n" +
                        "Median (sorted): " + numList + "\n" +
                        "Median = " + median,
                2,
                "Statistics"
        );
    }

    private Problem generateIntegerSumsProblem() {
        int start = random.nextInt(10) + 1;
        int end = start + random.nextInt(10) + 5;
        int n = end - start + 1;
        double sum = (n * (start + end)) / 2.0;

        return new Problem(
                "Find the sum of all integers from " + start + " to " + end,
                sum,
                "Use the formula: n(first + last)/2\n" +
                        "n = " + n + " numbers\n" +
                        "first = " + start + ", last = " + end + "\n" +
                        n + " × (" + start + " + " + end + ") ÷ 2 = " + sum,
                2,
                "Integer Sums"
        );
    }

    private Problem generateRemainderProblem() {
        int divisor = random.nextInt(9) + 2;
        int quotient = random.nextInt(10) + 1;
        int remainder = random.nextInt(divisor);
        int dividend = divisor * quotient + remainder;

        return new Problem(
                "What is the remainder when " + dividend + " is divided by " + divisor + "?",
                remainder,
                dividend + " ÷ " + divisor + " = " + quotient + " with remainder " + remainder + "\n" +
                        dividend + " = " + divisor + " × " + quotient + " + " + remainder,
                2,
                "Remainders"
        );
    }

    private Problem generateConsumerMathProblem() {
        double originalPrice = (random.nextInt(100) + 1) * 5;
        int discountPercent = (random.nextInt(4) + 1) * 10;
        double discount = originalPrice * discountPercent / 100;
        double finalPrice = originalPrice - discount;

        return new Problem(
                String.format("A $%.2f item is on sale with %d%% discount. What's the final price?",
                        originalPrice, discountPercent),
                finalPrice,
                String.format("1. Calculate discount: $%.2f × %d%% = $%.2f\n" +
                                "2. Subtract from original: $%.2f - $%.2f = $%.2f",
                        originalPrice, discountPercent, discount,
                        originalPrice, discount, finalPrice),
                2,
                "Consumer Math"
        );
    }

    private Problem generateNumberTheoryProblem() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: // Prime factorization
                int num = random.nextInt(50) + 20;
                List<Integer> factors = getPrimeFactors(num);
                return new Problem(
                        "Find the prime factorization of " + num,
                        num,
                        "Prime factors: " + factors + "\n" +
                                "Result: " + formatPrimeFactorization(factors),
                        3,
                        "Number Theory"
                );

            case 1: // Count factors
                int number = random.nextInt(30) + 10;
                List<Integer> allFactors = getFactors(number);
                return new Problem(
                        "How many factors does " + number + " have?",
                        allFactors.size(),
                        "Factors of " + number + ": " + allFactors,
                        2,
                        "Number Theory"
                );

            default: // Is prime
                int primeCandidate = generatePrime();
                return new Problem(
                        "Is " + primeCandidate + " prime? (1 for yes, 0 for no)",
                        isPrime(primeCandidate) ? 1 : 0,
                        "Check if divisible by numbers up to square root",
                        2,
                        "Number Theory"
                );
        }
    }

    private Problem generateWordProblem() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: // Age problem
                int currentAge = random.nextInt(20) + 10;
                int yearsPassed = random.nextInt(10) + 5;
                return new Problem(
                        "If John is " + currentAge + " years old now, how old will he be in " + yearsPassed + " years?",
                        currentAge + yearsPassed,
                        "Add years passed to current age:\n" +
                                currentAge + " + " + yearsPassed + " = " + (currentAge + yearsPassed),
                        1,
                        "Word Problems"
                );

            case 1: // Distance/Rate/Time
                int rate = random.nextInt(20) + 30;
                int time = random.nextInt(4) + 2;
                return new Problem(
                        "A car travels at " + rate + " mph for " + time + " hours. How far does it go?",
                        rate * time,
                        "Distance = Rate × Time\n" +
                                rate + " × " + time + " = " + (rate * time),
                        2,
                        "Word Problems"
                );

            default: // Work problem
                int timeA = random.nextInt(4) + 2;
                int timeB = random.nextInt(4) + 2;
                double combined = 1.0 / ((1.0/timeA + 1.0/timeB));
                return new Problem(
                        "If Alice takes " + timeA + " hours and Bob takes " + timeB +
                                " hours to complete a task alone, how long will it take them working together?",
                        combined,
                        "Combined time = 1 / (1/A + 1/B)\n" +
                                "= 1 / (1/" + timeA + " + 1/" + timeB + ")",
                        3,
                        "Word Problems"
                );
        }
    }

    private Problem generateAbsoluteValueProblem() {
        int num1 = random.nextInt(100) - 50;
        int num2 = random.nextInt(100) - 50;

        return new Problem(
                String.format("Calculate |%d| - |%d|", num1, num2),
                Math.abs(num1) - Math.abs(num2),
                String.format("1. |%d| = %d\n2. |%d| = %d\n3. %d - %d = %d",
                        num1, Math.abs(num1),
                        num2, Math.abs(num2),
                        Math.abs(num1), Math.abs(num2),
                        Math.abs(num1) - Math.abs(num2)),
                2,
                "Absolute Value"
        );
    }

    private Problem generateRatioProblem() {
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;
        int multiplier = random.nextInt(5) + 2;

        return new Problem(
                String.format("If the ratio of a to b is %d:%d and a = %d, what is b?",
                        a, b, a * multiplier),
                b * multiplier,
                String.format("1. Original ratio %d:%d\n" +
                                "2. First number increased by factor of %d\n" +
                                "3. Second number must increase by same factor\n" +
                                "4. %d × %d = %d",
                        a, b, multiplier, b, multiplier, b * multiplier),
                2,
                "Ratio and Proportion"
        );
    }
    private Problem generatePowersProblem() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: // Simple powers
                int base = random.nextInt(8) + 2;
                int exponent = random.nextInt(3) + 2;
                int result = (int) Math.pow(base, exponent);
                return new Problem(
                        "Calculate " + base + "^" + exponent,
                        result,
                        "Multiply " + base + " by itself " + exponent + " times",
                        2,
                        "Powers"
                );

            case 1: // Power with negative exponent
                base = random.nextInt(4) + 2;
                exponent = -(random.nextInt(2) + 1);
                double decimalResult = Math.pow(base, exponent);
                return new Problem(
                        "Express " + base + "^(" + exponent + ") as a decimal",
                        decimalResult,
                        "1 divided by " + base + " raised to " + Math.abs(exponent),
                        2,
                        "Powers"
                );

            default: // Square of binomial
                int a = random.nextInt(5) + 1;
                int b = random.nextInt(5) + 1;
                return new Problem(
                        "Expand (" + a + "x + " + b + ")²",
                        a * a,  // Only return first coefficient
                        a + "²x² + " + (2 * a * b) + "x + " + b + "²",
                        2,
                        "Powers"
                );
        }
    }

    private Problem generateRootsProblem() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: // Perfect square roots
                int[] perfectSquares = {16, 25, 36, 49, 64, 81, 100};
                int number = perfectSquares[random.nextInt(perfectSquares.length)];
                return new Problem(
                        "Calculate √" + number,
                        Math.sqrt(number),
                        "Think of what number times itself equals " + number,
                        1,
                        "Roots"
                );

            case 1: // Cube roots
                int[] perfectCubes = {8, 27, 64, 125};
                number = perfectCubes[random.nextInt(perfectCubes.length)];
                return new Problem(
                        "Calculate ∛" + number,
                        Math.cbrt(number),
                        "Think of what number cubed equals " + number,
                        2,
                        "Roots"
                );

            default: // Simplified radical
                int[] radicals = {12, 18, 32, 50, 72, 98};
                number = radicals[random.nextInt(radicals.length)];
                int outside = (int) Math.sqrt(getLargestPerfectSquareFactor(number));
                int inside = number / (outside * outside);
                return new Problem(
                        "Simplify √" + number,
                        outside,  // Return only the outside number
                        outside + "√" + inside,
                        2,
                        "Roots"
                );
        }
    }

    private Problem generateSetsProblem() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: // Set cardinality
                String[] elements = {"a", "b", "c", "d", "e"};
                int size = random.nextInt(3) + 2;
                StringBuilder set = new StringBuilder("{");
                for (int i = 0; i < size; i++) {
                    set.append(elements[i]);
                    if (i < size - 1) set.append(",");
                }
                set.append("}");
                int subsetSize = random.nextInt(size) + 1;
                return new Problem(
                        "How many subsets of size " + subsetSize + " does " + set.toString() + " have?",
                        calculateCombination(size, subsetSize),
                        "Use combination formula: C(" + size + "," + subsetSize + ")",
                        2,
                        "Sets"
                );

            case 1: // Set operations
                int[] setA = {1, 3, 5, 7};
                int[] setB = {2, 3, 5, 8};
                return new Problem(
                        "How many elements are in the intersection of A={1,3,5,7} and B={2,3,5,8}?",
                        2,
                        "Count elements that appear in both sets: {3,5}",
                        1,
                        "Sets"
                );

            default: // Power set
                size = random.nextInt(2) + 3;
                return new Problem(
                        "How many elements are in the power set of a set with " + size + " elements?",
                        Math.pow(2, size),
                        "Power set size = 2^n where n is number of elements",
                        2,
                        "Sets"
                );
        }
    }

    private Problem generateBaseConversion() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: // Binary to decimal
                int binaryLength = random.nextInt(4) + 3;
                StringBuilder binary = new StringBuilder();
                for (int i = 0; i < binaryLength; i++) {
                    binary.append(random.nextInt(2));
                }
                return new Problem(
                        "Convert " + binary + " (base 2) to decimal",
                        Integer.parseInt(binary.toString(), 2),
                        "Multiply each digit by its place value (powers of 2)",
                        2,
                        "Base Conversion"
                );

            case 1: // Decimal to hex
                int decimal = random.nextInt(200) + 50;
                return new Problem(
                        "Convert " + decimal + " to hexadecimal",
                        0.0 + Double.valueOf(Integer.toHexString(decimal)),
                        "Divide by 16 repeatedly and convert remainders",
                        2,
                        "Base Conversion"
                );

            default: // Octal to decimal
                int octal = random.nextInt(200) + 100;
                return new Problem(
                        "Convert " + Integer.toOctalString(octal) + " (base 8) to decimal",
                        octal,
                        "Multiply each digit by powers of 8",
                        2,
                        "Base Conversion"
                );
        }
    }

    private Problem generateSimpleEquation() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: // Linear equation
                int coefficient = random.nextInt(5) + 2;
                int constant = random.nextInt(20) + 1;
                int solution = random.nextInt(10) + 1;
                int rightSide = coefficient * solution + constant;
                return new Problem(
                        String.format("Solve for x: %dx + %d = %d", coefficient, constant, rightSide),
                        solution,
                        "Subtract " + constant + " from both sides, then divide by " + coefficient,
                        2,
                        "Simple Equations"
                );

            case 1: // Absolute value
                int value = random.nextInt(20) - 10;
                int answer = Math.abs(value);
                return new Problem(
                        "Solve |x| = " + answer,
                        value,  // Return the positive solution
                        "x can be " + answer + " or -" + answer,
                        2,
                        "Simple Equations"
                );

            default: // Simple quadratic
                int root = random.nextInt(5) + 1;
                return new Problem(
                        String.format("Solve x² - %dx + %d = 0", 2 * root, root * root),
                        root,
                        "Factor (x - " + root + ")(x - " + root + ")",
                        2,
                        "Simple Equations"
                );
        }
    }

    private Problem generateSystemEquations() {
        int x = random.nextInt(5) + 1;
        int y = random.nextInt(5) + 1;
        int a1 = random.nextInt(3) + 1;
        int b1 = random.nextInt(3) + 1;
        int c1 = a1 * x + b1 * y;
        int a2 = random.nextInt(3) + 1;
        int b2 = random.nextInt(3) + 1;
        int c2 = a2 * x + b2 * y;

        return new Problem(
                String.format("Solve the system:\n%dx + %dy = %d\n%dx + %dy = %d\nFind x.",
                        a1, b1, c1, a2, b2, c2),
                x,
                "Use elimination or substitution method",
                3,
                "System of Equations"
        );
    }

    private Problem generateRepeatingDecimal() {
        int[] numerators = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] denominators = {3, 6, 7, 9, 11, 13};
        int numerator = numerators[random.nextInt(numerators.length)];
        int denominator = denominators[random.nextInt(denominators.length)];

        return new Problem(
                "Convert " + numerator + "/" + denominator + " to a decimal",
                (double) numerator / denominator,
                "Divide " + numerator + " by " + denominator + " using long division",
                2,
                "Repeating Decimals"
        );
    }

    private Problem generateBasicGeometry() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: // Rectangle area/perimeter
                int length = random.nextInt(10) + 5;
                int width = random.nextInt(5) + 3;
                boolean isArea = random.nextBoolean();
                return new Problem(
                        "Find the " + (isArea ? "area" : "perimeter") +
                                " of a rectangle with length " + length + " and width " + width,
                        isArea ? length * width : 2 * (length + width),
                        isArea ? "Area = length × width" : "Perimeter = 2(length + width)",
                        1,
                        "Basic Geometry"
                );

            case 1: // Circle circumference
                int radius = random.nextInt(10) + 1;
                return new Problem(
                        "Find the circumference of a circle with radius " + radius + " (use π = 3.14)",
                        2 * 3.14 * radius,
                        "Circumference = 2πr = 2 × 3.14 × " + radius,
                        2,
                        "Basic Geometry"
                );

            default: // Triangle area
                int base = random.nextInt(10) + 5;
                int height = random.nextInt(10) + 5;
                return new Problem(
                        "Find the area of a triangle with base " + base + " and height " + height,
                        0.5 * base * height,
                        "Area = ½ × base × height",
                        2,
                        "Basic Geometry"
                );
        }
    }

    private Problem generateBasicSequence() {
        int type = random.nextInt(3);
        switch (type) {
            case 0: // Arithmetic sequence
                int start = random.nextInt(10) + 1;
                int difference = random.nextInt(5) + 2;
                int terms = random.nextInt(3) + 4;
                int[] sequence = new int[terms];
                for (int i = 0; i < terms; i++) {
                    sequence[i] = start + i * difference;
                }
                return new Problem(
                        "What comes next: " + formatSequence(sequence) + "?",
                        sequence[terms - 1] + difference,
                        "Add " + difference + " to each term",
                        1,
                        "Sequences"
                );

            case 1: // Geometric sequence
                start = random.nextInt(3) + 1;
                int ratio = random.nextInt(2) + 2;
                terms = random.nextInt(3) + 4;
                sequence = new int[terms];
                int value = start;
                for (int i = 0; i < terms; i++) {
                    sequence[i] = value;
                    value *= ratio;
                }
                return new Problem(
                        "What comes next: " + formatSequence(sequence) + "?",
                        sequence[terms - 1] * ratio,
                        "Multiply each term by " + ratio,
                        2,
                        "Sequences"
                );

            default: // Fibonacci-like
                int f1 = random.nextInt(5) + 1;
                int f2 = random.nextInt(5) + f1;
                terms = random.nextInt(3) + 4;
                sequence = new int[terms];
                sequence[0] = f1;
                sequence[1] = f2;
                for (int i = 2; i < terms; i++) {
                    sequence[i] = sequence[i-1] + sequence[i-2];
                }
                return new Problem(
                        "What comes next: " + formatSequence(sequence) + "?",
                        sequence[terms - 1] + sequence[terms - 2],
                        "Add previous two terms",
                        2,
                        "Sequences"
                );
        }
    }

    // Helper methods
    private int getLargestPerfectSquareFactor(int n) {
        int result = 1;
        for (int i = 1; i * i <= n; i++) {
            if (n % (i * i) == 0) {
                result = i * i;
            }
        }
        return result;
    }

    private int calculateCombination(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        return calculateCombination(n - 1, r - 1) + calculateCombination(n - 1, r);
    }

    private String formatSequence(int[] sequence) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            sb.append(sequence[i]);
            if (i < sequence.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private List<Integer> getPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        int number = n;
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }
        return factors;
    }

    private String formatPrimeFactorization(List<Integer> factors) {
        if (factors.isEmpty()) return "1";

        StringBuilder result = new StringBuilder();
        int current = factors.get(0);
        int count = 1;

        for (int i = 1; i < factors.size(); i++) {
            if (factors.get(i) == current) {
                count++;
            } else {
                result.append(current);
                if (count > 1) result.append("^").append(count);
                result.append(" × ");
                current = factors.get(i);
                count = 1;
            }
        }

        result.append(current);
        if (count > 1) result.append("^").append(count);
        return result.toString();
    }

    private List<Integer> getFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private int generatePrime() {
        int[] smallPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        return smallPrimes[random.nextInt(smallPrimes.length)];
    }
}