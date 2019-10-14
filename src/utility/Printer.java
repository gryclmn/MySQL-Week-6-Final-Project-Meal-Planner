package utility;

public class Printer {

    private static Integer horizontalDividerLength = 30;
    private static final String CONSOLE_RESET = "\u001B[0m";
    private static final String CONSOLE_RED = "\u001B[31m";
    private static final String CONSOLE_GREEN = "\u001B[32m";
    private static final String CONSOLE_YELLOW = "\u001B[33m";
    private static final String CONSOLE_BLUE = "\u001B[34m";
    private static final String CONSOLE_PURPLE = "\u001B[35m";
    private static final String CONSOLE_CYAN = "\u001B[36m";
    private static final String CONSOLE_WHITE = "\u001B[37m";

    private Printer() { }

    public static void printTitle(String title) {
        int marginLength = (horizontalDividerLength - title.length()) / 2;
        String margin = buildHorizontalDivider(" ", marginLength);
        String horizontalDivide = buildHorizontalDivider("*", horizontalDividerLength);

        System.out.print(CONSOLE_GREEN);
        System.out.println(horizontalDivide);
        System.out.println(margin + " " + title.toUpperCase() + " " + margin);
        System.out.println(horizontalDivide);
        System.out.print(CONSOLE_RESET);
    }

    public static void printInstructions(String instructions) {
        System.out.print(CONSOLE_BLUE);
        System.out.print("--> " + instructions + " <--\n");
        System.out.print(CONSOLE_RESET);
    }

    public static void printOption(String option, int optionNumber) {
        System.out.print(CONSOLE_BLUE);
        System.out.println("\t" + optionNumber + ") " + option);
        System.out.print(CONSOLE_RESET);
    }

    public static void printResponse(String response) {
        System.out.print(CONSOLE_PURPLE);
        System.out.println(response);
        System.out.print(CONSOLE_RESET);
    }

    public static void printAlert(String alert) {
        System.out.print(CONSOLE_RED);
        System.out.println("!!! " + alert + " !!!");
        System.out.print(CONSOLE_RESET);
    }

    public static void printSectionEnd() {
        System.out.print(CONSOLE_GREEN);
        System.out.println(buildHorizontalDivider("^", horizontalDividerLength));
        System.out.print(CONSOLE_RESET);
    }

    private static String buildHorizontalDivider(String string, int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

}
