## Test 사용하기

- spring-boot-starter-test 추가
- @SpringBootTest
  - @RunWith(SpringRunner.class)
  - webEnvironment
    - MOCK : mock servlet environment. 내장 톰캣 구동 X
    - RANDOM_PORT, DEFINED_PORT : 내장 톰캣 사용
- @MockBean
  - ApplicationContext에 들어있는 빈을 Mock으로 만든 객체로 교체
  - 모든 @Test 마다 자동 리셋



- Mock Object
  - <https://medium.com/@SlackBeck/mock-object%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80-85159754b2ac>



- Test Util

  - ##### OutputCapture

    - log 와 System.out.println에 찍히는 모든 것을 캡쳐해주는 역할
    - 가장 유용하게 쓰임

  - TestPropertyValues

  - TestRestTemplate

  - ConfigFileApplicationContextInitializer