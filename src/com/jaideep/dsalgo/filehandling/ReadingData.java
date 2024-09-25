package com.jaideep.dsalgo.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingData {
    public static void main(String[] args) {
        try (InputStreamReader inputStreamReader = new FileReader("src/com/jaideep/dsalgo/filehandling/note.txt")) {
            while (inputStreamReader.ready()) {
                char letter = (char) inputStreamReader.read();
                System.out.println(letter);
                if (letter == 'v') break;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(bufferedReader.readLine());
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/com/jaideep/dsalgo/filehandling/note.txt"))) {
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
