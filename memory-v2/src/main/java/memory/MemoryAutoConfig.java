package memory;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * memory=on 환경정보가 있을 경우에 라이브러리를 적용
 * - resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports 를 추가로 작성해야한다.
 *  - 해당 AutoConfiguration 클래스를 추가하기 위해 memory.MemoryAutoConfig 를 기재한다.
 */
@AutoConfiguration
@ConditionalOnProperty(name = "memory", havingValue = "on")
public class MemoryAutoConfig {

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }
}
