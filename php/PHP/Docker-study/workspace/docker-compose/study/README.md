===================================================================================== 명령어 =====================================================================================

# docker network ls                                // 네트워크 보기
# docker network rm 네트워크명                     // 네트워크 삭제
# docker rmi {이미지 ID} -f                        // 이미지 삭제
# docker-compose up -d                             // 이미지 생성및 실행 (-d 는 데몬으로 실행하는 옵션)
# docker-compose --compatibility up -d [서비스명]  // CPU 또는 메모리를 제한하여 실행하는 경우
# docker-compose ps                                // compose로 실행중인 각 서비스의 상태를 보여준다
# docker-compose start [서비스명]                  // 서비스 시작
# docker-compose stop [서비스명]                   // 서비스 정지
# docker-compose down --volumes                    // 서비스를 지운다. 컨테이너와 네트워크를 삭제하며, 옵션에 따라 볼륨도 지운다.
# docker-compose rm -fsv [서비스명]                // 서비스 정지및 삭제, 볼륨제거
# docker-compose logs [서비스명]                   // 서비스의 로그를 확인, 컨테이너명이 아니고 서비스명
  ex) docker-compose logs web

# docker exec -it {서비스(컨테이너) 이름} /bin/bash  // 서비스 접속

===================================================================================== 권한문제 발생시 처리방법 =====================================================================================

1.mariadb
 # chown -R mysql:mysql /var/lib/mysql/

2.web
 # chown www-data:www-data -R /home/Code/api/storage

 HTTP 500 오류는 웹 사이트의 파일 또는 폴더에 대한 권한 문제로 인해 발생할 수 있음
 # chmod 755 -R {폴더명}
 # chmod 755 -R ./study    // study폴더 권한 755 변경
