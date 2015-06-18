package com.twu.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// It is used to read books from a file.

public class BookFileReader {

    private String filePath;

    public BookFileReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> getListOfAvailableBooks() {
        ArrayList<String> bookList = new ArrayList<>();
        BufferedReader br = null;
        try {
            String currentBookLine;
            br = new BufferedReader(new FileReader(filePath));

            while ((currentBookLine = br.readLine()) != null) {
                bookList.add(currentBookLine);
            }
        } catch (IOException exception) {
            exception.getStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return bookList;
    }
}