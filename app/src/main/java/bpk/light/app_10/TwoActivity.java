package bpk.light.app_10;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView textRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        textRandom = (TextView)findViewById(R.id.textRandom) ;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        switch ( sharedPreferences.getInt("typeRand",1)){
            case 1:{
                if(!sharedPreferences.getBoolean("NumBool",false)){
                    int intRand =  (int)Math.round(Math.random()* (sharedPreferences.getInt("NumMax",10000)- sharedPreferences.getInt("NumMin",1)));
                    textRandom.setText(""+intRand);
                }
                else{
                    double dobleRand = Math.random()* (sharedPreferences.getInt("NumMax",10000)- sharedPreferences.getInt("NumMin",1));
                    textRandom.setText(""+dobleRand);
                }
            }
        }

    }
}
