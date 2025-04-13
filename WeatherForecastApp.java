import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class WeatherForecastApp {

    public static void main(String[] args) {
        try {
            String apiKey = "YOUR_API_KEY";
            String city = "London";
            String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
            
            URL url = new URL(urlString);
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int status = connection.getResponseCode();
            if (status != 200) {
                System.out.println("Error: Unable to fetch data. Status code: " + status);
                return;
            }
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String responseString = response.toString();
            String cityName = extractJsonValue(responseString, "\"name\":\"", "\"");
            String weatherDescription = extractJsonValue(responseString, "\"description\":\"", "\"");
            String temp = extractJsonValue(responseString, "\"temp\":", ",");
            String pressure = extractJsonValue(responseString, "\"pressure\":", ",");
            String humidity = extractJsonValue(responseString, "\"humidity\":", ",");
            String visibility = extractJsonValue(responseString, "\"visibility\":", ",");
            
            System.out.println("Weather Forecast for " + cityName);
            System.out.println("Weather Description: " + weatherDescription);
            System.out.println("Temperature: " + temp + "°C");
            System.out.println("Pressure: " + pressure + " hPa");
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Visibility: " + visibility + " meters");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String extractJsonValue(String json, String key, String delimiter) {
        int start = json.indexOf(key);
        if (start == -1) return "Not Available";
        start += key.length();
        int end = json.indexOf(delimiter, start);
        if (end == -1) end = json.indexOf("}", start);
        return json.substring(start, end);
    }
}
