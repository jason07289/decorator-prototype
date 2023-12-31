package decorator;

public class HcisLoginFailureEvent {

    private AlarmService alarmService;

    public HcisLoginFailureEvent(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    public void failCount5(LoginFailureMessage event) {
    	alarmService.sendMessage(event);
    }
}
