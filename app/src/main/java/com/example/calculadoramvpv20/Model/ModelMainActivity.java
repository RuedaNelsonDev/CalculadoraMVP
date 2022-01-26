package com.example.calculadoramvpv20.Model;

import com.example.calculadoramvpv20.Interface.InterfaceMainActivity;
import com.example.calculadoramvpv20.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelMainActivity implements InterfaceMainActivity.Model {

    boolean checkSign;

    InterfaceMainActivity.Presenter presenter;
    String newValor;
    String saveResult;

    public String getSaveResult() {
        return saveResult;
    }

    public void setSaveResult(String saveResult) {
        this.saveResult = saveResult;
    }

    public ModelMainActivity(InterfaceMainActivity.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void number(String oldValor, int number) {
        String addNumber = String.valueOf(number);

        newValor = (oldValor + addNumber);
        this.presenter.sendNewValor(newValor);
        checkSign = false;
    }

    @Override
    public void sign(String oldValor, String sign) {

        if (oldValor.trim().length() > 0 && checkSign == false || oldValor.startsWith("-")) {

            if (oldValor.endsWith("*")
                    || oldValor.endsWith("/")
                    || oldValor.endsWith("+")
                    || oldValor.endsWith("-")
                    || oldValor.endsWith(".")
                    || oldValor.endsWith("^")) {

                oldValor = oldValor.substring(0, oldValor.length() - 1);
                this.presenter.sendNewValor(oldValor);

            }
            newValor = (oldValor + sign);
            checkSign = true;
            this.presenter.sendNewValor(newValor);

        }
    }


    @Override
    public void delete(String oldValor) {
        if (oldValor.length() > 0) {
            String newValor = oldValor.substring(0, oldValor.length() - 1);
            this.presenter.sendNewValor(newValor);
        }
    }

    @Override
    public void deleteAll(String empty) {
        this.presenter.sendNewValor(empty);
        this.presenter.showResult(empty);
    }

    @Override
    public void equal(String oldValor) {
        if (oldValor.endsWith("*")
                || oldValor.endsWith("/")
                || oldValor.endsWith("+")
                || oldValor.endsWith("-")
                || oldValor.endsWith(".")
                || oldValor.endsWith("^")) {
            this.presenter.showResult("Syntax Error");
        } else {
            resultOperation(oldValor);
            String result = resultOperation(oldValor);
            this.presenter.showResult(result);
            this.presenter.sendNewValor("");
            setSaveResult(result);
        }

    }

    @Override
    public void addAns(String oldValor) {

        if ((oldValor.trim().length() == 0 || oldValor.endsWith("*")
                || oldValor.endsWith("/")
                || oldValor.endsWith("+")
                || oldValor.endsWith("-")
                || oldValor.endsWith(".")
                || oldValor.endsWith("^"))) {

            newValor = oldValor + getSaveResult();
            this.presenter.sendNewValor(newValor);
            checkSign = false;
        } else {
            this.presenter.sendNewValor(oldValor);
        }

    }

    private String resolver(String expresionMatematica, char operacionExpresion) {


        expresionMatematica = expresionMatematica.trim();

        Pattern p = Pattern.compile("([-]{1}[\\d]+\\.[\\d]+|[\\d]+\\.[\\d]+|-[\\d]+|[\\d]+)(\\" + operacionExpresion + ")(-[\\d]+\\.[\\d]+|[\\d]+\\.[\\d]+|[\\d]+)");


        Matcher m = p.matcher(expresionMatematica);

        if (m.find()) {

            double num1 = Double.parseDouble(m.group(1));
            char operacion = m.group(2).charAt(0);
            double num2 = Double.parseDouble(m.group(3));

            double resultado = 0;
            switch (operacion) {
                case '/':
                    if (num2 == 0) {
                        return "ERRROR Division por CERO(0)";
                    }
                    resultado = num1 / num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '^':
                    resultado = Math.pow(num1, num2);
                    break;
                default:
                    break;
            }
            String txtResultado = "0";
            if (Math.abs(resultado) > 0) {
                txtResultado = String.valueOf(resultado);
                if ((Math.abs(resultado) / (int) Math.abs(resultado)) == 1D) {
                    //Eliminamos el .0
                    txtResultado = String.valueOf(resultado).replaceFirst("\\.0", "");
                }
            }

            expresionMatematica = m.replaceFirst(txtResultado);
        }
        return expresionMatematica;
    }

    public String resultOperation(String operation) {


        //Division y multiplica
        while (true) {
            int indiceDivision = operation.indexOf("/");
            int indiceMultiplica = operation.indexOf("*");
            int indiceExponent = operation.indexOf("^");

            if (indiceDivision == -1 && indiceMultiplica == -1 && indiceExponent == -1) {
                break;
            } else if (indiceExponent >= 0 && indiceMultiplica == -1 && indiceDivision == -1) {
                operation = resolver(operation, '^');
            } else if (indiceDivision == -1 && indiceExponent == -1 && indiceMultiplica >= 0) {
                operation = resolver(operation, '*');
            } else if (indiceDivision >= 0 && indiceMultiplica == -1 && indiceExponent == -1) {
                operation = resolver(operation, '/');

            } else if (indiceExponent > indiceDivision || indiceExponent > indiceMultiplica) {
                operation = resolver(operation, '^');
            } else if (indiceMultiplica < indiceDivision || indiceMultiplica < indiceExponent) {
                operation = resolver(operation, '*');
            } else {
                operation = resolver(operation, '/');
            }

        }
        //Resta y Suma
        while (true) {
            int indiceResta = operation.indexOf("-", 1);
            int indiceSuma = operation.indexOf("+");

            if (indiceResta == -1 && indiceSuma == -1) {
                break;
            } else if (indiceResta == -1 && indiceSuma >= 0) {
                operation = resolver(operation, '+');
            } else if (indiceResta >= 0 && indiceSuma == -1) {
                operation = resolver(operation, '-');
            } else if (indiceSuma < indiceResta) {
                operation = resolver(operation, '+');
            } else {
                operation = resolver(operation, '-');
            }
        }
        return operation;
    }


}
