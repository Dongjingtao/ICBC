package com.icbc.sh.mq.anno.util.test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * ɨ�����·�� ���������ļ���jar���ļ�
 * 
 * @author ljb
 *
 */
public class ScanningFile {

	private Class<?> superStrategy = String.class;// �ӿ���class ���ڹ��� ���Բ�Ҫ

	private List<Class<? extends String>> eleStrategyList = new ArrayList<Class<? extends String>>();

	private ClassLoader classLoader = ScanningFile.class.getClassLoader();// Ĭ��ʹ�õ��������

	// private static final String STARATEGY_PATH = "com.MyUtils.file";//��Ҫɨ��Ĳ��԰���
	private static final String STARATEGY_PATH = "com.icbc.sh.mq.anno.util";// ��Ҫɨ��Ĳ��԰���

	public static void main(String[] args) {
		ScanningFile s = new ScanningFile();
		s.addClass();
	}

	/**
	 * ��ȡ��������ʵ����superStrategy���ಢ����list
	 */
	private void addClass() {
		URL url = classLoader.getResource(STARATEGY_PATH.replace(".", "/"));
		String protocol = url.getProtocol();
		if ("file".equals(protocol)) {
			// �����Լ��ɼ��Ĵ���
			findClassLocal(STARATEGY_PATH);
		} else if ("jar".equals(protocol)) {
			// ����jar���Ĵ���
			findClassJar(STARATEGY_PATH);
		}
	}

	/**
	 * ���ز���
	 * 
	 * @param packName
	 */
	private void findClassLocal(final String packName) {
		URI url = null;
		try {
			url = classLoader.getResource(packName.replace(".", "/")).toURI();
		} catch (URISyntaxException e1) {
			throw new RuntimeException("δ�ҵ�������Դ");
		}

		File file = new File(url);
		file.listFiles(new FileFilter() {

			public boolean accept(File chiFile) {
				if (chiFile.isDirectory()) {
					findClassLocal(packName + "." + chiFile.getName());
				}
				if (chiFile.getName().endsWith(".class")) {
					Class<?> clazz = null;
					try {
						clazz = classLoader.loadClass(packName + "." + chiFile.getName().replace(".class", ""));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					System.out.println(chiFile);
					if (superStrategy.isAssignableFrom(clazz)) {
						eleStrategyList.add((Class<? extends String>) clazz);
					}
					return true;
				}
				return false;
			}
		});

	}

	/**
	 * jar������
	 * 
	 * @param packName
	 */
	private void findClassJar(final String packName) {
		String pathName = packName.replace(".", "/");
		JarFile jarFile = null;
		try {
			URL url = classLoader.getResource(pathName);
			JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
			jarFile = jarURLConnection.getJarFile();
		} catch (IOException e) {
			throw new RuntimeException("δ�ҵ�������Դ");
		}

		Enumeration<JarEntry> jarEntries = jarFile.entries();
		while (jarEntries.hasMoreElements()) {
			JarEntry jarEntry = jarEntries.nextElement();
			String jarEntryName = jarEntry.getName();

			if (jarEntryName.contains(pathName) && !jarEntryName.equals(pathName + "/")) {
				// �ݹ������Ŀ¼
				if (jarEntry.isDirectory()) {
					String clazzName = jarEntry.getName().replace("/", ".");
					int endIndex = clazzName.lastIndexOf(".");
					String prefix = null;
					if (endIndex > 0) {
						prefix = clazzName.substring(0, endIndex);
					}
					findClassJar(prefix);
				}
				if (jarEntry.getName().endsWith(".class")) {
					Class<?> clazz = null;
					try {
						clazz = classLoader.loadClass(jarEntry.getName().replace("/", ".").replace(".class", ""));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					if (superStrategy.isAssignableFrom(clazz)) {
						eleStrategyList.add((Class<? extends String>) clazz);
					}
				}
			}

		}

	}

}