package com.example.lab2savchenko;//////////////////////////.package com.example.lab2savchenko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lab2savchenko.R;

import java.util.Arrays;
import java.util.List;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView countTextView;
    private Button countButton;
    private boolean isWord = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        countTextView = findViewById(R.id.resultText);
        countButton = findViewById(R.id.button);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counting(isWord);
            }
        });
        final List<String> countTypes = Arrays.asList("Words", "Chars");

        final Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, countTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String newItem = spinner.getSelectedItem().toString();
                isWord = newItem.equalsIgnoreCase("Words");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }
    void counting (boolean isWord)
    {
        String inputText = editText.getText().toString();
        if(inputText.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Text field is empty! Please enter the text.", Toast.LENGTH_SHORT).show();
        }
        else if(isWord)
        {
            int wordCount = Counter.countWords(inputText);
            countTextView.setText("Words: " + wordCount);
        }
        else
        {
            int charCount = Counter.countChars(inputText);
            countTextView.setText("Characters: " + charCount);
        }

    }
}