package membertest.service.dto;

public class TokenResponse {
    private String token;
    private String tokenType;

    public TokenResponse(String token, String tokenType) {
        this.token = token;
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }
}
