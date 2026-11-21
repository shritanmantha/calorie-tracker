# Calorie Tracker

A lightweight Java command-line application for logging daily meals, tracking calories and macronutrients against a daily target, and persisting meal logs locally to a CSV file.

## The Problem

Tracking daily calorie and macronutrient intake often requires bloated mobile apps full of ads, subscriptions, or slow interfaces. This CLI tool gives students and lifters a fast, offline, terminal-based way to log meals and check remaining daily calories in seconds.

## How It Works

![System Diagram](System%20Diagram.png)

1. **User Terminal (`Main.java`):** Displays an interactive menu (`Log a meal`, `View daily summary`, `Exit`) and validates user input via `Scanner`.
2. **Data Model (`FoodItem.java`):** Encapsulates each meal's name, calories, protein, carbs, and fats, and formats entries for display and CSV serialization.
3. **Local File Storage (`nutrition_log.csv`):** Appends each logged meal immediately on entry and reloads existing entries automatically on startup.

## Tech Stack

- **Language:** Java (JDK 11+)
- **Storage:** Local CSV file (`nutrition_log.csv`)
- **Tools:** VS Code, Git, GitHub, Terminal

## Setup & Usage

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/shritanmantha/calorie-tracker.git](https://github.com/shritanmantha/calorie-tracker.git)
   cd calorie-tracker

   ## Roadmap

- [x] Core Java CLI menu loop and `Scanner` input handling
- [x] `FoodItem` model class and daily calorie/macro aggregation
- [x] Input validation and error handling for invalid entries
- [x] Persistent CSV file storage (`nutrition_log.csv`)
- [ ] Configurable daily calorie and macro targets
- [ ] Multi-day date filtering and weekly averages

## Demo Video

- [Video Walkthrough](ADD_YOUR_VIDEO_LINK_HERE)