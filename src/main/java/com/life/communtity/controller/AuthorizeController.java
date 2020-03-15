package com.life.communtity.controller;

import com.life.communtity.Provide.GitHubProvider;
import com.life.communtity.dto.AccessTokenDTO;
import com.life.communtity.dto.GitHubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author:Chengzhen
 * @date:2020/3/15
 * @ver:1.0
 **/
@Controller
public class AuthorizeController {
    @Autowired
    private GitHubProvider gitHubProvider;
    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("6de21ba7e711c30c7cd6");
        accessTokenDTO.setClient_secret("75471798ec3b80916c5af9075a207c5d96bef750");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri("http://localhost:8088/callback");
        String acessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser user = gitHubProvider.getUser(acessToken);
        System.out.println(user.getId());
        return "index";
    }
}
