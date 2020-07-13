package com.restapi.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RestSearchVo {

    private String keywordNm;

    private String currentPage;

    private int pageSize = 10;
}
