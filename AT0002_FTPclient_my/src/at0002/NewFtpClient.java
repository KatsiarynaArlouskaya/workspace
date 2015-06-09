package at0002;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class NewFtpClient {
	FTPClient ftp;
	final static String STRING_EMPTY ="";
	
	public boolean connectFTP(String serverAddress, String username, String password) {
		try {
			System.out.println("Try to connect to ftp");
			// new ftp client
			ftp = new FTPClient();
			// try to connect
			ftp.connect(serverAddress);
			// login to server
			if (username.equals("")) { // as anonymous
				username = "anonymous";
				password = System.getProperty("user.name") + "@"
						+ InetAddress.getLocalHost().getHostName();
			}
			if (!ftp.login(username, password)) {
				ftp.logout();
				System.out.println("not login");
				return false;
			}
			int reply = ftp.getReplyCode();
			// After connection attempt, you should check the reply code to
			// verify success.
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				System.err.println("FTP server refused connection.");
				System.exit(1);
			}
			System.out.println("login is success");
			// enter passive mode
			ftp.enterLocalPassiveMode();
			// get system name
			System.out.println("Remote system is " + ftp.getSystemType());
			listDirsFiles();

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public void disconnect() {
		if (ftp.isConnected()) {
			try {
				ftp.logout();
				ftp.disconnect();
			} catch (IOException f) {
				// do nothing as file is already saved to server
			}
		}
	}

	public void goBack() {
		try {
			// go to parentDir
			if (ftp.changeToParentDirectory()) {
				listDirsFiles();
			} else {
				System.out.println("fail");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void downloadFile(String localDirectory, String fileName) {
		if (!fileName.equals(STRING_EMPTY)) {
			try {
				ftp.setFileType(FTP.BINARY_FILE_TYPE); // change transfer mode
				// ftp.setFileType(FTP.ASCII_FILE_TYPE);
				// get output stream
				OutputStream output;
				output = new FileOutputStream(localDirectory + "/" + fileName);
				// get the file from the remote system
				if (ftp.retrieveFile(fileName, output)) {
					System.out.println("download is succes");
				} else {
					System.out.println("download fail");
				}
				// close output stream
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("not specified arg");
		}
	}

	public void moveToDir(String remoteDirectory) {
		if (!remoteDirectory.equals(STRING_EMPTY)) {
			try {
				// go to remoteDir
				if (ftp.changeWorkingDirectory(remoteDirectory)) {
					listDirsFiles();
				} else {
					System.out.println("not valid path");
				}

			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			System.out.println("not specified arg");
		}
	}

	public void listDirsFiles() {
		try {
			// get list of filenames
			System.out.println("--------Current directory is "
					+ ftp.printWorkingDirectory());
			FTPFile[] ftpFiles = ftp.listFiles();
			if (ftpFiles != null && ftpFiles.length > 0) {
				for (FTPFile file : ftpFiles) {
					if (!file.isFile()) {
						System.out.println("[" + file.getName() + "]");
					}
				}
				for (FTPFile file : ftpFiles) {
					if (file.isFile()) {
						System.out.println(file.getName());
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
