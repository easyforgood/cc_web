package util;

import java.io.File;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

//�ϴ����ļ��������������������ϴ�ʱ���Զ�������
public class RandomFileRenamePolicy implements FileRenamePolicy {
	@Override
	public File rename(File file) {
		String body = "";
		String ext = "";
		Date date = new Date();
		int pot = file.getName().lastIndexOf(".");// ȡ���ļ����ͺ�׺�ָ��
		if (pot != -1) {// ˵����׺����
			body = date.getTime() + "";// ����ʱ�����ʽ����
			ext = file.getName().substring(pot);// ��ȡ��׺��
		} else {
			body = (new Date()).getTime() + "";
			ext = "";
		}
		String newName = body + ext;
		file = new File(file.getParent(), newName);// ���ļ�����������
		return file;

	}

}
