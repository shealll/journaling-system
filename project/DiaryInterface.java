
import java.io.*;
import java.lang.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

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