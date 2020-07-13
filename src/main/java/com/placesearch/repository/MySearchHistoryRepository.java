package com.placesearch.repository;

import com.placesearch.domain.MySearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MySearchHistoryRepository extends JpaRepository<MySearchHistory,String> {

    @Query(value = "SELECT distinct keyword, created_date FROM My_Search_History WHERE user_name =:UserName order by created_date desc LIMIT 10" , nativeQuery=true)
    public List<Object[]> selectMySearchHistory(@RequestParam String UserName);
    //public List<String> selectMySearchHistory();

}
