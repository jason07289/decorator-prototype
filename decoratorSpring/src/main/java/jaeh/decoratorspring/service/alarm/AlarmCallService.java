package jaeh.decoratorspring.service.alarm;


import jaeh.decoratorspring.client.LoginFailureMessage;
import jaeh.decoratorspring.config.properties.EmailAlarmProperties;
import jaeh.decoratorspring.config.properties.SlackAlarmProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AlarmCallService {

    private final EmailAlarmProperties emailAlarmProperties;
    private final SlackAlarmProperties slackAlarmProperties;
    private AlarmService alarmService;

    public AlarmCallService(EmailAlarmProperties emailAlarmProperties, SlackAlarmProperties slackAlarmProperties) {
        this.emailAlarmProperties = emailAlarmProperties;
        this.slackAlarmProperties = slackAlarmProperties;
    }

    @PostConstruct
    private void createAlarmService() {
        this.alarmService = new DefaultAlarmService();

        if (Boolean.TRUE.equals(emailAlarmProperties.getEnabled())) {
            alarmService = new EmailAlarmDecorator(alarmService);
        }

        if (Boolean.TRUE.equals(slackAlarmProperties.getEnabled())) {
            alarmService = new SlackAlarmDecorator(alarmService);
        }
    }

    public void sendAlarm(LoginFailureMessage loginFailureEvent){
        alarmService.sendMessage(loginFailureEvent);
    }

}
