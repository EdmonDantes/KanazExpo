package ru.doublegum;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HereApi {

    private static final String APP_ID = "1mg85PnDFUTywNhDV4Av";
    private static final String APP_CODE = "PJCgtuFiz_torVAdzr99tg";

    private static String get(String url, Map<String, String> param) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(url).append("?");
        for (Map.Entry<String, String> tmp : param.entrySet()) {
            builder.append(tmp.getKey()).append("=").append(tmp.getValue()).append("&");
        }

        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
        urlConnection.setRequestMethod("GET");


        BufferedReader in = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        urlConnection.disconnect();
        return content.toString();
    }

    private static String hereGet(String url, Map<String, String> param) throws IOException {
        param.put("app_id", APP_ID);
        param.put("app_code", APP_CODE);
        param.put("gen","10");
        param.put("language", "ru");
        param.put("locationattributes", "ru");
        return get(url, param);
    }

    public static Map<String, String> getAddressFromPoint(double x, double y) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("prox", x + "," + "y" + "," + 15);
        params.put("mode", "retrieveAddresses");
        params.put("maxresults", "1");
        params.put("gen","9");
        JsonObject obj = (JsonObject) new JsonParser().parse(hereGet("http://reverse.geocoder.api.here.com/6.2/reversegeocode.json", params));
        obj = obj.get("Response").getAsJsonObject().get("View").getAsJsonArray().get(0).getAsJsonObject().get("Result").getAsJsonArray().get(0).getAsJsonObject().get("Address").getAsJsonObject();

        Map<String, String> result = new HashMap<>();

        if (obj.has("Country"))
            result.put("country", obj.get("Country").getAsString());
        if (obj.has("State"))
            result.put("state", obj.get("State").getAsString());
        if (obj.has("City"))
            result.put("city", obj.get("City").getAsString());
        if (obj.has("District"))
            result.put("district", obj.get("District").getAsString());
        if (obj.has("Street"))
            result.put("street", obj.get("Street").getAsString());
        
        return result;
    }

    public static String getLocationId(Map<String, String> data) throws IOException {
        JsonObject obj = (JsonObject) new JsonParser().parse(hereGet("http://geocoder.api.here.com/6.2/geocode.json", data));
        return obj.get("Response").getAsJsonObject().get("View").getAsJsonArray().get(0).getAsJsonObject().get("Result").getAsJsonArray().get(0).getAsJsonObject().get("Location").getAsJsonObject().get("LocationId").getAsString();
    }

}
