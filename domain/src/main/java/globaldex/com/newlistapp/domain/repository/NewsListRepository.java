package globaldex.com.newlistapp.domain.repository;

import java.util.List;

import globaldex.com.newlistapp.domain.model.NewsList;
import globaldex.com.newlistapp.domain.model.Results;
import io.reactivex.Observable;

/**
 * Created by renjumenon on 20/02/19.
 */
public interface NewsListRepository {
    Observable<List<Results>> getNewsList();
}
