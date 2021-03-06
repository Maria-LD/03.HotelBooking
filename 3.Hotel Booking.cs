using System;

namespace HotelBooking
{
    class HotelBooking
    {
        static void Main(string[] args)
        {
            try
            {
                Console.Write("Enter month (words): ");
                string month = Console.ReadLine().ToLower();
                while (!("may".Equals(month)) && !("june".Equals(month)) && !("july".Equals(month)) &&
                    !("august".Equals(month)) && !("september".Equals(month)) && !("october".Equals(month)) &&
                    !("december".Equals(month)))
                {
                    Console.Write("Invalid month or bad spelling! Try again! " +
                            "Keep in mind that we offer rooms only for " +
                            "May, June, July, August, September, October and December" +
                            "(the first letter could be both capital or low): ");
                    month = Console.ReadLine().ToLower();
                }

                Console.Write("Enter number of nights (1-200): ");
                int nights = int.Parse(Console.ReadLine());
                while (nights < 1 || nights > 200)
                {
                    Console.Write("Invalid number of nights! It must be between 1 and 200. Try Again: ");
                    nights = int.Parse(Console.ReadLine());
                }


                double priceStudio = 0;
                    double priceDouble = 0;
                    double priceSuite = 0;

                    //price per a room in different months
                    switch (month)
                    {
                        case "may":
                        case "october":
                            priceStudio = 50;
                            priceDouble = 65;
                            priceSuite = 75;
                            break;
                        case "june":
                        case "september":
                            priceStudio = 60;
                            priceDouble = 72;
                            priceSuite = 82;
                            break;
                        case "july":
                        case "august":
                        case "december":
                            priceStudio = 68;
                            priceDouble = 77;
                            priceSuite = 89;
                            break;
                    }

                    //discounts per a room according to months and number of nights
                    if ((month == "may" || month == "october") && nights > 7)
                    {
                        priceStudio -= 0.05 * priceStudio;
                    }

                    if ((month == "june" || month == "september") && nights > 14)
                    {
                        priceDouble -= 0.10 * priceDouble;
                    }

                    if ((month == "july" || month == "august" || month == "december") && nights > 14)
                    {
                        priceSuite -= 0.15 * priceSuite;
                    }

                    //total prices with the discounts
                    double totalPriceStudio = priceStudio * nights;
                    double totalPriceDouble = priceDouble * nights;
                    double totalPriceSuite = priceSuite * nights;

                    //free night discount
                    if ((month == "september" || month == "october") && nights > 7)
                    {
                        totalPriceStudio = priceStudio * (nights - 1);
                    }

                    Console.WriteLine($"Studio: {totalPriceStudio:F2} lv.");
                    Console.WriteLine($"Double: {totalPriceDouble:F2} lv.");
                    Console.WriteLine($"Suite: {totalPriceSuite:F2} lv.");

            }
            catch
            {
                Console.WriteLine("Sorry, invalid input!!!Start from the beginning, please!" +
                    "Read the instructions carefully!");
            }
        }
    }
}
