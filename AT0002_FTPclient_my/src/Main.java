import java.util.Scanner;

public class Main {
	final static String WHITESPACE =" ";
	final static String CMD_LIST = "list"; //list of commands
	final static String CMD_CD = "cd";
	final static String CMD_PARENT = "/";
	final static String CMD_SAVE = "save";
	final static String CMD_EXIT = "exit";
	
	public static void main(String[] args) {
		NewFtpClient ftpClient = new NewFtpClient();
		String serverAddress = "ftp.dlink.ru";
		String username = "";
		String password = "";
		String localDirectory = "/Downloads"; // directory for save files from ftp
		String command = "";
		String commandMain = ""; // command
		String commandArg = ""; // arg for command
		if (ftpClient.connectFTP(serverAddress, username, password)) {
			printListofCommands();
			Scanner in = new Scanner(System.in);
			do {
				command = in.nextLine();
				if (command.contains(" ")) {
					commandMain = command.substring(0, command.indexOf(WHITESPACE));
					commandArg = command.substring(command.indexOf(WHITESPACE) + 1,
							command.length());
				} else {
					commandMain = command;
				}
				switch (commandMain) {
				case CMD_LIST: // list of files&dirs
					ftpClient.listDirsFiles();
					break;
				case CMD_CD: // go to dir
					ftpClient.moveToDir(commandArg);
					break;
				case CMD_PARENT: // go to parent dir
					ftpClient.goBack();
					break;
				case CMD_SAVE: // download file from ftp-server
					ftpClient.downloadFile(localDirectory, commandArg);
					break;
				case CMD_EXIT: // disconnect server
					System.out.println("Ftp will be disconnect");
					break;
				default:
					System.out.println("not vallid command");
					break;
				}
			} while (!command.equals("exit"));
		} else {
			System.out.println("Connect is fail");
		}
		ftpClient.disconnect();
		System.out.println("Ftp is disconnect");
	}

	private static void printListofCommands() {
		System.out.println("------List of commands:\n"
				+ CMD_CD+" <dir> - go to dir \n" + CMD_LIST+" - list of files&dir \n"
				+ CMD_SAVE+" <filename> - download file from ftp-server \n"
				+ CMD_PARENT+" - go to parent dir \n" + CMD_EXIT+" - disconnect");
		System.out.println("Please, enter command:");
	}

}
