package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonDot, buttonAC,
            buttonAdd, buttonSub, buttonMul, buttonDivision, buttonMod, buttonEqual, buttonQuit;

    ImageView imgViewUndo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 控件绑定


        button0 = (Button) findViewById(R.id.button_0);
        button1 = (Button) findViewById(R.id.button_1);
        button2 = (Button) findViewById(R.id.button_2);
        button3 = (Button) findViewById(R.id.button_3);
        button4 = (Button) findViewById(R.id.button_4);
        button5 = (Button) findViewById(R.id.button_5);
        button6 = (Button) findViewById(R.id.button_6);
        button7 = (Button) findViewById(R.id.button_7);
        button8 = (Button) findViewById(R.id.button_8);
        button9 = (Button) findViewById(R.id.button_9);
        buttonDot = (Button) findViewById(R.id.button_dot);

        buttonAC = (Button) findViewById(R.id.button_AC);
        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonSub = (Button) findViewById(R.id.button_subduction);
        buttonMul = (Button) findViewById(R.id.button_multiply);
        buttonDivision = (Button) findViewById(R.id.button_division);
        buttonMod = (Button) findViewById(R.id.button_mod);
        buttonEqual = (Button) findViewById(R.id.button_equal);
        buttonQuit = (Button) findViewById(R.id.button_close);     // 退出应用
        imgViewUndo = (ImageView) findViewById(R.id.imageView_Undo);  // 撤销输入


        

    }
}