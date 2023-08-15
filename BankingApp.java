import java.util.Scanner;

public class BankingApp {
    private static Scanner scanner = new Scanner (System.in);
    public static void main(String[] args) {

        final String BLUE_COLOR = "\033[034;1m";
        final String RED_COLOR = "\033[031;1m";
        final String GREEN_COLOR = "\033[032;1m";
        final String RESET = "\033[0m";
        final String CLEAR = "\033[H\033[2J";
        final String ERROR_MSG = String.format("\n\t%s%s%s\n", RED_COLOR,"%s",RESET);
        final String SUCCESS_MSG = String.format("\n\t%s%s%s\n", GREEN_COLOR,"%s",RESET);
        final String APP_MARGIN = String.format("\n\t%s%s%s\n", BLUE_COLOR,"%s",RESET);
        
        final String DASHBOARD = "💰 Welcome to Smart Banking App";
        final String OPEN_ACCOUNT = "Open New Account";
        final String DEPOSIT_MONEY = "Deposit Money";
        final String WITHDRAW_MONEY = "Withdraw Money";
        final String TRANSFER_MONEY = "Transfer Money";
        final String CHECK_BALANCE = "Check Account Balance";
        final String DROP_ACCOUNT = "Drop Existing Account";
        final String EXIT = "Exit App";

        int[] accountIds = {1,2,3};
        String[] accountNames = {"Suresh Mahanama","Sanath Jayasuriya","Avishka Gunawardene"};
        double[] accountBalances = {50000,75000,95000};

        String screen = DASHBOARD;

        do {
            final String APPTITLE = screen;
            System.out.println(CLEAR);
            System.out.printf(APP_MARGIN, APPTITLE);

            mainSwitch:
            switch (screen){
                case DASHBOARD:
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
                        case 7: screen = EXIT; break;
                        default:
                    }
                    break;

                case OPEN_ACCOUNT:

                    boolean valid;

                    // Generating account id
                    int accountId = accountIds[accountIds.length-1]+1;
                    System.out.printf("\n\t[1]. Account ID: SDB-%05d", accountId);

                    //Enter Account name
                    String accountName;

                    accountNameLoop:
                    do {
                        valid = true;
                        System.out.printf("\n\t[2]. Enter Customer name: ");
                        accountName = scanner.nextLine().strip();

                        //checking blank content
                        if (accountName.isBlank()){
                            System.out.printf(ERROR_MSG,"Customer name cannot be empty");
                            valid = false;
                            
                            System.out.print("\n\tDo you want to continue (Y/n)? ");
                            String answer = scanner.nextLine().strip().toUpperCase();

                            if (answer.equals("Y")) continue;
                            else {
                                screen = DASHBOARD;
                                break mainSwitch;
                            }
                        }

                        //Checking validity of Account name
                        for (int i = 0; i < accountName.length(); i++) {
                            if (!(Character.isLetter(accountName.charAt(i)) )) {
                                if (!(Character.isSpaceChar(accountName.charAt(i)))) {
                                    System.out.printf(ERROR_MSG, "Invalid account name");
                                    valid = false;

                                    System.out.print("\n\tDo you want to continue (Y/n)? ");
                                    String answer = scanner.nextLine().strip().toUpperCase();

                                    if (answer.equals("Y")) continue accountNameLoop;
                                    else {
                                        screen = DASHBOARD;
                                        break mainSwitch;
                                    }
                                }
                            }
                        }

                    } while (!valid);

                    //Enter initial deposit
                    double accountBalance;
                    do {
                        valid = true;
                        System.out.print("\t[3]. Enter Initial Deposit: Rs. ");
                        accountBalance = scanner.nextDouble();
                        scanner.nextLine();
        
                        //Validating initial deposit
                        if (accountBalance < 5000.00) {
                            System.out.printf(ERROR_MSG, "Minimum initial deposit Rs.5000.00");
                            valid = false;

                            System.out.print("\n\tDo you want to continue (Y/n)? ");
                            String answer = scanner.nextLine().strip().toUpperCase();
                            System.out.println();
                            if (answer.equals("Y")) continue;
                            else {
                                screen = DASHBOARD;
                                break mainSwitch;
                            }
                        }
                        
                    } while (!valid);

                    // Storing data into arrays
                    int[] newAccountIds = new int[accountIds.length + 1];
                    String[] newAccountNames = new String[accountNames.length + 1];
                    double[] newAccountBalances = new double[accountBalances.length + 1];

                    int index;
                    for (index = 0; index < accountIds.length; index++) {
                        newAccountIds[index] = accountIds[index];
                        newAccountNames[index] = accountNames[index];
                        newAccountBalances[index] = accountBalances[index];
                    }

                    newAccountIds[index] = accountId;
                    newAccountNames[index] = accountName;
                    newAccountBalances[index] = accountBalance;

                    accountIds = newAccountIds;
                    accountNames = newAccountNames;
                    accountBalances = newAccountBalances;

                    // Success message & Asking to add another customer
                    System.out.printf(SUCCESS_MSG,String.format("Account number SDB-%05d for %s has been created successfully.", accountId, accountName));
                    System.out.print("\n\tDo you want to add another new customer (Y/n)? ");
                    String answer = scanner.nextLine().strip().toUpperCase();

                    if (answer.equals("Y")) continue;
                    else {
                        screen = DASHBOARD;
                        break;
                    }

                case EXIT:

                    System.out.print("\n\tAre you sure you want to exit from App (Y/n)? ");
                    String answerExit = scanner.nextLine().strip().toUpperCase();
                    System.out.println();
                    if (answerExit.equals("Y")) System.exit(0);
                    else {
                        screen = DASHBOARD;
                        break;
                    }

                default:
            }
                
 
        } while (true);

    }
}