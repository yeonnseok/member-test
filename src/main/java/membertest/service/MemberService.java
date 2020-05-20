package membertest.service;

import membertest.domain.Member;
import membertest.domain.MemberRepository;
import membertest.service.dto.MemberRequest;
import membertest.service.dto.MemberResponse;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponse createMember(MemberRequest memberRequest) {
        Member member = memberRequest.toMember();
        Member persistenceMember = memberRepository.save(member);
        return MemberResponse.from(persistenceMember);
    }
}
