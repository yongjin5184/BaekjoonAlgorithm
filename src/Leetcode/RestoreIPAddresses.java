package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    /**
     * @description 모든 가능성있는 IP address 를 리턴하는 문제
     * IP Address 가 될 수 있는 조건 하기와 같다.
     * 1. 0 ~ 255 사이의 숫자로 구성되어야 한다.
     * 2. 0.011.255.245 에서 011 처럼 0 이 lead 되는 숫자가 나오면 안된다.
     */
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return list;
        }
        search(s, 0, 0, new StringBuilder(), list);
        return list;
    }

    public static void search(String s, int index, int count, StringBuilder sb, List<String> list) {
        if (count == 4) {
            if (index == s.length()) {
                list.add(sb.toString());
            }
            return;
        }

        for (int i = 1; i + index <= s.length() && i <= 3; i++) {
            int num = Integer.parseInt(s.substring(index, index + i));
            if (num >= 0 && num <= 255) {
                if (num < 10 && i > 1) {
                    return;
                }
                StringBuilder newSb = new StringBuilder(sb);
                if (count == 0) {
                    newSb.append(num);
                } else {
                    newSb.append(".").append(num);
                }
                search(s, index + i, count + 1, newSb, list);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
    }
}
