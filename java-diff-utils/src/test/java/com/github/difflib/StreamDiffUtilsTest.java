package com.github.difflib;

import org.junit.jupiter.api.Test;

import java.io.*;

class StreamDiffUtilsTest {

    @Test
    void testDiff() throws IOException {
        BufferedReader original = new BufferedReader(new StringReader("aaa\nbbb\nccc"));
        BufferedReader revised = new BufferedReader(new StringReader("aaa\nccc\nddd\neee"));

        StreamPatch patch = new StreamPatch() {

            @Override
            public void addInsert(String line) throws IOException {
                System.out.println("+++ " + line);
            }

            @Override
            public void addDelete(String line) throws IOException {
                System.out.println("--- " + line);
            }
        };

        StreamDiffUtils.diff(original, revised, patch);

        original.close();
        revised.close();
    }
}