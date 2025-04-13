A simple Java application that fetches real-time weather data for a specified city from the OpenWeatherMap API and displays key weather details such as temperature, pressure, humidity, and visibility.

Features
Fetches weather data from OpenWeatherMap API.

Displays temperature, pressure, humidity, and visibility.

Handles basic errors such as invalid city names or connection issues.

Simple string parsing for extracting JSON data.

Prerequisites
Java 8 or higher.

OpenWeatherMap API Key (sign up at OpenWeatherMap for a free API key).

Setup and Usage
Clone the repository or download the project files.

Replace YOUR_API_KEY in the code with your valid OpenWeatherMap API key.

java
Copy
Edit
String apiKey = "YOUR_API_KEY"; // Replace with your OpenWeatherMap API key
Set the city you want the weather information for:

java
Copy
Edit
String city = "London"; // Replace with your desired city
Compile and run the Java application:

bash
Copy
Edit
javac WeatherForecastApp.java
java WeatherForecastApp
The weather information for the specified city will be displayed in the console.

Example Output:
yaml
Copy
Edit
Weather Forecast for London
Weather Description: clear sky
Temperature: 15°C
Pressure: 1012 hPa
Humidity: 81%
Visibility: 10000 meters
License
This project is open-source and available under the MIT License.
