package project.controller;

import project.AppGlobalState;
import project.model.AccuWeatherCityProvider;
import project.model.AccuWeatherProvider;
import project.model.ICityProvider;
import project.model.IWeatherProvider;

import java.io.IOException;

public class Controller implements IController {
    ICityProvider codeProvider = new AccuWeatherCityProvider();
    IWeatherProvider weatherProvider = new AccuWeatherProvider();

    @Override
    public void onCityInput(String city) throws IOException {
        if (city.length() == 1) {
            throw new IOException("Недопустимо короткое название города");
        }

        codeProvider.getCodeByCityName(city);
    }

    @Override
    public void onCommandChosen(int selectedCommand) throws IOException {
        switch (selectedCommand) {
            case 1: {
                weatherProvider.getCurrentWeather(AppGlobalState.getInstance().getCityKey());
                break;
            }
            default: {
                throw new IOException("Неверный ввод\n");
            }
        }
    }
}
