package com.icbc.sh.mq.anno.util;

import java.util.HashMap;
import java.util.List;

import com.icbc.sh.mq.base.annotation.MqRecvMsgOper;
import com.icbc.sh.mq.base.annotation.MqSendMsgOper;

public class MqClassAnnotationUtil {
	public static HashMap<String, Class<?>> sendToMqClassMap = new HashMap<String, Class<?>>();
	public static HashMap<String, Class<?>> recvFromMqClassMap = new HashMap<String, Class<?>>();

	public static void validAnnotation(List<Class<?>> clsList) throws Exception {
		if (clsList != null && clsList.size() > 0) {
			for (Class<?> cls : clsList) {
				// 获取类中的所有的方法
				MqRecvMsgOper recvoper = cls.getAnnotation(MqRecvMsgOper.class);
				if (recvoper != null) {
					// 可以做权限验证
					// System.out.println("RECVANNO"+mqRecvAnnotion.mq_channel());
					String quename = recvoper.mq_channel();
					if (recvFromMqClassMap.containsKey(quename)) {
						throw new Exception("RECV_QUEUE_RE_DEFINED@" + quename);
					}

					recvFromMqClassMap.put(recvoper.mq_channel(), cls);

				}

				MqSendMsgOper sendoper = cls.getAnnotation(MqSendMsgOper.class);
				if (sendoper != null) {
					// 可以做权限验证
					// System.out.println("SENDANNO"+senderAnnotation.mq_channel());
					String quename = sendoper.mq_channel();
					if (sendToMqClassMap.containsKey(quename)) {
						throw new Exception("SEND_QUEUE_RE_DEFINED@" + quename);
					}

					sendToMqClassMap.put(sendoper.mq_channel(), cls);
				}
			}
		}
	}
}
