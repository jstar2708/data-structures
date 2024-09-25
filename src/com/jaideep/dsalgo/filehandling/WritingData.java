package com.jaideep.dsalgo.filehandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class WritingData {
    public static void main(String[] args) throws IOException {
//        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out)) {
//            String out = "Hello my name is Jaideep";
//            outputStreamWriter.write(out);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/com/jaideep/dsalgo/filehandling/note.txt", true))) {
//            fileWriter.write("Bye! Bye! Bye1");
//        }

        File myFile = new File("newFile.txt");
        myFile.createNewFile();
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(myFile, true))) {
            System.out.println(myFile.getAbsoluteFile());
            fileWriter.write("Bye! Bye! Bye1");
        }
    }
}
