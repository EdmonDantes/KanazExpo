package ru.doublegum;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.hibernate.action.internal.CollectionAction;
import org.springframework.boot.json.YamlJsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HereApi {

    private static final String APP_ID = "1mg85PnDFUTywNhDV4Av";
    private static final String APP_CODE = "PJCgtuFiz_torVAdzr99tg";

    private String get(String url, Map<String, String> param) throws IOException {
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

    public String hereGet(String url, Map<String, String> param) throws IOException {
        param.put("app_id", APP_ID);
        param.put("app_code", APP_CODE);
        param.put("language", "ru");
        param.put("locationattributes", "ru");
        return get(url, param);
    }

    public Map<String, String> getAddressFromPoint(double x, double y) throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("prox", x + "," + "y" + "," + 15);
        params.put("mode", "retrieveAddresses");
        params.put("maxresults", "1");
        params.put("gen","9");
        JsonObject obj = (JsonObject) new JsonParser().parse(hereGet("http://reverse.geocoder.api.here.com/6.2/reversegeocode.json", params));
        obj = obj.get("Response").getAsJsonObject().get("View").getAsJsonArray().get(0).getAsJsonObject().get("Result").getAsJsonArray().get(0).getAsJsonObject().get("Address").getAsJsonObject();

        Map<String, String> result = new HashMap<>();

        result.put("Country", "TODO:");
        return result;
    }

}
