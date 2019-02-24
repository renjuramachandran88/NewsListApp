package com.globaldex.newlistapp.news;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.globaldex.newlistapp.R;
import com.globaldex.newlistapp.data.mapper.NewsListDataMapper;
import com.globaldex.newlistapp.data.repository.NewsListDataRepository;
import com.globaldex.newlistapp.databinding.ActivityNewsBinding;

import java.util.ArrayList;
import java.util.List;

import globaldex.com.newlistapp.domain.model.Results;
import globaldex.com.newlistapp.domain.usecases.NewsListUseCase;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class NewsActivity extends AppCompatActivity implements NewsAdapter.NewsItemClickListener {
    private ActivityNewsBinding binding;
    private NewsListUseCase newsListUseCase;
    private CompositeDisposable disposables;
    private List<Results> resultsList;
    private NewsAdapter newsAdapter;
    private Results selectedresult;

    public NewsActivity() {
        newsListUseCase = new NewsListUseCase(new NewsListDataRepository(new NewsListDataMapper()));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(NewsActivity.this, R.layout.activity_news);
        showNewsList();


    }

    private List<Results> getResults(List<Results> inputProviderList) {
        List<Results> outputProviderLists = new ArrayList<>();
        for (Results results : inputProviderList) {
            outputProviderLists.add(results);
        }
        return outputProviderLists;
    }

    private CompositeDisposable getCompositeDisposable() {
        if (disposables == null || disposables.isDisposed()) {
            disposables = new CompositeDisposable();
        }
        return disposables;
    }

    @Override
    public void onListItemClick(Results results) {
        selectedresult = results;
        Intent intent = new Intent(NewsActivity.this,NewsDetailActivity.class);
        intent.putExtra("html",selectedresult.getUrl());
        Log.e("html",selectedresult.getUrl());
        startActivity(intent);

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

    private void showNewsList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(binding.getRoot().getContext());
        binding.rvNews.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(this);
        binding.rvNews.setAdapter(newsAdapter);
        getNews();


    }

    private void getNews(){
        newsListUseCase.getNewsList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposingObserver<List<Results>>() {
                    @Override
                    public void onNext(List<Results> value) {
                        for(Results r : value){
                            Log.e("hh",r.getTitle());
                            Log.e("hh",r.getByline());
                        }
                        newsAdapter.setNewsList(value);
                        newsAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.e("error", throwable.toString());
                    }
                });

    }
}
