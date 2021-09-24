package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void f_Count(View view) {
        EditText weightObj = (EditText) findViewById(R.id.weight);
        EditText heightObj = (EditText) findViewById(R.id.height);
        TextView scoreObj = (TextView) findViewById(R.id.score);

        try {
            double weight = Double.parseDouble(weightObj.getText().toString());
            double height = Double.parseDouble(heightObj.getText().toString());

            if(weight <= 0 || height <= 0) {
                throw new Exception("Waga i wzrost muszą być dodatnie!");
            }

            height /= 100.0d;

            double BMI = Math.round((weight / Math.pow(height,2))*100d)/100.0d;

            if(BMI < 16) {
                scoreObj.setText(BMI + " - wygłodzenie!!!");
            }
            else if(BMI < 17) {
                scoreObj.setText(BMI + " - wychudzenie!!");
            }
            else if(BMI < 18.5) {
                scoreObj.setText(BMI + " - niedowaga!");
            }
            else if(BMI < 25) {
                scoreObj.setText(BMI + " - wartość prawidłowa");
            }
            else if(BMI < 30) {
                scoreObj.setText(BMI + " - nadwaga!");
            }
            else if(BMI < 35) {
                scoreObj.setText(BMI + " - I stopień otyłości!");
            }
            else if(BMI < 40) {
                scoreObj.setText(BMI + " - II stopień otyłości!!");
            }
            else {
                scoreObj.setText(BMI + " - III otyłość skrajna!!");
            }

        } catch (NumberFormatException e) {
            scoreObj.setText("Błędne dane!");
        } catch (Exception e) {
            scoreObj.setText(e.getMessage());
        }
    }
}