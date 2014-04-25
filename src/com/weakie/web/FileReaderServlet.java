package com.weakie.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weakie.util.log.LogUtil;

/**
 * Servlet implementation class FileReaderServlet
 */
public class FileReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileReaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String fileName = request.getParameter("fileName");
		LogUtil.info("request to read file: "+fileName);
		File file = new File(fileName);
		if(file.isFile()){
			String downloadName = "download";
			try {
				downloadName = URLEncoder.encode(file.getName(), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				LogUtil.error(e1);
			}
			LogUtil.info("download filename="+downloadName);
			response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadName+"\"");
			response.setContentType("application/octet-stream;charset=GB18030");
			//response.addHeader("Cache-control", "max-age=3600");
			//response.setContentType("application/x-msdownload");
			response.setContentLength((int)file.length());
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			try {
				bin = new BufferedInputStream(new FileInputStream(file));
				bout = new BufferedOutputStream(response.getOutputStream());
				byte[] buf = new byte[512];
				int length = 0;
				LogUtil.info("start to read file.");
				while((length = bin.read(buf, 0, buf.length))!=-1){
					bout.write(buf, 0, length);
				}
				response.flushBuffer();
				LogUtil.info("stop to read file.");
			} catch (FileNotFoundException e) {
				LogUtil.error(e);
			} catch (IOException e) {
				LogUtil.error(e);
			} finally{
				if(bin != null){
					try {
						bin.close();
					} catch (IOException e) {
						LogUtil.error(e);
					}
				}
				if(bout != null){
					try {
						bout.close();
					} catch (IOException e) {
						LogUtil.error(e);
					}
				}
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
