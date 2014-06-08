package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUtil {
	/**
	 * �������-FTP��ʽ
	 * @param hostname FTP��������ַ
	 * @param port FTP�������˿�
	 * @param username FTP��¼�û���
	 * @param password FTP��¼����
	 * @return FTPClient
	 */
	public FTPClient getConnectionFTP(String hostName, int port, String userName, String passWord) {
		//����FTPClient����
		FTPClient ftp = new FTPClient();
		try {
			//����FTP������
			ftp.connect(hostName, port);
			//�������д������Ҫ�����Ҳ��ܸı�����ʽ����������ȷ���������ļ�
			ftp.setControlEncoding("GBK");
			FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
			conf.setServerLanguageCode("zh");
			//��¼ftp
			ftp.login(userName, passWord);
			if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				ftp.disconnect();
				//System.out.println("���ӷ�����ʧ��");
			}
			//System.out.println("��½�������ɹ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ftp;
	}
	
	/**
	 * �ر�����-FTP��ʽ
	 * @param ftp FTPClient����
	 * @return boolean
	 */
	public boolean closeFTP(FTPClient ftp) {
		if (ftp.isConnected()) {
			try {
				ftp.disconnect();
				//System.out.println("ftp�Ѿ��ر�");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * �ϴ��ļ�-FTP��ʽ
	 * @param ftp FTPClient����
	 * @param path FTP�������ϴ���ַ
	 * @param filename �����ļ�·��
	 * @param inputStream ������
	 * @return boolean
	 */
	public boolean uploadFile(FTPClient ftp, String path, String fileName, InputStream inputStream) {
		boolean success = false;
		try {
			ftp.changeWorkingDirectory(path);//ת�Ƶ�ָ��FTP������Ŀ¼
			FTPFile[] fs = ftp.listFiles();//�õ�Ŀ¼����Ӧ�ļ��б�
			fileName = FTPUtil.changeName(fileName, fs);
			fileName = new String(fileName.getBytes("GBK"),"ISO-8859-1");
			path = new String(path.getBytes("GBK"), "ISO-8859-1");
			//ת��ָ���ϴ�Ŀ¼
			ftp.changeWorkingDirectory(path);
			//���ϴ��ļ��洢��ָ��Ŀ¼
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			//���ȱʡ�þ� ����txt���� ��ͼƬ��������ʽ���ļ������������
			ftp.storeFile(fileName, inputStream);
			//�ر�������
			inputStream.close();
			//�˳�ftp
			ftp.logout();
			//��ʾ�ϴ��ɹ�
			success = true;
			System.out.println("�ϴ��ɹ�������������");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * ɾ���ļ�-FTP��ʽ
	 * @param ftp FTPClient����
	 * @param path FTP�������ϴ���ַ
	 * @param filename FTP��������Ҫɾ�����ļ���
	 * @return
	 */
	public boolean deleteFile(FTPClient ftp, String path, String fileName) {
		boolean success = false;
		try {
			ftp.changeWorkingDirectory(path);//ת�Ƶ�ָ��FTP������Ŀ¼
			fileName = new String(fileName.getBytes("GBK"),	"ISO-8859-1");
			path = new String(path.getBytes("GBK"), "ISO-8859-1");
			ftp.deleteFile(fileName);
			ftp.logout();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(success)
			System.out.println("ɾ���ɹ�");
		else
			System.out.println("ɾ��ʧ��");
		
		return success;
	}

	/**
	 * �ϴ��ļ�-FTP��ʽ
	 * @param ftp FTPClient����
	 * @param path FTP�������ϴ���ַ
	 * @param fileName �����ļ�·��
	 * @param localPath ����洢·��
	 * @return boolean
	 */
	public boolean downFile(FTPClient ftp, String path, String fileName, String localPath) {
		boolean success = false;
		try {
			ftp.changeWorkingDirectory(path);//ת�Ƶ�FTP������Ŀ¼
			FTPFile[] fs = ftp.listFiles(); //�õ�Ŀ¼����Ӧ�ļ��б�
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File localFile = new File(localPath + "\\" + ff.getName());
					OutputStream outputStream = new FileOutputStream(localFile);
					//���ļ����浽�����outputStream��
					ftp.retrieveFile(new String(ff.getName().getBytes("GBK"), "ISO-8859-1"), outputStream);
					outputStream.flush();
					outputStream.close();
					System.out.println("���سɹ�");
				}
			}
			ftp.logout();
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	/**
	 * �ж��Ƿ��������ļ�
	 * @param fileName
	 * @param fs
	 * @return
	 */
	public static boolean isFileExist(String fileName, FTPFile[] fs) {
		for (int i = 0; i < fs.length; i++) {
			FTPFile ff = fs[i];
			if (ff.getName().equals(fileName)) {
				return true; //������ڷ��� ��ȷ�ź�
			}
		}
		return false; //��������ڷ��ش����ź�
	}

	/**
	 * ���������жϵĽ�� �����µ��ļ�������
	 * @param fileName
	 * @param fs
	 * @return
	 */
	public static String changeName(String fileName, FTPFile[] fs) {
		int n = 0;
//		fileName = fileName.append(fileName);
		while (isFileExist(fileName.toString(), fs)) {
			n++;
			String a = "[" + n + "]";
			int b = fileName.lastIndexOf(".");//���һ����С�����λ��
			int c = fileName.lastIndexOf("[");//���һ��"["���ֵ�λ��
			if (c < 0) {
				c = b;
			}
			StringBuffer name = new StringBuffer(fileName.substring(0, c));//�ļ�������
			StringBuffer suffix = new StringBuffer(fileName.substring(b + 1));//��׺������
			fileName = name.append(a) + "." + suffix;
		}
		return fileName.toString();
	}
	
	public static FTPClient getConnectionFTP(){
		return new FTPUtil().getConnectionFTP(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_LOGIN_NAME, FTP_LOGIN_PWD);
	}
	
	public static boolean movePic(String from, String to) throws IOException{
		boolean flag = false;

		//ftp.changeWorkingDirectory("/tcm/search/plant/" + path);//ת�Ƶ�ָ��FTP������Ŀ¼
		
		try {
			ftp.rename(from, to);
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		}
		
		return flag;
	}
	
	public static int getPicsCount(String path) throws IOException{
		
		ftp.changeWorkingDirectory(path);//ת�Ƶ�ָ��FTP������Ŀ¼
		FTPFile[] fs = ftp.listFiles();//�õ�Ŀ¼����Ӧ�ļ��б�
		return fs.length;
	}

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * 
	 */
	public static void main(String[] args) throws IOException {

		String path = "/tcm/search/plant/1/plant";
		FTPUtil a = new FTPUtil();

		FTPClient ftp = a.getConnectionFTP(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_LOGIN_NAME, FTP_LOGIN_PWD);

		//ftp.changeWorkingDirectory(path);//ת�Ƶ�ָ��FTP������Ŀ¼
		//FTPFile[] fs = ftp.listFiles();//�õ�Ŀ¼����Ӧ�ļ��б�
		//System.out.println(fs.length);
		
		ftp.rename("/tcm/search/plant/1/plant/1_1_0.jpg","/tcm/search/plant/1/plant/all/1_1_0.jpg");
		//a.deleteFile(ftp, path, "1_1_0.jpg");
		//a.uploadFile(ftp, path, filename, input);
		//a.deleteFile(ftp, path, filename);
		a.closeFTP(ftp);
	}
	
	/*FTP��������¼�û���*/
	public static String FTP_LOGIN_NAME = "Administrator";
	/*FTP��������¼����*/
	public static String FTP_LOGIN_PWD = "cadalTCM220";
	
	/*FTP������IP*/
	public static String FTP_SERVER_IP = "10.15.62.28";
	
	/*FTP�������˿�*/
	public static int FTP_SERVER_PORT = 21;
	
	public static FTPClient ftp = new FTPUtil().getConnectionFTP(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_LOGIN_NAME, FTP_LOGIN_PWD);
}