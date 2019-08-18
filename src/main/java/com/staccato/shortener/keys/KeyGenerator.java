package com.staccato.shortener.keys;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class KeyGenerator {

    private static final String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final List<Character> SOURCE = Lists.charactersOf(characters);

    public static List<String> generateKeys(int keyLength){
        if(keyLength <1){
            throw new IllegalArgumentException("Can't get keys of zero or negative length");
        }else if(keyLength >= SOURCE.size()){
            throw new UnsupportedOperationException();
        }
        List<String> result = new LinkedList<>();

        List<Character> provisional = new LinkedList<>(SOURCE);

        Collections.shuffle(provisional);

        for(int i=0; i<provisional.size() - keyLength; i+=keyLength){
            Character[] sequence = provisional.subList(i, i+keyLength).toArray(new Character[0]);
            result.add(new String(ArrayUtils.toPrimitive(sequence)));
        }
        return result;
    }
}
