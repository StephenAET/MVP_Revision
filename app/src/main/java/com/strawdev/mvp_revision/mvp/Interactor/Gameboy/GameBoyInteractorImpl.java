package com.strawdev.mvp_revision.mvp.Interactor.Gameboy;

public class GameBoyInteractorImpl implements GameBoyInteractor {

    private boolean mGameBoyIsTurnedOn = false;

    @Override
    public boolean onToggleGameBoyPower() {
        this.mGameBoyIsTurnedOn = !this.mGameBoyIsTurnedOn;
        return this.mGameBoyIsTurnedOn;
    }
}
