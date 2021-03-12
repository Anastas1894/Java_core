package project;

public class AppGlobalState {
    private static AppGlobalState instanse;

    private String cityKey;

    public String getCityKey() {

        return cityKey;
    }

    public void setCityKey(String cityKey) {

        this.cityKey = cityKey;
    }

    public String getApiKey() {
        return "56xn0s83Kt8BZvka4AWzhplnLDnpHIER";
    }

    private AppGlobalState() {
    }

    public static AppGlobalState getInstance() {
        if (instanse == null) {
            instanse = new AppGlobalState();
        }
        return instanse;
    }
}
