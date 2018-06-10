
package mchehab.com.java;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SensorsFragment extends Fragment {

    public SensorsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sensors, container, false);
        ListView listView = view.findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout
                .simple_list_item_1, getListSensors());
        listView.setAdapter(arrayAdapter);
        return view;
    }

    private List<String> getListSensors(){
        SensorManager sensorManager = (SensorManager) getActivity().getApplicationContext()
                .getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> listSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<String> listSensorsNames = new ArrayList<>();
        for(Sensor sensor:listSensors){
            listSensorsNames.add(sensor.getName());
        }
        return listSensorsNames;
    }
}