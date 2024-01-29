package ruby.memory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Memory 패키지는 예제에서 외부 라이브러리 역할을 담당
 * - Memory
 * - MemoryFinder
 * - MemoryController
 */
@AllArgsConstructor
@Getter
@ToString
public class Memory {
    private long used;
    private long max;
}
