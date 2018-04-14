package com.strawdev.mvp_revision.mvp.view.Fragment.Gameboy;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.strawdev.mvp_revision.R;
import com.strawdev.mvp_revision.mvp.Interactor.Gameboy.GameBoyInteractorImpl;
import com.strawdev.mvp_revision.mvp.Presenter.Gameboy.GameBoyPresenter;
import com.strawdev.mvp_revision.mvp.Presenter.Gameboy.GameBoyPresenterImpl;

public class GameBoyFragment extends Fragment implements GameBoyView {

    GameBoyPresenter mGameBoyPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gameboy, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.mGameBoyPresenter = new GameBoyPresenterImpl(new GameBoyInteractorImpl());
        this.mGameBoyPresenter.attachView(this);

        Button button = view.findViewById(R.id.btn_button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameBoyFragment.this.mGameBoyPresenter.toggleGameBoyPowerState();
            }
        });
    }

    @Override
    public void onPowerChanged(boolean pIsPoweredOn) {
        if (getView() == null){
            return;
        }
        ImageView screen = getView().findViewById(R.id.img_screen);

        if (pIsPoweredOn) {
            screen.setImageDrawable(getResources().getDrawable(R.drawable.gameboy, null));
            screen.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            screen.setImageDrawable(null);
        }
    }

    @Override
    public void onSuccess() {
        // TODO
    }

    @Override
    public void onFailure(String pMessage) {
        // TODO
    }

}
