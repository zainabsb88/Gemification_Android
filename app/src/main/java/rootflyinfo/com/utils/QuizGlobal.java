package rootflyinfo.com.utils;

import android.app.Application;

/**
 * Created by Mithun Manoharan on 8/24/2016.
 */
public class QuizGlobal extends Application{
    private static int quiz_no;

    public static int getQuiz_no() {
        return quiz_no;
    }

    public static void setQuiz_no(int quiz_no) {
        QuizGlobal.quiz_no = quiz_no;
    }

    //SignUp Company Details
    private static String cmp_name="";

    public static String getCmp_name() {
        return cmp_name;
    }

    public static void setCmp_name(String cmp_name) {
        QuizGlobal.cmp_name = cmp_name;
    }


    //Default Package

    public static QuizGlobal getSingleton() {
        return singleton;
    }

    public static void setSingleton(QuizGlobal singleton) {
        QuizGlobal.singleton = singleton;
    }
    private static QuizGlobal singleton;

    public static QuizGlobal getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}
