package bpk.light.app_10;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    RadioButton rbtnMap, rbtnCont;
    RadioGroup mainGroup, passGroup;
    CheckBox chkMap, chkCont;
    SeekBar seekNumVar, seekNumMin, seekNumMax, seekPassLen;
    EditText editNumVar, editNumMin, editNumMax, editPassLen;
    LinearLayout layNum, layPass, layName, layMap, layCont;
    int typeRand = 0;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String LL = "LightLog";
    Switch swBool, swPassTwoReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
        rbtnMap =(RadioButton)findViewById(R.id.rbtnMap);
        rbtnCont =(RadioButton)findViewById(R.id.rbtnCont);
        chkMap = (CheckBox) findViewById(R.id.chkMap);
        chkCont = (CheckBox) findViewById(R.id.chkCont);
        swBool = (Switch)findViewById(R.id.swBool);
        swPassTwoReg = (Switch)findViewById(R.id.swPassTwoReg);
        seekNumVar = (SeekBar) findViewById(R.id.seekNumVar);
        seekNumMin = (SeekBar) findViewById(R.id.seekNumMin);
        seekNumMax = (SeekBar) findViewById(R.id.seekNumMax);
        seekPassLen = (SeekBar) findViewById(R.id.seekPassLen);
        editNumVar = (EditText) findViewById(R.id.editNumVar);
        editNumMin = (EditText) findViewById(R.id.editNumMin);
        editNumMax = (EditText) findViewById(R.id.editNumMax);
        editPassLen = (EditText) findViewById(R.id.editPassLen);
        layNum = (LinearLayout) findViewById(R.id.layNum);
        layPass = (LinearLayout) findViewById(R.id.layPass);
        layName = (LinearLayout) findViewById(R.id.layName);
        layMap = (LinearLayout) findViewById(R.id.layMap);
        layCont = (LinearLayout) findViewById(R.id.layCont);
        mainGroup = (RadioGroup) findViewById(R.id.mainGroup);
        passGroup = (RadioGroup) findViewById(R.id.passGroup);
//------------------------Main option---------------------------------------------------------
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
                        typeRand = 1;
                        break;
                    case R.id.rbtnPass:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.VISIBLE);
                        layName.setVisibility(View.INVISIBLE);
                        layMap.setVisibility(View.INVISIBLE);
                        layCont.setVisibility(View.INVISIBLE);
                        typeRand = 2;
                        break;
                    case R.id.rbtnName:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.INVISIBLE);
                        layName.setVisibility(View.VISIBLE);
                        layMap.setVisibility(View.INVISIBLE);
                        layCont.setVisibility(View.INVISIBLE);
                        typeRand = 3;
                        break;
                    case R.id.rbtnMap:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.INVISIBLE);
                        layName.setVisibility(View.INVISIBLE);
                        layMap.setVisibility(View.VISIBLE);
                        layCont.setVisibility(View.INVISIBLE);
                        typeRand = 4;
                        break;
                    case R.id.rbtnCont:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.INVISIBLE);
                        layName.setVisibility(View.INVISIBLE);
                        layMap.setVisibility(View.INVISIBLE);
                        layCont.setVisibility(View.VISIBLE);
                        typeRand = 5;
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


        seekNumVar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editNumVar.setText(""+seekNumVar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        editNumVar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int var = Integer.parseInt(editNumVar.getText().toString());
                    seekNumVar.setProgress(var);
                    editor.putInt("NumVar",var);
                    editor.commit();
                    Log.d(LL,"NumVar = "+var);
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        });
        //--------------------------------Number menu---------------------------------------

        seekNumMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editNumMin.setText(""+seekNumMin.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        editNumMin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int var = Integer.parseInt(editNumMin.getText().toString());
                    seekNumMin.setProgress(var);
                    editor.putInt("NumMin",var);
                    editor.commit();
                    Log.d(LL,"NumMin = "+var);
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        });
        seekNumMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editNumMax.setText(""+seekNumMax.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        editNumMax.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int var = Integer.parseInt(editNumMax.getText().toString());
                    seekNumMax.setProgress(var);
                    editor.putInt("NumMax",var);
                    editor.commit();
                    Log.d(LL,"NumMax = "+var);
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        });
        swBool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swBool.isChecked()){
                    editor.putBoolean("NumBool",true);
                    editor.commit();
                    Log.d(LL,"NumBool = true");
                }
                else{
                    editor.putBoolean("NumBool",false);
                    editor.commit();
                    Log.d(LL,"NumBool = false");
                }
            }
        });
        //------------------------------Password menu---------------------------
        seekPassLen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editPassLen.setText(""+seekPassLen.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        editPassLen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int var = Integer.parseInt(editPassLen.getText().toString());
                    seekPassLen.setProgress(var);
                    editor.putInt("PassLen",var);
                    editor.commit();
                    Log.d(LL,"PassLen = "+var);
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        });
        passGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case -1:
                        break;
                    case R.id.rbtnPassChar:
                        editor.putBoolean("PassChar",true);
                        editor.putBoolean("PassCustom",false);
                        editor.putBoolean("PassNumChar",false);
                        editor.putBoolean("PassNumCharSym",false);
                        editor.putBoolean("PassGraf",false);
                        editor.commit();
                        Log.d(LL,"PassChar true");
                        break;
                    case R.id.rbtnPassCustom:
                        editor.putBoolean("PassChar",false);
                        editor.putBoolean("PassCustom",true);
                        editor.putBoolean("PassNumChar",false);
                        editor.putBoolean("PassNumCharSym",false);
                        editor.putBoolean("PassGraf",false);
                        editor.commit();
                        Log.d(LL,"PassCustom true");
                        break;
                    case R.id.rbtnPassNumChar:
                        editor.putBoolean("PassChar",false);
                        editor.putBoolean("PassCustom",false);
                        editor.putBoolean("PassNumChar",true);
                        editor.putBoolean("PassNumCharSym",false);
                        editor.putBoolean("PassGraf",false);
                        editor.commit();
                        Log.d(LL,"PassNumChar true");
                        break;
                    case R.id.rbtnPassNumCharSym:
                        editor.putBoolean("PassChar",false);
                        editor.putBoolean("PassCustom",false);
                        editor.putBoolean("PassNumChar",false);
                        editor.putBoolean("PassNumCharSym",true);
                        editor.putBoolean("PassGraf",false);
                        editor.commit();
                        Log.d(LL,"PassNumCharSym true");
                        break;
                    case R.id.rbtnPassGraf:
                        editor.putBoolean("PassChar",false);
                        editor.putBoolean("PassCustom",false);
                        editor.putBoolean("PassNumChar",false);
                        editor.putBoolean("PassNumCharSym",false);
                        editor.putBoolean("PassGraf",true);
                        editor.commit();
                        Log.d(LL,"PassGraf true");
                        break;
                }
            }
        });
        swPassTwoReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swPassTwoReg.isChecked()){
                    editor.putBoolean("PassTwoReg",true);
                    editor.commit();
                    Log.d(LL,"PassTwoReg = true");
                }
                else{
                    editor.putBoolean("PassTwoReg",false);
                    editor.commit();
                    Log.d(LL,"PassTwoReg = false");
                }
            }
        });
    }
}
