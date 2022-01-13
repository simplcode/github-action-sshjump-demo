# Github Action SSH Jump deployment demo
SSH Jump를 이용한 Github Action 데모.
## 개요
- 빌드된 스프링부트 애플리케이션을 SSH Proxy 서버를 통해 Test1, Test2 서버에 순차적으로 배포 및 실행.
- Test1, Test2 서버는 Private subnets에 배치. Public subnet의 load-balancer와는 8080/tcp, SSH Proxy와는 22/tcp 포트를 사용.
## GitHub Action 설정
### Secret
- TEST_HOST1_PVT: Test1서버의 private ip address
- TEST_HOST2_PVT: Test2서버의 private ip address
- TEST_HOST_KEY: Test1, 2 서버 접속용 SSH private key
- USERNAME: Test1, 2 서버 접속용 SSH username
- PROXY_HOST: SSH Proxy 서버의 public ip address
- PROXY_KEY: SSH Proxy 서버 접속용 SSH private key
- PROXY_USERNAME: SSH Proxy 서버 접속용 SSH username
- SLACK_WEBHOOK_URL: slack app webhook url
### Branch
- develop 브랜치로의 push를 감지하여 배포를 수행.
## 주의 사항
- main또는 default로 지정된 브랜치에 action을 설정해야 동작함.
- build 과정에서 생성되는 artifact는 기본 90일의 보관기간을 가지므로 action이 빈번하게 실행될 경우 Artifact storage quota가 가득찰 수 있슴. workflow 또는 repository 설정에서 기간을 조정 필요함.
