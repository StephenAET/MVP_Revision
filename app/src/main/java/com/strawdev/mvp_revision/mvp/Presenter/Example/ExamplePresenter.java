package com.strawdev.mvp_revision.mvp.Presenter.Example;

import com.strawdev.mvp_revision.mvp.Presenter.Base.BasePresenter;
import com.strawdev.mvp_revision.mvp.view.Fragment.Example.ExampleView;

public interface ExamplePresenter extends BasePresenter<ExampleView> {

    void updateTitleText();

}
