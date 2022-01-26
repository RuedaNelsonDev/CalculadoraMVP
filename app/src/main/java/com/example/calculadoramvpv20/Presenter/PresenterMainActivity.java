package com.example.calculadoramvpv20.Presenter;

import com.example.calculadoramvpv20.Interface.InterfaceMainActivity;
import com.example.calculadoramvpv20.Model.ModelMainActivity;

public class PresenterMainActivity implements InterfaceMainActivity.Presenter {

    InterfaceMainActivity.View view;
    InterfaceMainActivity.Model model;

    public PresenterMainActivity(InterfaceMainActivity.View view) {
        this.view = view;
        InterfaceMainActivity.Model model;
        this.model = new ModelMainActivity(this);
    }

    @Override
    public void addNumber(String oldValor, int number) {

        this.model.number(oldValor, number);

    }


    @Override
    public void addSign(String oldValor, String sign) {
        this.model.sign(oldValor, sign);
    }

    @Override
    public void delete(String oldValor) {
        this.model.delete(oldValor);
    }

    @Override
    public void deleteAll(String empty) {
        this.model.deleteAll(empty);
    }

    @Override
    public void equal(String oldValor) {
        this.model.equal(oldValor);

    }

    @Override
    public void addAns(String oldValor) {
        this.model.addAns(oldValor);
    }

    @Override
    public void sendNewValor(String number) {
        this.view.showNewValor(number);

    }

    @Override
    public void showResult(String result) {
        this.view.showResult(result);
    }
}
