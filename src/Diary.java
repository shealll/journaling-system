

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Diary implements DiaryInterface{

    private Database database;
    private Scanner scanner = new Scanner(System.in);
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/y HH:mm");
    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/y");

    public Diary() {
        database = new Database();
    }
    
    public LocalDateTime readDateTime() {
        System.out.println("Enter date and time as dd/mm/yyyy hh:mm");
        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter); //read and format date and time
        }
        catch (DateTimeParseException e) {
            System.out.println("Error. Please try again.");
            return readDateTime();
        }
        return dateTime;
    }
   
    public LocalDate readDate() {
        System.out.println("Enter date as dd/mm/yyyy");    
        LocalDate date;
        try {
            date = LocalDate.parse(scanner.nextLine(), dateFormatter); //read and format date
        }
        catch (DateTimeParseException e) {
            System.out.println("Error. Please try again.");
            return readDate();
        }
        return date;
    }
    
    public void printEntries(LocalDate day) {
        ArrayList<Entry> entries = database.findDateTime(day.atStartOfDay(), false); 
        for (Entry entry : entries) {
            System.out.println(entry);
        }
    }

    public void addEntry() {
        String[] meal = {"Breakfast", "Lunch", "Dinner"};
        String[] food = {"Fruits", "Vegetables", "Grains", "Protein Foods", "Dairy"};
        String mealtime = "";
        String fgroup = "";

        LocalDateTime dateTime = readDateTime();
        System.out.println("\nChoose a Meal Time:");
        System.out.println("1 - Breakfast");
        System.out.println("2 - Lunch");
        System.out.println("3 - Dinner");

        String choose1 = "0";
        choose1 = scanner.nextLine();

            switch(choose1){
                case "1":
                    mealtime = meal[0];
                    break;
                case "2":
                    mealtime = meal[1];
                    break;
                case "3":
                    mealtime = meal[2];
                    break;
                default:
                    System.out.println("Error. Press any key to choose another action.");
                    break;
            }

            System.out.println("\nEnter Food Name:");
            String fname = scanner.nextLine();      //enter food name

            System.out.println("\nChoose a Food Group:");
            System.out.println("1 - Fruits");
            System.out.println("2 - Vegetables");
            System.out.println("3 - Grains");
            System.out.println("4 - Protein Foods");
            System.out.println("5 - Dairy");

            String choose2 = "0";
            choose2 = scanner.nextLine();

                switch(choose2){   //assign food group
                    case "1":
                        fgroup = food[0];
                        break;
                    case "2":
                        fgroup = food[1];
                        break;
                    case "3":
                        fgroup = food[2];
                        break;
                    case "4":
                        fgroup = food[3];
                        break;
                    case "5":
                        fgroup = food[4];
                        break;
                    default:
                        System.out.println("Error. Press any key to choose another action.");
                        break;
                }
            
            System.out.println("\nEnter Day:");     
            String day = scanner.nextLine();
            System.out.println("\nEnter Drink Name:");   
            String drink = scanner.nextLine();

            database.addEntry(dateTime, mealtime, fname, fgroup, day, drink);
        }
        
    public void viewEntry(){
        LocalDateTime dateTime = readDate().atStartOfDay();    //ask for entry date
        ArrayList<Entry> entries = database.findDateTime(dateTime, false);

        if (entries.size() > 0) {
            System.out.println("Entries found: \n");
            for (Entry entry : entries) {
                System.out.println(entry);
            }
        } else {
            System.out.println("No entries were found.");
        }
        scanner.nextLine();
    }

    public void editEntries(){

        LocalDateTime dateTime = readDateTime();  //get date of the entry to edit
        database.deleteEntries(dateTime);
        System.out.println("Edit:");
        System.out.println();
        addEntry();
    }

    public void searchEntries() {

        String search = "0";

        while (!search.equals("3")){ 
            System.out.println("\tChoose an action:");
            System.out.println("\t1 - General Search");   //search by mealtime and food group
            System.out.println("\t2 - Filter by Food Group"); //filter through food group
            System.out.println("\t3 - Back");

            search = scanner.nextLine();
            System.out.println();

            switch(search){
                case "1":
                    generalSearch();
                    break;
                case "2":
                    filterbyGroup();
                    break;
                case "3":
                    System.out.println();
                    home();
                    break;
                default:
                    System.out.println("Error. Press any key to choose another action.");
                    break;
            }
        }
    }
    
    public void generalSearch(){   //search by mealtime and food group
        String searchmeal;
        String searchfood;

            System.out.println("\tGeneral Search");
            System.out.println();
            System.out.println("\tSearch by Meal Time and Food Group:\n");
            System.out.println("\tMeal Time: Breakfast, Lunch, Dinner");
            System.out.println("\tFood Group: Fruits, Vegetables, Grains, Protein Foods and Dairy");
            System.out.println("\n\tMeal Time: ");
            searchmeal = scanner.nextLine();
            System.out.println();
            System.out.println("Food Group: ");
            searchfood = scanner.nextLine();
            System.out.println();
            

        ArrayList<Entry> entries = database.findEntries(searchmeal, searchfood, false);

        if (entries.size() > 0){
            System.out.println();
            System.out.println("Entries found: \n");
            for (Entry entry : entries) {
                System.out.println();
                System.out.println(entry);
            }
        }
        else{
            System.out.println("No entries were found.");
        }
        scanner.nextLine(); 

    }

    public void filterbyGroup(){  //filter through food group

        String food = readFood();

        ArrayList<Entry> entries = database.findFoodGroup(food, false);

        if (entries.size() > 0){
            System.out.println();
            System.out.println("Entries found: ");
            for (Entry entry : entries) {
                System.out.println();
                System.out.println(entry);
            }
        }
        else{

            System.out.println("No entries were found.");
        }
        scanner.nextLine(); 

    }

    public void deleteEntries() {
        LocalDateTime dateTime = readDateTime();
        database.deleteEntries(dateTime);
    }
    
    public String readSearch(){
        String read = " ";
        return read;
    }

    public String readFood(){
        String search = "0";
        String[] food = {"Fruits", "Vegetables", "Grains", "Protein Foods", "Dairy"};
        String fgroup = "";

        System.out.println();
        System.out.println("Choose a Food Type:");
        System.out.println("1 - Fruits");
        System.out.println("2 - Vegetables");
        System.out.println("3 - Grains");
        System.out.println("4 - Protein Foods");
        System.out.println("5 - Dairy");
        search = scanner.nextLine();

        switch(search){
                case "1": 
                    fgroup = food[0];
                    break;

                case "2": 
                    fgroup = food[1];
                    break;

                case "3": 
                    fgroup = food[2];
                    break;

                case "4": 
                    fgroup = food[3];
                    break;

                case "5": 
                    fgroup = food[4];
                    break;

                default:
                    System.out.println("Error. Press any key to choose another action.");
                    break;
            }
        return fgroup;
    }

     public void home() {
        System.out.println();
        System.out.println();
        System.out.println("\t--------- Meal Diary ---------");
        System.out.println("\tToday is: " + LocalDateTime.now().format(dateTimeFormatter));
        System.out.println();

        System.out.println("\tToday:\n\t------");
        printEntries(LocalDate.now());
        System.out.println();
        System.out.println("\tYesterday:\n\t----------");
        System.out.println();
        printEntries(LocalDate.now().plusDays(-1));
    }
}