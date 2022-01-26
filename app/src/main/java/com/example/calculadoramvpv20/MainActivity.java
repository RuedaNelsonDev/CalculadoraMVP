package com.example.calculadoramvpv20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.*;

import com.example.calculadoramvpv20.Interface.InterfaceMainActivity;
import com.example.calculadoramvpv20.Presenter.PresenterMainActivity;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener, InterfaceMainActivity.View {

        InterfaceMainActivity.Presenter presenter;
        EditText etOperation;
        TextView tvResult;
        Button btnNumberZero;
        Button btnNumberOne;
        Button btnNumberTwo;
        Button btnNumberThree;
        Button btnNumberFour;
        Button btnNumberFive;
        Button btnNumberSix;
        Button btnNumberSeven;
        Button btnNumberEight;
        Button btnNumberNine;
        Button btnSignMultiplication;
        Button btnSignDivision;
        Button btnSignAddition;
        Button btnSignSubtraction;
        Button btnSignExponent;
        Button btnSignEqual;
        Button btnPoint;
        Button btnAns;
        Button btnC;
        Button btnDel;


        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            this.findElement();
            presenter = new PresenterMainActivity(this);



        }

        @Override
        public void onClick(View v) {

            String operation = etOperation.getText().toString().trim();

            String oldValor = operation;

            switch (v.getId()) {
                case R.id.btnNumberZero:
                    presenter.addNumber(oldValor, 0);
                    break;
                case R.id.btnNumberOne:
                    presenter.addNumber(oldValor, 1);
                    break;
                case R.id.btnNumberTwo:
                    presenter.addNumber(oldValor, 2);
                    break;
                case R.id.btnNumberThree:
                    presenter.addNumber(oldValor, 3);
                    break;
                case R.id.btnNumberFour:
                    presenter.addNumber(oldValor, 4);
                    break;
                case R.id.btnNumberFive:
                    presenter.addNumber(oldValor, 5);
                    break;
                case R.id.btnNumberSix:
                    presenter.addNumber(oldValor, 6);
                    break;
                case R.id.btnNumberSeven:
                    presenter.addNumber(oldValor, 7);
                    break;
                case R.id.btnNumberEight:
                    presenter.addNumber(oldValor, 8);
                    break;
                case R.id.btnNumberNine:
                    presenter.addNumber(oldValor, 9);
                    break;
                case R.id.btnSignMultiplication:
                    presenter.addSign(oldValor, "*");
                    break;
                case R.id.btnSignDivision:
                    oldValor = operation;
                    presenter.addSign(oldValor, "/");
                    break;
                case R.id.btnSignAddition:
                    oldValor = operation;
                    presenter.addSign(oldValor, "+");
                    break;
                case R.id.btnSignSubtraction:
                    oldValor = operation;
                    presenter.addSign(oldValor, "-");
                    break;
                case R.id.btnSignExponent:
                    oldValor = operation;
                    presenter.addSign(oldValor, "^");
                    break;
                case R.id.btnPoint:
                    oldValor = operation;
                    presenter.addSign(oldValor, ".");
                    break;
                case R.id.btnAns:
                    oldValor = operation;
                    presenter.addAns(oldValor);
                    break;
                case R.id.btnC:
                    presenter.deleteAll( "");
                    break;
                case R.id.btnDel:
                    oldValor = operation;
                    presenter.delete(oldValor);
                    break;
                case R.id.btnSignEqual:
                    oldValor = operation;
                    presenter.equal(oldValor);
                    break;

            }
        }

        @Override
        public void findElement() {
            etOperation = findViewById(R.id.etOperation);
            etOperation.setFocusable( true );
            etOperation.setFocusableInTouchMode( true );
            etOperation.setInputType( InputType.TYPE_NULL );

            tvResult = findViewById(R.id.tvResult);

            btnNumberZero = findViewById(R.id.btnNumberZero);
            btnNumberZero.setOnClickListener(this);

            btnNumberOne = findViewById(R.id.btnNumberOne);
            btnNumberOne.setOnClickListener(this);

            btnNumberTwo = findViewById(R.id.btnNumberTwo);
            btnNumberTwo.setOnClickListener(this);

            btnNumberThree = findViewById(R.id.btnNumberThree);
            btnNumberThree.setOnClickListener(this);

            btnNumberFour = findViewById(R.id.btnNumberFour);
            btnNumberFour.setOnClickListener(this);

            btnNumberFive = findViewById(R.id.btnNumberFive);
            btnNumberFive.setOnClickListener(this);

            btnNumberSix = findViewById(R.id.btnNumberSix);
            btnNumberSix.setOnClickListener(this);

            btnNumberSeven = findViewById(R.id.btnNumberSeven);
            btnNumberSeven.setOnClickListener(this);

            btnNumberEight = findViewById(R.id.btnNumberEight);
            btnNumberEight.setOnClickListener(this);

            btnNumberNine = findViewById(R.id.btnNumberNine);
            btnNumberNine.setOnClickListener(this);

            btnSignMultiplication = findViewById(R.id.btnSignMultiplication);
            btnSignMultiplication.setOnClickListener(this);

            btnSignDivision = findViewById(R.id.btnSignDivision);
            btnSignDivision.setOnClickListener(this);

            btnSignAddition = findViewById(R.id.btnSignAddition);
            btnSignAddition.setOnClickListener(this);

            btnSignSubtraction = findViewById(R.id.btnSignSubtraction);
            btnSignSubtraction.setOnClickListener(this);

            btnSignExponent = findViewById(R.id.btnSignExponent);
            btnSignExponent.setOnClickListener(this);

            btnPoint = findViewById(R.id.btnPoint);
            btnPoint.setOnClickListener(this);

            btnAns = findViewById(R.id.btnAns);
            btnAns.setOnClickListener(this);

            btnSignEqual = findViewById(R.id.btnSignEqual);
            btnSignEqual.setOnClickListener(this);

            btnC = findViewById(R.id.btnC);
            btnC.setOnClickListener(this);

            btnDel = findViewById(R.id.btnDel);
            btnDel.setOnClickListener(this);

        }

        @Override
        public void showNewValor(String newValor) {

            etOperation.setText(newValor);
        }

        @Override
        public void showResult(String result) {
            /*setResult(result);*/
            tvResult.setText(result);
        }
    }