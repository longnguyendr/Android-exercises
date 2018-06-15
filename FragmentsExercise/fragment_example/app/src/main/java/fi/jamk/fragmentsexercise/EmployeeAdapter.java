package fi.jamk.fragmentsexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class EmployeeAdapter extends ArrayAdapter<EmployeesData.Employee> {
    private Context context;
    private ArrayList<EmployeesData.Employee> employees;

    public EmployeeAdapter(Context context, ArrayList<EmployeesData.Employee> employees) {
        super(context,0,employees);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EmployeesData.Employee employee = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_employee,parent,false);
        }
        TextView lastnameTextView = (TextView) convertView.findViewById(R.id.lastnameTextView);
        TextView firstnameTextView = (TextView) convertView.findViewById(R.id.firstnameTextView);
        lastnameTextView.setText(employee.lastname);
        firstnameTextView.setText(employee.firstname);
        return convertView;
    }
}