package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(

        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        //@ComponentScan으로 다 자동으로 bean을 등록하는데 제외할것을 설정하는 코드
        //@Configuration은 우리가 수동으로 bean을 등록하는 곳인데 자동으로 등록되면 큰일남을 이해해야함.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
