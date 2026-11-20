// LOOP SAMPLE (not stopping until user enters 5)
// Sample1 inputs: 
// 1 (selecting print choice menu)
// 2 (selecting print choice menu)
// 3 (selecting service)
// L (selecting paper size)
// 24 (inputing number of pages)
// 100 (inputing payment)

// Sample1 output:
// ==================================
//           ORDER RECEIPT
// ==================================
// Service: Black & White Photocopy
// Paper Name: Long Bond Paper
// Number Of Pages: 24
// Total Cost: P96.00
// Payment: P100.00
// Change: P4.00

// Sample2 inputs:
// 1 (selecting print choice menu)
// 2 (selecting print choice menu)
// 2 (selecting service)
// S (selecting paper size)
// 35 (inputing number of pages)
// 500 (inputing payment)

// Sample2 output: 
// ==================================
//           ORDER RECEIPT
// ==================================
// Service: Colored Print
// Paper Name: Short Bond Paper
// Number Of Pages: 35
// Total Cost: P350.00
// Payment: P500.00
// Change: P150.00

// Sample3 inputs:
// 6 (selecting print choice menu)
// 1 (selecting print choice menu)
// 2 (selecting print choice menu)
// 5 (selecting service)
// 4 (selecting service)
// a (selecting paper size)
// A (selecting paper size)
// -10 (inputing number of pages)
// 10 (inputing number of pages)
// 49 (inputing payment)
// 50 (inputing payment)
// 3 (selecting print choice menu)
// 4 (selecting print choice menu)
// 5 (selecting print choice menu)

// Sample3 output:
// =====================================================================
//      !!!!! INCORRECT CHOICE. Please input numbers 1 to 5. !!!!!
// =====================================================================
// =====================================================================
//      !!!!! INCORRECT SERVICE. Please input numbers 1 to 4. !!!!!
// =====================================================================
// Service: Colored Photocopy
// =====================================================================
//     !!!!! INCORRECT PAPERSIZE. Please select either A, S & L. !!!!!
// =====================================================================
// Paper Name: A4 Bond Paper
// =====================================================================
//              !!!!! Enter A Number Greater Than 0. !!!!!
// =====================================================================
// Number Of Pages: 10
// Total Cost: P50.00
// =====================================================================
//          !!!!! INSUFFICIENT MONEY. Please Try Again. !!!!!
// ===================================================================== 
// Payment: P50.00
// Change: P0.00

// ==================================
//           ORDER SUMMARY
// ==================================

// Order: 1
// Service: Black & White Photocopy
// Paper Name: Long Bond Paper
// No. of Pages: 24
// Total Cost: P96.00
// Payment: P100.00
// Change: P4.00

// Order: 2
// Service: Colored Print
// Paper Name: Short Bond Paper
// No. of Pages: 35
// Total Cost: P350.00
// Payment: P500.00
// Change: P150.00

// Order: 3
// Service: Colored Photocopy
// Paper Name: A4 Bond Paper
// No. of Pages: 10
// Total Cost: P50.00
// Payment: P50.00
// Change: P0.00
// ==================================
// Total Orders: 3

// ==================================
//            DAILY SALES
// ==================================

// Total Pages: 69
// Total Orders: 3
// Total Earnings: P496.00
// Average Order: P165.33
// ==================================

// Printing Session Ended.


import java.util.Scanner;

public class printCenter{
    
        // BLACK AND WHITE PRICES
        static final double BW_A4 = 5.00;
        static final double BW_SHORT = 5.00;
        static final double BW_LONG = 8.00;
        // COLORED PRICES
        static final double COLORED_A4 = 10.00;
        static final double COLORED_SHORT = 10.00;
        static final double COLORED_LONG = 13.00;
        // PHOTOCOPY B&W PRICES
        static final double COPY_BW_A4 = 2.00;
        static final double COPY_BW_SHORT = 2.00;
        static final double COPY_BW_LONG = 4.00;
        // PHOTOCOPY COLORED PRICES
        static final double COPY_COLORED_A4 = 5.00;
        static final double COPY_COLORED_SHORT = 5.00;
        static final double COPY_COLORED_LONG = 7.00;

        // RUNNING TOTALS
        static double totalEarnings = 0.00;
        static int totalOrders = 0;
        static int totalPages = 0;

        static String records = "";
        
        public static void main (String [] args){
            Scanner input = new Scanner (System.in);
            
            int choice;

            do {
                menu();

                System.out.print("\nEnter Your Choice: ");
                choice = input.nextInt();

                // ERROR HANDLING FOR CHOICE
                while (choice < 1 || choice > 5){
                    System.out.println("\n==================================================================");
                    System.out.println("    !!!!! INCORRECT CHOICE. Please input numbers 1 to 5. !!!!!");
                    System.out.println("==================================================================");
                    System.out.print("\nEnter Your Choice: ");
                    choice = input.nextInt();
                }

                switch (choice) {
                    case 1: 
                        service();
                        break;
                    case 2: 
                        customerOrder(input);
                        break;
                    case 3: 
                        orderSummary();
                        break;
                    case 4: 
                        dailySales();
                        break;
                    case 5: 
                        System.out.println("Printing Session Ended.");
                        break;
                }
              
            } while (choice != 5);
   
        }

        // MENU OF OUR SYSTEM
        public static void menu(){
            
            System.out.println("\n==================================");
            System.out.println("         PRINTING SYSTEM");
            System.out.println("==================================");
            System.out.println("\n- Printing Services \t(1)");
            System.out.println("- Record Customer Order (2)");
            System.out.println("- Order Summary \t(3)");
            System.out.println("- Review Daily Sales \t(4)");
            System.out.println("- Exit          \t(5)");
            System.out.println("\n==================================");
            

        }

        // VIEWING OF PRINT SERVICES
        public static void service(){
            System.out.println("\n===================================");
            System.out.println("         AVAILABLE SERVICES");
            System.out.println("===================================");

            System.out.println("\nBlack & White Print Service:");
            System.out.printf("- A4 Paper:\tP%.2f%n", BW_A4);
            System.out.printf("- Short Paper:\tP%.2f%n", BW_SHORT);
            System.out.printf("- Long Paper:\tP%.2f%n", BW_LONG);

            System.out.println("\nColored Print Service:");
            System.out.printf("- A4 Paper:\tP%.2f%n", COLORED_A4);
            System.out.printf("- Short Paper:\tP%.2f%n", COLORED_SHORT);
            System.out.printf("- Long Paper:\tP%.2f%n", COLORED_LONG);

            System.out.println("\nBlack & White Photocopy Service:");
            System.out.printf("- A4 Paper:\tP%.2f%n", COPY_BW_A4);
            System.out.printf("- Short Paper:\tP%.2f%n", COPY_BW_SHORT);
            System.out.printf("- Long Paper:\tP%.2f%n", COPY_BW_LONG);

            System.out.println("\nColored Photocopy Service:");
            System.out.printf("- A4 Paper:\tP%.2f%n", COPY_COLORED_A4);
            System.out.printf("- Short Paper:\tP%.2f%n", COPY_COLORED_SHORT);
            System.out.printf("- Long Paper:\tP%.2f%n", COPY_COLORED_LONG);
            System.out.println("\n==================================");
        }

    // RECORDING OF CUSTOMER'S ORDER
    public static void customerOrder(Scanner input){

        int service;
        char paperSize;
        int quantity;

        double pricePerPage = 0.00;
        double totalCost = 0.00;
        double payment = 0.00;
        double change = 0.00;

        String serviceName = " ";
        String paperName = " ";

        // CHOOSING SERVICES
        System.out.println("\n==================================");
        System.out.println("         CHOOSE SERVICE");
        System.out.println("==================================");
        System.out.println("\n- Black & White Print     (1)");
        System.out.println("- Colored Print           (2)");
        System.out.println("- Black & White Photocopy (3)");
        System.out.println("- Colored Photocopy       (4)");
        System.out.println("\n==================================");

        System.out.print("\nSelect Service: ");
        service = input.nextInt();

        // ERROR HANDLING FOR SERVICES
        while (service < 1 || service > 4){
            System.out.println("\n===================================================================");
            System.out.println("    !!!!! INCORRECT SERVICE. Please input numbers 1 to 4. !!!!!");
            System.out.println("===================================================================");
            System.out.print("\nSelect Service: ");
            service = input.nextInt();
        }
        
        // CHOOSING PAPERSIZE
        System.out.println("\n==================================");
        System.out.println("         CHOOSE PAPER SIZE");
        System.out.println("==================================");
        System.out.println("\n- A4 Bond Paper \t(A)");
        System.out.println("- Short Bond Paper \t(S)");
        System.out.println("- Long Bond Paper \t(L)");
        System.out.println("\n==================================");

        System.out.print("\nSelect Paper Size: ");
        paperSize = input.next().charAt(0);

        // ERROR HANDLING FOR PAPER SIZE
        while (paperSize != 'A' && paperSize != 'S' && paperSize != 'L'){
            System.out.println("\n=====================================================================");
            System.out.println("    !!!!! INCORRECT PAPERSIZE. Please select either A, S & L. !!!!!");
            System.out.println("=====================================================================");
            System.out.print("\nSelect Paper Size: ");
            paperSize = input.next().charAt(0);
        }

        // PRICE PER PAGE & SERVICE NAMES
        switch (service){
            case 1: 
                serviceName = "Black & White Print";

                if (paperSize == 'A'){
                    pricePerPage = BW_A4;
                }else if (paperSize == 'S'){
                    pricePerPage = BW_SHORT;
                }else {
                    pricePerPage = BW_LONG;
                }
                break;
            case 2: 
                serviceName = "Colored Print";

                if (paperSize == 'A'){
                    pricePerPage = COLORED_A4;
                }else if (paperSize == 'S'){
                    pricePerPage = COLORED_SHORT;
                }else {
                    pricePerPage = COLORED_LONG;
                }
                break;
            case 3:
                serviceName = "Black & White Photocopy";

                if (paperSize == 'A'){
                    pricePerPage = COPY_BW_A4;
                }else if (paperSize == 'S'){
                    pricePerPage = COPY_BW_SHORT;
                }else {
                    pricePerPage = COPY_BW_LONG;
                }
                break;
            case 4: 
                serviceName = "Colored Photocopy";

                if (paperSize == 'A'){
                    pricePerPage = COPY_COLORED_A4;
                }else if (paperSize == 'S'){
                    pricePerPage = COPY_COLORED_SHORT;
                }else {
                    pricePerPage = COPY_COLORED_LONG;
                }
                break;
        }

        // PAPER NAMES
        if (paperSize == 'A'){
            paperName = "A4 Bond Paper";
        }else if (paperSize == 'S'){
            paperName = "Short Bond Paper";
        }else {
            paperName = "Long Bond Paper";
        }

        // HOW MANY PAGES THE CUSTOMER WANTS
        System.out.print("\nEnter The Number Of Pages: ");
        quantity = input.nextInt();

        // INPUT VALIDATION FOR QUANTITY
        while (quantity <= 0){
            System.out.println("\n==================================================");
            System.out.println("    !!!!! Enter A Number Greater Than 0. !!!!!");
            System.out.println("==================================================");
            System.out.print("\nEnter The Number Of Pages: ");
            quantity = input.nextInt();
        }
        // TOTAL COST
        totalCost = pricePerPage * quantity;
        
        System.out.println("\n==================================");
        System.out.printf("        Total Cost: P%.2f%n", totalCost);
        System.out.println("==================================");

        // PAYMENT
        System.out.print("\nEnter Your Payment: P");
        payment = input.nextDouble();
        System.out.printf("\nYour Payment: P%.2f%n", payment);

        // ERROR HANDLING OF PAYMENT
        while (payment < totalCost){
            System.out.println("\n=========================================================");
            System.out.println("    !!!!! INSUFFICIENT PAYMENT. Please Try Again. !!!!!");
            System.out.println("=========================================================");
            System.out.print("\nEnter Your Payment: P");
            payment = input.nextDouble();
        }

        // CHANGE
        change = payment - totalCost;
        System.out.printf("Change: P%.2f%n", change);

        // UPDATE DAILY TOTALS
        totalOrders++;
        totalPages += quantity;
        totalEarnings += totalCost;

        // SAVE ORDER INFORMATION
        records += String.format(
        "Order: %d%n" +
        "Service: %s%n" +
        "Paper Name: %s%n" +
        "No. of Pages: %d%n" +
        "Total Cost: P%.2f%n" +
        "Payment: P%.2f%n" +
        "Change: P%.2f%n%n",
        totalOrders, serviceName, paperName,
        quantity, totalCost, payment, change);

        // PRINT ORDER RECEIPT
        System.out.println("\n==================================");
        System.out.println("          ORDER RECEIPT");
        System.out.println("==================================");

        System.out.println("\nService: " + serviceName);
        System.out.println("Paper Name: " + paperName);
        System.out.println("Number Of Pages: " + quantity);
        System.out.printf("Total Cost: P%.2f%n", totalCost);
        System.out.printf("Payment: P%.2f%n", payment);
        System.out.printf("Change: P%.2f%n", change);

        System.out.println("\n==================================");
        System.out.println("\nOrder Has Been Recorded!");

    }

    public static void orderSummary(){
    
    System.out.println("\n==================================");
    System.out.println("          ORDER SUMMARY");
    System.out.println("==================================");

    if (totalOrders == 0){
        System.out.println("\nNo orders have been recorded yet.");
    }else{
        System.out.println("\n" + records);
        System.out.println("\n==================================");
        System.out.println("Total Orders: " + totalOrders);
    }

    System.out.println("\n==================================");

    }

    // DAILY SALES
    public static void dailySales(){

    double averageOrder = 0.00;

    if (totalOrders > 0){
        averageOrder = totalEarnings / totalOrders;
    }

    System.out.println("\n==================================");
    System.out.println("           DAILY SALES");
    System.out.println("==================================");

    System.out.println("\nTotal Pages: " + totalPages);
    System.out.println("Total Orders: " + totalOrders);
    System.out.printf("Total Earnings: P%.2f%n", totalEarnings);
    System.out.printf("Average Order: P%.2f%n", averageOrder);

    System.out.println("\n=================================");
    }

}