package com.placesearch.vo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageVO {

    private static final int DEFAULT_SIZE = 10;      //page data size
    private static final int DEFAULT_MAX_SIZE = 10; //toatl data size

    private int page;
    private int size;

    public PageVO() {
        this.page = 1;
        this.size = DEFAULT_SIZE;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page < 0 ? 1 : page;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = (size < DEFAULT_SIZE || size > DEFAULT_SIZE) ? DEFAULT_SIZE : size;
    }

    //Make Pageable
    public Pageable makePageable(int direction, String orderbyName) {

        Sort.Direction dir = direction == 0 ? Sort.Direction.DESC : Sort.Direction.ASC; //order standard
        return PageRequest.of(this.page - 1, this.size, dir, orderbyName);

    }
}
