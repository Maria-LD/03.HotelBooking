import java.util.Scanner;

public class HotelBooking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter month (words): ");
            String month = scanner.nextLine().toLowerCase();
            while (!("may".equals(month)) && !("june".equals(month)) && !("july".equals(month)) &&
                    !("august".equals(month)) && !("september".equals(month)) && !("october".equals(month)) &&
                    !("december".equals(month))) {
                System.out.print("Invalid month or bad spelling! Try again! " +
                        "Keep in mind that we offer rooms only for " +
                        "May, June, July, August, September, October and December" +
                        "(the first letter could be both capital or low): ");
                month = scanner.nextLine().toLowerCase();
            }

            System.out.print("Enter number of nights (1-200): ");
            int nightsCount = Integer.parseInt(scanner.nextLine());
            while (nightsCount < 1 || nightsCount > 200) {
                System.out.print("Invalid number of nights! It must be between 1 and 200. Try Again: ");
                nightsCount = Integer.parseInt(scanner.nextLine());
            }

            double studioPrice = 0;
            double doublePrice = 0;
            double suitePrice = 0;

            //price per a room in the different months
            if ("may".equals(month) || "october".equals(month)) {
                studioPrice = 50;
                doublePrice = 65;
                suitePrice = 75;

            } else if ("june".equals(month) || "september".equals(month)) {
                studioPrice = 60;
                doublePrice = 72;
                suitePrice = 82;

            } else if ("july".equals(month) || "august".equals(month) || "december".equals(month)) {
                studioPrice = 68;
                doublePrice = 77;
                suitePrice = 89;
            }

            //discount per a room according to a month
            if (nightsCount > 7 && ("may".equals(month) || "october".equals(month))) {
                studioPrice -= 0.05 * studioPrice;
            }

            if (nightsCount > 14 && ("june".equals(month) || "september".equals(month))) {
                doublePrice -= 0.10 * doublePrice;
            }

            if (nightsCount > 14 && ("july".equals(month) || "august".equals(month) || "december".equals(month))) {
                suitePrice -= 0.15 * suitePrice;
            }

            //total prices with the discounts
            double priceStudioWithDiscount = studioPrice * nightsCount;
            double priceDoubleWithDiscount = doublePrice * nightsCount;
            double priceSuiteWithDiscount = suitePrice * nightsCount;

            //free night discount
            if (nightsCount > 7 && ("September".equals(month) || "October".equals(month))) {
                priceStudioWithDiscount = studioPrice * (nightsCount - 1);
            }

            System.out.printf("Studio: %.2f lv.\n", priceStudioWithDiscount);
            System.out.printf("Double: %.2f lv.\n", priceDoubleWithDiscount);
            System.out.printf("Suite: %.2f lv.\n", priceSuiteWithDiscount);

        } catch (
                Exception ex)

        {
            System.out.println("Sorry, invalid input!!! Start from the beginning, please! " +
                    "Read the instructions carefully!");
        }
    }
}
