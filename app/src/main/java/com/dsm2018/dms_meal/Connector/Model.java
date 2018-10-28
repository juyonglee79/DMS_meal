package com.dsm2018.dms_meal.Connector;

import java.util.ArrayList;

public class Model {
    ArrayList<String> breakfast, lunch, dinner;

    public ArrayList<String> getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(ArrayList<String> breakfast) {
        this.breakfast = breakfast;
    }

    public ArrayList<String> getLunch() {
        return lunch;
    }

    public void setLunch(ArrayList<String> lunch) {
        this.lunch = lunch;
    }

    public ArrayList<String> getDinner() {
        return dinner;
    }

    public void setDinner(ArrayList<String> dinner) {
        this.dinner = dinner;
    }
}