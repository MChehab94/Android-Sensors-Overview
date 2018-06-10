package mchehab.com.readsensordata

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class SensorsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sensors, container, false)
        val arrayAdapter = ArrayAdapter<String>(activity!!.applicationContext, android.R.layout
                .simple_list_item_1, getListSensors())
        val listView = view.findViewById<ListView>(R.id.listView)
        listView.adapter = arrayAdapter
        return view
    }

    private fun getListSensors(): List<String>{
        val sensorManager = activity?.applicationContext?.getSystemService(Context.SENSOR_SERVICE)
                as SensorManager
        val sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL)
        val sensorsListNames = mutableListOf<String>()
        for(sensor in sensorsList){
            sensorsListNames.add(sensor.name)
        }
        return sensorsListNames
    }

}
