
import java.util.*;
import java.time.LocalDateTime;


public class Database extends Entry{

    LocalDateTime dateTime;
    private ArrayList<Entry> entries;

    public Database() {
    super();
	entries = new ArrayList<>();
    }

 //adding the data into the db   
    public void addEntry(LocalDateTime dateTime, String mealtime, String food_name, String food_group, String day, String drink) {
        entries.add(new Entry(dateTime, mealtime, food_name, food_group, day, drink));
    }

//search data by datetime 
    public ArrayList<Entry> findDateTime(LocalDateTime dateTime, boolean searchbydate) {
        ArrayList<Entry> found = new ArrayList<>();
        for (Entry entry : entries) {
            if ((searchbydate && (entry.getDateTime().equals(dateTime)))|| // filtered by time and date
            ((!searchbydate) && (entry.getDateTime().toLocalDate().equals(dateTime.toLocalDate())))) { // filtered by date 
                found.add(entry);
            }
        }
        return found;
    }

//search data by food_group    
    public ArrayList<Entry> findFoodGroup(String food_group, boolean searchbygroup) {

        ArrayList<Entry> found = new ArrayList<>();
        for (Entry entry : entries) {
            if (!searchbygroup && (entry.getFoodGroup().equals(food_group))){
                    found.add(entry);
                }
        }
        return found;
    }

//general search by mealtime and food_group
    public ArrayList<Entry> findEntries(String mealtime, String food_group, boolean searchbymealfood) {

        ArrayList<Entry> found = new ArrayList<>();
        for (Entry entry : entries) {
            if ((!searchbymealfood && (entry.getMealTime().equals(mealtime)))&&
                (!searchbymealfood && (entry.getFoodGroup().equals(food_group)))){
                    found.add(entry);
                }
        }
	   return found;
    }
    
    public void deleteEntries(LocalDateTime dateTime) {
	ArrayList<Entry> found = findDateTime(dateTime, true);

	for (Entry entry : found) {
            entries.remove(entry);
        }
    }
    
}