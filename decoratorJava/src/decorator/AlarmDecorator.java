package decorator;

public class AlarmDecorator implements AlarmService {

    private AlarmService alarmService;

    public AlarmDecorator(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

	@Override
	public void sendMessage(String message) {
		alarmService.sendMessage(message);
	}
}
