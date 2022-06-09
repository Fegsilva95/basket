package br.ufjf.dcc196.fabricioguidine.baket;

import android.content.Context;
import android.content.SharedPreferences;

public class BasketRepository {
    private Context context;
    private SharedPreferences preferences;
    private final String PREFERENCES_NAME = "br.ufjf.basket";
    public final static String POINTS_KEY = "POINTS_KEY";

    public BasketRepository(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public Integer getPoints() {
        return preferences.getInt(POINTS_KEY, 0);
    }

    public void setPoints(Integer points) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(POINTS_KEY, points);
        editor.apply();
    }

    public void incPoints() {
       Integer points = getPoints() + 1;
       setPoints(points);
    }

    public void decPoints() {
        Integer points = getPoints() - 1;
        setPoints(points);
    }

}
