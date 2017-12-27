package bpk.light.app_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    RadioButton rbtnNum, rbtnPass, rbtnName, rbtnMap, rbtnCont;
    CheckBox chkMap, chkCont;
    SeekBar seekNumVar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbtnNum = (RadioButton) findViewById(R.id.rbtnNum);
        rbtnPass = (RadioButton) findViewById(R.id.rbtnPass);
        rbtnName = (RadioButton) findViewById(R.id.rbtnName);
        rbtnMap = (RadioButton) findViewById(R.id.rbtnMap);
        rbtnCont = (RadioButton) findViewById(R.id.rbtnCont);
        chkMap = (CheckBox) findViewById(R.id.chkMap);
        chkCont = (CheckBox) findViewById(R.id.chkCont);
        seekNumVar = (SeekBar) findViewById(R.id.seekNumVar);
    }
}
