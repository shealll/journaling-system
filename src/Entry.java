
import java.time.LocalDateTime;


public class Entry implements EntryInterface{

    private LocalDateTime dateTime;
    private String mealtime;
	private String food_name; 
    private String food_group;
    private String day;
    private String drink;
    
    Entry(){
        mealtime = "";
        food_name = "";
        food_group = "";
        day = "";
        drink = "";
    }

    public Entry(LocalDateTime dateTime, String mealtime, String food_name, String food_group, String day, String drink) {
        this.dateTime = dateTime;
        this.mealtime = mealtime;
        this.food_name = food_name;
        this.food_group = food_group;
        this.day = day;
        this.drink = drink;
    }
	
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
	
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMealTime(){
        return mealtime;
    }

    // public void setMealTime(String meal_time){
    //     this.mealtime = mealtime;
    // }

    public String getFoodname(){
        return food_name;
    }

    public void setFoodname(String food_name){
        this.food_name = food_name;
    }

    public String getFoodGroup(){
        return food_group;
    }

    public void setFoodGroup(String food_group){
        this.food_group = food_group;
    }

    public String getDay(){
        return day;
    }

    public void setDay(String day){
        this.day = day;
    }

    public String getDrink(){
        return drink;
    }

    public void setDrink(String drink){
        this.drink = drink;
    }

    public String toString() {
        return ("\t\t"+dateTime.format(Diary.dateTimeFormatter)+"\n\t\t--"+ mealtime +"--\n\t\tFood Name: " + food_name + "\n\t\tFood Group: " + food_group + "\n\t\tDay: " + day + "\n\t\tDrink: " + drink);
    }
}