
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Diary diary = new Diary();
        String choice = "0";

        while (!choice.equals("6")) {
            diary.home(); 
            System.out.println();
            System.out.println("\tChoose an action:");
            System.out.println("\t1 - Add an entry");
            System.out.println("\t2 - View an Entry");
            System.out.println("\t3 - Edit an entry");
            System.out.println("\t4 - Search entries"); 
            System.out.println("\t5 - Delete entries");
            System.out.println("\t6 - End");
            choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    diary.addEntry();
                    break;
                case "2":
                    diary.viewEntry();
                    break;
                case "3":
                    diary.editEntries();
                    break;
                case "4":
                    diary.searchEntries();
                    break;
                case "5":
                    System.out.println("Entries with the same exact date and time will be deleted");
                    diary.deleteEntries();
                    break;
                case "6":
                    System.out.println("Press any key to quit the program...");
                    break;
                default:
                    System.out.println("Error. Press any key to choose another action.");
                    break;
            }
        }
    }
}
