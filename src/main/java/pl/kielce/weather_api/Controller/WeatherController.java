package pl.kielce.weather_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kielce.weather_api.Service.WeatherService;

import pl.kielce.weather_api.model.Location;
import pl.kielce.weather_api.model.Weather;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WeatherController {
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // @RequestMapping(method = RequestMethod.GET)
    // To samo co @GetMapping ^^^
    @GetMapping
    public String getWeather(Model model, @RequestParam(required = false, defaultValue = "") String query,
                             @RequestParam(required = false, defaultValue = "") String id) {

        List<Location> locations = new ArrayList<>();
        Weather weather = new Weather();


        if(!query.isEmpty()) {
            locations = weatherService.findLocationByName(query);
        }

        if(!id.isEmpty()) {
           weather = weatherService.getWeatherById(id);
        }

        model.addAttribute("loc", locations);
        model.addAttribute("weather", weather);

        return "home";
    }
}
