# 📚온라인 서점 웹 어플리케이션 
온라인 서점을 위한 웹 애플리케이션으로 서점 주인은 책의 정보를 확인, 편집이 가능합니다.

## 📑 Project Overview
### 개발 기간
- 2025.02.18 ~ 2025.02.20

### 개발 구성원
- 1인 개발

## 💻 개발 환경
- Front-end : Next.js, TypeScript
- Back-end : Spring Boot

## 데이터베이스와 통신하는 API 설계 및 구현 내용  
- 책 목록의 조회 (GET /api/books)
- 책 상세정보 조회 (GET /api/books/:id)
- 책 정보 추가 (POST /api/books)
- 책 정보 수정 (PUT api/books:id)
- 책 정보 삭제 (DELETE /api/books/:id)

### 사용 기술
- JPA : DB 테이블과의 매칭을 용이하게 하기 위해 사용하였으며 객체 모델을 이용한 로직 구성에만 집중 가능합니다.
- model mapper : Dto와 Entity의 필드 값 매핑을 짧은 코드로 구현하기 위해 사용하였습니다.
- lombok : getter 및 setter 메소드의 간소화를 위해 사용하였습니다.
