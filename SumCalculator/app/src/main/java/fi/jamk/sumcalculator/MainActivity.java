package fi.jamk.sumcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Calculate(View view) {
        //get number fields
        EditText num1 = (EditText) findViewById(R.id.number1);
        EditText num2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        //get value
        int number1 = Integer.parseInt(num1.getText().toString());
        int number2 = Integer.parseInt(num2.getText().toString());
        //set value
        String resultString = "result: " + number1 + " + " + number2 + " = " + sum(number1, number2);
        result.setText(resultString);
    }
    public int sum(int a,int b) {
        return a+b;
    }
}
