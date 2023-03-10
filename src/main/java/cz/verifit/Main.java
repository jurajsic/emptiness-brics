package cz.verifit;

public class Main {

    public static void main(String[] args) {
        String input;
        boolean alwaysMinimize = false;
        if (args.length == 1) {
            input = args[0];
        } else if (args.length == 2) {
            if (args[1].equals("--minimize")) {
                input = args[0];
            } else if (args[0].equals("--minimize")) {
                input = args[1];
            } else {
                System.err.println("error: Weird arguments");
                return;
            }
        } else {
            System.err.println("error: Program expects at least one argument (path to .emp file) and possibly option --minimize");
            return;
        }

        try {
            if ((new EmpParser()).parseAndCheckEmptiness(input, true)) {
                System.out.println("result: EMPTY");
            } else {
                System.out.println("result: NOT EMPTY");
            }
        } catch (Exception ex) {
            System.err.println("error: " + ex.getMessage());
        }
    }
}