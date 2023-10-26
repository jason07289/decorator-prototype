package jaeh.decoratorspring.service.alarm;

import jaeh.decoratorspring.AlarmService;
import jaeh.decoratorspring.LoginFailureMessage;

public class SlackAlarmDecorator extends AlarmDecorator {// 얘는 Decorator를 상속

    public SlackAlarmDecorator(AlarmService alarmService) {
        super(alarmService);
    }

    @Override
    public void sendMessage(LoginFailureMessage event) {
    	sendSlack(event);
        super.sendMessage(event);
    }

    private void sendSlack(LoginFailureMessage event) {
    	System.out.println("슬랙 전송 LoginFailSlackAlarmService 호출: " + event);

    }
}
