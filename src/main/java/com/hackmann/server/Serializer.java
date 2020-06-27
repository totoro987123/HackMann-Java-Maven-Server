package com.hackmann.server;

import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

import com.hackmann.packets.Event;

public class Serializer {

    private int headerSize;
    private Gson gson = new Gson();

    public Serializer(int headerSize) {
        this.headerSize = headerSize;
    }

    public int getLength(byte[] bytes) {
        int headerLength = 0;
        for (int i = 0; i < this.headerSize; i++) {
            if ((char) bytes[i] == '-') {
                headerLength = i;
                break;
            }
        }

        return Integer.parseInt(new String(Arrays.copyOfRange(bytes, 0, headerLength)));
    }

    public String bytesToText(byte[] bytes) {
        return new String(bytes);
    }

    public byte[] textToBytes(String string) {
        return string.getBytes();
    }

    public JSONObject stringToJSON(String string) {
        return new JSONObject(string);
    }

    public Event jsonToEvent(String json) {
        JSONObject jsonObject = this.stringToJSON(json);
        try {
            return (Event) this.gson.fromJson(json, Class.forName("com.hackmann.packets.server."+jsonObject.getString("className")));
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String eventToJson(Event event) {
        return this.gson.toJson(event);
    }

    public Event bytesToEvent(byte[] bytes){
        return this.jsonToEvent(this.bytesToText(bytes));
    }

    public byte[] eventToBytes(Event event){
        return this.textToBytes(this.eventToJson(event));
    }

}