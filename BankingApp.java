import java.util.Arrays;
import java.util.Scanner;

public class BankingApp {
    private static Scanner scanner = new Scanner (System.in);
    public static void main(String[] args) {

        final String BLUE_COLOR = "\033[034m";
        final String RED_COLOR = "\033[031m";
        final String BOLD = "\033[1m";
        final String RESET = "\033[0m";
        final String CLEAR = "\033[H\033[2J";

        final String APP_MARGIN = ".repeat((50-%s.length())/2).concat(%s)";
        
        final String DASHBOARD = "💰 Welcome to Smart Banking App";
        final String OPEN_ACCOUNT = "Open New Account";
        final String DEPOSIT_MONEY = "Deposit Money";
        final String WITHDRAW_MONEY = "Withdraw Money";
        final String TRANSFER_MONEY = "Transfer Money";
        final String CHECK_BALANCE = "Check Account Balance";
        final String DROP_ACCOUNT = "Drop Existing Account";

        int[] accountIds = {1,2,3};
        String[] accountNames = {"Suresh Mahanama","Sanath Jayasuriya","Avishka Gunawardene"};
        double[] accountBalances = {50000,75000,95000};

        String screen = DASHBOARD;
    
        do {
            final String APPTITLE = screen;
            System.out.println(CLEAR);
            System.out.println(BLUE_COLOR);
            System.out.println(BOLD);
            System.out.printf(" ".repeat((50-APPTITLE.length())/2).concat(APPTITLE));
            System.out.println(RESET);

            switch (screen){
                case DASHBOARD:
                    // System.out.println(COLOR);
                    System.out.printf("\n\t[1]. %s\n\t[2]. %s\n\t[3]. %s\n\t[4]. %s\n\t[5]. %s\n\t[6]. %s\n\t[7]. Exit\n", OPEN_ACCOUNT,DEPOSIT_MONEY,WITHDRAW_MONEY,TRANSFER_MONEY,CHECK_BALANCE,DROP_ACCOUNT);
                    System.out.print("\n\n\tEnter an option: ");
                    int option = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(RESET);
                    System.out.println();
                    System.out.println();

                    switch (option) {
                        case 1: screen = OPEN_ACCOUNT; break;
                        case 2: screen = DEPOSIT_MONEY; break;
                        case 3: screen = WITHDRAW_MONEY; break;
                        case 4: screen = TRANSFER_MONEY; break;
                        case 5: screen = CHECK_BALANCE; break;
                        case 6: screen = DROP_ACCOUNT; break;
                        case 7: System.exit(0); break;
                        default: ;
                    }
                    break;
                
                 
                case OPEN_ACCOUNT:

                    boolean valid;
                    String customerId;

                    // Generating account id
                    System.out.printf("[1]. Account ID: SDB-%50d", accountIds[accountIds.length-1]+1);

                    //Validating Account name
                    String accountName;

                    accountNameLoop:
                    do {
                        valid = true;
                        System.out.printf("\n[2]. Enter Customer name: ");
                        accountName = scanner.nextLine().strip();

                        //checking blank content
                        if (accountName.isBlank()){
                            System.out.printf("%s%sCustomer name cannot be empty%s\n",RED_COLOR,BOLD,RESET);
                            valid = false;
                            continue;
                        }

                        //Checking validity of Account name
                        for (int i = 0; i < accountName.length(); i++) {
                            if (!(Character.isLetter(accountName.charAt(i)) )) {
                                System.out.printf("%s%sInvalid%s\n",RED_COLOR,BOLD,RESET);
                                valid = false;
                                continue accountNameLoop;
                            }
                        }

                    } while (!valid);

                default: System.exit(1);
            }
                
 
        } while (true);

    }
}