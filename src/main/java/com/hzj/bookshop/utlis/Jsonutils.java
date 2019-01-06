package com.hzj.bookshop.utlis;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Jsonutils {

    public static Object getValue(String json,String memberName, String type) {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        if (jsonObject.has(memberName)) {
            switch (type) {
                case "int":
                    return jsonObject.get(memberName).getAsInt();
                case "string":
                    return jsonObject.get(memberName).getAsString();
                case "double":
                    return jsonObject.get(memberName).getAsDouble();
                case "float":
                    return jsonObject.get(memberName).getAsFloat();
            }
        }
        return null;
    }
}
