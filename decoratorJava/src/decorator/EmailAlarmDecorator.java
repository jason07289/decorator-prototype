package decorator;

public class EmailAlarmDecorator extends AlarmDecorator {

    public EmailAlarmDecorator(AlarmService alarmService) {
        super(alarmService);
    }

    @Override
    public void sendMessage(String message) {
    	System.out.println("이메일 전송 LoginFailEmailAlarmService 호출");
//        if (isNotSpam(message)) {
        super.sendMessage(message);
//        }
    }

    private boolean isNotSpam(String comment) {
        return !comment.contains("http");
    }
}
