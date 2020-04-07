DROP TABLE MVC_MEMBER;
CREATE TABLE MVC_MEMBER(
    mId VARCHAR2(30) PRIMARY KEY,
    mPw VARCHAR2(30) NOT NULL,
    mName VARCHAR2(30) NOT NULL,
    mEmail VARCHAR2(30),
    mPhoto VARCHAR2(30) DEFAULT 'NOIMG.JPG' NOT NULL,
    mBirth DATE,
    mAddress VARCHAR2(300),
    mRdate  DATE DEFAULT SYSDATE
);
-- mId 중복체크
SELECT * FROM MVC_MEMBER WHERE mId='aaa';
-- 회원가입(mID, mPw, mNAME / mEMAIL, mPHOTO, mBIRTH, mADDRESS)
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('aaa','1','홍길동','hong@naver.com','NOIMG.JPG','1990/12/12','종로');
-- 로그인 (mID, mPW)
SELECT * FROM MVC_MEMBER WHERE mID='aaa' and mPW='1';
--세션에 넣기 위해 mId로 member dto가져오기
SELECT * FROM MVC_MEMBER WHERE mId='aaa';
--회원정보수정(mPw, mNAME / mEMAIL, mPHOTO, mBIRTH, mADDRESS 수정 가능)
UPDATE MVC_MEMBER SET mPw = '111',
                    mName = 'HONG',
                    mEmail = 'yi@naver.com',
                    mPhoto = 'NOIMG.JPG',
                    mBirth = '1991/12/12',
                    mAddress = '서울'
        WHERE mId='aaa';
-- 회원목록(startRow ~ endRow)
SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM 
                        (SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC) A)
        WHERE RN BETWEEN 1 AND 10;
-- 가입한 전체 회원 명수
SELECT COUNT(*) cnt FROM MVC_MEMBER;
commit;










