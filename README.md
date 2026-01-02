# MoodTracker

## Overview
The Mood Tracker application helps users track and record their daily moods. Users are able to log a mood (ex: happy, sad, angry, etc.), then add a date for that mood, and finally add notes. The application stores the entries in a text file, allowing users to review their previous mood entries.

----

## Approach and Design
The application is designed with simplicity in mind.

- User input is gathered through CLI (Command-Line Interface)
- Mood entries include:
  - Mood type
  - Date
  - Notes
- Mood entries are stored in a text file
- Application is seperated between multiple files that have their own responsibilities such as input handling, filtering, and file storage to keep code maintainable and readable.

The design of the application makes sure that it is easy to add future improvements.

----

## Key Files and Folders

- `main.java`: Handles user interaction and flow
- `moodTracker.java`: Handles adding mood entries and filtering by date or mood
- `moodEntry.java`: Handles storing mood data and holds the mood, date, and notes
- `fileStorage.java`: Handles loading from file and saving to file
- `Mood.java`: Holds all the valid mood types
- `mood_data.txt`: Stores all the mood entries. Each line is a single mood entry

----

## Process to Run Application

1. Clone the repository:<br>
   ```bash
   git clone https://github.com/aishalatif/MoodTracker.git
2. Navigate to project directory:<br>
   cd MoodTracker <br>
   cd MoodTrackerProject
3. Compile the program and run:<br>
   java src/**/*.java
4. Follow the prompts given

----

## Test Data and Seed Data

- Sample mood data is stored in mood_data.txt
- Example of data format:
  Mood: ANGRY || Date: 2025-12-30 || Note: I had to do homework

----

## Future Improvements

- Implement into GUI or web interface
- Export data into CSV file for insights
- Weekly/monthly summaries
- Mood analytics
