package xyz.itwill10.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import xyz.itwill10.dto.FileBoard;
import xyz.itwill10.service.FileBoardService;

// ���� ���ε� ó�� ���
// 1. commons-fileupload ���̺귯�� ���� ó�� - pom.xml
//2.���� ���ε� ����� �����ϴ� Ŭ������ Spring Bean���� ��� - servlet-context.xml

@Controller
public class FileController {
	@Autowired
	private WebApplicationContext context; 
	
	@Autowired
	private FileBoardService fileBoardService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}
	
	/*
	// ù��°
	//MultipartHttpServletRequest : "multipart/form-data"�� ���޵Ǵ� ���� ������ ó���ϱ� ���� ��ü
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IOException {
		String uploadName=request.getParameter("uploadName");
		
		//MultipartHttpServletRequest.getFile(String parameterName) : ���޵� ������ 
		//MultipartFile ��ü�� ��ȯ�ϴ� �޼ҵ�
		//MultipartFile : ���޵� ������ ������ �����ϴ� ��ü
		MultipartFile uploadFile=request.getFile("uploadFile");

		//�������Ͽ� ���� ��ȿ�� �˻� : ���� ����, ���� ����, ���� ũ��
		//MultipartFile.isEmpty() : ���������� ���� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		
		// MultipartFile.getContentType() : ���޵� ������ ����(MimeType)�� ��ȯ�ϴ� �޼ҵ�
		System.out.println("���� ���� = "+uploadFile.getContentType());
		
		// MultipartFile.getBytes() : ���޵� ������ byte �迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		System.out.println("���� ũ�� = "+uploadFile.getBytes().length);
		
		
		// ���޵� ������ ������ �����ϱ� ���� ���ε� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDir=request.getServletContext().getRealPath("/resources/images");		
		
		// ���޵� ������ ������ �����ϱ� ���� File ��ü ����
		//	MultipartFile.getOriginalFilename() : ���޵� ������ �̸��� ��ȯ�ϴ� �޼ҵ�
		File file=new File(uploadDir, uploadFile.getOriginalFilename());
		
		// ���ε� ó��
		// MultipartFile.transferTo(File file) : ���������� ������ �����ϴ� �޼ҵ�
		//  => ���� ���ε� ���丮�� ���ε� ���ϰ� ���� �̸��� ������ �ִ� ��� �������Ͽ� ����
		uploadFile.transferTo(file); 
		
		request.setAttribute("uploadName", uploadName);
		request.setAttribute("uploadFile", uploadFile.getOriginalFilename());		
		
		return "file/upload_ok";
		
	}
	*/
		
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam String uploadName
			, @RequestParam MultipartFile uploadFile, Model model) throws IOException {
		if(uploadFile.isEmpty()) {
			return "file/upload_fail";
		}
		
		//WebApplicationContext ��ü�� �̿��Ͽ� ���� ���ε� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDir=context.getServletContext().getRealPath("/resources/images");
		
		File file=new File(uploadDir, uploadFile.getOriginalFilename());
		
		uploadFile.transferTo(file);//���ε� ó��
		
		model.addAttribute("uploadName", uploadName);
		model.addAttribute("uploadFile", uploadFile.getOriginalFilename());
		
		return "file/upload_ok";
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.GET)
	public String FileUpload() {
		return "file/file_upload";
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	public String FileUpload(@ModelAttribute FileBoard fileBoard) throws IllegalStateException, IOException {
		if(fileBoard.getFile().isEmpty()) { // ���� ���� xx
			return "file/file_upload";			
		}
		
		// �ٿ�ε� �� �� �ְ� ���� ���̱� ������ �ƹ��� ������ �� ���� WEB-INF ���� �ؿ� �����. >> ���α׷��� ������ ������ �ƹ��� ������ �� ����.
		//  => ���� ���
		String uploadDir= context.getServletContext().getRealPath("/WEB-INF/upload");
		
		// �������ϸ��� ��ȯ�޾� ����
		String origin= fileBoard.getFile().getOriginalFilename();
		
		// ���ε� ���ϸ��� �ĺ���(������(���� ���� ����� ��¥�� �ð� >> ���� �ý����� TimeStamp), �ߺ�x)�� �����Ͽ� ����
		//  => ���ε� ���ϸ��� �ߺ����� �ʵ��� ó��
		String upload= System.currentTimeMillis()+"";
		
		// ���� ���ε� >> �����ϱ����� ���� ���� ���ε�
		fileBoard.getFile().transferTo(new File(uploadDir, upload));
		
		// DTO ��ü�� �ʵ尪 ����
		fileBoard.setOrigin(origin);
		fileBoard.setUpload(upload);
		
		fileBoardService.addFileBoard(fileBoard);
		
		return "redirect:/file_list";
	}
	
	@RequestMapping("/file_list")
	public String fileList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/file_list";
	}
	
	@RequestMapping("/file_delete/{num}")
	public String fileDelete(@PathVariable int num) {
		// �Խñ��� �����ϸ� ���ϵ� ������ �Ǿ���ϱ⶧���� ���� ����ó�� ���� ���ش�.		
		// ���� ���丮�� ����� ���ε� ���� ���� >> �Խñ��� �����Ǳ����� ���� ���� ����
		FileBoard fileBoard= fileBoardService.getFileBoard(num);
		// ���� ���
		String uploadDir= context.getServletContext().getRealPath("/WEB-INF/upload");
		// ���� ����
		new File(uploadDir, fileBoard.getUpload()).delete();
		
		// FILEBOARD ���̺��� ����� �Խñ� ����
		fileBoardService.removeFileBoard(num);
		
		return "redirect:/file_list";
	}
	
	// �ش� ����(num�� �ش��ϴ� ����)�� �ٿ�ε�
	// ��û ó�� �޼ҵ忡�� ��û ó�� �� �ٿ�ε� ���α׷��� �����Ͽ� ������ �� �ֵ��� �����.
	//  => ��ȯ�Ǵ� ���ڿ��� �̿��Ͽ� ���α׷� ����ǵ��� ViewResolver ���� >> servler-context.xml
	@RequestMapping("/file_download/{num}")
	public String fileDownload(@PathVariable int num, Model model) {
		FileBoard fileBoard= fileBoardService.getFileBoard(num);
		
		// �ٿ�ε� ���� ������ �ٿ�ε� ���α׷�(Spring Bean)���� ����
		model.addAttribute("uploadDir", context.getServletContext().getRealPath("/WEB-INF/upload"));
		model.addAttribute("uploadFileName", fileBoard.getUpload());
		model.addAttribute("originFileName", fileBoard.getOrigin());
		
		// ���α׷�(Spring Bean)�� beanName ��ȯ
		return "fileDownload";
	}
}
