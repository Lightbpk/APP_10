package bpk.light.app_10;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    RadioButton rbtnMap, rbtnCont;
    RadioGroup mainGroup;
    CheckBox chkMap, chkCont;
    SeekBar seekNumVar;
    EditText editNumVar, editNumMin, editNumMax;
    LinearLayout layNum, layPass, layName, layMap, layCont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbtnMap =(RadioButton)findViewById(R.id.rbtnMap);
        rbtnCont =(RadioButton)findViewById(R.id.rbtnCont);
        chkMap = (CheckBox) findViewById(R.id.chkMap);
        chkCont = (CheckBox) findViewById(R.id.chkCont);
        seekNumVar = (SeekBar) findViewById(R.id.seekNumVar);
        editNumVar = (EditText) findViewById(R.id.editNumVar);
        editNumMin = (EditText) findViewById(R.id.editMinNum);
        editNumMax = (EditText) findViewById(R.id.editMaxNum);
        layNum = (LinearLayout) findViewById(R.id.layNum);
        layPass = (LinearLayout) findViewById(R.id.layPass);
        layName = (LinearLayout) findViewById(R.id.layName);
        layMap = (LinearLayout) findViewById(R.id.layMap);
        layCont = (LinearLayout) findViewById(R.id.layCont);
        mainGroup = (RadioGroup) findViewById(R.id.mainGroup);

        mainGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case -1:
                        break;
                    case R.id.rbtnNum:
                        layNum.setVisibility(View.VISIBLE);
                        layPass.setVisibility(View.INVISIBLE);
                        layName.setVisibility(View.INVISIBLE);
                        layMap.setVisibility(View.INVISIBLE);
                        layCont.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rbtnPass:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.VISIBLE);
                        layName.setVisibility(View.INVISIBLE);
                        layMap.setVisibility(View.INVISIBLE);
                        layCont.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rbtnName:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.INVISIBLE);
                        layName.setVisibility(View.VISIBLE);
                        layMap.setVisibility(View.INVISIBLE);
                        layCont.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rbtnMap:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.INVISIBLE);
                        layName.setVisibility(View.INVISIBLE);
                        layMap.setVisibility(View.VISIBLE);
                        layCont.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.rbtnCont:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.INVISIBLE);
                        layName.setVisibility(View.INVISIBLE);
                        layMap.setVisibility(View.INVISIBLE);
                        layCont.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        chkMap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    rbtnMap.setEnabled(true);
                }
                else{
                    rbtnMap.setEnabled(false);
                }
            }
        });
        chkCont.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    rbtnCont.setEnabled(true);
                }
                else{
                    rbtnCont.setEnabled(false);
                }
            }
        });
    }
}
