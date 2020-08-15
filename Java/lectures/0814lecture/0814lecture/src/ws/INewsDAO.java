package ws;

import java.util.List;

public interface INewsDAO {
	List<News> getNewsList(String url) throws Exception;
	News search(int index);
}
