package com.staccato.shortener;

import com.staccato.shortener.keys.KeyGenerator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;

public class KeyGeneratorTest {

    @Test
    public void getZeroLengthKey(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> KeyGenerator.generateKeys(0));
    }

    @Test
    public void getNegativeLengthKey(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> KeyGenerator.generateKeys(-12));
    }

    @Test
    public void getKeys(){
        List<String> keys = KeyGenerator.generateKeys(7); //ToDo: get this number from properties
        assert !keys.isEmpty();
        assert keys.size() >= 8;
    }
}
