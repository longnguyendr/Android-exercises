package fi.jamk.fragmentsexercise;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class DetailFragment extends Fragment {
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        showData();
        return rootView;
    }

    // show employee data
    public void showData() {
        SharedPreferences prefs = getActivity().getSharedPreferences(MainActivity.PREFS_NAME, 0);
        int index = prefs.getInt("index",0);

        // name
        TextView fullnameTextView = (TextView) rootView.findViewById(R.id.fullnameTextView);
        fullnameTextView.setText(EmployeesData.employees.get(index).lastname + ", " + EmployeesData.employees.get(index).firstname);

        // image
        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
        Drawable d = EmployeesData.employees.get(index).drawable;
        imageView.setImageDrawable(d);

        // info
        TextView infoTextView = (TextView) rootView.findViewById(R.id.infoTextView);
        String phone = "Phone: " + EmployeesData.employees.get(index).phone;
        String email = "Email: "+ EmployeesData.employees.get(index).email;
        infoTextView.setText(phone+"\n"+email);

        // text
        TextView textTextView = (TextView) rootView.findViewById(R.id.textTextView);
        textTextView.setText(EmployeesData.employees.get(index).text);
    }

}