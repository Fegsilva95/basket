package br.ufjf.dcc196.fabricioguidine.baket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    TextView pointsValue;
    Button pointsPlusButton;
    Button pointsMinusButton;
    BasketRepository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointsValue = findViewById(R.id.pointsValue);
        pointsPlusButton = findViewById(R.id.pointsPlusButton);
        pointsMinusButton = findViewById(R.id.pointsMinusButton);

        repo = new BasketRepository(getApplicationContext());
        pointsValue.setText(repo.getPoints().toString());
    }

    public void clickIncDec(View v){
        switch (v.getId()){
            case R.id.pointsPlusButton:
                repo.incPoints();
                pointsValue.setText(repo.getPoints().toString());
                break;
            case R.id.pointsMinusButton:
                repo.decPoints();
                pointsValue.setText(repo.getPoints().toString());
                break;
        }
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    switch (key){
        case BasketRepository.POINTS_KEY:
            pointsValue.setText(repo.getPoints().toString());
            break;
    }}
}