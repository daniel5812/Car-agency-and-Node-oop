package node;

import java.util.Scanner;
//Assignment:5
//Author:Daniel Dahan , ID:318840196

public class NodeMain {
    enum Menu {
        ADD_FIRST(1), ADD_LAST(2), CLEAR(3), CONTAINS(4), IS_EMPTY(5),
        PRINT_BACKWARD(6), PRINT_FORWARD(7), REMOVE(8),EXIT(9);
        private final int option;

        Menu(int option) {
            this.option = option;
        }

        public int getOption() {
            return option;
        }

/**
 * Retrieves the Menu option associated with the given integer value.
 * @param option the integer value representing the menu option
 * @return the corresponding Menu option, or null if no matching option is found
 * */

        public static Menu fromOption(int option) {
            for (NodeMain.Menu menu : NodeMain.Menu.values()) {
                if (menu.getOption() == option) {
                    return menu;
                }
            }
            return null;
        }

    }

    public static void main(String[] args) {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
            Scanner scanner = new Scanner(System.in);
            boolean exitProgram = false;
        while (!exitProgram) {
            displayMenu();
            int option = scanner.nextInt();
            NodeMain.Menu selectedOption = Menu.fromOption(option);
            if (selectedOption == null) {
                System.out.println("Invalid option. Please try again.");
                continue;
            }

            switch (selectedOption) {
                case ADD_FIRST:
                    System.out.println("Enter a number: ");
                    int addNumFirst = scanner.nextInt();
                    list.addFirst(addNumFirst);
                    break;
                case ADD_LAST:
                    System.out.println("Enter a number: ");
                    int addNumLast = scanner.nextInt();
                    list.addLast(addNumLast);
                    break;
                case CLEAR:
                    list.clear();
                    break;
                case CONTAINS:
                    System.out.println("Enter a number: ");
                    int num = scanner.nextInt();
                    boolean isContains =list.contains(num);
                    if (isContains)
                        System.out.println(num+" "+"is present int the list");
                    else System.out.println(num+" "+"was not found");
                    break;
                case IS_EMPTY:
                    boolean listEmpty=list.isEmpty();
                    if (listEmpty)
                        System.out.println("the list is Empty");
                    else System.out.println("the list is not empty");
                    break;
                case PRINT_BACKWARD:
                    list.printBackward();
                    break;
                case  PRINT_FORWARD:
                    list.printForward();
                    break;
                case REMOVE:
                    System.out.println("Enter a number: ");
                    int removedNum = scanner.nextInt();
                    list.remove(removedNum);
                    if (list.contains(removedNum))
                    System.out.println(removedNum+" "+"was removed successfully");
                    else System.out.println("number was not found");
                    break;
                case EXIT:
                    exitProgram = true;
                    break;

            }
        }





       }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. add first");
        System.out.println("2. add last");
        System.out.println("3. clear");
        System.out.println("4. contains");
        System.out.println("5. isEmpty");
        System.out.println("6. print backward ");
        System.out.println("7. print forward");
        System.out.println("8. remove");
        System.out.println("9. Exit");
        System.out.print("Choose an option: ");

    }
}

