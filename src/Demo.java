import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
 * �������÷���������ļ�������ʹ��Ӧ�ó������ʱ����Դ����������κ��޸�
 * ����ֻ��Ҫ�����෢�͸��ͻ��ˣ����޸������ļ�����
 */
public class Demo {
	public static void main(String[] args) throws Exception {
		// ͨ�������ȡClass����
		Class stuClass = Class.forName(getValue("className"));// "Student"
		// 2��ȡshow()����
		Method m = stuClass.getMethod(getValue("methodName"));// show
		// 3.����show()����
		m.invoke(stuClass.getConstructor().newInstance());
	}
	// �˷�������һ��key���������ļ��л�ȡ��Ӧ��value
	public static String getValue(String key) throws IOException {
		Properties pro = new Properties();// ��ȡ�����ļ��Ķ���
		FileReader in = new FileReader("config.txt");// ��ȡ������
		pro.load(in);// �������ص������ļ�������
		in.close();
		return pro.getProperty(key);// ���ظ���key��ȡ��valueֵ
	}
}
