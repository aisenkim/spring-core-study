package hello.core.member;

public interface MemberService {

    // Registering User
    void join(Member member);

    // Get member by id
    Member findMember(Long memberId);
}
