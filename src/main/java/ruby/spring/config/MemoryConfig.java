package ruby.spring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ruby.memory.MemoryController;
import ruby.memory.MemoryFinder;

@Configuration
//@Conditional(MemoryCondition.class)     // MemoryCondition 에서 구현한 matches 의 결과가 true 일 때 빈으로 등록됨
@ConditionalOnProperty(name = "memory", havingValue = "on")     // 시스템설정으로 memory 값이 on 일때 빈으로 등록됨
public class MemoryConfig {

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }
}
