![90market](https://user-images.githubusercontent.com/48228245/80719018-d6b5fd00-8b35-11ea-9edc-627a5660cc03.png)

## 프로젝트 개요
사용자가 물품을 사고 팔 수 있는 [번개장터](https://m.bunjang.co.kr/) 서비스 클론 제작

## 실행 방법
```
1. Eclipse -> Project Import 선택 -> Project from Gits -> Clone URI 선택
2. 구공마켓 URI 복사 후 붙여넣고 Clone
3. Tomcat 설정 후 실행
```
## 개발 스택
- BackEnd
  - Java, Spring, MySQL, MyBatis
- FrontEnd
  - HTML, CSS, JavaScript

## 아키텍처
![ClassStructure](https://user-images.githubusercontent.com/48228245/80710943-86856d80-8b2a-11ea-88f0-6d2ab1df7c6e.png)
  
## 구현 기능
- 회원 기능
  - 회원가입, 회원 정보수정, 회원탈퇴
  - 이메일 인증, 패스워드 암호화
- 로그인 기능
  - 로그인아웃, 소셜 로그인
- 상품 기능
  - 상품 등록(이미지 포함), 상품 상세정보 표시
  - 상품 썸네일 표시

## 컨트롤러
- Auth Controller : 소셜 로그인(네이버) 관련 인증 및 DB 저장, 로그인한 이메일이 DB에 존재하는지 체크 기능
- Category Controller : 카테고리별로 페이지를 이동시켜주는 기능
- Home Controller : 메인 화면에서 이용할 수 있는 카테고리, 상품 관련 이동 기능
- Login Controller : 로그인, 로그아웃 등 인증 관련 기능
- Member Controller : 회원가입, 이메일 인증, 회원정보 수정, 회원 탈퇴 등 회원 관련 기능
- Product Controller : 상품 등록, 업로드한 상품 원본 이미지 및 썸네일 저장, 상품 수정, 상품 상세정보 등 상품 관련 기능
- RestApi Controller : 회원가입 시 이메일 란에 입력한 이메일 중복 여부 체크 기능
- Search Controller : 등록되어 있는 상품 상세정보의 제목으로 검색할 수 있는 기능
  
## 실행 화면
![RunProject](https://user-images.githubusercontent.com/48228245/80821377-8c0ab280-8c13-11ea-8224-a201b6046a42.png)

## 실행 화면
시연 영상
[![Video Label](https://user-images.githubusercontent.com/48228245/80821377-8c0ab280-8c13-11ea-8224-a201b6046a42.png)](https://www.youtube.com/watch?v=0rym0r32ibc)
