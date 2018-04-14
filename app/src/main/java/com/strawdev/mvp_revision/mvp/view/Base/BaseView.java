package com.strawdev.mvp_revision.mvp.view.Base;

/**
 * Views are any UI elements such as Fragments
 *
 * Place methods that are common amongst all views here.
 *
 * Most commonly are on success and on failure
 */
public interface BaseView {

    void onSuccess();

    void onFailure(String pMessage);
}