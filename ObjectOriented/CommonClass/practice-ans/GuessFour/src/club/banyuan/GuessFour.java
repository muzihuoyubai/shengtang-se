package club.banyuan;

import java.util.Arrays;

public class GuessFour {

    public static void main(String[] args) {
        System.out.println("猜一猜4个不重复的数字，请输入4个数字：");

        FourNumber answer = FourNumber.generateFourNumberRandom();
        System.out.println(Arrays.toString(answer.getValue()));

        while (true) {
            FourNumber userInput = FourNumber.generateFourNumberFromUserInput();

            NumberCompareResult result = answer.compare(userInput);
            if (result.isSuccess()) {
                System.out.println("回答正确");
                return;
            }

            result.printResult();

            System.out.println("请输入4个数字：");
        }
    }
}