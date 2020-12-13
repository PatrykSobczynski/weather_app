package pl.kielce.weather_api.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kielce.weather_api.model.Location;
import pl.kielce.weather_api.model.Weather;

import java.util.List;

import static java.util.Arrays.asList;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public List<Location> findLocationByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Location[] locations = restTemplate.getForObject("https://www.metaweather.com/api/location/search/?query=" + name, Location[].class);
        return asList(locations);
    }

    @Override
    public Weather getWeatherById(String woeId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.metaweather.com/api/location/" + woeId, Weather.class);
    }
}
