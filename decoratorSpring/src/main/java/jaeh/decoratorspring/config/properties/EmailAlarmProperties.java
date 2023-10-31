package jaeh.decoratorspring.config.properties;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "alarm.email")
public class EmailAlarmProperties {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final String settingData;

    private final String settingInfo;

    private final Boolean enabled;

    public String getSettingData() {
        if( settingData == null) {// property를 불러오지 못하면 exception 발생
            LOGGER.error("property의 alarm.setting-data에 파일경로를 입력해주세요.");
            throw new RuntimeException("로그 확인 후 설정정보를 셋팅해주세요.");
        }
        return settingData;
    }

    public String getSettingInfo() {
        if( settingInfo == null) {// property를 불러오지 못하면 exception 발생
            LOGGER.error("property의 alarm.setting-info에 파일경로를 입력해주세요.");
            throw new RuntimeException("로그 확인 후 설정정보를 셋팅해주세요.");
        }
        return settingInfo;
    }
    public Boolean getEnabled() {
        if( enabled == null) {// property를 불러오지 못하면 exception 발생
            LOGGER.error("property의 alarm.enabled에 값을 입력해주세요.");
            throw new RuntimeException("로그 확인 후 설정정보를 셋팅해주세요.");
        }
        return enabled;
    }
}
