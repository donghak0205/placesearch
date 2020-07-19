package com.restapi.vo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RestSearchResult {

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

}
