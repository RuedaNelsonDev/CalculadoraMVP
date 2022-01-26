package com.example.calculadoramvpv20.Interface;

public interface InterfaceMainActivity {
    interface View {
    void findElement();

    void showNewValor(String newValor);

    void showResult(String result);
}

    interface Presenter {

        void addNumber(String oldValor, int number);

        void addSign(String oldValor, String sign);

        void delete(String oldValor);

        void deleteAll(String empty);

        void equal(String oldValor);

        void addAns(String oldValor);

        void sendNewValor(String number);

        void showResult(String result);
    }

    interface Model {

        void number(String oldValor, int number);

        void sign(String oldValor, String sign);

        void delete(String oldValor);

        void deleteAll(String empty);

        void equal(String oldValor);

        void addAns(String oldValor);


    }
}