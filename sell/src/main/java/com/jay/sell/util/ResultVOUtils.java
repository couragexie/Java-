package com.jay.sell.util;

import com.jay.sell.VO.ResultVO;

import javax.xml.transform.Result;

/**
 * @program: sell
 * @description: 返回结果的处理
 * @author: Jay
 * @create: 2020-03-17 16:48
 **/

public class ResultVOUtils {

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        return resultVO;
    }

    public static ResultVO error(int code) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage("失败");
        return resultVO;
    }
}
