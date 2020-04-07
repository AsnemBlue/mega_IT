package com.tj.ch18.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.tj.ch18.dao.BookDao;
import com.tj.ch18.dto.Book;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	String backupPath = "D:/mega_IT/source/9_Spring/ch18/src/main/webapp/bookImgFileUpload/";
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}
	@Override
	public List<Book> bookList(Book book) {
		return bookDao.bookList(book);
	}
	@Override
	public Book getBook(int bnum) {
		return bookDao.getBook(bnum);
	}
	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // temp_bimg1, ...
		String[] bimg = {"",""};
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 연결된 파일 객체
			bimg[idx] = mFile.getOriginalFilename(); 
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				//파일첨부 했다
				if(new File(uploadPath+bimg[idx]).exists()) {
					//서버에 같은 파일이름의 있을 때 첨부한 파일이름을 교체
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}//if
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx])); //서버에 저장
					System.out.println("서버파일 : "+uploadPath+bimg[idx]);
					System.out.println("백업파일 : "+backupPath+bimg[idx]);
					int result = 
					  fileCopy(uploadPath+bimg[idx], backupPath+bimg[idx]); //파일 카피
					System.out.println(result == 1? idx+"번째 복사성공":idx+"번째 복사 실패");
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				//파일첨부 안 하면 bimg[idx]는 ""가 됨
				//bimg[idx] = "";
			}//if
			idx++;
		}//while
		book.setBimg1(bimg[0]);//첫번째 첨부한 파일이름
		book.setBimg2(bimg[1]);//두번째 첨부한 파일이름
		return bookDao.registerBook(book);
	}
	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // temp_bimg1, ...
		String[] bimg = new String[2];
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 연결된 파일 객체
			bimg[idx] = mFile.getOriginalFilename(); 
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				//파일첨부 했다
				if(new File(uploadPath+bimg[idx]).exists()) {
					//서버에 같은 파일이름의 있을 때 첨부한 파일이름을 교체
					bimg[idx] = System.currentTimeMillis()+"_"+bimg[idx];
				}//if
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx])); //서버에 저장
					System.out.println("서버파일 : "+uploadPath+bimg[idx]);
					System.out.println("백업파일 : "+backupPath+bimg[idx]);
					int result = 
					  fileCopy(uploadPath+bimg[idx], backupPath+bimg[idx]); //파일 카피
					System.out.println(result == 1? idx+"번째 복사성공":idx+"번째 복사 실패");
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				//파일첨부 안 하면 bimg[idx]는 ""가 됨
				//bimg[idx] = "";
			}//if
			idx++;
		}//while
		Book book = new Book();
		book.setBnum(Integer.parseInt(mRequest.getParameter("bnum")));
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBinfo(mRequest.getParameter("binfo"));
		book.setBimg1(bimg[0]);//첫번째 첨부한 파일이름
		book.setBimg2(bimg[1]);//두번째 첨부한 파일이름
		return bookDao.modifyBook(book);
	}
	@Override
	public int cntBook() {
		return bookDao.cntBook();
	}
	private int fileCopy(String serverFile, String backupFile) {
		int isCopy = 0;
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			is = new FileInputStream(serverFile);
			os = new FileOutputStream(backupFile);
			File sFile = new File(serverFile);
			byte[] buff = new byte[(int)sFile.length()];
			while(true) {
				int nRead = is.read(buff);
				if(nRead== -1) break;
				os.write(buff, 0, nRead);
			}
			isCopy = 1;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e) { }
		}
		return isCopy;
	}
}
