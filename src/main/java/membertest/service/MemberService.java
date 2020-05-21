package membertest.service;

import membertest.domain.Member;
import membertest.domain.MemberRepository;
import membertest.exceptions.NotExistEmailException;
import membertest.exceptions.WrongPasswordException;
import membertest.util.JwtTokenProvider;
import membertest.service.dto.LoginRequest;
import membertest.service.dto.MemberRequest;
import membertest.service.dto.MemberResponse;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public MemberService(MemberRepository memberRepository, JwtTokenProvider jwtTokenProvider) {
        this.memberRepository = memberRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public MemberResponse createMember(MemberRequest memberRequest) {
        Member member = memberRequest.toMember();
        Member persistenceMember = memberRepository.save(member);
        return MemberResponse.from(persistenceMember);
    }

    public String createToken(LoginRequest loginRequest) {
        Member member = memberRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(NotExistEmailException::new);

        if (!member.checkPassword(loginRequest.getPassword())) {
            throw new WrongPasswordException();
        }

        return jwtTokenProvider.createToken(loginRequest.getEmail()); // email 정보만 가지고 token을 만든다.
    }

    public Member findMemberByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(NotExistEmailException::new);
    }
}
