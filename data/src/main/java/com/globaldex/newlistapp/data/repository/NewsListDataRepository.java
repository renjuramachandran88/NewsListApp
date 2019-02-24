package com.globaldex.newlistapp.data.repository;

import com.globaldex.newlistapp.data.entity.NewsListEntity;
import com.globaldex.newlistapp.data.entity.ResultsEntity;
import com.globaldex.newlistapp.data.mapper.NewsListDataMapper;
import com.globaldex.newlistapp.data.network.NewsNetwork;

import java.util.List;

import globaldex.com.newlistapp.domain.model.NewsList;
import globaldex.com.newlistapp.domain.model.Results;
import globaldex.com.newlistapp.domain.repository.NewsListRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by renjumenon on 20/02/19.
 */
public class NewsListDataRepository implements NewsListRepository {
    private NewsListDataMapper newsListDataMapper;

    public NewsListDataRepository(NewsListDataMapper newsListDataMapper){
        this.newsListDataMapper = newsListDataMapper;
    }
    @Override
    public Observable<List<Results>> getNewsList() {
        return NewsNetwork.getNewsList()
                .map(new Function<List<ResultsEntity>, List<Results>>() {
                    @Override
                    public List<Results> apply(List<ResultsEntity> resultsEntityList) throws Exception {
                        return newsListDataMapper.transform(resultsEntityList);                    }
                    
                });
    }
}
