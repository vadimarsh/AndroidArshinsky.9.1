package com.example.androidarshinsky91;

import android.app.Activity;
import android.content.Intent;

public class Util {

    public final static int THEME_DEFAULT = 0;
    public final static int THEME_BlACK = 2;
    public final static int THEME_GREEN = 1;
    public final static int THEME_BLUE = 3;
    private static int sTheme;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.recreate();
        //activity.finish();
        //activity.startActivity(new Intent(activity, activity.getClass()));

    }

    /**
     * Set the theme of the activity, according to the configuration.
     */
    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_BlACK:
                activity.setTheme(R.style.ThemeBlack);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.ThemeGreen);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.ThemeBlue);
                break;
        }
    }
}

