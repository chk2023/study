ARG UBUNTU_VERSION

FROM ubuntu:${UBUNTU_VERSION}
LABEL maintainer="jidanmian777@gmail.com"
LABEL name="chk"
LABEL Version="1.0"

# Install PHP, and supplimentary programs. openssh-server, curl, and lynx-cur are for debugging the container.
# RUN apt update && apt -y upgrade && DEBIAN_FRONTEND=noninteractive apt -y install \
# RUN apt update && apt install -y --no-install-recommends apt-utils
ARG DEBIAN_FRONTEND=noninteractive

# 레파지토리 추가
RUN apt update && apt -y install software-properties-common
RUN add-apt-repository ppa:ondrej/php && add-apt-repository ppa:ondrej/nginx

# 저장소 카카오로 변경 및 기본패키지 추가
RUN apt update && apt install -y --no-install-recommends apt-utils
RUN sed -i 's/archive.ubuntu.com/mirror.kakao.com/g' /etc/apt/sources.list \
    && apt update && apt -y upgrade && apt -y install \
    php7.4 \
    php7.4-cli \
    php7.4-common \
    php7.4-mysql \
    curl \
    wget \
    php7.4-gd \
    php7.4-json \
    php7.4-curl \
    php7.4-mbstring \
    php7.4-xml \
    php7.4-zip \
    php7.4-opcache \
    php7.4-dev \
    php-imagick \
    unzip \
    git \
    vim \
    build-essential \
    && rm -rf /var/lib/apt/lists/*

# nginx, fpm설치
RUN apt update && apt install -y nginx php7.4-fpm

# Update the PHP.ini file, enable <? ?> tags and quieten logging.
RUN sed -i "s/short_open_tag = Off/short_open_tag = On/" /etc/php/7.4/fpm/php.ini
RUN sed -i "s/error_reporting = .*$/error_reporting = E_ERROR | E_WARNING | E_PARSE/" /etc/php/7.4/fpm/php.ini
RUN sed -i "s/upload_max_filesize = 2M/upload_max_filesize = 20M/" /etc/php/7.4/fpm/php.ini
RUN sed -i "s/;max_input_vars = 1000/max_input_vars = 10000/" /etc/php/7.4/fpm/php.ini
RUN sed -i "s/;max_input_vars = 1000/max_input_vars = 10000/" /etc/php/7.4/cli/php.ini
# 필수는 아니지만 권장함
RUN sed -i "s/;date.timezone =/date.timezone = Asia\/Seoul/" /etc/php/7.4/fpm/php.ini
RUN sed -i "s/;date.timezone =/date.timezone = Asia\/Seoul/" /etc/php/7.4/cli/php.ini

ADD nginx.conf /etc/nginx/
ADD base /etc/nginx/sites-available/
ADD fastcgi_params /etc/nginx/fastcgi_params
# default 파일 삭제
RUN rm /etc/nginx/sites-available/default
RUN rm /etc/nginx/sites-enabled/default
# /etc/nginx/sites-enabled 에 심볼릭 링크를 만든다
RUN ln -s /etc/nginx/sites-available/base /etc/nginx/sites-enabled/

# pear 설치
RUN apt -y install php-pear
RUN wget http://pear.php.net/go-pear.phar
RUN php -- args all go-pear.phar

# PHP버전 7.4으로 지정(자동으로 상위버전으로 지정될 수 있음)
RUN update-alternatives --set php /usr/bin/php7.4

# XDEBUG 설치 및 세팅 (버전 3)
# 참고 : https://hello-bryan.tistory.com/261
#        https://xdebug.org/docs/upgrade_guide
# xdebug 가 간혹 안되는 경우가 있다. 이때는 zend_extension의 경로가 올바르지 않은 경우일 수 있다. 아래의 명령어를 통해 xdebug.so파일의 위치를 찾아 올바르게 적용한다.
# find /usr/lib/php/ -name '*xdebug.so*'
RUN apt install -y php7.4-xdebug
RUN echo 'zend_extension=/usr/lib/php/20190902/xdebug.so\n\
    xdebug.mode=debug\n\
    xdebug.client_host=host.docker.internal\n\
    xdebug.client_port=9003\n\
    xdebug.start_with_request=yes\n\
    xdebug.log="/var/log/nginx/xdebug.log"\n\
    xdebug.idekey="vscode"\n\
    xdebug.discover_client_host=false\n\
    xdebug.remote_enable=1\n\
    xdebug.default_enable=0\n\
    xdebug.profiler_enable=0\n\
    xdebug.auto_trace=0\n\
    xdebug.coverage_enable=0\n'\
    > /etc/php/7.4/mods-available/xdebug.ini

# Yarn 설치
## 저장소 등록
RUN curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -
RUN echo "deb http://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list
## 설치
RUN apt update && apt install -y yarn

# SnappyPDF 사용시 서버에 아래 명령 필요
## UBUNTU 20.04부터는 libssl1.0을 지원안한다 따라서 아래의 저장소를 통해 설치해야 한다
RUN echo "deb http://security.ubuntu.com/ubuntu/ bionic-security main" >> /etc/apt/sources.list
RUN apt-get update -y && apt-cache policy libssl1.0-dev
RUN apt-get install -y libssl1.0-dev

EXPOSE 80

CMD service php7.4-fpm start && nginx -g "daemon off;"