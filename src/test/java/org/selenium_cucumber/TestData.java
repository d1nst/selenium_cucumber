package org.selenium_cucumber;

import org.selenium_cucumber.myRunner.TestRunner;

public enum TestData {

    FIRST_NAME("Dan"),
    EMAIL(TestRunner.EMAIL),
    LAST_NAME("Stefan"),
    PASSWORD("P@ssw0rd!1"),
    TOWN("Bucureşti"),
    COUNTRY("Romania"),
    COUNTRY_CODE("RO"),
    STATE_CODE("287"),
    POSTAL_CODE("123940"),
    PHONE_NUMBER("0751123456");

    public final String value;
    TestData(String value){
        this.value = value;
    }
}