import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PackageMeasurementConverter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the measurement string:");
        String userInput=scanner.nextLine();
        scanner.close();
        List<Integer> convertedValues =  measurmentConverter(userInput);

        System.out.println("Result :"+convertedValues);


    }
    public static List<Integer> measurmentConverter(String convertString) {
        List<Integer> convertedValues = new ArrayList<>();
        int currentIndex = 0;

        while (currentIndex < convertString.length()) {
            int count = convertString.charAt(currentIndex) - 'a' + 1;
            currentIndex++;

            int currentValueNum = 0;

            for (int i = 0; i < count && currentIndex < convertString.length(); i++) {
                char character = convertString.charAt(currentIndex);
                if (Character.isLowerCase(character)) {
                    if (character == 'z') {
                        currentValueNum += 26;
                    } else {
                        currentValueNum += character - 'a' + 1;
                    }
                }
                currentIndex++;
            }
            convertedValues.add(currentValueNum);
        }
        return convertedValues;
    }
}
