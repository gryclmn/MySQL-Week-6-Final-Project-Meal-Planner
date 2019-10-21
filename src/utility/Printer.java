package utility;

public class Printer {

    private static Integer horizontalDividerLength = 30;

    private Printer() { }

    public static void printTitle(String title) {
        int marginLength = (horizontalDividerLength - title.length()) / 2;
        String margin = buildHorizontalDivider(" ", marginLength);
        String horizontalDivide = buildHorizontalDivider("*", horizontalDividerLength);

        System.out.println(horizontalDivide);
        System.out.println(margin + " " + title.toUpperCase() + " " + margin);
        System.out.println(horizontalDivide);
    }
    
    public static void printSubTitle(String subTitle) {
    	int marginLength = (horizontalDividerLength - subTitle.length()) / 2;
    	String margin = buildHorizontalDivider(" ", marginLength);
    	String horizontalDivide = buildHorizontalDivider("-", horizontalDividerLength);
    	
    	System.out.println(horizontalDivide);
    	System.out.println(margin + " " + subTitle.toUpperCase() + " " + margin);
    	System.out.println(horizontalDivide);
    }

    public static void printInstructions(String instructions) {
        System.out.print("--> " + instructions + " <--\n");
    }

    public static void printOption(String option, int optionNumber) {
        System.out.println("\t" + optionNumber + ") " + option);
    }

    public static void printResponse(String response) {
        System.out.println(response);
    }

    public static void printAlert(String alert) {
        System.out.println("!!! " + alert + " !!!");
    }

    public static void printSectionEnd() {
        System.out.println(buildHorizontalDivider("^", horizontalDividerLength));
    }

    private static String buildHorizontalDivider(String string, int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

}
