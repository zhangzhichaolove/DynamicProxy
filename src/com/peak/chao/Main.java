package com.peak.chao;

import com.peak.chao.api.GitHubApi;
import com.peak.chao.retrofit.Retrofit;

public class Main {

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit();
        GitHubApi gitHubApi = retrofit.create(GitHubApi.class);
        gitHubApi.register("13594347817", "123456");
        gitHubApi.login("13594347817", "123456");
    }
}
