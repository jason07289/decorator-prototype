package jaeh.decoratorspring;


import jaeh.decoratorspring.config.properties.EmailAlarmProperties;
import jaeh.decoratorspring.config.properties.SlackAlarmProperties;
import jaeh.decoratorspring.service.alarm.DefaultAlarmService;
import jaeh.decoratorspring.service.alarm.EmailAlarmDecorator;
import jaeh.decoratorspring.service.alarm.SlackAlarmDecorator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientService {

    private final EmailAlarmProperties emailAlarmProperties;
    private final SlackAlarmProperties slackAlarmProperties;

    public void callService(){
        AlarmService alarmService = new DefaultAlarmService();

        if (emailAlarmProperties.getEnabled()) {
            alarmService = new EmailAlarmDecorator(alarmService);
        }

        if (slackAlarmProperties.getEnabled()) {
            alarmService = new SlackAlarmDecorator(alarmService);
        }

        HcisLoginFailureEvent client = new HcisLoginFailureEvent(alarmService);

        LoginFailureMessage loginFailureEvent = new LoginFailureMessage("jaeh0728","127.0.0.1",5);
        client.failCount5(loginFailureEvent);
    };

}
