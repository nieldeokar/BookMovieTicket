package com.tentwenty.bookmovie

import org.json.JSONArray
import org.json.JSONException
import org.junit.Test
import org.junit.Assert.*


class TestTheaterLayout {

    companion object {
        private const val ROW_MAX = 3
        private const val COLUMN_MAX = 6
        private const val KEY_ROW = "row"
        private const val KEY_ROW_VALUES = "values"
        private const val JSON_STRING = "[{\n" +
                "\t\t\"row\": \"A\",\n" +
                "\t\t\"values\": {\n" +
                "\t\t\t\"0,0\": 1,\n" +
                "\t\t\t\"0,1\": 1,\n" +
                "\t\t\t\"0,2\": 0,\n" +
                "\t\t\t\"0,3\": 0,\n" +
                "\t\t\t\"0,4\": 1,\n" +
                "\t\t\t\"0,5\": 1\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\n" +
                "\t{\n" +
                "\t\t\"row\": \"B\",\n" +
                "\t\t\"values\": {\n" +
                "\t\t\t\"1,0\": 1,\n" +
                "\t\t\t\"1,1\": 1,\n" +
                "\t\t\t\"1,2\": 0,\n" +
                "\t\t\t\"1,3\": 0,\n" +
                "\t\t\t\"1,4\": 1,\n" +
                "\t\t\t\"1,5\": 1\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\n" +
                "\n" +
                "\t{\n" +
                "\t\t\"row\": \"C\",\n" +
                "\t\t\"values\": {\n" +
                "\t\t\t\"2,0\": 1,\n" +
                "\t\t\t\"2,1\": 1,\n" +
                "\t\t\t\"2,2\": 1,\n" +
                "\t\t\t\"2,3\": 1,\n" +
                "\t\t\t\"2,4\": 1,\n" +
                "\t\t\t\"2,5\": 1\n" +
                "\t\t}\n" +
                "\t}\n" +
                "]"

    }

    @Test
    fun testLayoutData() {

        try {
            val array = JSONArray(JSON_STRING)

            for (row in 0 until ROW_MAX) {

                val rowObject = array.getJSONObject(row)

                val rowName = rowObject.getString(KEY_ROW)
                val seatsObj = rowObject.getJSONObject(KEY_ROW_VALUES)
                print("$rowName ")

                for (column in 0 until COLUMN_MAX) {
                    val key = row.toString() + "," + column
                    print(seatsObj.getInt(key).toString() + " ")
                }
                println()
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

}