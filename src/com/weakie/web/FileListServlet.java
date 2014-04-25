package com.weakie.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.weakie.util.log.LogUtil;

/**
 * Servlet implementation class FileListServlet
 */
public class FileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileListServlet() {
        super();
        LogUtil.info("Servlet init.");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = request.getParameter("baseDir");
		LogUtil.info("new request:"+dir);
		if(StringUtils.isEmpty(dir)){
			dir = getServletContext().getInitParameter("baseDir");
		}
		File file = new File(dir);
		if(file.isDirectory()){
			File[] files = file.listFiles();
			request.setAttribute("file", file);
			request.setAttribute("files", files);
			request.getRequestDispatcher("jsp/filelist.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("FileReaderServlet?fileName="+dir).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
