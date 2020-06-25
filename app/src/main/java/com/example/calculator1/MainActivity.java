package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView tvShow;
    double num=0;
    double saveNum=0;
    String massage="";
    String operator="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        tvShow=findViewById(R.id.tvShow);

    }

    public void onClick(View view) {
        Button btn=(Button)view;
        if (view.getId() == R.id.btnplus) {
            massage+="+";
            tvShow.setText(massage);
            saveNum=num;
            num=0;
            operator="+";
        }
      else   if (view.getId() == R.id.btnminus) {
           massage+="-";
            tvShow.setText(massage);
            saveNum=num;
            num=0;
            operator="-";
        }
       else if (view.getId() == R.id.btnmult) {
            massage+="*";
            tvShow.setText(massage);
            saveNum=num;
            num=0;
            operator="*";
        }
       else if (view.getId() == R.id.btndiv) {
            massage+="/";
            tvShow.setText(massage);
            saveNum=num;
            num=0;
            operator="/";
        }
      else   if (view.getId()==R.id.btnclean){
            massage="";
            tvShow.setText(massage);
            saveNum=0;
            num=0;
            operator="";
    }
      else {
          num=(num*10)+ Double.parseDouble(btn.getText().toString());
          massage+=btn.getText().toString();
          tvShow.setText(massage);
        }
    }

    public void resultOnClick(View view) {
        double total=0;
        if (operator.equals("+")){
            total=saveNum + num;
        }
        if (operator.equals("-")){
          total=saveNum - num;
        }
        if (operator.equals("*")){
            total=saveNum * num;
        }
        if (operator.equals("/")){
            total=saveNum / num;
        }
        if (operator.equals("")){
            total=0;
        }
        if ((total*10)%10==0) {
            tvShow.setText(massage + " = " + (int)total);
        }

        else {
            DecimalFormat decimalFormat=new DecimalFormat("0.0000");
            tvShow.setText(massage + " = " + decimalFormat.format(total)+" ... ");
        }
        num=0;
        saveNum=0;
        massage="";
    }
}
