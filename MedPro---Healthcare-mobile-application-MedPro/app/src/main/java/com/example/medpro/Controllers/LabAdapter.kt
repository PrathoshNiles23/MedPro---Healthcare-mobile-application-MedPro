package com.example.medpro.Controllers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.medpro.Models.Lab

class LabAdapter(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_LABTESTS($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_PNAME TEXT , $COL_LNAME TEXT , $COL_FEE TEXT, $COL_DATE TEXT, $COL_TIME TEXT);")
    }

    private fun dropDb(db: SQLiteDatabase) {
        db.execSQL("DROP TABLE $TABLE_LABTESTS;")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        this.dropDb(db)
        onCreate(db)
    }

    inner class TABLE_LABTESTS {
        fun ADD_DATA_LABTESTS(patient_name:String,doctor_name:String,doctor_fee:String,app_date:String,app_time:String) {
            val db = writableDatabase;
            val newContentoffline = ContentValues()
            newContentoffline.put(COL_PNAME, patient_name)
            newContentoffline.put(COL_LNAME, doctor_name)
            newContentoffline.put(COL_FEE, doctor_fee)
            newContentoffline.put(COL_DATE, app_date)
            newContentoffline.put(COL_TIME, app_time)
            db.insert(TABLE_LABTESTS, null, newContentoffline)
        }

        fun DELETE_DATA_LABTESTS(id: String): Int {
            val db = writableDatabase
            return db.delete(TABLE_LABTESTS, "lab_id = ?", arrayOf(id))
        }

        fun GET_DATA_LABTESTS(): ArrayList<Lab> {
            val db = writableDatabase
            val res = db.rawQuery("SELECT * FROM ${TABLE_LABTESTS}", null)
            val useList = ArrayList<Lab>()
            var i = 0
            if (res.moveToFirst()) {

                while (!res.isAfterLast()) {
                    val model =
                        Lab(
                            res.getString(0),
                            res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4),
                            res.getString(5),
                        )


                    useList.add(model)
                    res.moveToNext()
                }
            }
            res.close()
            return useList
        }

        fun UPDATE_DATA_LABTESTS(id: String, pname: String,dname:String,fee:String,date:String,time:String) {
            val db = writableDatabase
            val newContentoffline = ContentValues()
            newContentoffline.put(COL_ID, id)
            newContentoffline.put(COL_PNAME, pname)
            newContentoffline.put(COL_PNAME, pname)
            newContentoffline.put(COL_LNAME, dname)
            newContentoffline.put(COL_FEE, fee)
            newContentoffline.put(COL_DATE, date)
            newContentoffline.put(COL_TIME, time)
            db.update(TABLE_LABTESTS, newContentoffline, "$COL_ID = ?", arrayOf(id))
        }

    }
    companion object {
        val DATABASE_NAME = "Labs"
        val TABLE_LABTESTS = "tblLabs"
        val COL_ID = "lab_id"
        val COL_PNAME = "patient_name"
        val COL_LNAME= "lab_name"
        val COL_FEE = "lab_fee"
        val COL_DATE = "app_date"
        val COL_TIME= "app_time"
    }

}