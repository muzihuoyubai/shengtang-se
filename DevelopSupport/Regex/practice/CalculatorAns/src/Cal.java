import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cal {

  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("(\\d+(\\.\\d+)?)\\s*[+\\-*/%]\\s*(\\d+(\\.\\d+)?)");
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String input = scanner.nextLine();
      Matcher matcher = pattern.matcher(input);
      if (matcher.find()) {
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(3));
      }else{
        System.out.println("输入不合法，请重新输入");
      }

    }
  }
}
