package com.strawdev.mvp_revision.mvp.Presenter.Example;

import com.strawdev.mvp_revision.mvp.Interactor.Example.ExampleInteractor;
import com.strawdev.mvp_revision.mvp.Presenter.Base.BasePresenterImpl;
import com.strawdev.mvp_revision.mvp.view.Fragment.Example.ExampleView;

/**
 * This is an example of a presenter implementation
 * It implements our example presenter interface for this presenter's methods
 *
 * Extending BasePresenterImpl conveniently (and consistently)
 * provides definitions for base presenter methods
 */
public class ExamplePresenterImpl extends BasePresenterImpl<ExampleView> implements ExamplePresenter {

    ExampleInteractor mExampleInteractor;

    public ExamplePresenterImpl(ExampleInteractor mExampleInteractor) {
        this.mExampleInteractor = mExampleInteractor;
    }

    @Override
    public void updateTitleText() {
        // We must make sure a view is attached first!
        checkViewAttached();

        getView().onSuccess();

        // Do presenter method logic here,
        //      First we want to get the title text string,
        //      The presenter doesn't know what the string should be, so it asks the interactor.
        //      The interactor provides the string to the presenter.
        //      The presenter can then invoke the view's update text method
        getView().onUpdateText(mExampleInteractor.getTitleText());
    }

    @Override
    public void detachView() {
        // Implement parent
        super.detachView();

        // Clean up logic can be done here
        // e.g.s disposing of a Disposable
    }
}
