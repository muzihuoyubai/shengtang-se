package club.banyuan.machine;

import static club.banyuan.machine.FlowStatus.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class VendingMachine {

  public static final int SHELVES_NUM = 5;
  public static final String NO_PURCHASE = "=";
  public static final String PRODUCT_SELL_​​OUT = "X";
  public static final String PRODUCT_AVAILABLE = "O";
  public static final String PRODUCT_DEFAULT = " ";
  private int userAmount;
  private String purchasedProduct = NO_PURCHASE;
  private Shelf[] shelves = new Shelf[SHELVES_NUM];

  private FlowStatus flowStatus = ROOT;

  {
    /*
    初始化产品列表
    A. Juice ($10) (5 left)
    B. Cola($6)(1left)
    C. Tea ($5) (2 left)
    D. Water ($8) (1 left)
    E. Coffee ($7) (9 left)
     */
    shelves[0] = new Shelf("A", "Juice", 10, 5);
    shelves[1] = new Shelf("B", "Cola", 6, 1);
    shelves[2] = new Shelf("C", "Tea", 5, 2);
    shelves[3] = new Shelf("D", "Water", 8, 1);
    shelves[4] = new Shelf("E", "Coffee", 7, 9);
  }


  public String displayShevles() {
    StringBuilder stringBuilder = new StringBuilder();
    buildLogoDisplay(stringBuilder);
    buildShelvesDisplay(stringBuilder);
    buildBottomDisplay(stringBuilder);
    System.out.println(stringBuilder.toString());
    System.out.println();
    return stringBuilder.toString();
  }

  private void buildBottomDisplay(StringBuilder stringBuilder) {
    stringBuilder.append("*---------------------------*").append(System.lineSeparator());
    stringBuilder.append(String.format("|                    [$%2s]  |", userAmount))
        .append(System.lineSeparator());
    stringBuilder.append("|                           |").append(System.lineSeparator());
    stringBuilder.append(String.format("|           [=%s=]           |", purchasedProduct))
        .append(System.lineSeparator());
    stringBuilder.append("*---------------------------*");
  }

  private void buildLogoDisplay(StringBuilder stringBuilder) {
    stringBuilder
        .append("*---------------------------*").append(System.lineSeparator())
        .append("|     Vending   Machine     |").append(System.lineSeparator())
        .append("*---------------------------*").append(System.lineSeparator());
  }

  private void buildShelvesDisplay(StringBuilder stringBuilder) {

    String[] codeTemplate = new String[SHELVES_NUM];
    int[] priceTemplate = new int[SHELVES_NUM];
    String[] inventoryTemplate = new String[SHELVES_NUM];

    for (int i = 0; i < shelves.length; i++) {
      codeTemplate[i] = shelves[i].getCode();
      priceTemplate[i] = shelves[i].getPrice();
      // 如果用户投币的金额如果小于 产品的金额，不显示内容。
      // 如果用户投币的金额大于产品金额，显示O
      // 如果产品库存为0，显示X
      inventoryTemplate[i] = shelves[i].getInventory() == 0 ? PRODUCT_SELL_​​OUT
          : (shelves[i].getPrice() <= userAmount ? PRODUCT_AVAILABLE : PRODUCT_DEFAULT);
    }

    stringBuilder.append(String
        .format("|   %s    %s    %s    %s    %s   |", codeTemplate[0], codeTemplate[1],
            codeTemplate[2], codeTemplate[3], codeTemplate[4])).append(System.lineSeparator());

    stringBuilder.append(String
        .format("|  $%2s  $%2s  $%2s  $%2s  $%2s  |", priceTemplate[0], priceTemplate[1],
            priceTemplate[2], priceTemplate[3], priceTemplate[4])).append(System.lineSeparator());
    stringBuilder.append(String
        .format("|  [%s]  [%s]  [%s]  [%s]  [%s]  |", inventoryTemplate[0], inventoryTemplate[1],
            inventoryTemplate[2], inventoryTemplate[3], inventoryTemplate[4]))
        .append(System.lineSeparator());
  }

  public void start() {
    displayShevles();
    while (true) {
      switch (flowStatus) {
        case ROOT:
          displayRootMenu();
          String userInput = scanUserInput(
              t -> Arrays.asList("1", "2", "3", "4", "0", "9").contains(t), t -> displayRootMenu()
          );
          flowStatus = changeMenuFromRoot(userInput);
          break;

        case READ_PRODUCT_INFO:
          displayProductInfo();
          flowStatus = ROOT;
          break;
        case INSERT_COIN:
          break;
        case PRESS_PRODUCT_BTN:
          break;
        case PRESS_RETURN_BTN:
          break;
        case OPEN_SERVICE_MENU:
          break;

        case QUIT:
          System.exit(0);
      }
    }


  }

  /**
   * (1) The displayed products are:
   * A. Juice ($10)
   * B. Cola ($6)
   * C. Tea ($5)
   * D. Water ($8)
   * E. Coffee ($7)
   */
  private void displayProductInfo() {
    System.out.println();
    System.out.println("(1) The displayed products are:");
    for (Shelf shelf : shelves) {
      System.out.printf("%s. %s ($%s)\n", shelf.getCode(), shelf.getName(), shelf.getPrice());
    }
    System.out.println();
  }

  private FlowStatus changeMenuFromRoot(String userInput) {
    switch (userInput) {
      case "1":
        return FlowStatus.READ_PRODUCT_INFO;
      case "2":
        return FlowStatus.INSERT_COIN;
      case "3":
        return FlowStatus.PRESS_PRODUCT_BTN;
      case "4":
        return FlowStatus.PRESS_RETURN_BTN;
      case "9":
        return FlowStatus.OPEN_SERVICE_MENU;
      case "0":
        return FlowStatus.QUIT;
      default:
        throw new VendingMachineException("user input invalid:" + userInput);
    }
  }

  private void displayRootMenu() {
    System.out.println("What would you like to do?\n"
        + " 1. Read product information\n"
        + " 2. Insert coin\n"
        + " 3. Press product button\n"
        + " 4. Press return button\n"
        + " 9. Open service menu (code required)\n"
        + " 0. Quit\n");
  }

  private String scanUserInput(Predicate<String> inputValidate,
      Consumer<String> displayDuringInputWrong) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Your choice:");
    String userInput = scanner.next();
    boolean testResult = inputValidate.test(userInput);
    if (!testResult) {
      System.out.println("Invalid choice!");
      System.out.println();
      displayDuringInputWrong.accept(userInput);
      userInput = scanUserInput(inputValidate, displayDuringInputWrong);
    }
    return userInput;
    // int rlt;
    // try {
    //   rlt = Integer.parseInt(scanner.next());
    // } catch (NumberFormatException e) {
    //   System.out.println("invalid choice");
    //   // 用户定制的方法
    //   doSomething();
    //   rlt = scanUserInput();
    // }
    // return rlt;
  }

}
