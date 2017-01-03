import java.util.Scanner;
public class MyUrlDemo
{
    /**
     * main
     */
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Loop, asking for a new URL to be entered.
        do {
            System.out.println();
            System.out.println("Enter URL site (or 'exit')...");
            String baseUrl = sc.nextLine();
            if (baseUrl.equalsIgnoreCase("exit"))
                break;

            // Create a new MyUrl object and call its constructor
            MyUrl u = new MyUrl(baseUrl);
            System.out.println("Url value read was: " + baseUrl);

            // Loop, asking for argument/value input
            do {
                System.out.println("Enter URL argument name (or 'done')...");
                String argName = sc.nextLine();
                if (argName.equalsIgnoreCase("done"))
                    break;
                System.out.println("Enter type of argument value (string, integer, double)...");
                String argType = sc.nextLine();

                if (argType.startsWith("s")) {
                    System.out.println("Enter a string value");
                    String s = sc.nextLine();
                    u.addArgument(argName, s);
                } else if (argType.startsWith("i")) {
                    System.out.println("Enter an integer value");
                    int i = sc.nextInt();
                    sc.nextLine();
                    u.addArgument(argName, i);
                } else if (argType.startsWith("d")) {
                    System.out.println("Enter a double value");
                    double d = sc.nextDouble();
                    sc.nextLine();
                    u.addArgument(argName, d);
                } else {
                    System.out.println("Unrecognized value type - must be (s)tring, (i)nteger, or (d)ouble");
                    continue;
                }
            }while (true);

            // Display the final url
            System.out.println("URL with appended arguments is:");
            System.out.println("  " + u.toString());

        } while (true);

        // Keep console window alive until 'enter' pressed (if needed).
        System.out.println();
        System.out.println("Done - press enter key to end program");
        String junk = sc.nextLine();
    }
}