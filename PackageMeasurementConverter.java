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
    public static List<Integer>measurmentConverter(String converString){
        List<Integer> convertedValues = new ArrayList<>();
        int currentIndex = 0;
      /*  for (char character : converString.toCharArray()) {
            if (character == 'z') {
                currentIndex += 26;
            } else {
                int value =  + character -currentIndex- 'a' + 1;
                convertedValues.add(value);
                currentIndex=0;

            }

       }
        return convertedValues;*/
        while (currentIndex < converString.length()) {
            int count = converString.charAt(currentIndex) - 'a' + 1;
            currentIndex++;

            int currentValueNum = 0;

            for (int i = 0; i < count; i++) {
                char character = converString.charAt(currentIndex);
                if (character == 'z') {
                    currentValueNum += 26;
                } else {
                    currentValueNum += character - 'a' + 1;
                }
                currentIndex++;
            }

            convertedValues.add(currentValueNum);
        }
        return convertedValues;
    }

}
