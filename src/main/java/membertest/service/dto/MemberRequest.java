package membertest.service.dto;

import membertest.domain.Member;

public class MemberRequest {
    private final String email;
    private final String name;
    private final String password;

    public MemberRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Member toMember() {
        return new Member(email, name, password);
    }
}
