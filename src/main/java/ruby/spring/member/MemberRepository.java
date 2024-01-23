package ruby.spring.member;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final JdbcTemplate template;

    public void initTable() {
        // 예제를 간단하게 하기 위해서 자바 코드 내에서 테이블 생성 코드를 작성
        template.execute("create table member(id varchar primary key, name varchar)");
    }

    public void save(Member member) {
        template.update(
            "insert into member(id, name) values (?, ?)",
            member.getId(), member.getName()
        );
    }

    public Member find(String id) {
        return template.queryForObject(
            "select id, name from member where id = ?",
            BeanPropertyRowMapper.newInstance(Member.class),
            id
        );
    }

    public List<Member> findAll() {
        return template.query(
            "select id, name from member",
            BeanPropertyRowMapper.newInstance(Member.class)
        );
    }
}
