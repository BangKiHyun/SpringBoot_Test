## Spring JDBC H2

의존성 추가

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

```
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

Spring-JDBC가 클래스패스에 있으면 자동 설정이 필요한 빈 설정

- DataSource
- JdbcTemplate



데이터베이스 기본 연결 정보 확인하는 방법

- URL : "jdbc:h2:mem:testdb"
- username: "sa"
- password:""



H2 콘솔 사용하는 방법

- spring-boot-devtools 추가
- spring.h2.consol.enabled=true 추가
- /h2-console로 접속