package com.restapi.service;

import com.restapi.vo.RestSearchVo;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;

@Component
@NoArgsConstructor
public class KakaoMapApi {

    private final String app_key = "7947034c108cfae102db77003dea5e8a";
    private final String Host  = "https://dapi.kakao.com";
    private final String SEARCH_PLACE_KEYWORD_PATH = "/v2/local/search/keyword.json";

    public ResponseEntity getPlace(RestSearchVo restSearchVo) throws Exception{

        //condition Create
        String queryString = "?query="+ URLEncoder.encode( restSearchVo.getKeywordNm(),"UTF-8")
                           + "&page="+restSearchVo.getCurrentPage()
                           + "&size=" + restSearchVo.getPageSize();

        URI uri= new URI(Host+SEARCH_PLACE_KEYWORD_PATH+queryString);

        //Header Crate
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "KakaoAK " + app_key);

        RequestEntity<String> rq = new RequestEntity<>(httpHeaders, HttpMethod.GET,uri);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> re = restTemplate.exchange(rq, String.class);

        return re;
    }

}
