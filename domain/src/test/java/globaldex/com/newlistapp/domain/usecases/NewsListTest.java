package globaldex.com.newlistapp.domain.usecases;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import globaldex.com.newlistapp.domain.repository.NewsListRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by renjumenon on 24/02/19.
 */
@RunWith(MockitoJUnitRunner.class)
public class NewsListTest {
    private NewsListUseCase newsListUseCase;


    @Mock
    NewsListRepository repository;

    @Before
    public void setUp() throws Exception {
        newsListUseCase = new NewsListUseCase(repository);
    }

    @Test
    public void testGetPayBillServiceProviderListHappyCase(){
        newsListUseCase.getNewsList();
        verify(repository).getNewsList();
        verifyNoMoreInteractions(repository);
    }

}
