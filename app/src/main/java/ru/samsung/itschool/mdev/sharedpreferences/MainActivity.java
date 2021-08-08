package ru.samsung.itschool.mdev.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextStr, editTextNum;
    private SharedPreferences sharedPreferences;
    final String SAVED_TEXT = "TEXT";
    final String SAVED_NUM = "NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextStr = findViewById(R.id.editTextStr);
        editTextNum = findViewById(R.id.editTextNum);

        Button btnSave = findViewById(R.id.save);
        btnSave.setOnClickListener(this);

        Button btnLoad = findViewById(R.id.load);
        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                saveData();
                break;
            case R.id.load:
                loadData();
                break;
            default:
                break;
        }
    }

    void saveData() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SAVED_TEXT, editTextStr.getText().toString());
        editor.putInt(SAVED_NUM, Integer.parseInt(editTextNum.getText().toString()));
        editor.apply();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    void loadData() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        String savedText = sharedPreferences.getString(SAVED_TEXT, "");
        int savedNum = sharedPreferences.getInt(SAVED_NUM, 0);
        editTextStr.setText(savedText);
        editTextNum.setText(Integer.toString(savedNum));
        Toast.makeText(this, "Loaded", Toast.LENGTH_SHORT).show();
    }
}