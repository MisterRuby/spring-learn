//package ruby.spring.config;
//
//import memory.MemoryController;
//import memory.MemoryFinder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * libs/memory-v1-0.0.1.jar 를 통해 추가한 외부 라이브러리를 빈으로 수동 등록
// *  - libs/memory-v1-0.0.1.jar 는 자동 구성을 제공하지 않음
// *  - 외부 라이브러리를 파악해야만 빈으로 등록할 것들을 알 수 있다.
// *  - 외부 사용자를 위한 별도의 메뉴얼을 제공해야함
// */
//@Configuration
//public class OriginMemoryConfig {
//
//    @Bean
//    public MemoryFinder memoryFinder() {
//        return new MemoryFinder();
//    }
//
//    @Bean
//    public MemoryController memoryController() {
//        return new MemoryController(memoryFinder());
//    }
//}
