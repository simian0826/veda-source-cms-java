package tech.veda.cms.biz.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author lizhiying
 */
public class NetWorkUtil {

  public static String getWifFiIPAddress(){
    String ipAddress = "";
    try {
      // 获取所有网络接口
      Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

      while (networkInterfaces.hasMoreElements()) {
        NetworkInterface networkInterface = networkInterfaces.nextElement();

        // 过滤掉回环接口和未启用的接口
        if (networkInterface.isLoopback() || !networkInterface.isUp()) {
          continue;
        }

        // 获取网络接口的所有 IP 地址
        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();

        while (inetAddresses.hasMoreElements()) {
          InetAddress inetAddress = inetAddresses.nextElement();

          // 过滤掉回环地址和IPv6地址
          if (inetAddress.isLoopbackAddress() || inetAddress instanceof java.net.Inet6Address) {
            continue;
          }

          // 打印 IP 地址
          System.out.println("当前WiFi的 IP 地址: " + inetAddress.getHostAddress());
          ipAddress = inetAddress.getHostAddress();
          return ipAddress;
        }
      }
    } catch (SocketException e) {
      e.printStackTrace();
    }
    return ipAddress;
  }
}

