package jaeh.decoratorspring;


public class Client {

    //property 값
    private static boolean wneEmailEnabled = true;
    private static boolean wneSlackEnabled = true;
    public static void callService(){
        AlarmService alarmService = new DefaultAlarmService();

        if (wneEmailEnabled) {
            alarmService = new EmailAlarmDecorator(alarmService);
        }

        if (wneSlackEnabled) {
            alarmService = new SlackAlarmDecorator(alarmService);
        }

        HcisLoginFailureEvent client = new HcisLoginFailureEvent(alarmService);

        LoginFailureMessage loginFailureEvent = new LoginFailureMessage("jaeh0728","127.0.0.1",5);
        client.failCount5(loginFailureEvent);
    };

}
