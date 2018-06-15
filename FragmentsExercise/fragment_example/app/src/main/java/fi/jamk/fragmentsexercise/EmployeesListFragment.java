package fi.jamk.fragmentsexercise;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EmployeesListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // get view
        View view = inflater.inflate(R.layout.fragment_employeelist,container, false);
        // custom adapter
        EmployeeAdapter ea = new EmployeeAdapter(getActivity(),EmployeesData.employees);
        setListAdapter(ea);
        // return view
        return view;
    }

    // listener to pass data to activity
    private OnItemSelectedListener listener;

    public interface OnItemSelectedListener {
        public void onItemSelected(int index);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenet EmployeesListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(listView, view, position, id);
        // Send data to Activity
        listener.onItemSelected(position);
    }


}
