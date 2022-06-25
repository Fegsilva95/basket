package br.ufjf.dcc196.fabricioguidine.baket;

import android.content.Context;
import android.content.SharedPreferences;

public class BasketRepository {
    private Context context;
    private SharedPreferences preferences;
    private final String PREFERENCES_NAME = "br.ufjf.basket";
    public final static String POINTS_KEY = "POINTS_KEY";
    public final static String THROWS_KEY = "THROWS_KEY";
    public final static String BLOCKS_KEY = "BLOCKS_KEY";

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

    public Integer getThrows() {
        return preferences.getInt(THROWS_KEY, 0);
    }

    public void setThrows(Integer throwsValue) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(THROWS_KEY, throwsValue);
        editor.apply();
    }

    public void incThrows() {
        Integer throwsValue = getThrows() + 1;
        setThrows(throwsValue);
    }

    public void decThrows() {
        Integer throwsValue = getThrows() - 1;
        setThrows(throwsValue);
    }

    public Integer getBlocks() {
        return preferences.getInt(BLOCKS_KEY, 0);
    }

    public void setBlocks(Integer blocksValue) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(BLOCKS_KEY, blocksValue);
        editor.apply();
    }

    public void incBlocks() {
        Integer blocksValue = getBlocks() + 1;
        setBlocks(blocksValue);
    }

    public void decBlocks() {
        Integer blocksValue = getBlocks() - 1;
        setBlocks(blocksValue);
    }


}
