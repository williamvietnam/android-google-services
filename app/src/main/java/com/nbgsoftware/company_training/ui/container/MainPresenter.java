package com.nbgsoftware.company_training.ui.container;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    public void setView(MainContract.View view) {
        this.view = view;
    }

    public MainContract.View getView() {
        return view;
    }

    @Override
    public void handleEvent() {

    }
}
