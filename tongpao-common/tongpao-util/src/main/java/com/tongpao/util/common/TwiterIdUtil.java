package com.tongpao.util.common;

/**
 * 生成码工具类
 *
 * @author raojing
 * @date 2019/12/8 14:23
 */
public class TwiterIdUtil {

    private static int node = 1;
    public static final int NODE_SHIFT = 10;
    public static final int SEQ_SHIFT = 12;

    public static final short MAX_SEQUENCE = 4096;

    private static short sequence;
    private static long referenceTime;


    private static synchronized long next() {

        long currentTime = System.currentTimeMillis();
        long counter;

        synchronized (TwiterIdUtil.class) {

            if (currentTime < referenceTime) {
                throw new RuntimeException(String.format("Last referenceTime %s is after reference time %s", referenceTime, currentTime));
            } else if (currentTime > referenceTime) {
                sequence = 0;
            } else {
                if (sequence < MAX_SEQUENCE) {
                    sequence++;
                } else {
                    throw new RuntimeException("Sequence exhausted at " + sequence);
                }
            }
            counter = sequence;
            referenceTime = currentTime;
        }

        return currentTime << NODE_SHIFT << SEQ_SHIFT | node << SEQ_SHIFT | counter;
    }

    /**
     * 生成分布式id
     *
     * @return
     */
    public static Long getTwiterId() {
        return next();
    }


    /**
     * 随机生成指定数
     *
     * @param len
     * @return
     */
    public static String getRandomCode(Integer len) {
        //字符源，可以根据需要删减
        //去掉1和i ，0和o
        String generateSource = "23456789abcdefghgklmnpqrstuvwxyz";
        String rtnStr = "";
        for (int i = 0; i < len; i++) {
            //循环随机获得当次字符，并移走选出的字符
            String nowStr = String.valueOf(generateSource.charAt((int) Math.floor(Math.random() * generateSource.length())));
            rtnStr += nowStr;
            generateSource = generateSource.replaceAll(nowStr, "");
        }
        return rtnStr.toUpperCase();
    }

}
