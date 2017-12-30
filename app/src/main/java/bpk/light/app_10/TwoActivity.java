package bpk.light.app_10;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.UUID;

public class TwoActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView textRandom;
    ImageView imageRandom;
    ConstraintLayout lay2;
    public static final String str = "qwertyuiopasdfghjklzxcvbnm";
    public static final String strTwoReg = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    public static final String strNum = "qwertyuiopasdfghjklzxcvbnm0123456789";
    public static final String strNumTwoReg = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
    public static final String strNumSym = "qwertyuiopasdfghjklzxcvbnm0123456789-=[];',./|";
    public static final String strNumSymTwoReg = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789-=[];',./|";
    int passLen;
    String[] Europa = {"Россия","Англия","Франция"};
    String[] Asia = {"Китай","Корея","Япония"};
    String[] Africa = {"Нигер","Нипал","Мали"};
    String[] America = {"США","Канада","Мексика"};
    String[] Australia = {"Австралия"};
    String[] CapEuropa = {"Москва","Лондон","Париж"};
    String[] CapAsia = {"Пекин","Токио","Астана"};
    String[] CapAfrica = {"Абу-даби","Абуджа","Ниамей"};
    String[] CapAmerica = {"Вашингтон","Мехико","Оттава"};
    String[] CapAustralia = {"Сиэтл"};
    String[][] World = {Europa,Asia,Africa,America,Australia,CapEuropa,CapAsia,CapAfrica,CapAmerica,CapAustralia};
    TextView[] randTextMass;
    int k;
    int var;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        lay2= (ConstraintLayout) findViewById(R.id.lay2);
        ConstraintLayout.LayoutParams viewParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        imageRandom = (ImageView) findViewById(R.id.imageRandom);
        textRandom = (TextView)findViewById(R.id.textRandom) ;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        passLen = sharedPreferences.getInt("PassLen",8);
        var = sharedPreferences.getInt("NumVar",1);
        k =0;
        switch ( sharedPreferences.getInt("typeRand",1)){
            case 1:{
                if(!sharedPreferences.getBoolean("NumBool",false)){
                        int intRand =  (int)Math.round(Math.random()* (sharedPreferences.getInt("NumMax",10000)- sharedPreferences.getInt("NumMin",1)));
                        textRandom.setText("" + intRand);
                }
                else{
                    double dobleRand = Math.random()* (sharedPreferences.getInt("NumMax",10000)- sharedPreferences.getInt("NumMin",1));
                    textRandom.setText(""+dobleRand);
                }
                break;
            }
            case 2:{
                switch (sharedPreferences.getInt("PassType",1)){
                    case 1:
                        int intRand =  (int)Math.round(Math.random()* (sharedPreferences.getInt("NumMax",10000)- sharedPreferences.getInt("NumMin",1)));
                        textRandom.setText(""+intRand);
                        break;
                    case 2:
                        if(!sharedPreferences.getBoolean("PassTwoReg",false)){
                            String strOut="";
                                 for(int i =0 ; i< passLen ; i++){
                                    strOut = strOut+str.charAt((int)(Math.round(Math.random()*str.length()-1)));
                                 }
                            textRandom.setText(strOut);
                        }
                        else{
                            String strOut="";
                            for(int i =0 ; i< passLen ; i++){
                                strOut = strOut+strTwoReg.charAt((int)(Math.round(Math.random()*strTwoReg.length()-1)));
                            }
                            textRandom.setText(strOut);
                        }
                        break;
                    case 3:
                        if(!sharedPreferences.getBoolean("PassTwoReg",false)){
                            String strOut="";
                            for(int i =0 ; i< passLen ; i++){
                                strOut = strOut+strNum.charAt((int)(Math.round(Math.random()*strNum.length()-1)));
                            }
                            textRandom.setText(strOut);
                        }
                        else {
                            String strOut="";
                            for(int i =0 ; i< passLen ; i++){
                                strOut = strOut+strNumTwoReg.charAt((int)(Math.round(Math.random()*strNumTwoReg.length()-1)));
                            }
                            textRandom.setText(strOut);
                        }
                        break;
                    case 4:{
                        if(!sharedPreferences.getBoolean("PassTwoReg",false)){
                            String strOut="";
                            for(int i =0 ; i< passLen ; i++){
                                strOut = strOut+strNumSym.charAt((int)(Math.round(Math.random()*strNumSym.length()-1)));
                            }
                            textRandom.setText(strOut);
                        }
                        else {
                            String strOut="";
                            for(int i =0 ; i< passLen ; i++){
                                strOut = strOut+strNumSymTwoReg.charAt((int)(Math.round(Math.random()*strNumSymTwoReg.length()-1)));
                            }
                            textRandom.setText(strOut);
                        }
                        break;
                    }


                }
            }
            break;
            case 3:{
                String[] str1 = (sharedPreferences.getString("Names","")).split(",");
                textRandom.setText(str1[(int)Math.round(Math.random()*(str1.length-1))]);
                imageRandom.setVisibility(View.INVISIBLE);
            }
            break;
            case 4:{
                int[] mapIndex = {R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten,R.drawable.vale,R.drawable.dam,R.drawable.korol,R.drawable.tuz};
                if(sharedPreferences.getInt("MapType",1)==1){
                    imageRandom.setImageResource(mapIndex[(int)Math.round(Math.random()*(mapIndex.length-1))]);
                    imageRandom.setVisibility(View.VISIBLE);
                }
                else if(sharedPreferences.getInt("MapType",1)==2){
                    imageRandom.setImageResource(mapIndex[(int)Math.round(Math.random()*(mapIndex.length-5))]);
                    imageRandom.setVisibility(View.VISIBLE);
                }
                else if(sharedPreferences.getInt("MapType",1)==3){
                    imageRandom.setImageResource(mapIndex[5+(int)Math.round(Math.random()*3)]);
                    imageRandom.setVisibility(View.VISIBLE);
                }

            }
            break;
            case 5: {

                        if(sharedPreferences.getInt("ContType",1)==1){
                            switch(sharedPreferences.getInt("ContSelect",1)){
                                case 1:
                                    int j =(int)Math.round(Math.random()*4);
                                    textRandom.setText(World[j][(int)Math.round(Math.random()*(World[j].length-1))]);
                                    break;
                                case 2:
                                    textRandom.setText(World[0][(int)Math.round(Math.random()*(World[0].length-1))]);
                                    break;
                                case 3:
                                    textRandom.setText(World[1][(int)Math.round(Math.random()*(World[1].length-1))]);
                                    break;
                                case 4:
                                    textRandom.setText(World[2][(int)Math.round(Math.random()*(World[2].length-1))]);
                                    break;
                                case 5:
                                    textRandom.setText(World[3][(int)Math.round(Math.random()*(World[3].length-1))]);
                                    break;
                                case 6:
                                    textRandom.setText(World[4][(int)Math.round(Math.random()*(World[4].length-1))]);
                                    break;
                            }
                        }
                        else if(sharedPreferences.getInt("ContType",1)==2){
                            switch(sharedPreferences.getInt("ContSelect",1)){
                                case 1:
                                    int j =5+(int)Math.round((Math.random()*5)-1);
                                    textRandom.setText(World[j][(int)Math.round(Math.random()*(World[j].length-1))]);
                                    break;
                                case 2:
                                    textRandom.setText(World[5][(int)Math.round(Math.random()*(World[5].length-1))]);
                                    break;
                                case 3:
                                    textRandom.setText(World[6][(int)Math.round(Math.random()*(World[6].length-1))]);
                                    break;
                                case 4:
                                    textRandom.setText(World[7][(int)Math.round(Math.random()*(World[7].length-1))]);
                                    break;
                                case 5:
                                    textRandom.setText(World[8][(int)Math.round(Math.random()*(World[8].length-1))]);
                                    break;
                                case 6:
                                    textRandom.setText(World[9][(int)Math.round(Math.random()*(World[9].length-1))]);
                                    break;
                            }
                        }
                        else if(sharedPreferences.getInt("ContType",1)==3){
                            Random rand = new Random();
                            boolean bol;
                            switch(sharedPreferences.getInt("ContSelect",2)){
                                case 1:

                                    int j =(int)Math.round(Math.random()*9);
                                    textRandom.setText(World[j][(int)Math.round(Math.random()*(World[j].length-1))]);
                                    break;
                                case 2:
                                    bol = rand.nextBoolean();
                                    if(bol) j=0;
                                    else j=5;
                                    textRandom.setText(World[j][(int)Math.round(Math.random()*(World[j].length-1))]);
                                    break;
                                case 3:
                                    bol = rand.nextBoolean();
                                    if(bol) j=1;
                                    else j=6;
                                    textRandom.setText(World[j][(int)Math.round(Math.random()*(World[j].length-1))]);
                                    break;
                                case 4:
                                    bol = rand.nextBoolean();
                                    if(bol) j=2;
                                    else j=7;
                                    textRandom.setText(World[j][(int)Math.round(Math.random()*(World[j].length-1))]);
                                    break;
                                case 5:
                                    bol = rand.nextBoolean();
                                    if(bol) j=3;
                                    else j=8;
                                    textRandom.setText(World[j][(int)Math.round(Math.random()*(World[j].length-1))]);
                                    break;
                                case 6:
                                    bol = rand.nextBoolean();
                                    if(bol) j=4;
                                    else j=9;
                                    textRandom.setText(World[j][(int)Math.round(Math.random()*(World[j].length-1))]);
                                    break;
                            }
                        }

            }
            break;
        }
    }
    public class randMulti{

    }
}
