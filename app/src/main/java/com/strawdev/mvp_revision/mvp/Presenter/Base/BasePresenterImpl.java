package com.strawdev.mvp_revision.mvp.Presenter.Base;

import com.strawdev.mvp_revision.mvp.view.Base.BaseView;

public class BasePresenterImpl  <T extends BaseView> implements BasePresenter<T> {

    private T mView;

    @Override
    public void attachView(T mvpView) {
        this.mView = mvpView;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    @Override
    public T getView() {
        return mView;
    }

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }

    @Override
    public void checkViewAttached() {
        if (this.mView == null) {
            throw new ViewNotAttachedException();
        }
    }

    /**
     * Runtime exception for when trying to use a view when one hasn't been attached.
     */
    public static class ViewNotAttachedException extends RuntimeException {

        private static final String EXCEPTION = "B^u " +
                "You forgot to attach a view to this presenter! " +
                "Please invoke attachView() first!";

        public ViewNotAttachedException() {
            super(EXCEPTION);
        }
    }
}