# Spring-Security-TDD

## 기술 스택
- Java 17
- gradle 7.3
- H2
- Spring Data JPA
- Spring Security
- JWT
- Spring REST docs

## 요구사항
### 사용자
- 로그인한 회원만 내 정보 확인 가능
### 관리자
- 회원 가입된 모든 회원 정보 조회
- 일별로 회원가입 한 숫자 통계


## Udacity Git Commit Message Style Guide
[udacity 보러가기](https://udacity.github.io/git-styleguide/)   
feat: A new feature   
fix: A bug fix   
docs: Changes to documentation   
style: Formatting, missing semi colons, etc; no code change   
refactor: Refactoring production code   
test: Adding tests, refactoring test; no production code change   
chore: Updating build tasks, package manager configs, etc; no production code change   


## 알게된 점
### WebSecurityConfigurerAdapter
WebSecurityConfigurerAdapter를 상속받는 클래스는 모든 요청을 거치기 때문에 주입 받은 객체들은 테스트 할때 주입 받아야 한다.   