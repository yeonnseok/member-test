package membertest.exceptions;

public class NotExistEmailException extends RuntimeException {
    public NotExistEmailException() {
        super("존재하지 않는 계정입니다.");
    }
}
