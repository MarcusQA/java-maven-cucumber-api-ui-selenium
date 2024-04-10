package api.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpResponses {
    public static String getResponseBody(HttpURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer responseBody = new StringBuffer();
        while (true) {
            try {
                if ((inputLine = reader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            responseBody.append(inputLine);
        }
        reader.close();
        return responseBody.toString();
    }
}
