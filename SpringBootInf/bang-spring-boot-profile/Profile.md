## Profile

- @Profile 어노테이션 사용하는 곳
  - @Configuration
  - Component
- 어떤 profile을 활성화 할 것인가
  - spring.profiles.active = name
- 어떤 profile을 추가할 것인가
  - spring.profiles.include = name

- properties 우선순위를 이용한 profile 바꾸는 방법
  - java -jar .jar --spring.properties.active=프로파일name