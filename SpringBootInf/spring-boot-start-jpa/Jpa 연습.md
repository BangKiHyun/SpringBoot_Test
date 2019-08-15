# Jpa 연습

- JpaRepository
  - <Entity, ID>
- Entity
  - @GeneratedValue , 값 자동 설정
- spirng.jpa.hibernate.ddl-auto 
  - create-drop  - 처음에 스키마 생성, application종료시 스키마 삭제
  - create - 시작할 때 스키마 삭제후 새로 생성
  - update - 기존에 있는 스키마 유지, 추가된 스키마만 변경  -- 기존 데이터 유지 가능
  - spring.jpa.generate-ddl = true 로 변경
  - spirng.jpa.show-sql - 생성되는 스키마 보여줌