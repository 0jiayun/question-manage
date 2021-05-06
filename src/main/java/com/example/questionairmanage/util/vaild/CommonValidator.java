package com.example.questionairmanage.util.vaild;

/**
 * @Description 数据校验工具类
 */
public class CommonValidator {

    /**
     * 判断操作过程是否成功
     *
     * @param returnRows  返回数
     * @param successRows 业务中所需数据行数
     * @return 判断结果
     */
    public static boolean isProcessSuccess(int returnRows, int successRows) {
        return returnRows == successRows;
    }

    /**
     * 判断传入的对象是否为空
     *
     * @param obj 传入对象
     * @return 判断结果
     */
    public static <T> boolean notNull(T obj) {
        return null != obj;
    }

}
