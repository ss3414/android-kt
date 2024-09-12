package com.example.kotlindemo.first.c07

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class SQLiteUtil(private val context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val sql = """
            create table user (
            id integer primary key autoincrement,
            name text,
            password text)
        """.trimIndent()
        p0?.execSQL(sql)
        Toast.makeText(this.context, "创建数据库", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists test")
        val sql = """
            create table test (
            id integer primary key autoincrement,
            name text,
            password text)
        """.trimIndent()
        p0?.execSQL(sql)
        Toast.makeText(this.context, "更新数据库", Toast.LENGTH_SHORT).show()
    }
}
