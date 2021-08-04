package com.solvd.TextParsing;
import org.apache.commons.io.FileSystem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.*;


public class Runner {
    private final static Logger LOGGER = Logger.getLogger(Runner.class);

    public final static void main(String[] args) throws IOException {

        File Florem = new File("src/main/resources/LoremIpsum.txt");

        FileUtils.write(new File("src/main/resources/result.txt"), wordCount(Florem), "UTF-8");
    }



    public static String wordCount(File file) throws IOException {

        Map<String, Integer> words = new HashMap<>();

        String text = FileUtils.readFileToString(file, "UTF-8").toLowerCase();

        Arrays.stream(StringUtils.split(text," .,-/")).forEach((word)->{
            if(words.containsKey(word))  words.replace(word, words.get(word) + 1);
            else words.put(word, 1);
        });

        return words.toString();
    }
}


