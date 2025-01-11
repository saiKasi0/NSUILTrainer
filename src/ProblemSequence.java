import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ProblemSequence {
    private static Scanner scanner = new Scanner(System.in);
    private static ProblemGenerator generator = new ProblemGenerator();
    private static List<Problem> problems = new ArrayList<>();
    private static Map<Character, String> sequenceDescriptions = new HashMap<>();

    static {
        sequenceDescriptions.put('A', "Problems 1-20: Basic Arithmetic and Number Theory");
        sequenceDescriptions.put('B', "Problems 21-40: Powers, Roots, and Basic Algebra");
        sequenceDescriptions.put('C', "Problems 41-60: Advanced Algebra and Geometry");
        sequenceDescriptions.put('D', "Problems 61-70: Advanced Mathematics");
        sequenceDescriptions.put('E', "Problems 71-80: Calculus Concepts");
        sequenceDescriptions.put('F', "All Available Problems");
    }

    public static void run() {
        System.out.println("Practice Start");
        displayAvailableSequences();
        char sequence = getSequenceChoice();
        generateProblemsForSequence(sequence);
        runPractice();
    }

    private static void displayAvailableSequences() {
        System.out.println("\nAvailable Problem Sequences:");
        for (Map.Entry<Character, String> entry : sequenceDescriptions.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static char getSequenceChoice() {
        while (true) {
            System.out.print("\nEnter sequence (A-F): ");
            char choice = scanner.nextLine().toUpperCase().charAt(0);
            if (sequenceDescriptions.containsKey(choice)) {
                return choice;
            }
            System.out.println("Invalid choice. Please enter A through F.");
        }
    }

    private static void generateProblemsForSequence(char sequence) {
        problems.clear();
        ProblemType[] types = getProblemsForSequence(sequence);

        for (ProblemType type : types) {
            problems.add(generator.generateProblem(type));
            problems.add(generator.generateProblem(type));
        }
    }

    private static ProblemType[] getProblemsForSequence(char sequence) {
        switch (sequence) {
            case 'A':
                return new ProblemType[]{
                        ProblemType.ARITHMETIC_BASICS,
                        ProblemType.MULTIPLICATION_SHORTCUTS,
                        ProblemType.SQUARING_NUMBERS,
                        ProblemType.UNIT_CONVERSION,
                        ProblemType.GCD_LCM
                };
            case 'B':
                return new ProblemType[]{
                        ProblemType.POWERS,
                        ProblemType.ROOTS,
                        ProblemType.BASE_CONVERSION,
                        ProblemType.SIMPLE_EQUATIONS,
                        ProblemType.SEQUENCES_BASIC
                };
            // Add cases for C, D, E as needed
            case 'F':
                return new ProblemType[]{
                        ProblemType.ARITHMETIC_BASICS,
                        ProblemType.MULTIPLICATION_SHORTCUTS,
                        ProblemType.SQUARING_NUMBERS,
                        ProblemType.UNIT_CONVERSION,
                        ProblemType.GCD_LCM,
                        ProblemType.POWERS,
                        ProblemType.ROOTS,
                        ProblemType.BASE_CONVERSION,
                        ProblemType.SIMPLE_EQUATIONS,
                        ProblemType.SEQUENCES_BASIC
                };
            default:
                return new ProblemType[]{ProblemType.ARITHMETIC_BASICS};
        }
    }

    private static void runPractice() {
        int correct = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < problems.size(); i++) {
            Problem problem = problems.get(i);
            System.out.println("\nProblem " + (i + 1) + " (" + problem.getCategory() + "):");
            System.out.println(problem.getQuestion());

            System.out.print("Your answer: ");
            double userAnswer = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer

            if (Math.abs(userAnswer - problem.getAnswer()) < 0.01) {
                System.out.println("Correct!");
                correct++;
            } else {
                System.out.println("Incorrect. The answer is: " + problem.getAnswer());
                System.out.println("Explanation:\n" + problem.getExplanation());
            }
        }

        long endTime = System.currentTimeMillis();
        double timeInMinutes = (endTime - startTime) / 60000.0;

        System.out.println("\nPractice Complete!");
        System.out.println("Score: " + correct + "/" + problems.size());
        System.out.printf("Time taken: %.2f minutes\n", timeInMinutes);
    }
}