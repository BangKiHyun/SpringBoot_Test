## SpringApplication

- Banner
  - banner.txt
  - application.propertis
    - spring.banner.location=path
  - ${spring-boot.version} 등의 변수를 사용할 수 있음
  - Banner 클래스 구현하고 SpringApplication.setBanner()로 설정 가능
  - 배너 끄는 방법
    - SpringApplication.setBannerMode(Banner.Mode.OFF)

- ApplicationEvent 등록

  - ApplicationContext를 만들기 전 사용하는 리스너는 @Bean으로 등록할 수 없다
    - SpringApplication.addListners() 사용하여 사용 가능
  - ApplicationContext를 만들 전 사용하는 리스터는 @Bean으로 등록하면 사용 할 수 있다

- WebApplicationType 설정

  - NONE
  - REACTIVE
  - SERVLET

- Application 아규먼트 사용하기

  - ![1564043044957](C:\Users\rlrlv\AppData\Roaming\Typora\typora-user-images\1564043044957.png)

  - ```
    @Component
    public class SampleArgs {
    
        public SampleArgs(ApplicationArguments arguments){
            System.out.println("foo: " + arguments.containsOption("foo"));
            System.out.println("bar: " + arguments.containsOption("bar"));
        }
    }
    ```

  - foo faluse
    bar true

- Application 실행 후 뭔가 실행하고 싶을 때

  - ApplicationRunner or CommandLineRunner
  - 순서 지정
    - @Order
      - 순서가 낮을수록 우선순위 높음