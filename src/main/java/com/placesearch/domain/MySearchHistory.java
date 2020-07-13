package com.placesearch.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;


@ToString
@NoArgsConstructor
@Getter
@Entity
public class MySearchHistory {


    @Id
    String keyword;

    String userName;

    @CreationTimestamp
    private Timestamp createdDate;

    public MySearchHistory(String userName, String keyword) {
        this.userName = userName;
        this.keyword = keyword;
    }
}
