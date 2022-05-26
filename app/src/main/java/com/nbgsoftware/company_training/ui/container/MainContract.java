package com.nbgsoftware.company_training.ui.container;

public interface MainContract {
    interface View {
        void showStartQuizScreen();

        void showQuizDetailScreen();

        void showResultQuizScreen();
    }

    interface Presenter {
        void handleEvent();
    }
}
