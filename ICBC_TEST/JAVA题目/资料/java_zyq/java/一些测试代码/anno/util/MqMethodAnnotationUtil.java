package com.icbc.sh.mq.anno.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import com.icbc.sh.mq.base.annotation.dump.MqRecvMtd;
import com.icbc.sh.mq.base.annotation.dump.MqSendMtd;

public class MqMethodAnnotationUtil {
	public static HashMap<String, Class<?>> sendToMqClassMap = new HashMap<String, Class<?>>();
	public static HashMap<String, Class<?>> recvFromMqClassMap = new HashMap<String, Class<?>>();

	public static void validAnnotation(List<Class<?>> clsList) throws Exception {
		if (clsList != null && clsList.size() > 0) {
			for (Class<?> cls : clsList) {
				// 获取类中的所有的方法
				Method[] methods = cls.getDeclaredMethods();
				if (methods != null && methods.length > 0) {
					for (Method method : methods) {
						MqRecvMtd mqRecvAnnotion = (MqRecvMtd) method.getAnnotation(MqRecvMtd.class);
						if (mqRecvAnnotion != null) {
							// 可以做权限验证
							// System.out.println("RECVANNO"+mqRecvAnnotion.mq_channel());
							String quename=mqRecvAnnotion.mq_channel();
							if(recvFromMqClassMap.containsKey(quename))
							{
								throw new Exception("RECV_QUEUE_RE_DEFINED@"+quename);
							}
							
							recvFromMqClassMap.put(mqRecvAnnotion.mq_channel(), cls);

						}

						MqSendMtd senderAnnotation = (MqSendMtd) method.getAnnotation(MqSendMtd.class);
						if (senderAnnotation != null) {
							// 可以做权限验证
							// System.out.println("SENDANNO"+senderAnnotation.mq_channel());
							String quename=senderAnnotation.mq_channel();
							if(sendToMqClassMap.containsKey(quename))
							{
								throw new Exception("SEND_QUEUE_RE_DEFINED@"+quename);
							}
							
							sendToMqClassMap.put(senderAnnotation.mq_channel(), cls);
						}

					}
				}
			}
		}
	}

}
