//package membertest;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Acceptance {
//
//    public String createMember(String email, String name, String password) {
//        Map<String, String> params = new HashMap<>();
//        params.put("email", email);
//        params.put("name", name);
//        params.put("password", password);
//
//        return
//                given().
//                        body(params).
//                        contentType(MediaType.APPLICATION_JSON_VALUE).
//                        accept(MediaType.APPLICATION_JSON_VALUE).
//                        when().
//                        post("/members").
//                        then().
//                        log().all().
//                        statusCode(HttpStatus.CREATED.value()).
//                        extract().header("Location");
//    }
//
//    public MemberResponse getMember(String email) {
//        return
//                given().
//                        accept(MediaType.APPLICATION_JSON_VALUE).
//                        when().
//                        get("/members?email=" + email).
//                        then().
//                        log().all().
//                        statusCode(HttpStatus.OK.value()).
//                        extract().as(MemberResponse.class);
//    }
//
//    public void updateMember(MemberResponse memberResponse) {
//        Map<String, String> params = new HashMap<>();
//        params.put("name", "NEW_" + TEST_USER_NAME);
//        params.put("password", "NEW_" + TEST_USER_PASSWORD);
//
//        given().
//                body(params).
//                contentType(MediaType.APPLICATION_JSON_VALUE).
//                accept(MediaType.APPLICATION_JSON_VALUE).
//                when().
//                put("/members/" + memberResponse.getId()).
//                then().
//                log().all().
//                statusCode(HttpStatus.OK.value());
//    }
//
//    public void deleteMember(MemberResponse memberResponse) {
//        given().when().
//                delete("/members/" + memberResponse.getId()).
//                then().
//                log().all().
//                statusCode(HttpStatus.NO_CONTENT.value());
//    }
//
//}
