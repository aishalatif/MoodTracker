package service;

import model.Mood;
import model.moodEntry;
import storage.fileStorage;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors; //stream API for filtering lists

public class moodTracker {
    private final fileStorage storage;
    private List<moodEntry> moodEntries;

    // constructor initializes the mood tracker with storage and loads existing entries
    public moodTracker(fileStorage storage) {
        this.storage = storage;
        this.moodEntries = storage.load();
    }

    // adds a new mood entry and saves to storage
    public void addMoodEntry(moodEntry entry) {
        moodEntries.add(entry);
        storage.save(moodEntries);
    }

    // gets all mood entries
    public List<moodEntry> getAll() {
        return moodEntries;
    }

    // filters mood entries by mood
    public List<moodEntry> getByMood(Mood mood) {
        return moodEntries.stream()
                .filter(entry -> entry.getMood() == mood)
                .collect(Collectors.toList());
    }

    // filters mood entries by date
    public List<moodEntry> getByDate(LocalDate date) {
        return moodEntries.stream()
                .filter(entry -> entry.getDate().equals(date))
                .collect(Collectors.toList());
    }
}
