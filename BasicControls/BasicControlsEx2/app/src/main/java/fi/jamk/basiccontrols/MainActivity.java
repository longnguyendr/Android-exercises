package fi.jamk.basiccontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initiate an auto complete text view
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.username); // add stings to control
        ArrayAdapter<String> AAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_dropdown_item_1line, new String[] {"Pasi","Juha","Kari","Jouni","Esa","Hannu"});
        actv.setAdapter(AAdapter);
    }
    public void BtnClicked(View view) {
        //find the username field and password field
        AutoCompleteTextView usernameView = (AutoCompleteTextView) findViewById(R.id.username);
        EditText passwordView = (EditText) findViewById(R.id.password);
        //get value
        String username = usernameView.getText().toString();
        String password = passwordView.getText().toString();
        String text = username + " " + password;
        //show Toast
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
}
