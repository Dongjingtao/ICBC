package com.icbc.sh.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 网络相关工具.
 *
 * @author kfzx-zhaowei
 * @date 2016-5-19下午02:24:35
 */
public class NetUtil {


    public static final String UNKNOWN_IP = "0.0.0.0";// 未知IP
    public static final String UNKNOWN_MAC = "00-00-00-00-00-00";// 未知MAC

    private static String ip; // IP地址, 仅获取一次
    private static String mac;
    private static String unLoopbackIp; // 非局域网、IPv4第一块网卡地址, 仅获取一次

    /**
     * 获取本机IP地址.
     * <p>
     * 当有多块网卡时，仅返回第一块网卡IP，排除ipv6以及192.168.开头的局域网IP.
     *
     * @return IP地址，如果获取失败，返回"0.0.0.0".
     */
    public static String getUnLoopbackLocalhost() {
        synchronized (NetUtil.class) {
            if (unLoopbackIp == null) {
                unLoopbackIp = doGetUnLoopbackLocalhost();
            }
        }
        return unLoopbackIp;
    }

    /**
     * 获取本机IP地址.
     * <p>
     * 当出现多块网卡或者localhost有回环定义时，返回可能不准确，如127.0.0.1.
     *
     * @return IP地址，如果获取失败，返回"0.0.0.0".
     */
    private static String getLocalhost() {
        synchronized (NetUtil.class) {
            if (ip == null) {
                ip = doGetLocalhost();
            }
        }
        return ip;
    }

    /**
     * 获取本机IP地址.
     * <p>
     * 当出现多块网卡或者localhost有回环定义时，返回可能不准确，如127.0.0.1.
     *
     * @return IP地址，如果获取失败，返回"0.0.0.0".
     */
    private static String doGetLocalhost() {
        try {
            StringBuilder buffer = new StringBuilder();
            byte[] ipbs = InetAddress.getLocalHost().getAddress();
            for (byte b : ipbs) {
                buffer.append((b < 0 ? b + 256 : b) + ".");
            }
            return buffer.deleteCharAt(buffer.length() - 1).toString();
        } catch (UnknownHostException e) {
            return UNKNOWN_IP;
        }
    }

    /**
     * 获取本机IP地址.
     * <p>
     * 当有多块网卡时，仅返回第一块网卡IP.
     *
     * @return IP地址，如果获取失败，返回"0.0.0.0".
     */
    private static String doGetUnLoopbackLocalhost() {
        try {
            Enumeration<NetworkInterface> addrs = NetworkInterface
                    .getNetworkInterfaces();
            while (addrs.hasMoreElements()) {
                NetworkInterface ni = addrs.nextElement();
                if (!ni.isLoopback() && ni.isUp()) {
                    Enumeration<InetAddress> ips = ni.getInetAddresses();
                    while (ips.hasMoreElements()) {
                        String host = ips.nextElement().getHostAddress();
                        if (host.indexOf(':') == -1
                                && host.indexOf("192.168.") == -1
                                && !host.equals("0.0.0.0")) {
                            return host;
                        }
                    }
                }
            }

            return getLocalhost();
        } catch (SocketException e) {
            return getLocalhost();
        }
    }

    private static String getMacByIP() {
        ip = getUnLoopbackLocalhost();
        try {
            InetAddress ia = InetAddress.getByName(ip);
            byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                String hexString = Integer.toHexString(mac[i] & 0xFF);
                sb.append(hexString.length() == 1 ? "0" + hexString : hexString);
            }
            return sb.toString().toUpperCase();
        } catch (UnknownHostException e) {
            return UNKNOWN_MAC;
        } catch (SocketException e) {
            return UNKNOWN_MAC;
        }
    }

    public static String getMac() {
        synchronized (NetUtil.class) {
            if (mac == null) {
                mac = getMacByIP();
            }
        }
        return mac;
    }

}