package org.example;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerifierTest {


    @Test
    void taskExampleTest() {
        Assertions.assertFalse(Verifier.verify("src\\test\\resources\\example_1.json"));
    }

    @Test
    void moreStatementsWithValidResources(){
        Assertions.assertTrue(Verifier.verify("src\\test\\resources\\example_2.json"));
    }

    @Test
    void resourceWithSingleAsteriskAsASubstring(){
        Assertions.assertTrue(Verifier.verify("src\\test\\resources\\example_3.json"));
    }

    @Test
    void resourceWithDoubleAsterisk(){
        Assertions.assertTrue(Verifier.verify("src\\test\\resources\\example_4.json"));
    }

    @Test
    void resourceAsListWithSingleAsterisksAsSubstrings(){
        Assertions.assertTrue(Verifier.verify("src\\test\\resources\\example_5.json"));
    }

    @Test
    void jsonWithoutResourceKey(){
        //should return true because resource is not obligatory
        Assertions.assertTrue(Verifier.verify("src\\test\\resources\\example_6.json"));
    }

    @Test
    void resourceWithValueThatIsNotStringOrArrayOfStrings(){
        //This is an edge case when Resource contains integer: 12345, it should return true because it's not "*"
        Assertions.assertTrue(Verifier.verify("src\\test\\resources\\example_7.json"));
    }

    @Test
    void multipleStatementsWithOneNotValid(){
        Assertions.assertFalse(Verifier.verify("src\\test\\resources\\example_8.json"));
    }

    @Test
    void statementGivenAsEmptyArray(){
        Assertions.assertTrue(Verifier.verify("src\\test\\resources\\example_9.json"));
    }
}