package com.globaldex.newlistapp.base;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.annotation.IdRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.inputmethod.InputMethodManager;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public abstract class BaseActivity extends AppCompatActivity {

    public static final String TARGET_FRAGMENT = "TARGET_FRAGMENT";
    private CompositeDisposable disposables;


    @Override
    protected void attachBaseContext(Context newBase) {

    }

    @Override
    protected void onStop() {
        super.onStop();

        DisposeManager.dispose();
        getCompositeDisposable().clear();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    public void replaceFragment(@IdRes int id, Fragment fragment, boolean popBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        // set Exit transition for the current visible fragment
        Fragment exitFragment = fragmentManager.findFragmentById(id);

        if (exitFragment != null && exitFragment.isVisible()) {
            // override existing fragment enter transition to reverse effect when popping backstack
            exitFragment.setEnterTransition(new Fade(Fade.IN));
            exitFragment.setExitTransition(new Fade(Fade.OUT));
        }

        if (popBackStack) {
            fragmentManager.popBackStack(null, android.support.v4.app.FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment, fragment.toString());
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void addFragment(@IdRes int id, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        // set Exit transition for the current visible fragment
        Fragment exitFragment = fragmentManager.findFragmentById(id);


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void addFragmentInActivityStack(@IdRes int id, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        // set Exit transition for the current visible fragment
        Fragment exitFragment = fragmentManager.findFragmentById(id);


        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(id, fragment, fragment.toString());
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void addDialogFragment(DialogFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragment, fragment.toString());
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void addDialogFragmentWithoutStack(DialogFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentManager.popBackStack(null, android.support.v4.app.FragmentManager.POP_BACK_STACK_INCLUSIVE);
        fragmentTransaction.add(fragment, fragment.toString());
        fragmentTransaction.commitAllowingStateLoss();
    }

    protected void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(findViewById(android.R.id.content).getWindowToken(), 0);
    }

    public void handleError(Throwable throwable) {

    }

    private CompositeDisposable getCompositeDisposable() {
        if (disposables == null || disposables.isDisposed()) {
            disposables = new CompositeDisposable();
        }
        return disposables;
    }

    protected class DisposingObserver<T> implements Observer<T> {

        @Override
        public void onSubscribe(Disposable d) {
            if (d != null) getCompositeDisposable().add(d);
        }

        @Override
        public void onNext(T value) {

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {
        }
    }
}

