package com.placesearch.vo;

import com.placesearch.domain.SearchResult;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.IntStream;

@Getter
@Setter
public class PageMaker {

    private int totalcount;
    private int pageable_count;
    private int pageCount = 0;
    private List<Integer> pageList;

    public PageMaker(SearchResult searchResult) {
        this.totalcount = searchResult.getTotal_count();
        this.pageable_count = searchResult.getPageable_count();

        calPages();

    }

    //Calculator Page size
    private void calPages() {
        IntStream.rangeClosed(0, pageable_count).forEach(i->pageList.add(i));
    }

}

