<div align="center">
  <h1 style="display:'inline-block'"> <img src='https://github.com/babyyu0/GamePT/blob/master/document/img/logo.png' width=280vw></h1>
</div>

<h3>
    Always Nearby You!&nbsp;
    <img src="https://em-content.zobj.net/source/apple/354/globe-showing-asia-australia_1f30f.png" width=16 height=16 alt="지구본 아이콘" />
</h3>

판타지 세계로 여행을 떠나보고 싶다고 생각하신 적 없으신가요?  
게임에서 마음대로 행동하고 싶으셨던 적 없으신가요?  
ChatGPT와 함께하는 신비로운 탐험, **GamePT**는 가능합니다!

GamePT는 플레이어가 입력한 대화에 맞춰 상호작용이 일어납니다.   
다양한 이벤트를 즐길수록 레벨이 올라 더욱 강력한 스킬을 사용할 수 있습니다.  
마왕을 물리치기 위한 여정을 나만의 스토리로 만들어 보세요.

<h3>
    <img src="https://em-content.zobj.net/source/apple/354/calendar_1f4c5.png" width=16 height=16 alt="캘린더 아이콘" />
    &nbsp;프로젝트 기간
</h3>

&nbsp;&nbsp;**🛠️ 개발**: 2023. 10. 09 ~  2023. 11. 17
<h3>
    <img src="https://em-content.zobj.net/source/apple/354/gear_2699-fe0f.png" width=16 height=16 alt="톱니바퀴 아이콘" />
    &nbsp;개발 환경
</h3>
<img src='https://github.com/babyyu0/EnjoyTrip/blob/main/document/architecture.PNG' width=500vw>

**🎨 Back-end**
```
  🗲 java 17    🗲 Spring Boot 3.1.5    🗲 Spring Security    🗲 WebSocket
```

**💄 Front-end**
```
  🗲 Typescript 5.0.2    🗲 React 18.2.0    🗲 pnpm    🗲 vite 4.4.5    🗲 Jotai 2.4.3    🗲 tailwind 3.3.3
```

**🗃️ Database**
```
  🗲 MySQL    🗲 Redis
```

**🗃️ Infra**
```
  🗲 Amazon EC2 (ubuntu)    🗲 Docker    🗲 Jenkins    🗲 NginX
```

**🗣️ Conversation**
```
  🗲 Mattermost    🗲 Git    🗲 GitLab    🗲 Notion
```

# 기능

<h3>
    <img src="https://em-content.zobj.net/source/apple/354/puzzle-piece_1f9e9.png" width=16 height=16 alt="퍼즐 아이콘" />
    &nbsp;API 명세
</h3>

#### ➤ 회원
|대분류|기능|Method|URL|
|:-:|:-:|:-:|:-:|
|회원|카카오 로그인|`GET`|<p align='left'>/member/login/kakao</p>|

#### ➤ 플레이어
|대분류|기능|Method|URL|
|:-:|:-:|:-:|:-:|
|플레이어|종족 리스트 조회|`GET`|<p align='left'>/player/race</p>|
|플레이어|직업 리스트 조회|`GET`|<p align='left'>/player/job</p>|
|플레이어|플레이어 생성|`POST`|<p align='left'>/player</p>|
|플레이어|플레이어 정보 조회|`GET`|<p align='left'>/player</p>|
|플레이어|플레이어 정보 조회|`SOCKET`|<p align='left'>/player</p>|
|플레이어|플레이어 스탯 조회|`MESSAGE`|<p align='left'>/player/stat/{gameCode}/{playerCode}</p>|
|플레이어|플레이어 스탯 수정|`MESSAGE`|<p align='left'>/stat-up/{gameCode}/{playerCode}/{statCode}</p>|

#### ➤ 게임 진행
|대분류|기능|Method|URL|
|:-:|:-:|:-:|:-:|
|게임 진행|진행 기록 조회|`GET`|<p align='left'>/prompt</p>|
|게임 진행|ChatGPT 비동기 응답 구독|`GET`|<p align='left'>/prompt/subscribe/{gameCode}</p>|
|게임 진행|일반 게임 진행|`POST`|<p align='left'>/prompt/send/{gameCode}</p>|
|게임 진행|게임 생성|`POST`|<p align='left'>/game</p>|
|게임 진행|스토리 리스트 조회|`GET`|<p align='left'>/game/story</p>|
|게임 진행|스토리 정보 조회|`GET`|<p align='left'>/game/story/{storyCode}</p>|
|게임 진행|이벤트 주사위 생성|`MESSAGE`|<p align='left'>/game/dice/{gameCode}</p>|
|게임 진행|발생 이벤트의 선택지 리스트 조회|`GET`|<p align='left'>/game/{gameCode}</p>|
|게임 진행|발생 이벤트의 하위 선택지 리스트 조회|`MESSAGE`|<p align='left'>/game/subtask/{gameCode}</p>|
|게임 진행|선택 선택지 진행|`MESSAGE`|<p align='left'>/game/select/{gameCode}</p>|
|게임 진행|전투 이벤트 진행|`MESSAGE`|<p align='left'>/game/fight/{gameCode}</p>|
|게임 진행|엔딩 조회|`MESSAGE`|<p align='left'>/game/ending/{gameCode}</p>|
|게임 진행|채팅|`MESSAGE`|<p align='left'>/game/chat/{gameCode}</p>|

#### ➤ 아이템
|대분류|기능|Method|URL|
|:-:|:-:|:-:|:-:|
|게임 진행|아이템 획득|`MESSAGE`|<p align='left'>/item</p>|
|게임 진행|아이템 삭제|`MESSAGE`|<p align='left'>/item/{itemCode}</p>|

<h3>
    <img src="https://em-content.zobj.net/source/apple/354/link_1f517.png" width=16 height=16 alt="링크 아이콘" />
    &nbsp;URL
</h3>

|대분류|화면|URL|
|:-:|:-:|:-:|
|메인|메인|<p align='left'><a href='http://localhost:3000/'>/</a></p>|
|게임 시작|게임 생성|<p align='left'><a href='http://localhost:3000/createGame'>/createGame</a></p>|
|게임 시작|플레이어 생성|<p align='left'><a href='http://localhost:3000/createCharacter'>/createCharacter</a></p>|
|게임 진행|솔로 플레이 진행|<p align='left'><a href='http://localhost:3000/singleplay'>/singleplay</a></p>|
|게임 진행|멀티 플레이 진행|<p align='left'><a href='http://localhost:3000/multiplay'>/multiplay</a></p>|
|게임 진행|엔딩 조회|<p align='left'><a href='http://localhost:3000/ending'>/ending</a></p>|

<h3>
    <img src="https://em-content.zobj.net/source/apple/354/desktop-computer_1f5a5-fe0f.png" width=16 height=16 alt="컴퓨터 아이콘" />
    &nbsp;기능 설명
</h3>

#### ◉ 게임 시작
1. '게임 시작하기' 버튼을 클릭합니다.  
2. 홀로 즐기는 '싱글 플레이'와 최대 4명의 플레이어가 함께 즐기는 '멀티 플레이' 중 모드를 선택합니다.  
3. 즐길 스토리의 종류를 선택합니다.  
4. 종족을 선택합니다. (이는 기본 스탯에 영향을 미칩니다.)  
5. 직업을 선택합니다. (이는 추가 스탯에 영향을 미칩니다.)  
6. 닉네임을 입력한 후 '시작하기' 버튼을 클릭합니다.  

#### ◉ 게임 진행
1. 프롬프트 창에 진행 상황에 맞는 답변을 하며 모험을 즐깁니다.
2. 이벤트 발생 시 주어진 선택지를 통해 상황을 해결해 나갑니다.
3. 주사위는 성공 또는 실패 확률을 높입니다.
4. 이벤트 결과에 맞게 스탯이 변화하거나 아이템을 획득할 수 있습니다.

#### ◉ 게임 종료
1. 플레이어의 체력이 0이 되거나, 마왕을 물리쳤을 때 게임이 끝납니다.
	1. 일정 턴이 지나면 최종 보스인 '마왕'이 등장합니다.
	2. 일반 전투 로직과 같이 전투 선택지와 주사위를 통한 확률 조정으로 전투를 진행합니다.
2. 현재까지 진행한 스토리에 맞게 용사의 미래를 보여주며 게임은 끝이 납니다.
3. 종료된 게임은 정보를 더이상 저장하지 않고 곧바로 삭제됨에 유의하세요.

# 실행 가이드
<h3>
    <img src="https://em-content.zobj.net/source/apple/354/teacher_1f9d1-200d-1f3eb.png" width=16 height=16 alt="선생님 아이콘" />
    &nbsp;로컬 실행 가이드
</h3>

**1. Git Clone**
```git
$ git clone https://github.com/babyyu0/GamePT
```
  
**2. 백엔드 레포지토리 내 `application-local.yml` 생성**
<details>
    <summary>application-local.yml</summary>
    <div markdown="1">
    
```yml:application-local.yml
spring:
  config:
    activate:
      on-profile: "local"
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc: {insert your DB url}
    username: {insert your DB user name}
    password: {insert your DB password}
  data:
    redis:
      host: {insert your DB url}
      port: {insert your DB port}
      password: {insert your DB password}
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        auto_quote_keyword: true

jwt:
  secret: {insert your token password}

url:
  prod: {insert your front prod url}
  local: {insert your front local url}
  local-port: {insert your front local url with port}

gpt:
  model: gpt-3.5-turbo-16k-0613
  api-uri: https://api.openai.com/v1/chat/completions
  api-key: {insert your ChatGPT secret key}

security:
  kakao:
    client-id: {insert your kakao client id}
    redirect-uri: {insert your front url}/member/login/kakao
    token-uri: https://kauth.kakao.com/oauth/token
    user-info-uri: https://kapi.kakao.com/v2/user/me
```

</details>
  
**3. 프론트엔드 레포지토리 내 `.env` 생성**
<details>
    <summary>.env</summary>
    <div markdown="1">
        
```env
VITE_SOCKET_URL="{insert your socket api url}"
VITE_SERVER_URL="{insert your rest api url}"
```
    
</details>
  
**4. 개발 툴로 백엔드 실행**  
**5. 프론트엔드 필요 라이브러리 다운로드**
```node
> npm i -g pnpm
> pnpm install
```
**6. 개발 툴로 프론트엔드 실행**
```node
> pnpm run dev
```
<h3>
    <img src="https://em-content.zobj.net/source/apple/354/teacher_1f9d1-200d-1f3eb.png" width=16 height=16 alt="선생님 아이콘" />
    &nbsp;배포 실행 가이드
</h3>

**1. NginX를 위한 `default.conf` 설정**
<details>
    <summary>default.conf</summary>
    <div markdown="1">
        
```conf
upstream frontend {
    server localhost:3000;
}
upstream backend {
    server localhost:8080;
}
server {
    listen 80;
    server_name {insert your server url};
	server_tokens off;
	location / {
		return 301 https://$server_name$request_uri;
	}
}

server {
	listen 443 ssl http2;
    server_name {insert your server url};
	server_tokens off;
	access_log off;
	ssl_certificate /etc/letsencrypt/live/{insert your server url}/fullchain.pem;
	ssl_certificate_key /etc/letsencrypt/live/{insert your server url}/privkey.pem;
	include /etc/letsencrypt/options-ssl-nginx.conf;
	ssl_dhparam /etc/letsencrypt/ssl-dhparams.pem;
    location /api {
    rewrite ^/api(/.*)$ $1 break;
        proxy_pass http://backend;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }
    location / {
        proxy_pass http://frontend;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }
}
```

</details>

**2. 백엔드 `Dockerfile`, `application-local.yml` 생성**
<details>
    <summary>Dockerfile</summary>
    <div markdown="1">

```dockerfile
FROM gradle:8.3-jdk17-alpine AS build
WORKDIR /app
COPY build.gradle settings.gradle gradlew gradle ./
COPY src ./src
RUN chmod +x ./gradlew
RUN gradle clean bootJar

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
```

</details>
<details>
    <summary>application-local.yml</summary>
    <div markdown="1">
    
```yml:application-local.yml
spring:
  config:
    activate:
      on-profile: "local"
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc: {insert your DB url}
    username: {insert your DB user name}
    password: {insert your DB password}
  data:
    redis:
      host: {insert your DB url}
      port: {insert your DB port}
      password: {insert your DB password}
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        auto_quote_keyword: true

jwt:
  secret: {insert your token password}

url:
  prod: {insert your front prod url}
  local: {insert your front local url}
  local-port: {insert your front local url with port}

gpt:
  model: gpt-3.5-turbo-16k-0613
  api-uri: https://api.openai.com/v1/chat/completions
  api-key: {insert your ChatGPT secret key}

security:
  kakao:
    client-id: {insert your kakao client id}
    redirect-uri: {insert your front url}/member/login/kakao
    token-uri: https://kauth.kakao.com/oauth/token
    user-info-uri: https://kapi.kakao.com/v2/user/me
```

</details>

**3. 프론트엔드 `Dockerfile`, `.env`, `front.conf` 생성**
<details>
    <summary>Dockerfile</summary>
    <div markdown="1">
        
```dockerfile
# 가져올 노드 버전
FROM node:18.18.2 AS dist

# 경로 설정
WORKDIR /app

# 워킹 디렉토리에 package.json 복사
COPY package*.json ./

# npm 의존성 설치
RUN npm install --global pnpm
RUN pnpm install

# 모든 디렉토리 복사
COPY . ./

# 프로젝트 빌드
RUN pnpm build

# 프로젝트 시작
CMD ["pnpm", "dev"]

FROM nginx:stable-alpine

COPY --from=dist /app/dist /usr/share/nginx/html
COPY front.conf /etc/nginx/conf.d/default.conf
EXPOSE 3000
CMD ["nginx", "-g", "daemon off;"]
```

</details>

<details>
    <summary>.env</summary>
    <div markdown="1">
        
```env
VITE_SOCKET_URL="{insert your socket api url}"
VITE_SERVER_URL="{insert your rest api url}"
```
    
</details>

<details>
    <summary>front.conf</summary>
    <div markdown="1">
        
```config
server {
	listen 3000;
	location / {
		root /usr/share/nginx/html;
		index index.html;
		try_files $uri $uri/ /index.html;
	}
}
```

</details>

**4. Jenkins 파이프라인 작성**
<details>
    <summary>pipeline</summary>
    <div markdown="1">
        
```pipeline
pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Clone repository'
                echo "Branch : master"
                git branch: "master", url: "https://github.com/babyyu0/GamePT", credentialsId: "GamePT"
            }
        }
        
        stage('Set Environment') {
            steps {
                echo "Copy require file to pipeline folder"
                sh 'cp /var/jenkins_home/util/GamePT/frontend/Dockerfile ./frontend/gamept'
                sh 'cp /var/jenkins_home/util/GamePT/frontend/front.conf ./frontend/gamept'
                sh 'cp /var/jenkins_home/util/GamePT/backend/docker-compose.yml ./'
                sh 'cp /var/jenkins_home/util/GamePT/backend/Dockerfile ./backend'

            }
        }
        
        stage('Front-end Container Down') {
            steps {
                script {
                    try {
                        echo "Front-end container stop"
                        sh "docker stop frontend-container"
                    } catch(e) {
                        echo "Front-end container Stop Failed!"
                        sh "docker ps"
                    }
                    
                    try {
                        echo "Front-end container remove"
                        sh "docker rm frontend-container"
                    } catch(e) {
                        echo "Front-end container Remove Failed!"
                        sh "docker ps -a"
                    }
                }
            }
        }
        
        stage('Front-end Image down') {
            steps {
                script {
                    try {
                        echo "Front-end image remove"
                        sh "docker rmi frontend-image"
                    } catch(e) {
                        echo "Front-end image Remove Failed!"
                        sh "docker images"
                    }
                }
            }
        }
        
        stage('Back-end Container Down') {
            steps {
                script {
                    try {
                        echo "Back-end container stop"
                        sh "docker stop backend-container"
                    } catch(e) {
                        echo "Back-end container Stop Failed!"
                        sh "docker ps"
                    }
                    
                    try {
                        echo "Back-end container remove"
                        sh "docker rm backend-container"
                    } catch(e) {
                        echo "Back-end container Remove Failed!"
                        sh "docker ps -a"
                    }
                }
            }
        }
        
        stage('Back-end Image down') {
            steps {
                script {
                    try {
                        echo "Back-end image remove"
                        sh "docker rmi backend-image"
                    } catch(e) {
                        echo "Back-end image Remove Failed!"
                        sh "docker images"
                    }
                }
            }
        }
        
        stage('Docker Build') {
            steps {
                echo "docker build"
                sh 'docker build -t frontend-image ./frontend/gamept'
                sh 'docker build -t backend-image ./backend'
            }
            post {
                success {
                    echo "Success to build"
                }
                failure {
                    echo "Docker build failed. clear unused file"
                    sh "sudo docker system prune -f"
                    error 'pipeline aborted'
                }
            }
        }
        stage('Docker Up') {
            steps {
                echo "docker up"
                sh "docker run -d -p 3000:3000 --network deploy --name frontend-container frontend-image"
                sh "docker run -d -p 8080:8080 --network deploy --name backend-container backend-image"
            }
        }
        stage('Docker Clear') {
            steps{
                sh "docker system prune -f"
            }
        }
    }
}
```

</details>

# 팀원 소개
<table>
  <tr>
    <td align="center"><img src="https://avatars.githubusercontent.com/u/58788576?v=4&size=120" width=120px /></td>
    <td align="center"><img src="https://avatars.githubusercontent.com/u/72871841?v=4&size=120" width=120px /></td>
    <td align="center"><img src="https://avatars.githubusercontent.com/u/108918495?v=4&size=120" width=120px /></td>
    <td align="center"><img src="https://avatars.githubusercontent.com/u/122508669?v=4&size=120" width=120px /></td>
    <td align="center"><img src="https://avatars.githubusercontent.com/u/45381384?v=4&size=120" width=120px /></td>
    <td align="center"><img src="https://avatars.githubusercontent.com/u/86233884?v=4&size=120" width=120px /></td>
  </tr>
  <tr>
    <td align="center"><b>유영 (본인)</b></td>
    <td align="center">이유한</td>
    <td align="center">김봉준</td>
    <td align="center">김동준</td>
    <td align="center">박지환(팀장)</td>
    <td align="center">이우석</td>
  </tr>
  <tr>
    <td align="center">BE, INFRA</td>
    <td align="center">FE</td>
    <td align="center">FE</td>
    <td align="center">FE</td>
    <td align="center">BE</td>
    <td align="center">BE</td>
  </tr>
  <tr>
    <td>
      <ul>
        <li>무중단 배포</li>
        <li>게임방 생성</li>
        <li>캐릭터 생성</li>
        <li>엔딩 조회</li>
        <li>카카오 회원 연동</li>
      </ul>
    </td>
    <td>
      <ul>
        <li>게임 진행 및 이벤트 처리</li>
        <li>엔딩 처리</li>
        <li>WebSocket 관리</li>
        <li>SSE 관리</li>
      </ul>
    </td>
    <td>
      <ul>
        <li>게임방 생성</li>
        <li>캐릭터 생성</li>
        <li>UI 효과 삽입</li>
        <li>카카오 회원 연동</li>
      </ul>
    </td>
    <td>
      <ul>
        <li>사이드바 관리</li>
      </ul>
    </td>
    <td>
      <ul>
        <li>초기 데이터 생성 및 관리</li>
        <li>이벤트 처리 구현</li>
        <li>전투 로직 구현</li>
      </ul>
    </td>
    <td>
      <ul>
        <li>프롬프트 관리</li>
        <li>GPT 관리</li>
      </ul>
    </td>
  </tr>
</table>
