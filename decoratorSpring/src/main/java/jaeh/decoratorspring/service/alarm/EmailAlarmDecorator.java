package jaeh.decoratorspring.service.alarm;

import jaeh.decoratorspring.AlarmService;
import jaeh.decoratorspring.LoginFailureMessage;

public class EmailAlarmDecorator extends AlarmDecorator {

    public EmailAlarmDecorator(AlarmService alarmService) {
        super(alarmService);
    }

    @Override
    public void sendMessage(LoginFailureMessage event) {
    	
    	sendEmail(event);
        super.sendMessage(event);
    }

    private void sendEmail(LoginFailureMessage event) {
    	System.out.println("이메일 전송 LoginFailEmailAlarmService 호출: " + event);
    }
}
