package jaeh.decoratorspring.service.alarm;

import jaeh.decoratorspring.client.LoginFailureMessage;

public interface AlarmService {

    void sendMessage(LoginFailureMessage event);

}
