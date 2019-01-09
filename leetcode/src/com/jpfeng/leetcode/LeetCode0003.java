package com.jpfeng.leetcode;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 *子串* 的长度，"pwke" 是一个 *子序列*，不是子串。
 *
 * @author Jpfeng
 * e-mail: fengjup@live.com
 * date: 2018/12/29
 */
public class LeetCode0003 {

    /**
     *
     * time: 141ms
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (chars.contains(c)) {
                    break;
                } else {
                    chars.add(c);
                }
            }
            result = Math.max(chars.size(), result);
            chars.clear();
        }
        return result;
    }
}
