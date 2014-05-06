package com.weakie.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.util.log.LogUtil;

public class SpecialistInfoImageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	//upload-download
	private File file;
	private String username;
	
	//result
	private InputStream inputStream;
	
	//inject by spring,default:"/upload/"
	private String imgpath = "/upload";
	private String prePath = "d:/tmp/image";
	private boolean pathUnderServer = true;
	
	public String executeUpload() throws UnsupportedEncodingException{
		LogUtil.debug("userName: " + username);
		
		if(pathUnderServer){
			prePath = ServletActionContext.getServletContext().getRealPath("/");;
		}
		File destFile = new File(prePath + imgpath, username+".jpg");
		
		LogUtil.debug("source file length: "+file.length()/1024+" KB");
		LogUtil.debug("source file path: "+file.getAbsolutePath());
		LogUtil.debug("previous path: " + prePath);
		LogUtil.debug("file path: "+destFile.getAbsolutePath());
		
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream(destFile);
			byte[] buffer = new byte[512];
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			LogUtil.info(username+" upload file complete.");
		} catch (FileNotFoundException e) {
			LogUtil.error(e);
		} catch (IOException e) {
			LogUtil.error(e);
		} finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					LogUtil.error(e);
				}
			}
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					LogUtil.error(e);
				}
			}
		}
		String result = "user:"+this.username+":照片上传成功";
		this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		return SUCCESS;
	}
	
	public String executeDownload() {
		LogUtil.debug("download image userName: " + username);
		
		if(pathUnderServer){
			prePath = ServletActionContext.getServletContext().getRealPath("/");;
		}
		File tarFile = new File(prePath + imgpath, username+".jpg");
		if(tarFile.exists()){
			try {
				this.inputStream = new FileInputStream(tarFile);
			} catch (FileNotFoundException e) {
				LogUtil.error(e);
			}
		}else{
			this.inputStream = new ByteArrayInputStream("No Picture".getBytes());;
		}
		return SUCCESS;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	
	public void setPrePath(String prePath) {
		this.prePath = prePath;
	}

	public void setPathUnderServer(boolean pathUnderServer) {
		this.pathUnderServer = pathUnderServer;
	}

	public InputStream getInputStream() {
		return inputStream;
	}
	
}
