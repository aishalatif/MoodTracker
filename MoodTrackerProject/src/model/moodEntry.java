package model;

import java.time.LocalDate;

public class moodEntry {
    // encapsulates a mood entry with mood, date, and optional notes
    private Mood mood;
    private LocalDate date;
    private String notes;

    // constructor for a mood entry object
    public moodEntry(Mood mood, LocalDate date, String notes) {
        this.mood = mood; //assigns the mood parameter to the mood field
        this.date = date; //assigns the date parameter to the date field
        this.notes = notes; //assigns the notes parameter to the notes field
    }

    //getters allowing other classes to read the mood, date, and notes safely
    public Mood getMood() {
        return mood;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }

    @Override //overrides the default toString method
    // provides a string representation of the mood entry for easy display
    public String toString() {
        return "Mood: " + mood + " || Date: " + date + " || Note: " + notes;
    }
}
