package ru.eltex.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String SEPARATOR = ",";

    enum Action {
        initState,
        division,
        multi,
        minus,
        plus
    }

    Action currentAction = Action.initState;
    boolean newEnter = true;
    Double savedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCE = (Button) findViewById(R.id.buttonCE);
        buttonCE.setOnClickListener((view -> {
            ((TextView) findViewById(R.id.fieldMain)).setText("0");
            newEnter = true;
        }));

        Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener((view -> {
            reset();
        }));

        Button buttonBackspace = (Button) findViewById(R.id.buttonBackspace);
        buttonBackspace.setOnClickListener((view -> {
            clickBackspace();
        }));

        Button buttonDivision = (Button) findViewById(R.id.buttonDivision);
        buttonDivision.setOnClickListener((view -> {
            clickDivision();
        }));

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener((view -> {
            clickNumber("7");
        }));

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener((view -> {
            clickNumber("8");
        }));

        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener((view -> {
            clickNumber("9");
        }));

        Button buttonMulti = (Button) findViewById(R.id.buttonMulti);
        buttonMulti.setOnClickListener((view -> {
            clickMulti();
        }));

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener((view -> {
            clickNumber("4");
        }));

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener((view -> {
            clickNumber("5");
        }));

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener((view -> {
            clickNumber("6");
        }));

        Button buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener((view -> {
            clickMinus();
        }));

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener((view -> {
            clickNumber("1");
        }));

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener((view -> {
            clickNumber("2");
        }));

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener((view -> {
            clickNumber("3");
        }));

        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener((view -> {
            clickPlus();
        }));

        Button buttonReverse = (Button) findViewById(R.id.buttonReverse);
        buttonReverse.setOnClickListener((view -> {
            clickReverse();
        }));

        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener((view -> {
            clickNumber("0");
        }));

        Button buttonSeparator = (Button) findViewById(R.id.buttonSeparator);
        buttonSeparator.setOnClickListener((view -> {
            clickSeparator();
        }));

        Button buttonResult = (Button) findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener((view -> {
            clickResult();
        }));
    }

    public String getSymbolByAction(Action action) {
        String symbol = "";

        switch(action) {
            case division:
                symbol = "/";
                break;
            case multi:
                symbol = "*";
                break;
            case minus:
                symbol = "-";
                break;
            case plus:
                symbol = "+";
                break;
            default:
        }
        return symbol;
    }

    public void reset() {
        ((TextView) findViewById(R.id.fieldSave)).setText("");
        ((TextView) findViewById(R.id.fieldMain)).setText("0");
        currentAction = Action.initState;
        newEnter = true;
    }

    public boolean checkError() {
        TextView fieldMain = (TextView) findViewById(R.id.fieldMain);
        String tmp = fieldMain.getText().toString();

        if (tmp.equals("Infinity"))
            return true;
        else
            return false;
    }

    public boolean checkFieldMainSize(String field) {
        if (field.length() >= 16)
            return false;
        else
            return true;
    }

    public String rounding(String str) {
        String tmp = str;
        boolean needRounding = true;

        if (tmp.contains(SEPARATOR)) {
            for (int i = tmp.indexOf(SEPARATOR) + 1; i < tmp.length(); i++) {
                char c = tmp.charAt(i);
                if (c != '0')
                    needRounding = false;
            }
            if (needRounding) {
                tmp = tmp.substring(0, tmp.indexOf(SEPARATOR));
            }
        }
        return tmp;
    }

    public void arithmeticAction(Action action) {
        TextView fieldMain = (TextView) findViewById(R.id.fieldMain);
        TextView fieldSave = (TextView) findViewById(R.id.fieldSave);
        String tmp = fieldMain.getText().toString();

        if (checkError()) {
            reset();
            return;
        }

        if (tmp.equals("0"))
            return;

        tmp = rounding(tmp);
        currentAction = action;
        newEnter = true;
        savedValue = Double.parseDouble(tmp.replace(SEPARATOR,"."));
        fieldMain.setText(tmp);
        fieldSave.setText(tmp + " " + getSymbolByAction(action));
    }

    public void clickNumber(String number) {
        TextView fieldMain = (TextView) findViewById(R.id.fieldMain);
        String tmp = fieldMain.getText().toString();

        if (checkError()) {
            reset();
            return;
        }

        if (number.equals("0") && tmp.equals("0"))
            return;

        if (newEnter) {
            newEnter = false;
            tmp = number;
        } else {
            if (checkFieldMainSize(tmp))
                tmp += number;
        }
        fieldMain.setText(tmp);
    }

    public void clickBackspace() {
        TextView fieldMain = (TextView) findViewById(R.id.fieldMain);
        String tmp = fieldMain.getText().toString();

        if (checkError()) {
            reset();
            return;
        }

        if (tmp.length() > 1) {
            tmp = tmp.substring(0, tmp.length() - 1);
            if (tmp.equals("-0") || tmp.equals("-")) {
                tmp = "0";
                newEnter = true;
            }
        } else {
            tmp = "0";
            newEnter = true;
        }
        fieldMain.setText(tmp);
    }

    public void clickReverse() {
        TextView fieldMain = (TextView) findViewById(R.id.fieldMain);
        String tmp = fieldMain.getText().toString();

        if (checkError()) {
            reset();
            return;
        }

        if (tmp.indexOf("-") == 0)
            tmp = tmp.substring(1);
        else if (!tmp.equals("0"))
            tmp = "-" + tmp;

        fieldMain.setText(tmp);
    }

    public void clickSeparator() {
        TextView fieldMain = (TextView) findViewById(R.id.fieldMain);
        String tmp = fieldMain.getText().toString();

        if (checkError()) {
            reset();
            return;
        }

        if (newEnter)
            newEnter = false;

        if (checkFieldMainSize(tmp)) {
            if (!tmp.contains(SEPARATOR))
                fieldMain.setText(tmp + SEPARATOR);
        }
    }

    public void clickDivision() {
        arithmeticAction(Action.division);
    }

    public void clickMulti() {
        arithmeticAction(Action.multi);
    }

    public void clickMinus() {
        arithmeticAction(Action.minus);
    }

    public void clickPlus() {
        arithmeticAction(Action.plus);
    }

    public void clickResult() {
        TextView fieldMain = (TextView) findViewById(R.id.fieldMain);
        TextView fieldSave = (TextView) findViewById(R.id.fieldSave);
        String tmp = fieldMain.getText().toString();
        Double currentValue = Double.parseDouble( tmp.replace(",",".") );

        if (checkError()) {
            reset();
            return;
        }

        if (currentAction == Action.initState)
            return;

        switch(currentAction) {
            case division:
                currentValue = savedValue / currentValue;
                break;
            case multi:
                currentValue = savedValue * currentValue;
                break;
            case minus:
                currentValue = savedValue - currentValue;
                break;
            case plus:
                currentValue = savedValue + currentValue;
                break;
            default:
        }
        tmp = currentValue.toString().replace(".", SEPARATOR);
        tmp = rounding(tmp);

        fieldMain.setText(tmp);
        fieldSave.setText("");
        currentAction = Action.initState;
        newEnter = true;
    }
}