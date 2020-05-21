package membertest.controller;

import membertest.domain.Member;
import membertest.service.MemberService;
import membertest.service.dto.LoginRequest;
import membertest.service.dto.MemberResponse;
import membertest.service.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    private final MemberService memberService;

    public SessionController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public ResponseEntity<TokenResponse> login(
            @RequestBody LoginRequest loginRequest
    ) {
        String token = memberService.createToken(loginRequest);
        return ResponseEntity.ok().body(new TokenResponse(token, "bearer"));
    }

    @GetMapping("/me/detail")
    public ResponseEntity<MemberResponse> showMember(@LoginMember Member member) {
        return ResponseEntity.ok().body(MemberResponse.from(member));
    }

}
