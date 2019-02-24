package com.globaldex.newlistapp.data.network;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListFromStringTypeAdapter extends TypeAdapter<List<String>> {

    public List<String> read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        if (reader.peek() == JsonToken.STRING) {
            // ** This is the part where we fix the issue **
            // If we receive a String, get this and put it in a list.
            // Result will be that item in a list.
            List<String> list = new ArrayList<>();
            list.add(reader.nextString());
            return list;
        } else {
            // Else we expect to receive the array.
            // Based on original collection implementation:
            // https://github.com/google/gson/blob/0636635cbffa08157bdbd558b1212e4d806474eb/gson/src/main/java/com/google/gson/internal/bind/CollectionTypeAdapterFactory.java
            List<String> list = new ArrayList<>();
            reader.beginArray();
            while (reader.hasNext()) {
                String value = reader.nextString();
                list.add(value);
            }
            reader.endArray();
            return list;
        }
    }

    public void write(JsonWriter writer, List<String> list) throws IOException {
        // Simply writing the array, we don't need to modify anything here.
        // Based on original collection type adapter implementation:
        // https://github.com/google/gson/blob/0636635cbffa08157bdbd558b1212e4d806474eb/gson/src/main/java/com/google/gson/internal/bind/CollectionTypeAdapterFactory.java
        if (list == null) {
            writer.nullValue();
            return;
        }
        writer.beginArray();
        for (String string : list) {
            writer.value(string);
        }
        writer.endArray();
    }
}
