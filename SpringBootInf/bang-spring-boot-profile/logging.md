## logging

- Springboot Logging

  - --debug(일부 핵심 라이브러리만 디버깅 모드로)
  - --trace(전부 다 디버깅 모드로)
  - log 컬러 출력
    - spring.output .ansi.enabled
    - 시각적으로 좀더 보기 쉬워짐
  - 파일 출력
    - logging.file or loggin.path
  - 로그 레벨 조정
    - logging.level.패키지 = 로그 레벨

- 커스텀 로그 설정 파일 사용

  - logback-spring.xml

    - levels, as shown in the following example:

      ```
      <?xml version="1.0" encoding="UTF-8"?>
      <configuration>
      	<include resource="org/springframework/boot/logging/logback/base.xml"/>
      	<logger name="org.springframework.web" level="DEBUG"/>
      </configuration>
      ```

- 로거 Log4j2로 변경

  - The simplest path is probably through the starters, even though it requires some jiggling with excludes. The following example shows how to set up the starters in Maven:

    ```
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter</artifactId>
    	<exclusions>
    		<exclusion>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-logging</artifactId>
    		</exclusion>
    	</exclusions>
    </dependency>
    <dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-log4j2</artifactId>
    </dependency>
    ```