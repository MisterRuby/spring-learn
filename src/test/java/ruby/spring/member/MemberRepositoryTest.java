package ruby.spring.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void initTable() {
        memberRepository.initTable();
    }

    /**
     * @Transactional 을 사용하려면 TransactionManager 가 스프링 빈으로 등록되어 있어야 한다.
     */
    @Transactional
    @Test
    void memberTest() {
        Member member = new Member("루비", "김루비");
        memberRepository.save(member);
        Member findMember = memberRepository.find(member.getId());

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getName()).isEqualTo(member.getName());
    }
}