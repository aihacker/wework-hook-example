package com.godtoy.alipay.bill.alipay.utils

import android.util.Log
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import java.lang.Exception

object HookUtil {
    public fun printLogs(tag: String, param: XC_MethodHook.MethodHookParam) {
        var str = "$tag@${param.method}->Result:${param.result}"
        param.args?.forEach {
            try {
                str += "#${it.javaClass}____$it\t"
            } catch (ex: Exception) {

            }
        }
        XposedBridge.log(str)
    }

    public fun info(tag: String, message: String) {
        Log.d("xposed", "$tag-$message")
    }
}