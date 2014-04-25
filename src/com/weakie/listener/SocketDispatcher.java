package com.weakie.listener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.weakie.util.log.LogUtil;

public class SocketDispatcher implements Runnable {

	private ServerSocket listen;
	private int listenPort;
	private boolean stop = false;

	public SocketDispatcher() {}

	public void initialize(int port) throws IOException {
		this.listenPort = port;
		this.stop = false;
		this.listen = new ServerSocket(listenPort);
		LogUtil.info("socket diapatcher listen to port: " + this.listenPort);
	}

	public void destroy() throws IOException {
		this.stop = true;
		this.listen.close();
	}

	public int getListenPort() {
		return this.listenPort;
	}

	@Override
	public void run() {
		LogUtil.info("socket diapatcher running.");
		while (!stop) {
			try {
				Socket socket = listen.accept();
				socket.getPort();
			} catch (IOException e) {
				LogUtil.error(e);
			}
		}
		LogUtil.info("socket diapatcher closed. ");
	}
}
