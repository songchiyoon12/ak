package database.hello.hellospring.service;

import database.hello.hellospring.domain.Member;
import database.hello.hellospring.repository.JdbcMemberRepository;
import database.hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService {
    private final JdbcMemberRepository jdbcMemberRepository ;

    @Autowired
    public MemberService(JdbcMemberRepository jdbcMemberRepository){
        this.jdbcMemberRepository=jdbcMemberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member);
        jdbcMemberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        jdbcMemberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalMonitorStateException("이미 존재");
        });
    }

    public List<Member> findMembers() {
        return jdbcMemberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return jdbcMemberRepository.findById(memberId);
    }

}
