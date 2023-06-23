package com.example.medpro.Controllers

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.medpro.Models.User


public class UserC(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    var db:SQLiteDatabase = this.writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        var query1 = "CREATE TABLE Users (\n" +
                "   id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "   fullname TEXT NOT NULL ,\n" +
                "   email TEXT NOT NULL UNIQUE,\n" +
                "   phone TEXT NOT NULL \n," +
                "   password TEXT NOT NULL \n" +
                ");"
        if (db != null) {
            db.execSQL(query1)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun checkIfExists(userEmail: String): Boolean {
        db = this.readableDatabase
        val query = "SELECT email FROM Users"
        val cursor = db.rawQuery(query, null)
        var existEmail: String
        if (cursor.moveToFirst()) {
            do {
                existEmail = cursor.getString(0)
                if (existEmail == userEmail) {
                    return true
                }
            } while (cursor.moveToNext())
        }
        return false
    }

    fun register(user: User){
        var cv = ContentValues()
        cv.put("fullname",user.fullname)
        cv.put("email",user.email)
        cv.put("phone",user.phone)
        cv.put("password",user.password)

        db.insert("Users",null,cv)
        db.close()
    }

    fun login(email:String,password:String): Int {
        var result = 0
        var db:SQLiteDatabase = this.readableDatabase
        val s = arrayOf(email,password)
        var c: Cursor = db.rawQuery("SELECT * FROM Users WHERE email = ? AND password = ?",s)

        if(c.moveToFirst()){
            result = 1
        }
        return result

    }

    fun getId(email:String): Int {
        var db:SQLiteDatabase = this.readableDatabase
        val s = arrayOf(email)
        var c: Cursor = db.rawQuery("SELECT id FROM Users WHERE email = ? ",s)
        var n:Int = 0

        if (c.moveToFirst()) {
            do {
                n = c.getInt(0)

            } while (c.moveToNext())
        }
        return n

    }

    fun profile(email:String): User {
        val s = arrayOf(email)
        var user = User()
        db = this.readableDatabase
        var c: Cursor = db.rawQuery("SELECT id,fullname,phone,password FROM Users WHERE email = ?",s)

        if (c.moveToFirst()) {
            do {
                user.id = c.getInt(0)
                user.fullname = c.getString(1)
                user.phone = c.getString(2)
                user.password = c.getString(3)
            } while (c.moveToNext())
        }
        return user

    }

    fun updateProfile(user: User):Boolean{
        var db:SQLiteDatabase = this.writableDatabase
        var id = user.id
        val query = "SELECT * FROM Users"
        val result = db.rawQuery(query,null)
        val where = "id=$id"
        var k = false

        try{
            val c = ContentValues()
            c.put("fullname",user.fullname)
            c.put("phone",user.phone)
            c.put("password",user.password)
            db.update("Users",c,where, null)
            k = true
        }catch (e: Exception) {
            val error = e.message.toString()
        }
        return k

    }

    fun delete(user: User): Boolean {
        var s:Boolean = false
        var id = user.id
        val where = "id=$id"
        var db:SQLiteDatabase = writableDatabase
        try{
            db.delete("Users",where,null)
            s = true
        }catch (e: Exception) {
            val error = e.message.toString()
        }
        return s

    }




}