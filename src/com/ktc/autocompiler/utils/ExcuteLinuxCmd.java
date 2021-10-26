package com.ktc.autocompiler.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.ktc.autocompiler.constants.Config;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * @Author feizai
 * @Date 2021年10月26日 0026  下午 09:40:27
 * @Explain
 */
public class ExcuteLinuxCmd {
    private static Connection connection;
    private static Session session;
    private static BufferedReader bufferedReader;

    /*
     * 连接远程Linux服务器
     */
    public static boolean connectLinuxServer(String serverAddress,
                                             String userName, String password) {
        boolean isAuthenticated = false;
        try {
            connection = new Connection(serverAddress);
            connection.connect();

            isAuthenticated = connection.authenticateWithPassword(userName, password);
            if (isAuthenticated == false) {
                throw new IOException("Authentication failed.");
            } else {
                System.out.println("connect sussess!");
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("connect error!");
        }
        return isAuthenticated;
    }

    /*
     * 连接成功后，执行命令。注意，多条命令用 ；连接，需要在同一个会话中执行，不可用该方法分开执行
     */
    public static void excuteCmd(boolean isAuthenticated, String cmd, LogUtil log, String fileName) {
        try {

            if (isAuthenticated) {
                session = connection.openSession();//打开一个会话
                session.execCommand(cmd);
                System.out.println("Here is some information about the remote host:");

                InputStream in = new StreamGobbler(session.getStdout());
                InputStream error = new StreamGobbler(session.getStderr());

                bufferedReader = new BufferedReader(new InputStreamReader(in));
                session.waitForCondition(ChannelCondition.EXIT_STATUS, 5);

				/*DataOutputStream out = new DataOutputStream(session.getStdin());
				out.writeBytes("2");
				out.flush();*/
                System.out.println("outString: " + processStream(in));
                System.out.println("outError: " + processStream(error));

                for (; ; ) {
                    String line = bufferedReader.readLine();
                    System.out.println(line);
                    if (line == null) {
                        break;
                    }
                }
                if ((processStream(error).equals("") || processStream(error) == null)) {
                    if (fileName.equals("device.mk")) {
                        if (Config.COUNTRY_CHECK) {
                            log.d("", "-----修改时区成功！");
                        }
                        if (Config.LANGUAGE_CHECK) {
                            log.d("", "-----修改默认语言成功！!");
                        }
                        if (Config.BLUETOOTH_CHECK) {
                            log.d("", "-----打开蓝牙成功！!");
                        }
                        if (Config.DVBS_CHECK) {
                            log.d("", "-----去除DVB-S成功！!");
                        }
                        if (Config.HOTEL_CHECK) {
                            log.d("", "-----开启酒店菜单成功！!");
                        }
                    }

                }
                Integer exitStatus = session.getExitStatus();
                while (exitStatus == null) {
                    exitStatus = session.getExitStatus();
                }
                System.out.println("ExitCode: " + exitStatus + bufferedReader);
                if (exitStatus == 0) {
                    log.d("", fileName + "文件修改成功！");
                } else {
                    log.e("", fileName + "文件修改失败，请检查配置是否正确或存在！");
                }
                if (in != null) {
                    in.close();
                }
                if (error != null) {
                    error.close();
                }

            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace()[0]);
            // TODO: handle exception
            log.e("", fileName + "文件修改失败，请检查配置是否正确或存在！");
            System.out.println("connect error!");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                System.out.println("connect error!");
            }
        }
    }

    private static String processStream(InputStream in) throws Exception {
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (in.read(buf) != -1) {
            sb.append(new String(buf, Charset.defaultCharset().toString()));
        }
        return sb.toString();
    }

	/*
	public static String excuteCmd(String cmd) {
		String result = null;
		String line = null;

		Process process = null;
		BufferedReader bufferedReader = null;
		StringBuffer stringBuffer = null;

		try {
			process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			stringBuffer = new StringBuffer();
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line).append("\n");
				if (line.indexOf("���") != -1) {
					System.out.println("line :" + line);
				}
				//return line;
			}
			result = stringBuffer.toString();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("excute command error!");
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				process.destroy();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}*/
}
