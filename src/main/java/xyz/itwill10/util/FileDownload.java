package xyz.itwill10.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

// 파일 다운로드 기능을 제공하는 클래스 - Spring Bean 등록 >> servlet-context.xml 
// BeanNameViewResolver에 의해 실행되는 클래스는 반드시 AbstractView 클래스를 상속 받아 작성해야한다.
//  => renderMergedOutputModel() 메소드를 오버라이드 선언하여 응답 처리시 실행될 명령을 작성한다.
public class FileDownload extends AbstractView {
	// 클라이언트에게 응답할 파일형식(MimeType) 변경 >> 파일 다운로드 기능을 제공
	public FileDownload() {
		// AbstractView.setContentType(String mimeType) : 응답 파일형식을 변경하는 메소드
		setContentType("application/download; utf-8");
	}
	
	// BeanNameViewResolver에 의해 자동 호출되는 메소드
	//  => Map 자료형의 매개변수에는 요청 처리 메소드에서 Model 객체에 의해 제공되는 정보가 저장되어있다.
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 맵키를 이용하여 맵값을 반환받아 저장 >> 다운로드 파일 정보
		//  => Object 타입의 객체로 반환되므로 반드시 명시적 객체 형변환하여 사용
		String uploadDir= (String)model.get("uploadDir");
		String uploadFileName= (String)model.get("uploadFileName");
		String originFileName= (String)model.get("originFileName");
		
		// 다운로드 파일을 이용한 File 객체 생성
		File downloadFile= new File(uploadDir, uploadFileName);
		
		// 클라이언트에게 파일을 전달하기 위한 응답 정보를 변경
		response.setContentType(getContentType());
		response.setContentLength((int)downloadFile.length());
		
		// 클라이언트에게 다운로드 파일명 전달
		originFileName= URLEncoder.encode(originFileName, "UTF-8");
		
		response.setHeader("Content-Disposition", "attachement;filename=\""+originFileName+"\";");
		
		// 클라이언트에게 원시데이터를 전달하기 위한 출력스트림을 반환받아 저장
		OutputStream out= response.getOutputStream();
		
		FileInputStream in= null;
		try {
			// 다운로드 파일을 원시데이터로 읽기위한 입력스트림을 생성하여 저장
			in= new FileInputStream(downloadFile);
			
			// FileCopyUtils.copy(inputStream in, outputStream out) : 입력스트림을 이용하여 원시데이터를 읽어 출력스트림으로 반복해서 전달하는 메소드 > 파일 복사
			FileCopyUtils.copy(in, out); // 다운로드
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				in.close();				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}		
	}
}
