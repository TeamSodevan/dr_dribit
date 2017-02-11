package in.sodevan.dr_dribit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText doc_name;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doc_name=(EditText)findViewById(R.id.doc_name);
        login=(Button)findViewById(R.id.login);
        String name =doc_name.getText().toString();
        login.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        Intent intent=new Intent(getApplicationContext(),Patients.class);
        startActivity(intent);
        finish();
    }
}

