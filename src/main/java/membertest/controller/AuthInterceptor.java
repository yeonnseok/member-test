package membertest.controller;

import membertest.util.JwtTokenProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private AuthorizationExtractor authExtractor;
    private JwtTokenProvider jwtTokenProvider;

    public AuthInterceptor(AuthorizationExtractor authExtractor, JwtTokenProvider jwtTokenProvider) {
        this.authExtractor = authExtractor;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        String token = authExtractor.extract(request, "Bearer");
        if(!jwtTokenProvider.validateToken(token)) {  // 토큰의 유효성 검증
            throw new InvalidAuthenticationException("만료된 세션입니다.");
        };

        String email = jwtTokenProvider.getSubject(token);
        request.setAttribute("loginMemberEmail", email);
        return true;
    }
//
//    @Override
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response,
//                           Object handler,
//                           ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
}
