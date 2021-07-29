package com.ssafy.hwjava10;

import java.util.ArrayList;
import java.util.List;

public interface INewsDAO {
	List<News> getNewsList(String url);
}
