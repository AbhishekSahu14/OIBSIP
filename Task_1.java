import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    private static final String USER="abhi";
    private static final String PASS ="1234";
    private static boolean[] seat=new boolean[10];
    public static class login{
        private String username;
        private String password;
        Scanner sc= new Scanner(System.in);
        login(){
        }
        public String getUsername() {
            System.out.println("Enter Username : ");
            username = sc.nextLine();
            return username;
        }

        public String getPassword() {
            System.out.println("Enter Password : ");
            password = sc.nextLine();
            return password;
        }
    }
    public static class PnrRecord {
        private String passengerName;
        private String trainNumber;
        private String classType;
        private String journeyDate;
        private String from;
        private String to;

        Scanner sc = new Scanner(System.in);
        public String getPassengerName() {
            System.out.println("Enter the passenger name : ");
            passengerName = sc.nextLine();
            return passengerName;
        }
        public String gettrainNumber() {
            System.out.println("Enter the train number : ");
            trainNumber = sc.nextLine();
            return trainNumber;
        }
        public String getclassType() {
            System.out.println("Enter the class type : ");
            classType = sc.nextLine();
            return classType;
        }
        public String getjourneyDate() {
            System.out.println("Enter the Journey date as 'YYYY-MM-DD' format");
            journeyDate = sc.nextLine();
            return journeyDate;
        }
        public String getfrom() {
            System.out.println("Enter the starting place : ");
            from = sc.nextLine();
            return from;
        }
        public String getto() {
            System.out.println("Enter the destination place :  ");
            to = sc.nextLine();
            return to;
        }
    }
    private static void viewseat(){
        Random rand = new Random();
        System.out.println("Current Available seats with serial nos. are: ");
        for(int i=0;i< seat.length;i++){
            if(seat[i]){
                System.out.println((i+1)+" X not available");
            }
            else{
                int random= rand.nextInt(1000);
                System.out.println((i+1)+". "+(random+i)+" ");
            }
        }
        System.out.println();
    }
    private static void researveseat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the assign serial no. of available seats: ");
        int seatno = sc.nextInt();
        if (seatno < 1 || seatno > 10) {
            System.out.println("Invalid seat no. ");
        }
        else if (seat[seatno -1]){
            System.out.println("Seat already reserved");
        }
        else {
            seat[seatno -1] = true;
            System.out.println("Seat reserved!");
        }
    }
    private static void cancelresearveseat(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter reserved seat serial no : ");
        int seatno = sc.nextInt();
        if (seatno < 1 || seatno > 10) {
            System.out.println("Invalid seat no. ");
        }
        else if (!seat[seatno -1]){
            System.out.println("Seat not reserved.");
        }
        else {
            seat[seatno -1] = false;
            System.out.println("Reservation canceled!");
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your login details to proceed... ");
        login log= new login();
        String username = log.getUsername();
        String password = log.getPassword();
        if (username.equals(USER) && password.equals(PASS)){
            System.out.println("You have login Your account successfully !");
            while(true){
                System.out.println("   *** MENU ***   ");
                System.out.println("Enter the choice : ");
                System.out.println("1. Enter details for reservation.");
                System.out.println("2. View seat map.");
                System.out.println("3. Reserve seat.");
                System.out.println("4. Cancel reservation.");
                System.out.println("5. Exit.");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("__Booking Details__");
                        PnrRecord p1 = new PnrRecord();
                        String passengerName = p1.getPassengerName();
                        String trainNumber = p1.gettrainNumber();
                        String classType = p1.getclassType();
                        String journeyDate = p1.getjourneyDate();
                        String getfrom = p1.getfrom();
                        String getto = p1.getto();
                        System.out.println("You can now proceed to reserve seat.");
                        break;
                    case 2:
                        viewseat();
                        break;
                    case 3:
                        researveseat();
                        break;
                    case 4:
                        cancelresearveseat();
                        break;
                    case 5:
                        System.out.println("You have been logout from your account.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice, Please try again!");
                }
            }
        }
        else{
            System.out.println("You have entered wrong details! Try again...");
            System.exit(0);
        }
    }
}
