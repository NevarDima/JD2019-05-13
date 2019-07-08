package by.it.izaykoff.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResManager {
    INSTANCE;

    private String baseName = "by.it.izaykoff.jd02_05.resources.messages";
    private Locale locale;
    private ResourceBundle bundle;

    ResManager(){
        setLocale(Locale.ENGLISH);
    }

    public void setLocale(Locale locale){
        this.locale = locale;
        bundle = ResourceBundle.getBundle(baseName,locale);
    }

    public String get(String key){
        return bundle.getString(key);
    }

    public Locale getLocale(){
        return bundle.getLocale();
    }
}
