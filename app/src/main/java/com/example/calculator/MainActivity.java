package com.example.calculator;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int nums = 1;
    int isDot = 0;
    final static String SIGNS = "+-/*";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        textView = findViewById(R.id.textView);
    }


    public void num1(View view) {
        String str = textView.getText().toString();

        if (nums == 1 && str.charAt(str.length() - 1) == '0') {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "1");
        nums++;
    }

    public void num2(View view) {
        String str = textView.getText().toString();

        if (nums == 1 && str.charAt(str.length() - 1) == '0') {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "2");
        nums++;
    }

    public void num3(View view) {
        String str = textView.getText().toString();

        if (nums == 1 && str.charAt(str.length() - 1) == '0') {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "3");
        nums++;
    }

    public void num4(View view) {
        String str = textView.getText().toString();

        if (nums == 1 && str.charAt(str.length() - 1) == '0') {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "4");
        nums++;
    }

    public void num5(View view) {
        String str = textView.getText().toString();

        if (nums == 1 && str.charAt(str.length() - 1) == '0') {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "5");
        nums++;
    }

    public void num6(View view) {
        String str = textView.getText().toString();

        if (nums == 1 && str.charAt(str.length() - 1) == '0') {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "6");
        nums++;
    }

    public void num7(View view) {
        String str = textView.getText().toString();

        if (nums == 1 && str.charAt(str.length() - 1) == '0') {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "7");
        nums++;
    }

    public void num8(View view) {
        String str = textView.getText().toString();

        if (nums == 1 && str.charAt(str.length() - 1) == '0') {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "8");
        nums++;
    }

    public void num9(View view) {
        String str = textView.getText().toString();

        if (nums == 1 && str.charAt(str.length() - 1) == '0') {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "9");
        nums++;
    }

    public void num0(View view) {
        String str = textView.getText().toString();

        if (nums == 0 || nums >= 2 || (nums == 1 && str.charAt(str.length() - 1) != '0')) {
            textView.setText(str + "0");
            nums++;
        }
    }

    public void dot(View view) {
        if (isDot != 1) {
            String str = textView.getText().toString();

            isDot = 1;
            if (nums == 0) {
                textView.setText(str + "0.");
                nums = 1;
            } else {
                textView.setText(str + ".");
            }
        }
    }

    public void reverse(View view) {
        String str = textView.getText().toString();
        int toggle = -1;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (SIGNS.contains(str.charAt(i) + "")) {
                toggle = i;
                break;
            }
        }

        if (toggle == -1) {
            str = "-" + str;
        } else {
            switch (str.charAt(toggle)) {
                case '-': {
                    if (toggle == 0) {
                        str = str.substring(1);
                    } else {
                        str = str.substring(0, toggle) + "+" + str.substring(toggle + 1);
                    }
                    break;
                }
                case '+': {
                    str = str.substring(0, toggle) + "-" + str.substring(toggle + 1);
                    break;
                }
                case '/':
                case '*': {
                    str = str.substring(0, toggle + 1) + "-" + str.substring(toggle + 1);
                    break;
                }
            }
        }

        textView.setText(str);
    }

    public void oneDivideBy(View view) {
        String str = textView.getText().toString();
        int toggle = -1;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (SIGNS.contains(str.charAt(i) + "")) {
                toggle = i;
                break;
            }
        }

        String oneDiv = "1/";
        str = str.substring(0, toggle + 1) + oneDiv + str.substring(toggle + 1);
        textView.setText(str);
    }

    public void sqrt(View view) {
        String str = textView.getText().toString();
        int toggle = -1;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (SIGNS.contains(str.charAt(i) + "")) {
                toggle = i;
                break;
            }
        }

        String numStr = str.substring(toggle + 1);
        String oldStr;
        if (toggle == -1) {
            oldStr = "";
        } else {
            oldStr = str.substring(0, toggle + 1);
        }
        System.out.println(oldStr);

        double num = Double.parseDouble(numStr);
        num = Math.sqrt(num);
        str = oldStr + num;

        textView.setText(str);
    }

    public void clear(View view) {
        textView.setText("0");
        nums = 1;
        isDot = 0;
    }

    public void plus(View view) {
        String str = textView.getText().toString();
        String lastChar = str.charAt(str.length() - 1) + "";

        if (SIGNS.contains(lastChar)) {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "+");
        nums = 0;
        isDot = 0;
    }

    public void minus(View view) {
        String str = textView.getText().toString();
        String lastChar = str.charAt(str.length() - 1) + "";

        if (SIGNS.contains(lastChar)) {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "-");
        nums = 0;
        isDot = 0;
    }

    public void division(View view) {
        String str = textView.getText().toString();
        String lastChar = str.charAt(str.length() - 1) + "";

        if (SIGNS.contains(lastChar)) {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "/");
        nums = 0;
        isDot = 0;
    }

    public void multiply(View view) {
        String str = textView.getText().toString();
        String lastChar = str.charAt(str.length() - 1) + "";

        if (SIGNS.contains(lastChar)) {
            str = str.substring(0, str.length() - 1);
        }
        textView.setText(str + "*");
        nums = 0;
        isDot = 0;
    }

    //parsing and gets result
    public void result(View view) {
        String str = textView.getText().toString();

        List<String> list = new ArrayList();
        String s = "";

        // fix "7*" error
        if (SIGNS.contains(str.charAt(str.length() - 1) + "")) {
            str = str.substring(0, str.length() - 1);
        }
        //parser to list
        for (int i = 0; i < str.length(); i++) {
            s += str.charAt(i);
            if (i == str.length() - 1) {
                list.add(s);
            } else if (SIGNS.contains(str.charAt(i + 1) + "")) {
                list.add(s);
                list.add(str.charAt(i + 1) + "");
                i++;
                s = "";
            }
        }

        double temp;

        //calc
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("/")) {
                temp = Double.parseDouble(list.get(i - 1)) / Double.parseDouble(list.get(i + 1));
                list.set(i - 1, temp + "");
                list.remove(i + 1);
                list.remove(i);
                i--;
            } else if (list.get(i).equals("*")) {
                temp = Double.parseDouble(list.get(i - 1)) * Double.parseDouble(list.get(i + 1));
                list.set(i - 1, temp + "");
                list.remove(i + 1);
                list.remove(i);
                i--;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("+")) {
                temp = Double.parseDouble(list.get(i - 1)) + Double.parseDouble(list.get(i + 1));
                list.set(i - 1, temp + "");
                list.remove(i + 1);
                list.remove(i);
                i--;
            } else if (list.get(i).equals("-")) {
                temp = Double.parseDouble(list.get(i - 1)) - Double.parseDouble(list.get(i + 1));
                list.set(i - 1, temp + "");
                list.remove(i + 1);
                list.remove(i);
                i--;
            }
        }

        //max
        String res = list.get(0);
        if (res.length() > 15) {
            res = res.substring(0, 13) + res.substring(res.length() - 2);
        }

        textView.setText(res);
    }
}