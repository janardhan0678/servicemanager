package com.tbd.servicemanager.utils

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class JsonUtils {


    fun toMap(jsonobj: JSONObject): HashMap<String, String> {

        val map: HashMap<String, String> = HashMap()
        try {
            val keys = jsonobj.keys()
            while (keys.hasNext()) {
                val key = keys.next()
                var value = jsonobj.getString(key)
                map[key] = value
            }
        }catch (ex:JSONException){
        }
        return map
    }

    @Throws(JSONException::class)
    fun toList(array: JSONArray): List<Any> {
        val list: MutableList<Any> = ArrayList()
        for (i in 0 until array.length()) {
            var value = array[i]
            if (value is JSONArray) {
                value = toList(value)
            } else if (value is JSONObject) {
                value = toMap(value)
            }
            list.add(value)
        }
        return list
    }
}