package database.hello.hellospring.repository;

import database.hello.hellospring.domain.Member;
import jdk.jfr.Registered;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemberRepository {
    private Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    public void clearStore() {
        store.clear();
    }

}
