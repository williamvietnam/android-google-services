package com.nbgsoftware.company_training.ui.quiz.start;

public class StartPresenter implements StartContract.Presenter {

    private StartContract.View view;

    public StartContract.View getView() {
        return view;
    }

    public void setView(StartContract.View view) {
        this.view = view;
    }


}
