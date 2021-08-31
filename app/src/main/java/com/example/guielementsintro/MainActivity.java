package com.example.guielementsintro;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    Button inc;
    TextView greet;
    int count = 0;
    int count2 = 0;
    TextView newbutton2;
    Boolean x = true;
    String[] planets;
    RadioButton left;
    RadioButton right;
    TextView p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inc = findViewById(R.id.increment_button);
        greet = findViewById(R.id.greeting_textview);
        newbutton2 = findViewById(R.id.new_button);
        p = findViewById(R.id.planet);
        planets = getResources().getStringArray(R.array.planets_array);
        left = findViewById(R.id.radio_left);
        right = findViewById(R.id.radio_right);
        inc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("Incrementing " + ++count2);
                Log.i("incrementing", ""+count2);
                greet.setText(getString(R.string.likescount,count2));
                newbutton2.setText("Start Over!");
                if(right.isChecked())
                {
                    count = ++count% planets.length;
                    p.setText(planets[count]);
                    count %= planets.length;
                }
            }
        });

    }

    public void decrement(View view) {
        System.out.println("Decrementing " + --count2);
        greet.setText(getString(R.string.likescount,count2));
        newbutton2.setText("Start Over!");
        if(left.isChecked())
        {
            if(--count < 0)
                count = planets.length - 1;
            p.setText(planets[count]);
            count %= planets.length;
        }
    }

    public void startover(View view2)
    {
        p.setText(planets[count++]);
        count %= planets.length;
        if(newbutton2.getText().equals("Start!"))
        {
            System.out.println("Incrementing " + count2);
            greet.setText(getString(R.string.likescount,count2));
            newbutton2.setText("Start Over!");
           // x = false;
        }
        else
        {
            newbutton2.setText("Start!");
            count2 = 0;
            System.out.println("Count = 0");
            greet.setText("Hi!");
           // x = true;
        }
    }
}