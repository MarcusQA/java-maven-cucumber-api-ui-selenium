package api.helpers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpMethods {
    public static HttpURLConnection makeGetCall(String uri) {
        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            return connection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
