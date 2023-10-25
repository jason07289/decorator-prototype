package jaeh.decoratorspring;

public class AlarmDecorator implements AlarmService {

    private AlarmService alarmService;

    public AlarmDecorator(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

	@Override
	public void sendMessage(LoginFailureMessage event) {
		alarmService.sendMessage(event);
	}
}
