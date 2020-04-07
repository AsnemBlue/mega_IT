package com.tj.ex6_file;
import java.io.File;
public class Ex01_file {
	public static void main(String[] args) {
		File file = new File("."); // ch18_io프로젝트 폴더
		String[] fileStr = file.list();
		for(String fileS : fileStr) {
			System.out.println(fileS);
		}
		System.out.println("프로젝트 폴더의 내용");
		File[] files = file.listFiles();
		for(File f : files) {
			if(f.getName().length()>=8) {
				System.out.print(f.getName());
			}else {
				System.out.print(f.getName()+"\t");
			}
			System.out.print("\t"+f.length()+"\t");
			System.out.println(f.isDirectory()? "디렉토리":"파일");
		}
	}
}
