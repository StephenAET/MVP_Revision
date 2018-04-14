package com.strawdev.mvp_revision;

import android.app.Application;

public class App extends Application {

    public App() {
        super();

        /*
         * This is an example of MVP architecture as simple as it gets
         *
         * We hae an example fragment, Presenter and Interactor
         *
         * In this case, the fragment has a title and button.
         *
         * When the user presses the button in the fragment (view),
         * the view invokes a presenter method to update the title text.
         * (NOTE : the view doesn't interact with the interactor directly, the presenter does.)
         *
         * The presenter then responds to this by talking to the interactor to get a result,
         * in this case the text for the title.
         * The presenter isn't in charge of doing heavy lifting (logic),
         * When a presenter wants to update a ui or model,
         * the presenter needs to ask an interactor to do it form them.
         *
         * -------------------------------------
         * Our fancy Game-Boy Analogy
         * -------------------------------------
         * The view is the game-boy in the user's hands,
         * The presenter is the wire connection between the game-boy and the cpu.
         * The interactor is the console.
         *
         * When the user presses a button on the game-boy (interacts with the view e.g.s button press),
         * the game-boy sends a signal down the wire connection indicating it wants to do something.
         *
         * The wire connection doesn't know how to process the signal,
         * all it knows is to send and receive a signal between the game-boy and the cpu.
         * So the wire connection (the presenter), sends the signal to the cpu expecting a result.
         *
         * The cpu (the interactor), knows how to process the signal and does some logic,
         * In this case we want to open a menu.
         * The cpu does it's logic (which may be an asynchronous task!) and when it's done
         * it sends a new signal back through the wire connection (the presenter).
         * This signal indicates that a menu should be shown on the screen so it updates the game-boy's (view's) screen UI.
         */
    }
}
