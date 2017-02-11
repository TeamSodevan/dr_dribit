package in.sodevan.dr_dribit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.HashMap;

public class patientinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientinfo);
        Intent intent = getIntent();
        HashMap<String, Integer> hashMap = (HashMap<String, Integer>)intent.getSerializableExtra("map");
        Log.v("HashMapTest", String.valueOf(hashMap.get("T1")));

        GraphView graph= (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series=new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0,hashMap.get("T1")),
                new DataPoint(1,hashMap.get("T2")),
                new DataPoint(2,hashMap.get("T3")),
                new DataPoint(3,hashMap.get("T4")),
                new DataPoint(4,hashMap.get("T5")),
                new DataPoint(5,hashMap.get("T6")),
                new DataPoint(6,hashMap.get("T7")),
                new DataPoint(7,hashMap.get("T8")),
                new DataPoint(8,hashMap.get("T9")),
                new DataPoint(9,hashMap.get("T10")),
                new DataPoint(10,hashMap.get("T11")),
                new DataPoint(11,hashMap.get("T12")),
                new DataPoint(12,hashMap.get("T13")),
                new DataPoint(13,hashMap.get("T14")),
                new DataPoint(14,hashMap.get("T15")),
                new DataPoint(15,hashMap.get("T16")),
                new DataPoint(16,hashMap.get("T17")),
                new DataPoint(17,hashMap.get("T18")),
                new DataPoint(18,hashMap.get("T19"))
        });
        graph.addSeries(series);
    }
}
