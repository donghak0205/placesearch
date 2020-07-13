package com.restapi.restcontroller;

import com.restapi.service.KakaoMapApi;
import com.restapi.vo.RestSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class RestApiController {

    @Autowired
    KakaoMapApi kakaoMapApi;

    @GetMapping("/place")
    public ResponseEntity searchkeyword(HttpSession session, RestSearchVo paramVO) throws Exception {

        ResponseEntity apiResponse = kakaoMapApi.getPlace(paramVO);

        return apiResponse;

    }

}

