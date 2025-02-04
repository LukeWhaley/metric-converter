import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to metric converter!");
        System.out.println("Supported converions: km=m, g=oz, in=ft, sec=min");
        System.out.println("Please input your query. For example, 1 km=m");
        System.out.println("Type 'exit' to exit the program");
        
        while (true) {
            
            String userinput = scanner.nextLine();

            if (userinput.equals("exit")){
            System.out.println("Goodbye!");
            break;
            }

            String[] arr = userinput.split(" ", 2);

            if (arr.length < 2){
                System.err.println("Your input is not currently handled by this app, please input another query, for example, 1 km=m (with a space between the number and the metric conversion)");                //System.out.println(metric);
                continue;
            }

            String valString = arr[0];
            double val = Double.parseDouble(valString);            
            double originalVal = val;

            String metrics = arr[1];

            String[] arr2 = metrics.split("=", 2);

            if (arr2.length < 2){
                System.err.println("Your input is not currently handled by this app, please input another query, for example, 1 km=m (with a space between the number and the metric conversion)");                //System.out.println(metric);
                continue;
            }

            String metric1 = arr2[0];
            String metric2 = arr2[1];

            //kilometers and meters
            if (metrics.equals("km=m"))
                val = val*1000;
            else if (metrics.equals("m=km"))
                val = val/1000;
            //grams and ounces
            else if (metrics.equals("g=oz"))
                val = val/28.35;
            else if (metrics.equals("oz=g"))
                val = val*28.35;
            // inches and feet
            else if (metrics.equals("in=ft"))
                val = val/12;
            else if (metrics.equals("ft=in"))
                val = val*12;
            // seconds and minutes
            else if (metrics.equals("sec=min"))
                val = val/60;
            else if (metrics.equals("min=sec"))
                val = val*60;
            // not supported
            else{
                System.err.println("Your input is not currently handled by this app, please input another query, for example, 1 km=m");
                continue;
            }

            System.out.println(originalVal+metric1+" = "+val+metric2);

        }
        scanner.close();
    }
}
