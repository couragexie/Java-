package com.jay.sell.util;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: sell
 * @description: 自定义解析 select 注解，增强 mybatis 循环查询
 * @author: Jay
 * @create: 2020-03-17 15:08
 **/

public class SimpleSelectInExtendedLanguageDriver
        extends XMLLanguageDriver implements LanguageDriver {

    private final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

    @Override
    public SqlSource createSqlSource(Configuration configuration,
                                     String script, Class<?> parameterType) {

        System.out.println("拼装前的SQL：" + script);
        Matcher matcher = inPattern.matcher(script);
        if (matcher.find()) {
            script = matcher.replaceAll("(<foreach collection=\"$1\" item=\"__item\" separator=\",\" >#{__item}</foreach>)");
            // $1:表示括号第一个匹配到的，如上面代码 #{(categoryType)} $1表示括号 categoryType
        }

        script = "<script>" + script + "</script>";
        System.out.println("拼接后的 sql : " + script);
        return super.createSqlSource(configuration, script, parameterType);
    }
}
