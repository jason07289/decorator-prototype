package decorator;

public class App {//= 이벤트 발생하는 Class

	//property 값
    private static boolean wneEmailEnabled = true;
    private static boolean wneSlackEnabled = true;

    public static void main(String[] args) {
        AlarmService alarmService = new DefaultAlarmService();

        if (wneEmailEnabled) {
        	alarmService = new EmailAlarmDecorator(alarmService);
        }

        if (wneSlackEnabled) {
        	alarmService = new SlackAlarmDecorator(alarmService);
        }// 이부분은 어떤식으로 풀까? property로 Bean생성하는것을 조절?

        HcisLoginFailureEvent client = new HcisLoginFailureEvent(alarmService);
        client.failCount5("로그인 5회 실패");
    }
}
