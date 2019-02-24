package com.globaldex.newlistapp.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.WindowManager;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


public class BaseFragment extends Fragment {
    public final String TAG = this.getClass().getSimpleName();

    private CompositeDisposable disposables;

    /**
     * Loading indicator methods
     */

    protected Action onLoadingDialogTerminate = new Action() {
        @Override
        public void run() throws Exception {
        }
    };
    protected Consumer<? super Disposable> onLoadingDialogSubscribe = new Consumer<Disposable>() {
        @Override
        public void accept(Disposable disposable) throws Exception {
            if (!disposable.isDisposed()) {
            }
        }
    };
    private long startTime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (null != savedInstanceState) {
            requireActivity().getSupportFragmentManager().putFragment(savedInstanceState, requireActivity().getSupportFragmentManager().getClass().getName(), this);
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        hideKeyboardWhenLeave();
    }


    private void hideKeyboardWhenLeave() {
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        try {
        } catch (NullPointerException npe) {
            // getView() may produce NullPointerException
        }
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (!getCompositeDisposable().isDisposed()) {
        }

        DisposeManager.dispose();

        // clearing or un-subscribing
        getCompositeDisposable().clear();
    }



    public void setTitle(String title) {
        BaseActivity activity = (BaseActivity) requireActivity();
        activity.setTitle(title);
    }

    public void addFragment(@IdRes int id, Fragment fragment) {
        BaseActivity baseActivity = (BaseActivity) requireActivity();
        baseActivity.addFragment(id, fragment);
    }

    public void addFragmentInActivityStack(@IdRes int id, Fragment fragment) {
        BaseActivity baseActivity = (BaseActivity) requireActivity();
        baseActivity.addFragmentInActivityStack(id, fragment);
    }

    public void addDialogFragment(DialogFragment fragment) {
        BaseActivity baseActivity = (BaseActivity) requireActivity();
        baseActivity.addDialogFragment(fragment);

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
            BaseActivity activity = (BaseActivity) requireActivity();
            activity.handleError(throwable);
        }

        @Override
        public void onComplete() {
        }
    }


}
