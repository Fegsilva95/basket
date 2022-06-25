package br.ufjf.dcc196.fabricioguidine.baket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    TextView pointsValue;
    Button pointsPlusButton;
    Button pointsMinusButton;
    TextView throwsValue;
    Button throwPlusButton;
    Button throwMinusButton;
    TextView blocksValue;
    Button blocksPlusButton;
    Button blocksMinusButton;
    BasketRepository repo;
    String playerName;
    EditText namePlainText;
    Double distance;
    EditText distancePlainText;
    TextView message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointsValue = findViewById(R.id.pointsValue);
        pointsPlusButton = findViewById(R.id.pointsPlusButton);
        pointsMinusButton = findViewById(R.id.pointsMinusButton);

        throwsValue = findViewById(R.id.throwsValue);
        throwPlusButton = findViewById(R.id.throwPlusButton);
        throwMinusButton = findViewById(R.id.throwMinusButton);

        blocksValue = findViewById(R.id.blockValue);
        blocksPlusButton = findViewById(R.id.blockPlusButton);
        blocksMinusButton = findViewById(R.id.blockMinusButton);

        repo = new BasketRepository(getApplicationContext());
        pointsValue.setText(repo.getPoints().toString());
        throwsValue.setText(repo.getThrows().toString());
        blocksValue.setText(repo.getBlocks().toString());
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
            case R.id.throwPlusButton:
                repo.incThrows();
                throwsValue.setText(repo.getThrows().toString());
                break;
            case R.id.throwMinusButton:
                repo.decThrows();
                throwsValue.setText(repo.getThrows().toString());
                break;
            case R.id.blockPlusButton:
                repo.incBlocks();
                blocksValue.setText(repo.getBlocks().toString());
                break;
            case R.id.blockMinusButton:
                repo.decBlocks();
                blocksValue.setText(repo.getBlocks().toString());
                break;
        }
    }

    public void saveName(View v){
        namePlainText = findViewById(R.id.namePlainText);
        playerName = namePlainText.getText().toString();

        message = findViewById(R.id.playerTextView);
        message.setText("Player: " + playerName);
    }

    public void saveDistance(View v){
        distancePlainText = findViewById(R.id.distancePlainText);
        distance = Double.parseDouble(distancePlainText.getText().toString());

        message = findViewById(R.id.playerTextView);
        message.setText("Player: " + playerName + ", Distance: " + distance.toString());
    }

    public void resetValues(View v){
        repo.setBlocks(0);
        repo.setThrows(0);
        repo.setPoints(0);
        namePlainText = findViewById(R.id.namePlainText);
        namePlainText.setText("");
        distancePlainText.setText("0.0");

        playerName = "";
        distance = 0.0;
        message.setText("");
        blocksValue.setText(repo.getBlocks().toString());
        throwsValue.setText(repo.getThrows().toString());
        pointsValue.setText(repo.getPoints().toString());
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    switch (key){
        case BasketRepository.POINTS_KEY:
            pointsValue.setText(repo.getPoints().toString());
            break;
        case BasketRepository.THROWS_KEY:
            throwsValue.setText(repo.getThrows().toString());
            break;
        case BasketRepository.BLOCKS_KEY:
            blocksValue.setText(repo.getBlocks().toString());
            break;
    }}
}