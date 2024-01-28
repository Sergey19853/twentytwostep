package edu.examples.java_classes.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderWriterFilesUtil {
	
    public static void export(List<String> notes) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("resources/notes.txt"));
        for(String note: notes){
            writer.write(note);
        }
        writer.close();
    }

    public static List<String> importNotes() throws IOException {
        List<String> notes = new ArrayList<>();
        Stream<String> notesStream = Files.lines(Paths.get("resources/notes.txt"));
        notes =  notesStream.collect(Collectors.toList());
        return notes;
    }
    
}
