package api;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class HttpClient {
    private static String ACCESS_TOKEN = null;
    private static final String BASE_URL = "https://boka.techbuddy.io/api/customer/login/";
    private static final String USERNAME = "46701231231";
    private static final String PASSWORD = "100100";

    public static JsonParser parser = new JsonParser();

    public static String login(String username, String password) throws IOException {
        /*Response response;
        String responseJson;
*/
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"id\":\"46701231231\",\"code\":\"100100\",\"hash\":\"\"}");
        Request request = new Request.Builder()
                .url("https://boka.techbuddy.io/api/customer/login/")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "773a63c8-4e3f-4c2a-87b1-04766b735290")
                .build();

        Response response = client.newCall(request).execute();
        response.headers();
        return username;
    }

    public static Response get(String url, String jsonInString) throws IOException {
        if (ACCESS_TOKEN == null) {
            String jsonString = login(USERNAME, PASSWORD);
            ACCESS_TOKEN = parser.parse(jsonString).getAsJsonObject().get("jwt").getAsString();
        }
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://boka.techbuddy.io/api/customer/tasks/")
                .get()
                .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1Yjg2NzUwYWYwMGU1MjIyYTU1OTA4YjIiLCJleHAiOjE1MzU3NDgwNzgsImNvbnRleHQiOnsiaXNzdWVyIjoiY3VzdG9tZXIiLCJlbWFpbCI6bnVsbCwicGhvbmUiOiIrNDY3MDEyMzEyMzEiLCJjb3VudHJ5Ijoic2UiLCJpc01vYmlsZUNsaWVudCI6ZmFsc2V9fQ.Ox9l55gfRUdol7CaHQ8zE8eGZVcnUdTaxkMt6KanJys")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "9de9ec53-01c6-4542-81ae-da0ac7d8eabf")
                .build();

        Response response = client.newCall(request).execute();
        return response;
    }
}
