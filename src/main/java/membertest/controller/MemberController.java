package membertest.controller;

import membertest.domain.Member;
import membertest.service.MemberService;
import membertest.service.dto.MemberRequest;
import membertest.service.dto.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public ResponseEntity<Void> createMember(
            @Valid @RequestBody MemberRequest memberRequest
    ) {
        MemberResponse memberResponse = memberService.createMember(memberRequest);
        return ResponseEntity.created(
                URI.create("/members/" + memberResponse.getId())
                )
                .build();
    }

}
