package jaeh.decoratorspring.service.alarm;


import jaeh.decoratorspring.client.LoginFailureMessage;

public class AlarmDecorator implements AlarmService {

    private final AlarmService alarmService;

    public AlarmDecorator(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

	@Override
	public void sendMessage(LoginFailureMessage event) {
		alarmService.sendMessage(event);
	}

}
