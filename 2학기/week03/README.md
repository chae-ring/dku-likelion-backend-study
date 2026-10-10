# 2학기 3주차: Spring Boot 배포

Spring Boot 애플리케이션을 Docker 이미지로 만들고 Fly.io에 배포하는 실습입니다. 앱은 `GET /` 요청에 짧은 성공 메시지를 반환합니다.

## 실행 환경

- Java 21
- Spring Boot 4.0.8
- Gradle Wrapper 9.7.1
- Docker와 Fly CLI

## 로컬에서 실행

프로젝트 폴더에서 빌드와 테스트를 실행합니다.

```bash
./gradlew clean build
./gradlew bootRun
curl http://localhost:8080/
```

Windows에서는 `gradlew.bat`을 사용합니다. 정상 응답은 `Fly.io deployment successful!`입니다.

## 배포 준비

1. Fly.io에 로그인하고 새 앱을 준비합니다.
2. `fly.toml`의 `app` 값을 사용 가능한 앱 이름으로 바꿉니다.
3. 프로젝트 폴더에서 원격 빌드와 배포를 실행합니다.

```bash
fly auth login
fly launch --copy-config --no-deploy
fly deploy --remote-only --ha=false
```

배포 상태와 로그는 `fly status`와 `fly logs`로 확인할 수 있습니다. 앱 이름과 인증 정보는 각자의 Fly.io 계정에 맞춰 설정하세요.

## 구성 파일

| 파일 | 역할 |
| --- | --- |
| `src/main/java/com/likelion/flycicd/HomeController.java` | `GET /` 응답 |
| `src/test/java/com/likelion/flycicd/HomeEndpointTests.java` | HTTP 응답 확인 |
| `Dockerfile` | 빌드 및 실행 이미지 정의 |
| `fly.toml` | 앱 이름, 리전, 포트와 상태 검사 설정 |

참고: [Fly.io 지속적 배포 안내](https://fly.io/docs/launch/continuous-deployment-with-github-actions/), [Fly 앱 전용 배포 토큰](https://fly.io/docs/flyctl/tokens-create-deploy/)
