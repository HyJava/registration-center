package org.springframework.boot.actuate.autoconfigure.security.servlet;

import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
class ManagementWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    ManagementWebSecurityConfigurerAdapter() {
    }

    protected void configure(HttpSecurity http) throws Exception {
        //设置不需要权限的路径
        ((HttpSecurity)((HttpSecurity)((AuthorizedUrl)((AuthorizedUrl)http
                .authorizeRequests()
                .requestMatchers(new RequestMatcher[]{
                        EndpointRequest.to(new Class[]{HealthEndpoint.class, InfoEndpoint.class})
                        ,new RegexRequestMatcher("/eureka", null)
                        ,new RegexRequestMatcher("/hello/[a-z,A-Z]*", null)
                }))
                .permitAll().anyRequest()).authenticated().and()).formLogin().and()).httpBasic();
    }
}
