package fi.jamk.launchmap;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ShowMap(View view) throws InterruptedException {
        //find ele and parse to double values
        EditText latView = (EditText) findViewById(R.id.lat);
        EditText lngView = (EditText) findViewById(R.id.lng);
        double lat = Double.parseDouble(latView.getText().toString());
        double lng = Double.parseDouble(lngView.getText().toString());
        String text = "location: " + lat + ", " + lng;
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        Thread.sleep(1000);
        ShowMapInApp(lat, lng);
    }

    public void ShowMapInApp(double lat, double lng){
        //show map
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:"+lat+","+lng));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}
