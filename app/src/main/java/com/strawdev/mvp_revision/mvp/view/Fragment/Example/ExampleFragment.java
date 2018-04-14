package com.strawdev.mvp_revision.mvp.view.Fragment.Example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.strawdev.mvp_revision.R;
import com.strawdev.mvp_revision.mvp.Presenter.Example.ExamplePresenter;
import com.strawdev.mvp_revision.mvp.Presenter.Example.ExamplePresenterImpl;
import com.strawdev.mvp_revision.mvp.Interactor.Example.ExampleInteractor;

/**
 * This is an example of a fragment implementing a MVP View interface
 * ExampleView extends the BaseView interface
 */
public class ExampleFragment extends Fragment implements ExampleView {

    // This fragment's (view's) interactor.
    ExampleInteractor mExampleInteractor;

    // This fragment's (view's) Presenter, every single MVP view needs one presenter
    ExamplePresenter mExamplePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Implement parent
        super.onViewCreated(view, savedInstanceState);

        // Configure the layouts and views in this fragment
        // Fetch our layout's views

        // Fetch the title
        final TextView lTextView = view.findViewById(R.id.tv_title);
        // Set the default title
        lTextView.setText(R.string.before_example_method);
        // Fetch the button
        final Button lButton = view.findViewById(R.id.btn_button_1);
        // Initially disable the button
        lButton.setEnabled(false);

        // Create a new example interactor
        //this.mExampleInteractor = new ExampleInteractor(); // TODO Hmmm

        // Create a new example presenter
        this.mExamplePresenter = new ExamplePresenterImpl(null);
        // Attach this view to our new presenter
        this.mExamplePresenter.attachView(this);

        // Invoke the presenter method
        //      Presenter methods invoked this way can invoke this view's methods
        //      thanks to this view's interface
        this.mExamplePresenter.updateTitleText();
    }

    @Override
    public void onUpdateText(final String pText) {
        // Check that the view is valid
        if (getView() == null) {
            return;
        }
        // Fetch the title
        final TextView lTextView = getView().findViewById(R.id.tv_title);
        // Set the title text to reflect the text provided by the presenter
        lTextView.setText(pText);
    }

    @Override
    public void onSuccess() {
        // Check that the view is valid
        if (getView() == null) {
            return;
        }
        // Fetch the button
        final Button lButton = getView().findViewById(R.id.btn_button_1);
        // Ensure the button is enabled
        lButton.setEnabled(true);
    }

    @Override
    public void onFailure(String pMessage) {
        // Check that the view is valid
        if (getView() == null) {
            return;
        }
        // Fetch the title
        final TextView lTextView = getView().findViewById(R.id.tv_title);
        // Set the title to reflect the error message provided by the presenter
        lTextView.setText(pMessage);
        // Fetch the button
        final Button lButton = getView().findViewById(R.id.btn_button_1);
        // Ensure the button is disabled
        lButton.setEnabled(false);
    }
}
