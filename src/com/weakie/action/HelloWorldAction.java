package com.weakie.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.weakie.bean.MessageStore;
import com.weakie.util.log.LogUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 开发测试使用
 * @author dell
 *
 */
public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private MessageStore messageStore;
	private List<Integer> age;
	private int agew;
	
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	private String url;
	private final String imgpath = "upload/";
	
	public String execute() throws Exception {

		LogUtil.debug(age+"");
		LogUtil.debug(agew + ":ooo");
		agew = age.get(0);
		LogUtil.debug(agew + ":ppp");
		messageStore = new MessageStore();
		return SUCCESS;
	}
	
	
	public String executeUpload() throws Exception{
		LogUtil.debug(age+"");
		LogUtil.debug(agew + ":ooo");
		agew = age.get(0);
		LogUtil.debug(agew + ":ppp");
		messageStore = new MessageStore();
		
		LogUtil.debug(file.length()+"");
		InputStream is = new FileInputStream(file);

		String path = ServletActionContext.getServletContext().getRealPath("/");
		System.out.println(path);
		url = imgpath + fileFileName;
		File destFile = new File(path + imgpath, fileFileName);

		LogUtil.debug(destFile.getAbsolutePath());
		OutputStream os = new FileOutputStream(destFile);

		byte[] buffer = new byte[400];

		int length = 0;

		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
			LogUtil.debug("write");
		}

		is.close();

		os.close();
		return SUCCESS;
	}

	public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}

	public List<Integer> getAge() {
		return age;
	}

	public void setAge(List<Integer> age) {
		this.age = age;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getUrl() {
		return url;
	}
	
	
}