package project.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import project.AppGlobalState;

import java.io.IOException;

public class AccuWeatherProvider implements IWeatherProvider {
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CONDITIONS_PATH = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = AppGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void getCurrentWeather(String cityKey) throws IOException {
        //http://dataservice.accuweather.com//v1/27497?apikey={{accuweatherApiKey}}


        HttpUrl getWeatherUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(CONDITIONS_PATH)
                .addPathSegment(API_VERSION)
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request getWeatherRequest = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(getWeatherUrl)
                .build();

        Response response = client.newCall(getWeatherRequest).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Ошибка сети\n");
        }
        String jsonBody = response.body().string();

        JsonNode jsonNode = objectMapper.readTree(jsonBody);
        for (int i = 0; i < 5; i++) {
            String date = jsonNode.at("/DailyForecasts").get(i).at("/Date").asText();
            Integer TEMPERATURE = jsonNode.at("/DailyForecasts").get(i).at("/Temperature/Minimum/Value").asInt();
            String WEATHER_TEXT = jsonNode.at("/DailyForecasts").get(i).at("/Day/IconPhrase").asText();


            System.out.printf("%s ожидается температура %s погодные условия %s.\n ", date,TEMPERATURE,WEATHER_TEXT);
        }
    }
}
