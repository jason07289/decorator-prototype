package decorator;

public class LoginFailureEvent {
	private String loginId;
	private String ip;
	private int failCount;
	
	public String getLoginId() {
		return loginId;
	}

	public String getIp() {
		return ip;
	}

	public int getFailCount() {
		return failCount;
	}
	

	public LoginFailureEvent(String loginId, String ip, int failCount) {
		super();
		this.loginId = loginId;
		this.ip = ip;
		this.failCount = failCount;
	}

	@Override
	public String toString() {
		return "LoginFailureEvent [loginId=" + loginId + ", ip=" + ip + ", failCount=" + failCount + "]";
	}
	
	
}
