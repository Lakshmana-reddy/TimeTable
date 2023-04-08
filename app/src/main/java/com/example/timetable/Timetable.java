package com.example.timetable;

import java.util.HashMap;

public class Timetable {
    private HashMap<String, String[]> timetableData;

    public Timetable() {
        // Initialize the timetable data
        timetableData = new HashMap<>();
        timetableData.put("Monday", new String[]{"EPG&T", "PYTHON LAB", "MEFA", "EM-II", "MEFA", "SS", "EPG&T"});
        timetableData.put("Tuesday", new String[]{"SS", "EM LAB", "EM LAB", "EM LAB", "E&EM", "LIBRARY", "SPORTS"});
        timetableData.put("Wednesday", new String[]{"EM-II", "E&EM", "SS", "E&EM", "PCS-II", "PCS-II", "EM-II"});
        timetableData.put("Thursday", new String[]{"PCS-II", "PCS-II", "PYTHON LAB", "EM-II", "SS", "EPG&T", "E&EM"});
        timetableData.put("Friday", new String[]{"EPG&T", "PYTHON LAB", "PYTHON LAB", "PYTHON LAB", "EMS LAB", "EMS LAB", "EMS LAB"});
        timetableData.put("Saturday", new String[]{"PYTHON LAB", "EPG&T", "MEFA", "SS", "EM-II", "E&EM", "MEFA"});
        timetableData.put("Sunday", new String[]{"No classes"});
    }

    /**
     * Get an array of days of the week.
     *
     * @return An array of days of the week.
     */
    public String[] getDaysOfWeek() {
        return timetableData.keySet().toArray(new String[0]);
    }

    /**
     * Get an array of periods for a given day of the week.
     *
     * @param day The day of the week.
     * @return An array of periods for the given day.
     */
    public String[] getPeriodsForDay(String day) {
        return timetableData.get(day);
    }
}
