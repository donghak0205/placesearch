package com.placesearch.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.stream.IntStream;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class SearchResult {

    @Id
    String id;

    //meta
    String keyword;

    int pageable_count;

    int total_count;

    Boolean is_end;

    //document
    String place_name;

    String address_name;

    String category_name;

    String phone;

    String place_url;

    String x;

    String y;

    int pageCount=0;

    public SearchResult(String place_name, String phone, String address_name, String category_name, String place_url, String id, String x, String y,
                        String keyword, Object pageable_count, Object total_count) {

        this.place_name = place_name;
        this.phone = phone;
        this.address_name = address_name;
        this.category_name = category_name;
        this.place_url = place_url;
        this.id = id;
        this.x = x;
        this.y = y;
        this.keyword = keyword;
        this.pageable_count = (int)pageable_count;
        this.total_count = (int)total_count;

        calPage();
    }


    //Page Count Calculation
    public void calPage() {
        IntStream.rangeClosed(0, pageable_count/10).forEach(i->pageCount++);
    }

}
