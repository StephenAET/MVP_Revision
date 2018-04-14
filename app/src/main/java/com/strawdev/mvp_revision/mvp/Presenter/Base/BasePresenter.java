package com.strawdev.mvp_revision.mvp.Presenter.Base;

import com.strawdev.mvp_revision.mvp.view.Base.BaseView;

/**
 * Presenters are in charge of maintaining views
 * Each view should have one presenter
 * @param <T> The MVP view type this presenter maintains
 */
public interface BasePresenter <T extends BaseView> {

    /**
     * Attach a view to this Presenter
     * @param mvpView The view to be attached to this presenter
     */
    void attachView(T mvpView);

    /**
     * Detach the view from the presenter (if it has one)
     */
    void detachView();

    // The methods belows aren't essential, but they are worth having

    /**
     * @return Get the view current attached to this Presenter (If it has one)
     */
    T getView();

    /**
     * @return Check if a valid view has been attached to this presenter
     */
    boolean isViewAttached();

    /**
     * Exception handling for when a view hasn't been assigned.
     */
    void checkViewAttached();
}
