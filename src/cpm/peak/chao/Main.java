package cpm.peak.chao;

import cpm.peak.chao.api.GitHubApi;
import cpm.peak.chao.retrofit.Retrofit;

public class Main {

    public static void main(String[] args) {
        Retrofit retrofit= new Retrofit();
        GitHubApi gitHubApi = retrofit.create(GitHubApi.class);
        gitHubApi.login("13594347817","123456");
    }
}
