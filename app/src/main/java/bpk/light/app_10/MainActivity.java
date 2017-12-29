package bpk.light.app_10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    RadioButton rbtnMap, rbtnCont;
    RadioGroup mainGroup, passGroup, mapGroup, contryTypeGroup, contrySelectGroup;
    CheckBox chkMap, chkCont;
    SeekBar seekNumVar, seekNumMin, seekNumMax, seekPassLen, seekMapMin, seekMapMax;
    EditText editNumVar, editNumMin, editNumMax, editPassLen, editNameText;
    LinearLayout layNum, layPass, layName, layMap, layCont;
    int  miniMap1,miniMap2,miniMap3,miniMap4;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String LL = "LightLog";
    Switch swBool, swPassTwoReg;
    ImageView viewMap;
    Button btnGen;
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
        seekMapMin = (SeekBar) findViewById(R.id.seekMapMin);
        seekMapMax = (SeekBar) findViewById(R.id.seekMapMax);
        seekPassLen = (SeekBar) findViewById(R.id.seekPassLen);
        editNumVar = (EditText) findViewById(R.id.editNumVar);
        editNumMin = (EditText) findViewById(R.id.editNumMin);
        editNumMax = (EditText) findViewById(R.id.editNumMax);
        editPassLen = (EditText) findViewById(R.id.editPassLen);
        editNameText = (EditText) findViewById(R.id.editNameText);
        layNum = (LinearLayout) findViewById(R.id.layNum);
        layPass = (LinearLayout) findViewById(R.id.layPass);
        layName = (LinearLayout) findViewById(R.id.layName);
        layMap = (LinearLayout) findViewById(R.id.layMap);
        layCont = (LinearLayout) findViewById(R.id.layCont);
        mainGroup = (RadioGroup) findViewById(R.id.mainGroup);
        passGroup = (RadioGroup) findViewById(R.id.passGroup);
        mapGroup = (RadioGroup) findViewById(R.id.mapGroup);
        contryTypeGroup = (RadioGroup) findViewById(R.id.contryTypeGroup);
        contrySelectGroup = (RadioGroup) findViewById(R.id.contrySelectGroup);
        viewMap = (ImageView) findViewById(R.id.viewMap);
        btnGen = (Button)findViewById(R.id.btnGen);
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
                        editor.putInt("typeRand",1);
                        editor.commit();
                        break;
                    case R.id.rbtnPass:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.VISIBLE);
                        layName.setVisibility(View.INVISIBLE);
                        layMap.setVisibility(View.INVISIBLE);
                        layCont.setVisibility(View.INVISIBLE);
                        editor.putInt("typeRand",2);
                        editor.commit();
                        break;
                    case R.id.rbtnName:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.INVISIBLE);
                        layName.setVisibility(View.VISIBLE);
                        layMap.setVisibility(View.INVISIBLE);
                        layCont.setVisibility(View.INVISIBLE);
                        editor.putInt("typeRand",3);
                        editor.commit();
                        break;
                    case R.id.rbtnMap:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.INVISIBLE);
                        layName.setVisibility(View.INVISIBLE);
                        layMap.setVisibility(View.VISIBLE);
                        layCont.setVisibility(View.INVISIBLE);
                        editor.putInt("typeRand",4);
                        editor.commit();
                        break;
                    case R.id.rbtnCont:
                        layNum.setVisibility(View.INVISIBLE);
                        layPass.setVisibility(View.INVISIBLE);
                        layName.setVisibility(View.INVISIBLE);
                        layMap.setVisibility(View.INVISIBLE);
                        layCont.setVisibility(View.VISIBLE);
                        editor.putInt("typeRand",5);
                        editor.commit();
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
                        editor.putInt("PassType",2);
                        editor.commit();
                        Log.d(LL,"PassChar true");
                        break;
                    case R.id.rbtnPassCustom:
                        editor.putInt("PassType",5);
                        editor.commit();
                        Log.d(LL,"PassCustom true");
                        break;
                    case R.id.rbtnPassNumChar:
                        editor.putInt("PassType",3);
                        editor.commit();
                        Log.d(LL,"PassNumChar true");
                        break;
                    case R.id.rbtnPassNumCharSym:
                        editor.putInt("PassType",4);
                        editor.commit();
                        Log.d(LL,"PassNumCharSym true");
                        break;
                    case R.id.rbtnPassGraf:
                        editor.putInt("PassType",6);
                        editor.commit();
                        Log.d(LL,"PassGraf true");
                        break;
                    case R.id.rbtnPassNum:
                        editor.putInt("PassType",1);
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
        //------------------------Name menu------------------------------------------
        editor.putString("Names",editNameText.getText().toString());
        editor.commit();
        //-----------------------Map menu-------------------------------------------
        mapGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case -1:
                        break;
                    case R.id.rbtnMapPict:
                        miniMap1 = R.drawable.vale;
                        miniMap2 = R.drawable.dam;
                        miniMap3 = R.drawable.korol;
                        miniMap4 = R.drawable.tuz;
                        seekMapMin.setMax(4);
                        seekMapMax.setMax(4);
                        editor.putInt("MapType", 3);
                        editor.commit();
                        break;
                    case R.id.rbtnMapNum:
                        miniMap1 = R.drawable.six;
                        miniMap2 = R.drawable.seven;
                        miniMap3 = R.drawable.eight;
                        miniMap4 = R.drawable.nine;
                        seekMapMin.setMax(5);
                        seekMapMax.setMax(5);
                        editor.putInt("MapType", 2);
                        editor.commit();
                        break;
                    case R.id.rbtnMapAll:
                        miniMap1 = R.drawable.six;
                        miniMap2 = R.drawable.seven;
                        miniMap3 = R.drawable.eight;
                        miniMap4 = R.drawable.nine;
                        seekMapMin.setMax(9);
                        seekMapMax.setMax(9);
                        editor.putInt("MapType", 1);
                        editor.commit();
                        break;
                }
            }
        });
        seekMapMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (seekMapMin.getProgress()){
                    case 0:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(miniMap1);
                        editor.putInt("MapMin",seekMapMin.getProgress());
                        editor.commit();
                        break;
                    case 1:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(miniMap2);
                        editor.putInt("MapMin",seekMapMin.getProgress());
                        editor.commit();
                        break;
                    case 2:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(miniMap3);
                        editor.putInt("MapMin",seekMapMin.getProgress());
                        editor.commit();
                        break;
                    case 3:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(miniMap4);
                        editor.putInt("MapMin",seekMapMin.getProgress());
                        editor.commit();
                        break;
                    case 4:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(R.drawable.ten);
                        editor.putInt("MapMin",seekMapMin.getProgress());
                        editor.commit();
                        break;
                    case 5:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(R.drawable.vale);
                        editor.putInt("MapMin",seekMapMin.getProgress());
                        editor.commit();
                        break;
                    case 6:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(R.drawable.dam);
                        editor.putInt("MapMin",seekMapMin.getProgress());
                        editor.commit();
                        break;
                    case 7:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(R.drawable.korol);
                        editor.putInt("MapMin",seekMapMin.getProgress());
                        editor.commit();
                        break;
                    case 8:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(R.drawable.tuz);
                        editor.putInt("MapMin",seekMapMin.getProgress());
                        editor.commit();
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                viewMap.setVisibility(View.INVISIBLE);
            }
        });
        seekMapMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (seekMapMax.getProgress()){
                    case 0:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(miniMap1);
                        editor.putInt("MapMax",seekMapMax.getProgress());
                        editor.commit();
                        break;
                    case 1:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(miniMap2);
                        editor.putInt("MapMax",seekMapMax.getProgress());
                        editor.commit();
                        break;
                    case 2:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(miniMap3);
                        editor.putInt("MapMax",seekMapMax.getProgress());
                        editor.commit();
                        break;
                    case 3:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(miniMap4);
                        editor.putInt("MapMax",seekMapMax.getProgress());
                        editor.commit();
                        break;
                    case 4:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(R.drawable.ten);
                        editor.putInt("MapMax",seekMapMax.getProgress());
                        editor.commit();
                        break;
                    case 5:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(R.drawable.vale);
                        editor.putInt("MapMax",seekMapMax.getProgress());
                        editor.commit();
                        break;
                    case 6:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(R.drawable.dam);editor.putInt("MapMax",seekMapMax.getProgress());
                        editor.commit();
                        break;
                    case 7:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(R.drawable.korol);
                        editor.putInt("MapMax",seekMapMax.getProgress());
                        editor.commit();
                        break;
                    case 8:
                        viewMap.setVisibility(View.VISIBLE);
                        viewMap.setImageResource(R.drawable.tuz);
                        editor.putInt("MapMax",seekMapMax.getProgress());
                        editor.commit();
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                viewMap.setVisibility(View.INVISIBLE);
            }
        });
        //-------------------Contry menu-----------------------
        contryTypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case -1:
                        break;
                    case R.id.rbtnContCont:
                        editor.putInt("ContType", 1);
                        editor.commit();
                        break;
                    case R.id.rbtnCap:
                        editor.putInt("ContType", 2);
                        editor.commit();
                        break;
                    case R.id.rbtnContCap:
                        editor.putInt("ContType", 3);
                        editor.commit();
                        break;
                }
            }
        });
        contrySelectGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case -1:
                        break;
                    case R.id.rbtnWorld:
                        editor.putInt("ContSelect", 1);
                        editor.commit();
                        break;
                    case R.id.rbtnEvropa:
                        editor.putInt("ContSelect", 2);
                        editor.commit();
                        break;
                    case R.id.rbtnAsia:
                        editor.putInt("ContSelect", 3);
                        editor.commit();
                        break;
                    case R.id.rbtnAfrica:
                        editor.putInt("ContSelect", 4);
                        editor.commit();
                        break;
                    case R.id.rbtnAmerica:
                        editor.putInt("ContSelect", 5);
                        editor.commit();
                        break;
                    case R.id.rbtnAustralia:
                        editor.putInt("ContSelect", 6);
                        editor.commit();
                        break;
                }
            }
        });
        //----------------------------------------------------------
        btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });
    }
}
