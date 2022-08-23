# Drop
> 드론 택배 배송 서비스 <br/>

<br/>

## 1. 제작 기간 & 참여 인원
* 2022.06.07 ~ 2022.06.21
* 4명 : [이다혜](https://github.com/ekgpgdi), [김지호](https://github.com/kimziaco?tab=repositories), [김대희](https://github.com/eet43), [최찬혁](https://github.com/choichanhyeok)
<br/>

## 2. 사용 기술 
<b>```Back-end```<b/>
* Java17
* Spring Boot 2.7.0
* Gradle 7.4.1
* Spring Data JPA
* H2
* MySQL 8.0.29
* Spring Security 
* JWT

<br/>

## 3. ERD 설계
<img width="573" alt="스크린샷 2022-08-09 오후 5 18 45" src="https://user-images.githubusercontent.com/84092014/183600270-a8bbe543-5faf-4724-ac3b-91285d1d6552.png">

<img width="615" alt="스크린샷 2022-08-09 오후 5 18 58" src="https://user-images.githubusercontent.com/84092014/183600296-fa7df3a9-fda7-4259-b00f-021ebf68aefc.png">


<br/>
<br/>
<br/>

## 4. 핵심 기능
이 서비스의 핵심 기능은 사용 가능한 드론을 찾는 것입니다.
1. 사용자가 물건 무게와 출발지, 도착지를 입력
2. 해당 주소를 네이버 geocode API 에 태워 좌표를 받아옴
3. 받아온 좌표를 open weather map API 에 태워 날씨를 받아옴
4. 받아온 날씨로 모델을 조회
* 조건 1 : 출발지, 도착지 온도의 최소값보다 작동 최저 온도가 낮은
* 조건 2 : 출발지, 도착지 온도의 최대값보다 작동 최고 온도가 높은
* 조건 3 : 사용자의 무게보다 적재 가능 무게가 무거운
5. 해당 모델과 일치하는 드론 목록 중 운영 가능 대수가 1 이상인 드론 목록을 조회


[관련 PR 확인하기](https://github.com/eet43/Drop/pull/15)

<br/>
<br/>

## 5. 아키텍처도
<img width="1188" alt="스크린샷 2022-08-22 오후 6 14 31" src="https://user-images.githubusercontent.com/84092014/185902744-ee09d624-b202-4ab1-a5da-e09e9e433cf1.png">


<br/>
<br/>

## 6. 핵심 트러블 슈팅
1. 하나의 프로젝트 내 두개의 Spring Security 
> DDD 의 경험을 위해 각 도메인을 한명씩 담당하고 개발을 진행하다가 소통의 부재로 인해 두 개의 도메인에서 각 Spring Security 를 적용하였고 두 개의 Spring Security 인해 “Found 2 beans for type interface org.springframework.security.authentication.AuthenticationManag er, but none marked as primary” 오류가 발생하였습니다. 
> 
> 이때 MSA 아키텍처의 필요성을 느끼고 각 도메인을 분리하여 프로젝트를 구성했다면 어떨까 생각이 들어 다음 프로젝트에 MSA 아키텍처를 적용하였습니다.
> [관련 에러 정리](https://ddori-lee.tistory.com/entry/Error-creating-bean-WebSecurityConfiguration?category=1016553) <br/>
> [당시 TIL](https://ddori-lee.tistory.com/entry/%EC%8A%A4%ED%8C%8C%EB%A5%B4%ED%83%80-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EC%97%94%EC%A7%80%EB%8B%88%EC%96%B4-%EC%BA%A0%ED%94%84-D65-22%EB%85%84-6%EC%9B%94-21%EC%9D%BC?category=1017057)
