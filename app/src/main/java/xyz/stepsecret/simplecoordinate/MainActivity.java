package xyz.stepsecret.simplecoordinate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import xyz.stepsecret.findcoordinate.Find;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2,edt3,edt4,edt5;
    TextView tv1,tv2,tv3;
    Button btn1,btn2;
    Double Lat_F,Long_F,Lat_S,Long_S,dis,dis2;

    Find find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        find = new Find();

        edt1 = (EditText) findViewById(R.id.editText2);
        edt2 = (EditText) findViewById(R.id.editText);
        edt3 = (EditText) findViewById(R.id.editText3);
        edt4 = (EditText) findViewById(R.id.editText4);
        edt5 = (EditText) findViewById(R.id.editText5);

        tv1 = (TextView) findViewById(R.id.textView3);
        tv2 = (TextView) findViewById(R.id.textView4);
        tv3 = (TextView) findViewById(R.id.textView6);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Lat_F = Double.parseDouble(edt1.getText().toString());
                Long_F = Double.parseDouble(edt2.getText().toString());
                Lat_S = Double.parseDouble(edt3.getText().toString());
                Long_S = Double.parseDouble(edt4.getText().toString());

                dis = find.finddistance(Lat_F,Long_F,Lat_S,Long_S);

                tv3.setText("Distance : "+dis);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edt5.getText().length() > 0)
                {
                    Lat_F = Double.parseDouble(edt1.getText().toString());
                    Long_F = Double.parseDouble(edt2.getText().toString());
                    Lat_S = Double.parseDouble(edt3.getText().toString());
                    Long_S = Double.parseDouble(edt4.getText().toString());
                    dis2 = Double.parseDouble(edt5.getText().toString());

                    find.NewCoordinate(Lat_F,Long_F,Lat_S,Long_S,dis2);

                    tv1.setText(""+find.getLatitude());
                    tv2.setText(""+find.getLongitude());
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Plese input distance",
                             Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}
