package mchehab.com.readsensordata


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


class AccelerometerDataFragment : Fragment(), SensorEventListener {

    lateinit var sensorManager: SensorManager
    lateinit var arrayAdapter: ArrayAdapter<String>
    val sensorData = mutableListOf<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_accelerometer_data, container, false)
        arrayAdapter = ArrayAdapter(activity!!, android.R.layout.simple_list_item_1, sensorData)
        val listView = view.findViewById<ListView>(R.id.listView)
        listView.adapter = arrayAdapter
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        sensorManager = context!!.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this@AccelerometerDataFragment, sensorManager.getDefaultSensor(Sensor
                .TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onDetach() {
        super.onDetach()
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
            val data = "x: ${event.values[0]}, y: ${event.values[1]}, z: ${event.values[2]}"
            sensorData.add(data)
            arrayAdapter.notifyDataSetChanged()
        }
    }

}
