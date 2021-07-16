package in.wwpy.server.filter;

import in.wwpy.server.util.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static in.wwpy.server.constant.WebSecurityConstant.OPTIONS_HTTP_METHOD;
import static in.wwpy.server.constant.WebSecurityConstant.TOKEN_PREFIX;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    private JwtTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (httpServletRequest.getMethod().equalsIgnoreCase(OPTIONS_HTTP_METHOD)) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
        } else {
            String authorizationHeader = httpServletRequest.getHeader(AUTHORIZATION);
            if (authorizationHeader == null || !authorizationHeader.startsWith(TOKEN_PREFIX)) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }
            String token = authorizationHeader.substring(TOKEN_PREFIX.length());
            String userEmail = jwtTokenProvider.getSubject(token);
            if (jwtTokenProvider.isTokenValid(userEmail, token) && SecurityContextHolder.getContext().getAuthentication() == null) {
                List<GrantedAuthority> authorities = jwtTokenProvider.getAuthorities(token);
                Authentication authentication = jwtTokenProvider.getAuthentication(userEmail, authorities, httpServletRequest);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                SecurityContextHolder.clearContext();
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
