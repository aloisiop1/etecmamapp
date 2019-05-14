package br.com.etecmam.etecmamapp.sms;

import br.com.etecmam.etecmamapp.App;

public class Util {
    private static App app = null;

    public static App getApp() {
        return app;
    }

    public static void setApp(App app) {
        Util.app = app;
    }
}
