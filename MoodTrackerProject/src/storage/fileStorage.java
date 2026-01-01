package storage;

import model.Mood;
import model.moodEntry;

import java.io.*; //imports input/output classes
import java.time.LocalDate; //parses date strings
import java.util.ArrayList;
import java.util.List;

public class fileStorage {
    // Implementation details for file storage
    private final String FILE_PATH; //path to the file where mood entries are stored
    // final ensures the file path cannot be changed after initialization

    // allows for different file storage paths
    public fileStorage(String filePath) {
        this.FILE_PATH = filePath;
    }

    // loads mood entries from the specified file
    public List<moodEntry> load() {
        List<moodEntry> moodEntries = new ArrayList<>(); //empty list to hold loaded mood entries
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return moodEntries; // Return empty list if file does not exist
        }
        // opens the file and reads each line to create moodEntry objects
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3); //splits line into mood, date, and notes
                moodEntries.add(new moodEntry( //adds new moodEntry to the list
                        Mood.valueOf(parts[0]), //converts string to Mood enum
                        LocalDate.parse(parts[1]), //parses date string to LocalDate
                        parts.length > 2 ? parts[2] : "" //handles missing notes
                ));
            }
        } catch (IOException e) {
            e.printStackTrace(); //handles file read errors
        }
        return moodEntries;
    }

    // saves the list of mood entries back to the file
    public void save(List<moodEntry> moodEntries) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) { //opens file for writing
            for (moodEntry entry : moodEntries) {
                writer.println(entry.getMood() + "," + entry.getDate() + "," + entry.getNotes()); //writes each moodEntry as a line in the file (CSV format)
            }
        } catch (IOException e) {
            e.printStackTrace(); //handles file write errors
        }
    }
}
