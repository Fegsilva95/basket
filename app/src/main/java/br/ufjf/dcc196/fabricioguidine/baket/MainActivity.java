package br.ufjf.dcc196.fabricioguidine.baket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Integer points;
    TextView pointsValue;
    Button pointsPlusButton;
    Button pointsMinusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointsValue = findViewById(R.id.pointsValue);
        pointsPlusButton = findViewById(R.id.pointsPlusButton);
        pointsMinusButton = findViewById(R.id.pointsMinusButton);
        points = 0;
        pointsValue.setText(points.toString());
    }

    public void clickIncDec(View v){
        switch (v.getId()){
            case R.id.pointsPlusButton:
                points++;
                pointsValue.setText(points.toString());
                break;
            case R.id.pointsMinusButton:
                points--;
                pointsValue.setText(points.toString());
                break;
        }
    }
}