package com.globaldex.newlistapp.data.network;

import android.app.Application;
import android.util.Log;

import com.globaldex.newlistapp.data.entity.NewsListEntity;
import com.globaldex.newlistapp.data.entity.ResultsEntity;
import com.globaldex.newlistapp.data.network.News.NewsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by renjumenon on 21/02/19.
 */
public class NewsNetwork {
    // as per CPS timeout session
    private static final long TIMEOUT = 28;
    private static final String baseUrl = "http://api.nytimes.com/";


    private static Retrofit retrofit;


    public static void init(Application app) {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Type collectionStringType = new TypeToken<List<String>>() {}.getType();



        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setLenient()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .registerTypeAdapter(collectionStringType, new ListFromStringTypeAdapter())
                .create();


        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient)
                .build();


    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static Observable<List<ResultsEntity>> getNewsList() {
        final NewsService service = retrofit.create(NewsService.class);
        return service.getNewsList().map(new Function<BaseResponse<List<ResultsEntity>>, List<ResultsEntity>>() {
            @Override
            public List<ResultsEntity> apply(BaseResponse<List<ResultsEntity>> listBaseResponse) throws Exception {
                return listBaseResponse.getResults();
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("getNewsList",throwable.toString());
            }
        });


    }



}
















