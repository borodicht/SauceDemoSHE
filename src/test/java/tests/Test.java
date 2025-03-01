package tests;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Test {

    @org.testng.annotations.Test
    public void test() {
        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
        log.trace("trace");

    }
}
