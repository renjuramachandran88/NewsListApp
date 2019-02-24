package com.globaldex.newlistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.globaldex.newlistapp.data.mapper.NewsListDataMapper;
import com.globaldex.newlistapp.data.repository.NewsListDataRepository;

import globaldex.com.newlistapp.domain.usecases.NewsListUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {
    private NewsListUseCase newsListUseCase;

    public MainActivity(){
        newsListUseCase = new NewsListUseCase(new NewsListDataRepository(new NewsListDataMapper()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}
