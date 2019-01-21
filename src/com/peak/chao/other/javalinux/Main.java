package com.peak.chao.other.javalinux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("ls");
        print(process.getErrorStream());
        print(process.getInputStream());
        process.waitFor();
        Process pwd = Runtime.getRuntime().exec("pwd");
        print(pwd.getErrorStream());
        print(pwd.getInputStream());
        pwd.waitFor();
        Process cat = Runtime.getRuntime().exec("cat LICENSE");
        print(cat.getErrorStream());
        print(cat.getInputStream());
        cat.waitFor();
    }


    private static void print(InputStream is) throws IOException {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null) {
            System.err.println(line);
            //System.out.println(line);
        }
    }
}
