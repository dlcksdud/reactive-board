# Dream 프로젝트

안녕하세요.  
이 프로젝트는 개인 사이드 프로젝트로 간단한 CRUD 프로젝트입니다.  
현재는 JavaScript와 HTML로 화면단을 구성하였으며,  
추후 React 강의를 수강한 후 화면단을 React로 재구현할 예정입니다.

---

## 개발 환경
- **Backend**: Spring Boot  
- **Java**: 17 버전  
- **IDE**: IntelliJ IDEA  
- **Frontend**:
  - JavaScript
  - CSS
  - HTML  
- **API**: RESTful API  
- **Database**: MySQL  
- **Template Engine**: Thymeleaf  
- **ORM Framework**: MyBatis  

---

## 프로젝트 설명
1. **기능**:
   - CRUD (Create, Read, Update, Delete) 구현.
   - 사용자-friendly한 인터페이스 제공.
   
2. **향후 계획**:
   - React로 화면단 전환 및 프론트엔드 개선.
   - 추가적인 기능 구현 예정.

---

## 실행 방법
1. 프로젝트를 클론합니다:
   ```bash
   git clone https://github.com/username/dream.git
2. **IntelliJ에서 프로젝트 열기**  
   - IntelliJ IDEA에서 클론한 프로젝트를 엽니다.

3. **MySQL 데이터베이스 설정하기**  
   - 데이터베이스 DDL 및 초기화 쿼리는 추후 추가될 예정입니다.

4. **`application.properties` 설정**  
   - 프로젝트의 `src/main/resources/application.properties` 파일에 MySQL 데이터베이스 정보를 입력합니다.  
     예:  
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

5. **애플리케이션 실행**  
   - 아래 명령어를 사용하여 애플리케이션을 실행합니다:  
     ```bash
     ./mvnw spring-boot:run
     ```

6. **브라우저에서 확인**  
   - [http://localhost:8089](http://localhost:8089)에 접속하여 애플리케이션을 확인합니다.


