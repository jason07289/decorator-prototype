package jaeh.decoratorspring.client;

import jaeh.decoratorspring.service.alarm.AlarmCallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class clientService {

    private final AlarmCallService alarmCallService;
    public void failCount5() {
        LoginFailureMessage loginFailureEvent = new LoginFailureMessage("jaeh0728","127.0.0.1",5);
        alarmCallService.sendAlarm(loginFailureEvent);
    }
}
