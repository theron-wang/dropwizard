package com.uber;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Test {
    String foo(String path, @Nullable String s, @Nullable Object o) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Code inside try-resource gets analyzed
            // BUG: Diagnostic contains: dereferenced expression
            o.toString();
            s = br.readLine();
            return s;
        }
    }
}
