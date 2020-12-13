package pl.kielce.weather_api.Service;

import pl.kielce.weather_api.model.Location;
import pl.kielce.weather_api.model.Weather;

import java.util.List;

public interface WeatherService {
     List<Location> findLocationByName(String name);
     Weather getWeatherById(String woeId);
}
