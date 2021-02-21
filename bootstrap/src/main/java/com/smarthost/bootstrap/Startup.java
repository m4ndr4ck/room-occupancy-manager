package com.smarthost.bootstrap;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Startup {
    public static void main(String ... args) {
        Quarkus.run(args);
    }
}