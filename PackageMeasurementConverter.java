import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PackageMeasurementConverter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the measurement string:");
        String userInput=scanner.nextLine();
        scanner.close();
        // Call the measurementConverter method to convert the input string
        List<Integer> convertedValues =  measurementConverter(userInput.toLowerCase());
        // Print the input string  with the converted values
        System.out.println("Input: " +userInput + " =>  Measurement : " + convertedValues);

    }
    // Method to convert the measurement string into numerical values
    public static List<Integer> measurementConverter(String convertString) {
        List<Integer> convertedValues = new ArrayList<>();
        int currentIndex = 0;
        while (currentIndex< convertString.length()) {
            char ch = convertString.charAt(currentIndex);
            Integer currentValueNum = 0;
            if (ch >= 'a' && ch<= 'z') {
                int count = ch - 'a' + 1;//dealing with Ascii
                currentIndex++;
                StringBuilder sequence = new StringBuilder();
                boolean zEncountered = false; // Flag to track if 'z' is encountered within the sequence

                int i = 0;
                while (i < count && currentIndex < convertString.length()) {
                    char nextChar = convertString.charAt(currentIndex++);
                    if (nextChar == 'z') {
                        sequence.append(nextChar);
                        // Count consecutive 'z' characters and the next character
                        while (currentIndex < convertString.length() && convertString.charAt(currentIndex) == 'z') {
                            sequence.append(convertString.charAt(currentIndex++));
                        }
                        if (currentIndex < convertString.length()) {
                            sequence.append(convertString.charAt(currentIndex++));
                        }
                    } else if ((nextChar >= 'a' && nextChar <= 'z') || isNonAlphabetical(nextChar)) {
                        sequence.append(nextChar);
                        zEncountered = false;
                    } else {
                        currentIndex--; // Move back one step to process the non-alphabetical character again
                        break;
                    }
                    i++;
                }
                // Calculate value for the sequence if 'z' is not encountered or if it's the last character of the sequence
                if (!zEncountered || sequence.charAt(sequence.length() - 1) == 'z') {
                    currentValueNum = calculateValue(sequence.toString());
                    convertedValues.add(currentValueNum);
                }
            } else {
                currentIndex++;
            }
        }
        return convertedValues;
    }

    /** Method to check if the character is non-alphabetical */
    public static boolean isNonAlphabetical(char character) {
        return "@!#$%^&*()_<>{}[]".indexOf(character) != -1;
    }
    /** Calculates the value of the given input string. */
    public static int calculateValue(String input) {
        int value = 0;
        for (char letter : input.toCharArray()) {
            if (letter >= 'a' && letter <= 'z') {
                value += letter  - 'a' + 1;
            }
        }
        return value;
    }
}
