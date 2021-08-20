package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonDot, buttonAC,
            buttonAdd, buttonSub, buttonMul, buttonDivision, buttonMod, buttonEqual, buttonQuit;

    ImageView buttonUndo;


    private ArrayList<Button> buttonArrayList = new ArrayList<>(Arrays.asList(button0, button1, button2, button3,
            button4, button5, button6, button7, button8, button9));

    private StringBuilder currentInputNum = new StringBuilder();
    private ArrayList<Integer> numsList = new ArrayList<Integer>();
    private ArrayList<String> operatorList = new ArrayList<>();
    private Boolean isNumStart = true;

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
        buttonUndo = (ImageView) findViewById(R.id.imageView_Undo);  // 撤销输入

        // 清空
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAllButtonClicked(view);
            }
        });

        // 撤销输入
        buttonUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                undoButtonClicked(view);
            }
        });

        // 乘法
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorButtonClicked(view);
            }
        });

        // 除法
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorButtonClicked(view);
            }
        });

        // 加法
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorButtonClicked(view);
            }
        });

        // 减法
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorButtonClicked(view);
            }
        });

        // 数字 0
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonClicked(view);
            }
        });

        // 数字 1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberButtonClicked(view);
            }
        });

        for (Button it : buttonArrayList
        ) {
            it.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    numberButtonClicked(view);
                }
            });
        }


    }

    private void operatorButtonClicked(View view) {
    }

    private void undoButtonClicked(View view) {
    }

    private void clearAllButtonClicked(View view) {
    }

    // 数字按键
    private void numberButtonClicked(View view) {

    }
}