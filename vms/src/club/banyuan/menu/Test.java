package club.banyuan.menu;

import club.banyuan.machine.FlowStatus;
import java.util.Arrays;
import java.util.List;

public class Test {

  public static void main(String[] args) {

    List<MenuNode> list = Arrays.asList(
        new MenuNode(null, null, "What would you like to do?", FlowStatus.ROOT, null,
            MenuType.ROOT),
        new MenuNode(" 1. Read product information", "1", "(1) The displayed products are:",
            FlowStatus.READ_PRODUCT_INFO, FlowStatus.ROOT, MenuType.SINGLE),
        new MenuNode(" 2. Insert coin", "2", "(2) Which coin would you like to insert?",
            FlowStatus.INSERT_COIN, FlowStatus.ROOT, MenuType.PARENT),

        new MenuNode(" 1. $1", "1", null,
            null, FlowStatus.INSERT_COIN, MenuType.SINGLE),
        new MenuNode(" 2. $2", "2", null,
            null, FlowStatus.INSERT_COIN, MenuType.SINGLE),
        new MenuNode(" 3. $5", "3", null,
            null, FlowStatus.INSERT_COIN, MenuType.SINGLE),
        new MenuNode(" 4. $10", "4", null,
            null, FlowStatus.INSERT_COIN, MenuType.SINGLE),
        new MenuNode(" 0. Go back", "0", null,
            null, FlowStatus.INSERT_COIN, MenuType.GO_BACK),

        new MenuNode(" 3. Press product button", "3",
            "(3) Which product button would you like to press?",
            FlowStatus.PRESS_PRODUCT_BTN, FlowStatus.ROOT, MenuType.SINGLE),
        new MenuNode(" 4. Press return button", "4", "(4) Return button is pressed.",
            FlowStatus.PRESS_RETURN_BTN, FlowStatus.ROOT, MenuType.SINGLE),

        new MenuNode(" 9. Open service menu (code required)", "9", "(9) What would you like to do?",
            FlowStatus.OPEN_SERVICE_MENU, FlowStatus.ROOT, MenuType.PARENT),
        new MenuNode(" 1. Inspect machine status", "1", "(9-1) Machine status",
            FlowStatus.ADMIN_INSPECT_STATUS, FlowStatus.OPEN_SERVICE_MENU, MenuType.SINGLE),
        new MenuNode(" 2. Withdraw all money", "2", "(9-2) All money is being withdrawn.",
            FlowStatus.ADMIN_WITHDRAW_MONEY, FlowStatus.OPEN_SERVICE_MENU, MenuType.SINGLE),
        new MenuNode(" 3. Refill product", "3", "(9-3) Which product would you like to refill?",
            FlowStatus.ADMIN_REFILL_PRODUCT, FlowStatus.OPEN_SERVICE_MENU, MenuType.SINGLE),
        new MenuNode(" 4. Change product", "4", "(9-4) Which product would you like to change?",
            FlowStatus.ADMIN_CHANGE_PRODUCT, FlowStatus.OPEN_SERVICE_MENU, MenuType.SINGLE),
        new MenuNode(" 0. Go back", "0", null,
            null, FlowStatus.OPEN_SERVICE_MENU, MenuType.GO_BACK),

        new MenuNode(" 0. Quit", "0", null,
            null, FlowStatus.ROOT, MenuType.SINGLE));
    Menu menu = new Menu(list);

    menu.display();

    MenuNode menuNode = menu.scanUserInput();

    menu.toNextMenu(menuNode);

    menu.display();

  }
}
