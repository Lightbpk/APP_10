package bpk.light.app_10;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

public class TwoActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView textRandom;
    ImageView imageRandom;
    public static final String str = "qwertyuiopasdfghjklzxcvbnm";
    public static final String strTwoReg = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    public static final String strNum = "qwertyuiopasdfghjklzxcvbnm0123456789";
    public static final String strNumTwoReg = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
    public static final String strNumSym = "qwertyuiopasdfghjklzxcvbnm0123456789-=[];',./|";
    public static final String strNumSymTwoReg = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789-=[];',./|";
    int passLen;
    String[] Europa = {"Россия","Англия","Франция"};
    String[] Asia = {"Китай","Корея","Япония"};
    String[] Africa = {"Нигер","Нипал","Египет"};
    String[] America = {"США","Канада"};
    String[] Australia = {"Австралия"};
    String[] CapEuropa = {"Москва","Лондон","Париж"};
    String[] CapAsia = {"Пекин","Токио"};
    String[] CapAfrica = {"агагг","угучага","збзбзб"};
    String[] CapAmerica = {"Вашмнгтон"};
    String[] CapAustralia = {"Сиэтл"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        imageRandom = (ImageView) findViewById(R.id.imageRandom);
        textRandom = (TextView)findViewById(R.id.textRandom) ;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        passLen = sharedPreferences.getInt("PassLen",8);

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
            }
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
                    imageRandom.setImageResource(mapIndex[(int)Math.round(Math.random()*4)]);
                    imageRandom.setVisibility(View.VISIBLE);
                }
                break;
            }
            case 5: {
                switch (sharedPreferences.getInt("ContType",1)){
                    case 1:

                }
            }
        }

    }
}
