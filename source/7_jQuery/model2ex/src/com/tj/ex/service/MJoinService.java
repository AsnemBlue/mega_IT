package com.tj.ex.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.ex.dao.MemberDao;
import com.tj.ex.dto.MemberDto;
public class MJoinService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024; // 최대 업로드 사이즈 : 1M
		String mPhoto = "";
		try {
			// mRequest 객체 생성한 후 파일 이름 받아오기
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, 
									"utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames(); 
			//while(params.hasMoreElements()) {
				String param = params.nextElement(); // mPhoto
			//}
			mPhoto = mRequest.getFilesystemName(param);
			mPhoto = (mPhoto==null)? "NOIMG.JPG" : mPhoto;
			// 파라미터값 다 받아오기 -> DB에 넣기
			String mId = mRequest.getParameter("mId");
			String mPw = mRequest.getParameter("mPw");
			String mName = mRequest.getParameter("mName");
			String mEmail = mRequest.getParameter("mEmail");
			String mBirthStr = mRequest.getParameter("mBirth");
			Date mBirth = null;
			if(!mBirthStr.equals("")) {
				mBirth = Date.valueOf(mBirthStr);
			}
			String mAddress = mRequest.getParameter("mAddress");
			MemberDao mDao = MemberDao.getInstance();
			MemberDto member = new MemberDto(mId, mPw, mName, mEmail, mPhoto, 
															mBirth, mAddress, null);
			int	result = mDao.joinMember(member); //회원가입
			if(result==MemberDao.SUCCESS) {
					HttpSession session = request.getSession();
					session.setAttribute("mId", mId);
					request.setAttribute("joinResult", "회원가입이 완료되었습니다");
			}else {
					request.setAttribute("errorMsg", "길어서 가입이 실패되었습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 업로드된 파일을 소스폴더로 복사
		File serverFile = new File(path+"/"+mPhoto);
		if(!mPhoto.equals("NOIMG.JPG") && serverFile.exists()) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/mega_IT/source/7_jQuery/model2ex/WebContent/memberPhotoUp/"+mPhoto);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int readbyteCnt = is.read(bs);
					if(readbyteCnt == -1) break;
					os.write(bs, 0, readbyteCnt);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (Exception e) {}
			}//try-catch-finally
		}//execute()
	}
}








