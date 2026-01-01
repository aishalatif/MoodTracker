package app;

import model.Mood;
import model.moodEntry;
import service.moodTracker;
import storage.fileStorage;

import java.time.LocalDate;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        fileStorage storage = new fileStorage("mood_data.txt"); //specifies the file path for storing mood entries
        moodTracker tracker = new moodTracker(storage); //initializes the mood tracker with file storage
        Scanner scanner = new Scanner(System.in); //scanner for user input

        System.out.println("Welcome to the Mood Tracker!!");
        while (true) {
            // display menu options
            System.out.println("\n~~~~~~~~~~~~Menu~~~~~~~~~~~~");
            System.out.println("1. Add Mood Entry");
            System.out.println("2. View All Entries");
            System.out.println("3. View Entries by Mood");
            System.out.println("4. View Entries by Date");
            System.out.println("5. View All Available Moods");
            System.out.println("6. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); //get user choice
            scanner.nextLine(); //consume newline

            switch (choice) {
                // handle user choices
                case 1:
                    // add a new mood entry
                    System.out.print("Enter mood (HAPPY, SAD, ANGRY, etc.): ");
                    String moodStr = scanner.nextLine().toUpperCase();
                    try {
                        Mood.valueOf(moodStr); //validate mood input
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid mood entry. Pick from available moods.");
                        break;
                    }
                    Mood mood = Mood.valueOf(moodStr); //convert string to Mood enum
                    
                    // add date of entry
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();
                    try {
                        LocalDate.parse(dateStr); //validate date format
                    } catch (Exception e) {
                        System.out.println("Invalid date entry. Please use YYYY-MM-DD.");
                        break;
                    }

                    System.out.print("Enter notes (optional): ");
                    String notes = scanner.nextLine();
                    
                    LocalDate date = LocalDate.parse(dateStr);
                    moodEntry entry = new moodEntry(mood, date, notes); //create new mood entry
                    tracker.addMoodEntry(entry); //add entry to tracker
                    System.out.println("Mood entry added!");
                    break;
                case 2:
                    // view all mood entries
                    System.out.println("All Mood Entries:");
                    for (moodEntry e : tracker.getAll()) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    // view entries filtered by mood
                    System.out.print("Enter mood to filter by: ");
                    String filterMoodStr = scanner.nextLine().toUpperCase();
                    Mood filterMood = Mood.valueOf(filterMoodStr); 
                    System.out.println("Entries with mood " + filterMood + ":");
                    for (moodEntry e : tracker.getByMood(filterMood)) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    // view entries filtered by date
                    System.out.print("Enter date to filter by (YYYY-MM-DD): ");
                    String date_Str = scanner.nextLine();
                    LocalDate filterDate = LocalDate.parse(date_Str);
                    System.out.println("Entries on " + filterDate + ":");
                    for (moodEntry e : tracker.getByDate(filterDate)) {
                        System.out.println(e);
                    }
                    break;
                case 5:
                    // view all available moods
                    System.out.println("Available Moods:");
                    for (Mood m : Mood.values()) {
                        System.out.println("- " + m);
                    }
                    break;
                case 6:
                    // quit the program
                    System.out.println("Quitting. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
