package decorator;

public class DefaultAlarmService implements AlarmService {//concrete component
    @Override
    public void sendMessage(LoginFailureEvent event) {
        System.out.println("기본 서비스에서는 로그가 남습니다. : " + event);
    }
}
