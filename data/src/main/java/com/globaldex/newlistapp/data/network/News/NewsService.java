package com.globaldex.newlistapp.data.network.News;

import com.globaldex.newlistapp.data.entity.NewsListEntity;
import com.globaldex.newlistapp.data.entity.ResultsEntity;
import com.globaldex.newlistapp.data.network.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by renjumenon on 21/02/19.
 */
public interface NewsService {
    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=VAwrYe4PBxQ7U15RIoEVlcfAPuu7nzwP")
    Observable<BaseResponse<List<ResultsEntity>>> getNewsList();
}
