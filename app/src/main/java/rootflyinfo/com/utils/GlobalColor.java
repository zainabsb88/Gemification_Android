package rootflyinfo.com.utils;

import android.app.Application;

/**
 * Created by Mithun Manoharan on 9/15/2016.
 */
public class GlobalColor extends Application{

    //color coding
    static String header,header_text,foreground,background,content,logo;

    public static String getHeader() {
        return header;
    }

    public static void setHeader(String header) {
        GlobalColor.header = header;
    }

    public static String getHeader_text() {
        return header_text;
    }

    public static void setHeader_text(String header_text) {
        GlobalColor.header_text = header_text;
    }

    public static String getForeground() {
        return foreground;
    }

    public static void setForeground(String foreground) {
        GlobalColor.foreground = foreground;
    }

    public static String getBackground() {
        return background;
    }

    public static void setBackground(String background) {
        GlobalColor.background = background;
    }

    public static String getContent() {
        return content;
    }

    public static void setContent(String content) {
        GlobalColor.content = content;
    }

    public static String getLogo() {
        return logo;
    }

    public static void setLogo(String logo) {
        GlobalColor.logo = logo;
    }

    //Default Package
    public static GlobalColor getSingleton() {
        return singleton;
    }

    public static void setSingleton(GlobalColor singleton) {
        GlobalColor.singleton = singleton;
    }
    private static GlobalColor singleton;

    public static GlobalColor getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}
