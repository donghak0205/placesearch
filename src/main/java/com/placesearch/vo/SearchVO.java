package com.placesearch.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SearchVO {

	//meta
	String[] same_name;
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
	int currentPage;
}


