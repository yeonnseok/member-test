package membertest.exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
        super("잘못된 패스워드 입니다.");
    }
}
