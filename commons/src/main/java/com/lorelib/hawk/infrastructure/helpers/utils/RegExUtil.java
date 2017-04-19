package com.lorelib.hawk.infrastructure.helpers.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * Created by luomm on 2016/3/24.
 */
public class RegExUtil {
    public static List<String> extractToList(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        String[] ls = pattern.split(text);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ls.length; i++) {
            if (StringUtil.isNotBlank(ls[i])) list.add(ls[i]);
        }
        return list;
    }

    /**
     * 提取正则匹配的字符
     * @param input
     * @param regex
     * @return
     */
    public static List<String> Matcher(String input,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher= pattern.matcher(input);
        List<String> list = new ArrayList<>();
        while (matcher.find()){
            list.add(matcher.group());
        }
        return list;
    }

}
