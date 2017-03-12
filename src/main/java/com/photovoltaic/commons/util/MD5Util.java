package com.photovoltaic.commons.util;

import java.security.MessageDigest;

/**
 * Created by wushenjun on 2017/03/12.
 */
public class MD5Util {
    public MD5Util() {
    }

    public static final String MD5(String s) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] e = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(e);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;

            for (int xor = 0; xor < j; ++xor) {
                byte code = md[xor];
                str[k++] = hexDigits[code >>> 4 & 15];
                str[k++] = hexDigits[code & 15];
            }

            String var13 = new String(str);
            short var14 = 256;
            char[] charArray = var13.toCharArray();

            for (int i = 0; i < charArray.length; ++i) {
                charArray[i] = (char) (charArray[i] ^ var14);
            }

            return new String(charArray);
        } catch (Exception var12) {
            var12.printStackTrace();
            return null;
        }
    }

    public static void main(String[] a){
        String s = MD5("13244845462");
        if(s.equals("ĸĵıņıĹİĸĹŃņĸĳŁĴĲĹŅŃĲĶņŁŁĳıńńņĵıņ")){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        // ĸĵıņıĹİĸĹŃņĸĳŁĴĲĹŅŃĲĶņŁŁĳıńńņĵıņ
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultString;
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
}