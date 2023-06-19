package decorator;

public class EmailAlarmDecorator extends AlarmDecorator {

    public EmailAlarmDecorator(AlarmService alarmService) {
        super(alarmService);
    }

    @Override
    public void sendMessage(LoginFailureEvent event) {
    	
    	sendEmail(event);
        super.sendMessage(event);
    }

    private void sendEmail(LoginFailureEvent event) {
    	System.out.println("이메일 전송 LoginFailEmailAlarmService 호출: " + event);
    }
}
