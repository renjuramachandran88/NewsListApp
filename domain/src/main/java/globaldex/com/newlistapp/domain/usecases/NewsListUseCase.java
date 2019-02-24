package globaldex.com.newlistapp.domain.usecases;

import java.util.List;

import globaldex.com.newlistapp.domain.model.NewsList;
import globaldex.com.newlistapp.domain.model.Results;
import globaldex.com.newlistapp.domain.repository.NewsListRepository;
import io.reactivex.Observable;

/**
 * Created by renjumenon on 20/02/19.
 */
public class NewsListUseCase {

    private NewsListRepository newsListRepository;

    public NewsListUseCase(NewsListRepository newsListRepository){
        this.newsListRepository = newsListRepository;
    }

    public Observable<List<Results>> getNewsList(){
        return newsListRepository.getNewsList();
    }
}
