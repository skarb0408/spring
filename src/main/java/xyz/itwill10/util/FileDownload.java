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

// ���� �ٿ�ε� ����� �����ϴ� Ŭ���� - Spring Bean ��� >> servlet-context.xml 
// BeanNameViewResolver�� ���� ����Ǵ� Ŭ������ �ݵ�� AbstractView Ŭ������ ��� �޾� �ۼ��ؾ��Ѵ�.
//  => renderMergedOutputModel() �޼ҵ带 �������̵� �����Ͽ� ���� ó���� ����� ����� �ۼ��Ѵ�.
public class FileDownload extends AbstractView {
	// Ŭ���̾�Ʈ���� ������ ��������(MimeType) ���� >> ���� �ٿ�ε� ����� ����
	public FileDownload() {
		// AbstractView.setContentType(String mimeType) : ���� ���������� �����ϴ� �޼ҵ�
		setContentType("application/download; utf-8");
	}
	
	// BeanNameViewResolver�� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	//  => Map �ڷ����� �Ű��������� ��û ó�� �޼ҵ忡�� Model ��ü�� ���� �����Ǵ� ������ ����Ǿ��ִ�.
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ��Ű�� �̿��Ͽ� �ʰ��� ��ȯ�޾� ���� >> �ٿ�ε� ���� ����
		//  => Object Ÿ���� ��ü�� ��ȯ�ǹǷ� �ݵ�� ����� ��ü ����ȯ�Ͽ� ���
		String uploadDir= (String)model.get("uploadDir");
		String uploadFileName= (String)model.get("uploadFileName");
		String originFileName= (String)model.get("originFileName");
		
		// �ٿ�ε� ������ �̿��� File ��ü ����
		File downloadFile= new File(uploadDir, uploadFileName);
		
		// Ŭ���̾�Ʈ���� ������ �����ϱ� ���� ���� ������ ����
		response.setContentType(getContentType());
		response.setContentLength((int)downloadFile.length());
		
		// Ŭ���̾�Ʈ���� �ٿ�ε� ���ϸ� ����
		originFileName= URLEncoder.encode(originFileName, "UTF-8");
		
		response.setHeader("Content-Disposition", "attachement;filename=\""+originFileName+"\";");
		
		// Ŭ���̾�Ʈ���� ���õ����͸� �����ϱ� ���� ��½�Ʈ���� ��ȯ�޾� ����
		OutputStream out= response.getOutputStream();
		
		FileInputStream in= null;
		try {
			// �ٿ�ε� ������ ���õ����ͷ� �б����� �Է½�Ʈ���� �����Ͽ� ����
			in= new FileInputStream(downloadFile);
			
			// FileCopyUtils.copy(inputStream in, outputStream out) : �Է½�Ʈ���� �̿��Ͽ� ���õ����͸� �о� ��½�Ʈ������ �ݺ��ؼ� �����ϴ� �޼ҵ� > ���� ����
			FileCopyUtils.copy(in, out); // �ٿ�ε�
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
