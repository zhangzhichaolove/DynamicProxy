package com.peak.chao;

import com.peak.chao.api.GitHubApi;
import com.peak.chao.retrofit.Retrofit;

public class Main {

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit();
        GitHubApi gitHubApi = retrofit.create(GitHubApi.class);
        gitHubApi.register("00d91e8e0cca2b76f515926a36db68f5", "13594347817", "123456");
        gitHubApi.login("00d91e8e0cca2b76f515926a36db68f5", "13594347817", "123456");
    }
}
