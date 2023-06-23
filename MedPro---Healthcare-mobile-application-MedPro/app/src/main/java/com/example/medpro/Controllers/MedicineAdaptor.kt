package com.example.medpro.Controllers

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.medpro.Models.Medi

class MedicineAdaptor(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_MEDICINES($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_PNAME TEXT , $COL_LNAME TEXT , $COL_FEE TEXT);")
    }

    private fun dropDb(db: SQLiteDatabase) {
        db.execSQL("DROP TABLE $TABLE_MEDICINES;")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        this.dropDb(db)
        onCreate(db)
    }

    inner class TABLE_LABTESTS {
        var total = 0
        fun ADD_DATA_LABTESTS(patient_name:String,doctor_name:String,doctor_fee:String) {
            val db = writableDatabase;
            val newContentoffline = ContentValues()
            newContentoffline.put(COL_PNAME, patient_name)
            newContentoffline.put(COL_LNAME, doctor_name)
            newContentoffline.put(COL_FEE, doctor_fee)
            db.insert(TABLE_MEDICINES, null, newContentoffline)
        }

        fun DELETE_DATA_LABTESTS(id: String): Int {
            val db = writableDatabase
            return db.delete(TABLE_MEDICINES, "medi_id = ?", arrayOf(id))
        }

        fun GET_DATA_LABTESTS(): ArrayList<Medi> {
            val db = writableDatabase
            val res = db.rawQuery("SELECT * FROM ${TABLE_MEDICINES}", null)
            val useList = ArrayList<Medi>()
            var i = 0

            if (res.moveToFirst()) {

                while (!res.isAfterLast()) {
                    val model =
                        Medi(
                            res.getString(0),
                            res.getString(1),
                            res.getString(2),
                            res.getInt(3),
                        )
                    total += res.getInt(3)


                    useList.add(model)
                    res.moveToNext()
                    i++
                }
            }
            res.close()
            return useList
        }

        fun UPDATE_DATA_LABTESTS(id: String, pname: String,dname:String,fee:String) {
            val db = writableDatabase
            val newContentoffline = ContentValues()
            newContentoffline.put(COL_ID, id)
            newContentoffline.put(COL_PNAME, pname)
            newContentoffline.put(COL_LNAME, dname)
            newContentoffline.put(COL_FEE, fee)
            db.update(TABLE_MEDICINES, newContentoffline, "$COL_ID = ?", arrayOf(id))
        }

    }
    companion object {
        val DATABASE_NAME = "Medicines"
        val TABLE_MEDICINES = "tblMedicines"
        val COL_ID = "medi_id"
        val COL_PNAME = "user_name"
        val COL_LNAME= "medi_name"
        val COL_FEE = "lab_fee"
    }

}