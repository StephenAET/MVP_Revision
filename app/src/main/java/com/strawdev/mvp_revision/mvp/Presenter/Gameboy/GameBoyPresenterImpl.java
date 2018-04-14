package com.strawdev.mvp_revision.mvp.Presenter.Gameboy;

import com.strawdev.mvp_revision.mvp.Interactor.Gameboy.GameBoyInteractor;
import com.strawdev.mvp_revision.mvp.Interactor.Gameboy.GameBoyInteractorImpl;
import com.strawdev.mvp_revision.mvp.Presenter.Base.BasePresenterImpl;
import com.strawdev.mvp_revision.mvp.view.Fragment.Gameboy.GameBoyView;

public class GameBoyPresenterImpl extends BasePresenterImpl<GameBoyView> implements GameBoyPresenter {

    GameBoyInteractor mGameBoyInteractor;

    public GameBoyPresenterImpl(GameBoyInteractorImpl pGameBoyInteractor) {
        mGameBoyInteractor = pGameBoyInteractor;
    }

    @Override
    public void toggleGameBoyPowerState() {
        checkViewAttached();

        boolean isPowerOn = mGameBoyInteractor.onToggleGameBoyPower();

        getView().onPowerChanged(isPowerOn);


    }
}
