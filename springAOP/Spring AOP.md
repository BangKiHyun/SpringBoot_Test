## AOP(Aspect-oriendted Programming) 개념

1. 흩어진 Aspect를 모듈화 할 수 있는 프로그래밍
2. Aspect
   - 하나의 모듈(모듈화 한 것)
   - 모듈은 Advice와 Pointcut으로 나누어짐
3. Advice
   - 해야할 일들
4. Pointcut
   - 어디에 적용해야 하는지에 대한 정보를 갖고있음
5. Target
   - 적용이 되는 대상
6. Join point(합류점)
   - method 호출 or method 실행시점
   - method를 실행할 때 그 곳에 끼어들어라



## Spring AOP : 프록시 기반

- 의존성 추가
  <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-aop</artifactId>
  </dependency> 

1. 스프링 Bean에만 AOP를 적용할 수 있다
2. 프록시 패턴
   - Client는 Interface타입으로 Proxy개체를 사용하게 됨
   - Proxy객체는 원래 해야할 일(interface의 Subject)을 감싼다
   - 감싸 Proxy객체가 Client의 일을 처리한다
3. @Pointcut(표현식)
   - 주 표현식
     - execution
     - @annotation
     - bean
   - 조합
     - &&, ||, !
4. Advice 정의
   - @Before
   - @Around
   - @AfterReturning
   - @AfterThrowing
5. @Around
   - method를 감싸는 Annotation
   - Pointcut 정의