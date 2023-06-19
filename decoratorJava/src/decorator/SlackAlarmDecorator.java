package decorator;

public class SlackAlarmDecorator extends AlarmDecorator {// 얘는 Decorator를 상속  

    public SlackAlarmDecorator(AlarmService alarmService) {
        super(alarmService);
    }

    @Override
    public void sendMessage(String message) {
    	System.out.println("슬랙 전송");
        super.sendMessage(slackFormat(message));
    }

    private String slackFormat(String comment) {
        return comment.replace("...", "");
    }
}
