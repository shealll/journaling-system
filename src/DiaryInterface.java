
import java.time.LocalDate;
import java.time.LocalDateTime;


interface DiaryInterface{

	public void viewEntry();
	public void addEntry();
	public void editEntries();
	public void searchEntries();
	public void deleteEntries();
	public void generalSearch();
	public void filterbyGroup();
	public LocalDateTime readDateTime();
	public LocalDate readDate();
	public String readSearch();
	public String readFood();
	public void home();
}