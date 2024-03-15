import java.util.Scanner;
class Task_3{

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("   *** ATM INTERFACE ***   ");
        System.out.println("1. Register\n2. Exit");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        if(choice==1){
            BankAccount acc= new BankAccount();
            acc.register();
            while(true){
                System.out.println("1. login\n2. Exit");
                System.out.println("Enter your choice: ");
                int ch= sc.nextInt();
                if(ch==1){
                    if(acc.login()){
                        System.out.println("Welcome   "+acc.name+"   !!!");
                        boolean finish=false;
                        while(!finish){
                            System.out.println("   *** MENU ***   ");
                            System.out.println("1. Show Transaction History");
                            System.out.println("2. Deposit");
                            System.out.println("3. Withdraw.");
                            System.out.println("4. Transfer.");
                            System.out.println("5. Check balance.");
                            System.out.println("6. Redirect to login page!.");
                            System.out.println("\nEnter your choice: ");
                            int input = sc.nextInt();
                            switch (input){
                                case 1:
                                    acc.transhistory();
                                    break;
                                case 2:
                                    acc.deposit();
                                    break;
                                case 3:
                                    acc.withdraw();
                                    break;
                                case 4:
                                    acc.transfer();
                                    break;
                                case 5:
                                    acc.checkBalance();
                                    break;
                                case 6:
                                    finish=true;
                                    break;
                                default:
                                    System.out.println("Invalid input... try again!");
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }
}
class BankAccount{
    Scanner sc= new Scanner(System.in);
    String name;
    String userid;
    String password;
    String accountNo;
    int balance=100000;
    int transaction=0;
    String transactionhist="";
    public void register(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.name= sc.nextLine();
        System.out.println("Enter USER ID: ");
        this.userid= sc.nextLine();
        System.out.println("Enter PASSWORD: ");
        this.password= sc.nextLine();
        System.out.println("Enter Bank account no.: ");
        this.accountNo= sc.nextLine();
        System.out.println("Verification completed... Login to proceed!");
    }
    public void checkBalance(){
        System.out.println("Current account balance is Rs."+ balance);
    }
    public void deposit(){
        System.out.println("Enter amount to deposit: ");
        int amount = sc.nextInt();
        if(amount<=100000){
            transaction++;
            balance+=amount;
            System.out.println("Successfully deposited!");
            String str= "Rs."+amount+" deposited!";
            transactionhist=transactionhist.concat(str);
        }
        else{
            System.out.println("Sorry... limit is Rs.100000.");
        }
    }
    public void withdraw(){
        System.out.println("Enter amount to withdraw: ");
        int amount = sc.nextInt();
        if(balance>=amount){
            transaction++;
            balance-=amount;
            System.out.println("Successfully Withdrawn!");
            String str= "Rs."+amount+" Withdrawn!";
            transactionhist=transactionhist.concat(str);
        }
        else{
            System.out.println("Insufficient balance!");
        }
    }
    public void transfer(){
        System.out.println("Enter receiver's name: ");
        String receiver=sc.nextLine();
        System.out.println("Enter amount to transfer: ");
        int trans=sc.nextInt();
        if(balance>=trans){
            if(trans<=100000){
                transaction++;
                balance-=trans;
                System.out.println("Successfully transferred Rs."+trans+" to "+receiver);
                String str= "Rs."+trans+" transferred to "+receiver+" Acc.";
                transactionhist=transactionhist.concat(str);
            }
            else{
                System.out.println("Sorry... limit is Rs.100000.");
            }
        }
        else {
            System.out.println("Transfer failed due to insufficient balance.");
        }
    }
    public void transhistory(){
        if(transaction==0){
            System.out.println("Empty!");
        }
        else{
            System.out.println("\n"+transactionhist);
        }
    }
    public boolean login(){
        boolean islogin=false;
        while (!islogin){
            System.out.println("Enter USER ID: ");
            String user=sc.nextLine();
            if(user.equals(userid)){
                while(!islogin){
                    System.out.println("Enter Password: ");
                    String pass= sc.nextLine();
                    if(pass.equals(password)){
                        System.out.println("Login Successful!");
                        islogin=true;
                    }
                    else{
                        System.out.println("Incorrect password...");
                    }
                }
            }
            else{
                System.out.println("User not found...");
            }
        }
        return islogin;
    }
}



