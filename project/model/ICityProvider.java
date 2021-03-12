package project.model;

import java.io.IOException;

public interface ICityProvider {
    void getCodeByCityName(String cityName) throws IOException;
}
