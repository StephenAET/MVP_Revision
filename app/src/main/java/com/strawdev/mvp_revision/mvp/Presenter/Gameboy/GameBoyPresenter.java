package com.strawdev.mvp_revision.mvp.Presenter.Gameboy;

import com.strawdev.mvp_revision.mvp.Presenter.Base.BasePresenter;
import com.strawdev.mvp_revision.mvp.view.Fragment.Gameboy.GameBoyView;

public interface GameBoyPresenter extends BasePresenter<GameBoyView> {

    void toggleGameBoyPowerState();

}
