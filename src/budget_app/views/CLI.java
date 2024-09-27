package budget_app.views;

import budget_app.models.User;
import budget_app.services.UserService;

import java.util.Scanner;

public class CLI {
    private final Scanner scanner;

    public CLI() {
        this.scanner = new Scanner(System.in);
    }

    public void mainMenu() {
        var message = """
                Welcome to Your Budgeting App!
                
                Please select your menu option below to proceed:
                1) Manage User/Transaction (add/update/delete user info/transaction)
                2) View Account Balances
                3) Customize Goals/Budget
                4) View Overview Stats
                5) Run Customized Reports
                6) Exit
                """;
        System.out.println(message);
    }

    public void quickStatsMenu() {
        var message = """
                Welcome to QuickStats!
                ------------------------------------
                """;

        //Need to call service layer from here, which will call data layer and retrieve records for processing

        //Your checking account balance is: $#,###.##
        //Your savings account balance is: $#,###.##
        //Your total debt is: $#,###.##
        //Your income to debt ratio is currently 4 to 1
        //You are currently saving $###.## per month


    }

    public void customGoalsMenu() {
        var message = "Would you like to view existing goals (yes/no). You can type 'return' to go back to the home menu";

        while (true) {
            System.out.println(message);
            var response = userResponse().toLowerCase();
            switch (response){
                case "yes" -> {}  // call some other function to check and load existing goals
                case "no" -> {} // call some other function to create goals. Another menu
                case "return" -> {return;}
                default -> System.out.println("Invalid selection!");
            }
        }

        /**
         * Great
         * I see you have one existing goal defined:
         * ........................................
         * Goal Name: Hawaii!!
         * Goal Amount: $2500 USD
         * Amount Saved: $750 USD
         * Amount Remaining: $1750
         * ........................................
         */
    }

    public void reportMenu() {
        var message = """
                Welcome to the Reporting! Which Report would you like to run? (type 'return' to return to main menu)
                1) Debt Overview
                2) Savings Overview
                3) Spending & Saving Recommendations
                4) Financial Sanity
                """;

        while(true) {
            System.out.println(message);
            switch(userResponse()) {
                case "1" -> {} //View Debt
                case "2" -> {} //View Savings
                case "3" -> {} //Spending & Saving
                case "4" -> {} //Financial Sanity
                case "return" -> {return;} // return to home
                default -> System.out.println("Invalid selection!");
            }
        }
    }

    public void accountBalMenu() {

    }

    public void mainProcessing() {

        while (true) {
            mainMenu();
            var response = Integer.parseInt(userResponse());
            switch(response) {
                case 1 -> manageUserTransactMenu();  //View Account Balances
                case 2 -> accountBalMenu();      //View Account Balances
                case 3 -> customGoalsMenu();     //Customize Budget
                case 4 -> quickStatsMenu();     //View Overview Stats
                case 5 -> reportMenu();         //Run Customized Reports
                case 6 -> {return;}             //Exit
                default -> System.out.println("Invalid selection!");
            }

        }

    }

    public void manageUserTransactMenu() {
        var message = """
                Welcome to the User & Transaction management! Select your menu option (type 'return' to go to main menu)
                1) Add User Info
                2) Update User Info
                3) Add Transaction
                4) Update Transaction
                5) Delete Transaction
                6) Delete User (which will consequently delete user's transaction)
                """;

        while(true) {
            System.out.println(message);
            switch(userResponse()) {
                case "1" -> { addUserMenuInt();} //Add User Info
                case "2" -> { updateUsersInfo();} //Update User Info
                case "3" -> {} //Add Transaction
                case "4" -> {} //Update Transaction
                case "5" -> {} //Delete Transaction
                case "6" -> {} //Delete User (which will consequently delete user's transaction)
                case "return" -> {return;} // return to home
                default -> System.out.println("Invalid selection!");
            }
        }



    }

    private void updateUsersInfo() {
        UserService.updateUser("");
    }

    private void addUserMenuInt() {
        String[] response;

        while(true) {
            System.out.println("Please enter user name, first name, last name and email seperated by comma in one line:");
            response = userResponse().split(",");
            if (response.length == 4) {
                break;
            }

        }

        var user = User.builder().withUsername(response[0])
                                 .withFirstname(response[1])
                                 .withLastname(response[2])
                                 .withEmail(response[3])
                                 .build();
        var userId = UserService.addUser(user);
        System.out.println("UserId: " + userId);

    }


    public String userResponse(){
        return scanner.nextLine();
    }
}
