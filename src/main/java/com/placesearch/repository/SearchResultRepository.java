package com.placesearch.repository;

import com.placesearch.domain.SearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchResultRepository extends JpaRepository<SearchResult,String> {

    @Query(value = "SELECT DISTINCT page_count, keyword FROM SEARCH_RESULT" , nativeQuery=true)
    public List<Object[]> selectParameter();

}
