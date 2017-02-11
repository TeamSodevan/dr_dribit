package in.sodevan.dr_dribit;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;

public class Patients extends ListActivity {

    // declare class variables
    private ArrayList<Item> m_parts = new ArrayList<Item>();
    private Runnable viewParts;
    private ItemAdapter m_adapter;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        // instantiate our ItemAdapter class
        m_adapter = new ItemAdapter(this, R.layout.list_item, m_parts);
        setListAdapter(m_adapter);

        // here we are defining our runnable thread.
        viewParts = new Runnable(){
            public void run(){
                handler.sendEmptyMessage(0);
            }
        };

        // here we call the thread we just defined - it is sent to the handler below.
        Thread thread =  new Thread(null, viewParts, "MagentoBackground");
        thread.start();
    }

    private Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            // create some objects
            // here is where you could also request data from a server
            // and then create objects from that data.
            m_parts.add(new Item("Rajeev Jha","22","100bpm","Male"));
            m_parts.add(new Item("Moulika","18","89bpm","Female"));

            m_adapter = new ItemAdapter(Patients.this, R.layout.list_item, m_parts);

            // display the list.
            setListAdapter(m_adapter);
        }
    };
}