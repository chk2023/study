DROP TABLE IF EXISTS member_info;
DROP TABLE IF EXISTS team_info;

CREATE TABLE IF NOT EXISTS team_info (
	team_code INT AUTO_INCREMENT PRIMARY KEY,
	team_name VARCHAR(100) NOT NULL,
    team_detail VARCHAR(500),
    USE_YN CHAR(2) DEFAULT 'Y' CHECK (USE_YN IN ('Y', 'N')) NOT NULL
) ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS member_info (
	member_code INT AUTO_INCREMENT PRIMARY KEY,
	member_name VARCHAR(70) NOT NULL,
    birth_date DATE,
    division_code CHAR(2),
    detail_info VARCHAR(500),
    contact VARCHAR(50) NOT NULL,
    team_code INT NOT NULL,
    active_status CHAR(2) DEFAULT 'Y' CHECK (active_status IN ('Y', 'N', 'H')) NOT NULL,
	FOREIGN KEY (team_code)
		REFERENCES team_info (team_code)
) ENGINE=INNODB;

INSERT INTO 
	team_info 
VALUES (null, '음악감상부', '클래식 및 재즈 음악을 감상하는 사람들의 모임', 'Y'),
		(null, '맛집탐방부', '맛집을 찾아다니는 사람들의 모임', 'N'),
		(null, '행복찾기부', null, 'Y');
        
SELECT * FROM team_info;

INSERT INTO
	member_info
VALUES (null, '송가인', '1990-01-30', '1', '안녕하세요 송가인입니다~', '010-9494-9494', '1', 'H'),
		(null, '임영웅', '1992-05-03', null, '국민아들 임영웅입니다~', 'hero@trot.com', '1', 'Y'),
		(null, '태진아', null, null, null, '(1급 기밀)', '3', 'Y');
        
SELECT * FROM member_info;