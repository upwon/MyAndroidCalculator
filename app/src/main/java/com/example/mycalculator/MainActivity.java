package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonDot, buttonAC,
            buttonAdd, buttonSub, buttonMul, buttonDivision, buttonMod, buttonEqual, buttonQuit;

    ImageView buttonUndo;
    TextView textViewInput, textViewResult;

    private ArrayList<Button> buttonArrayList = new ArrayList<>();

    private StringBuilder currentInputNum = new StringBuilder();
    private ArrayList<Integer> numsList = new ArrayList<Integer>();
    private ArrayList<String> operatorList = new ArrayList<>();
    private Boolean isNumStart = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 控件绑定
        textViewInput = findViewById(R.id.textView_input);
        textViewResult = findViewById(R.id.textView_result);

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


        buttonArrayList.addAll(Arrays.asList(button0, button1, button2, button3,
                button4, button5, button6, button7, button8, button9));


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

        // 退出
        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"即将退出",Toast.LENGTH_LONG).show();
                finish();
            }
        });

//        // 数字 0
//        button0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                numberButtonClicked(view);
//            }
//        });
//
//        // 数字 1
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                numberButtonClicked(view);
//            }
//        });

        // 数字 0 - 9
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

    // 运算符 + - * / % 操作
    private void operatorButtonClicked(View view) {
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        } else {

            //将view强制转化为 Button
            Button btn = (Button) view;

            // 保存运算符
            operatorList.add(btn.getText().toString());

            // 改变标记 接下来输入的将是数字
            isNumStart = true;

            currentInputNum.delete(0, currentInputNum.length());
            freshUI();

        }

    }

    // 数字按键操作
    private void numberButtonClicked(View view) {

        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        } else {
            //将view强制转化为 Button
            Button btn = (Button) view;
            currentInputNum.append(btn.getText());

            if (isNumStart) {
                // 输入一个新的数字，添加至数组中
                numsList.add(Integer.valueOf(btn.getText().toString()));

                // 更改状态 即 已经不是一个数字的开始了
                isNumStart = false;

            } else {
//                numsList[numsList.size()-1]=Integer.parseInt(currentInputNum.toString()) ;
                // 第一个参数为索引位置，第二个为要修改的值
                numsList.set(numsList.size() - 1, Integer.parseInt(currentInputNum.toString()));

            }

        }

        freshUI();
        calculate();
    }


    // 撤销
    private void undoButtonClicked(View view) {

        // 需要判断要撤销的是数字还是我们得运算符
        if (numsList.size() > operatorList.size()) {
            // 撤销数字
            if (numsList.size() > 0) {
                numsList.remove(numsList.size() - 1);
                isNumStart = true;
                currentInputNum.delete(0, currentInputNum.length());
            }
        } else {
            // 撤销运算符
            if (operatorList.size() > 0) {
                operatorList.remove(operatorList.size() - 1);
                isNumStart = false;
                if (numsList.size() > 0) {
                    currentInputNum.append(numsList.get(currentInputNum.length()));  // bug 原为 .length()-1
                }
            }
        }

        freshUI();
        calculate();
    }

    // 清空
    private void clearAllButtonClicked(View view) {
        textViewInput.setText("");
        textViewResult.setText("");
        currentInputNum.delete(0, currentInputNum.length());
        numsList.clear();
        operatorList.clear();
        isNumStart = true;

    }

    private void calculate() {
        if (numsList.size() > 0) {
            int i = 0;

            // 记录第一个运算数
            float param1 = numsList.get(0).floatValue();
            float param2 = 0.0f;

            if (operatorList.size() > 0) {

                while (true) {

                    // 获取i对应的运算符
                    String operator = operatorList.get(i);

                    // 判断是不是乘除运算
                    if (operator.equals("x") || operator.equals("/")) {
                        // 乘除直接运算
                        // 找到第二个运算数
                        if (i + 1 < numsList.size()) {
                            param2 = numsList.get(i + 1);

                            // 运算
                            param1 = realCalculate(param1, operator, param2);
                        }
                    } else {
                        //判断是不是最后一个 或者 后面不是乘除
                        if (i == operatorList.size() - 1 ||
                                (!operatorList.get(i + 1).equals("x") && !operatorList.get(i + 1).equals("/"))) {
                            //可以直接运算
                            if (i < numsList.size() - 1) {
                                param2 = numsList.get(i + 1);
                                param1 = realCalculate(param1, operator, param2);
                            }
                        } else {
                            // 后面有更高优先级
                            int j = i + 1;
                            float mparam1 = numsList.get(j);
                            float mparam2 = 0.0f;
                            while (true) {
                                // 获取运算符
                                if (operatorList.get(j).equals("x") ||  operatorList.get(j).equals("/")) {
                                    if (j < numsList.size() - 1) {
                                        param2 = numsList.get(j + 1);

                                        // 运算
                                        param1 = realCalculate(param1, operator, param2);
                                    }
                                } else {
                                    break;
                                }
                                j++;
                                if (j == operatorList.size()) {
                                    break;
                                }
                            }
                            param2 = mparam1;
                            param1 = realCalculate(param1, operator, param2);
                            i = j - 1;
                        }

                    }
                    i++;
                    if (i == operatorList.size()) {
                        break;
                    }
                }
            }

            // 显示结果
            textViewResult.setText(String.format("%.1f", param1));
        }
        else{
            textViewResult.setText ("");
        }

    }

    private float realCalculate(float param1, String operator, float param2) {

        float result = 0.0f;

        switch (operator) {
            case "+":
                result = param1 + param2;
                break;

            case "-":
                result = param1 - param2;
                break;
            case "x":
                result = param1 * param2;
                break;
            case "/":
                result = param1 / param2;
                break;

            default:
                break;


        }
        return result;
    }

    private void freshUI() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < numsList.size(); i++) {
            //
            str.append(numsList.get(i));

            // 判断运算符数组中对应位置是否有内容
            if (operatorList.size() > i) {
                // 将第i 对应的运算符拼接到字符串中
                str.append(" " + operatorList.get(i) + " ");
            }

        }

        textViewInput.setText(str.toString());


    }

}