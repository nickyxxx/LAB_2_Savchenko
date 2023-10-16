package com.example.lab2savchenko;
import java.util.regex.Pattern;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class Counter {
    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.split("[\\s,\\.,\\,]+");
        return words.length;
    }

    public static int countChars(String text) {
        if (text == null) {
            return 0;
        }

        return text.length();
    }

}
