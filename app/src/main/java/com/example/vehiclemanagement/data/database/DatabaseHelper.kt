package com.example.vehiclemanagement.data.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.vehiclemanagement.data.model.Vehicle

class DatabaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    DatabaseManager.DATABASE_NAME,
    null,
    DatabaseManager.DATABASE_VERSION
) {

    companion object {
        const val KEY_ID = "_id"
        const val KEY_NAME = "name"
        const val KEY_TYPE = "type"
        const val KEY_PRICE = "price"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        createTable(db)
    }

    private fun createTable(db: SQLiteDatabase?) {
        val createQuery = "CREATE TABLE IF NOT EXISTS " + DatabaseManager.TABLE_NAME +
                " " + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT, " +
                KEY_TYPE + " TEXT, " + KEY_PRICE + " TEXT)"
        db?.execSQL(createQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addVehicle(vehicle: Vehicle): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, vehicle.id)
        contentValues.put(KEY_NAME, vehicle.name)
        contentValues.put(KEY_TYPE, vehicle.type)
        contentValues.put(KEY_PRICE, vehicle.price)

        val addQuery = db.insert(DatabaseManager.TABLE_NAME, null, contentValues)
        db.close()
        return addQuery
    }

    fun updateVehicleById(vehicle: Vehicle): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, vehicle.id)

        val updateQuery =
            db.update(DatabaseManager.TABLE_NAME, contentValues, KEY_ID + "=" + vehicle.id, null)
        db.close()
        return updateQuery
    }

    fun removeVehicleById(vehicle: Vehicle): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_ID, vehicle.id)

        val removeQuery = db.delete(DatabaseManager.TABLE_NAME, KEY_ID + "=" + vehicle.id, null)
        db.close()
        return removeQuery
    }

    fun getAllVehicle(): ArrayList<Vehicle> {
        val getAllQuery = "SELECT * FROM ${DatabaseManager.TABLE_NAME}"
        val vehicleList = ArrayList<Vehicle>()
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(getAllQuery, null)
        } catch (exception: SQLException) {
            db.execSQL(getAllQuery)
            return vehicleList
        }
        while (cursor != null && cursor.moveToNext()) {
            val id = cursor.getString(cursor.getColumnIndex(KEY_ID))
            val name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
            val type = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
            val price = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))

            vehicleList.add(Vehicle(id, name, type, price))
        }
        return vehicleList
    }

    fun getVehicleNameAsc(): ArrayList<Vehicle> {
        val getNameAscQuery = "SELECT * FROM ${DatabaseManager.TABLE_NAME} ORDER BY $KEY_NAME ASC"
        val vehicleList = ArrayList<Vehicle>()
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(getNameAscQuery, null)
        } catch (exception: SQLException) {
            db.execSQL(getNameAscQuery)
            return vehicleList
        }
        while (cursor != null && cursor.moveToNext()) {
            val id = cursor.getString(cursor.getColumnIndex(KEY_ID))
            val name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
            val type = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
            val price = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))

            vehicleList.add(Vehicle(id, name, type, price))
        }
        return vehicleList
    }

    fun getVehicleNameDesc(): ArrayList<Vehicle> {
        val getNameDescQuery = "SELECT * FROM ${DatabaseManager.TABLE_NAME} ORDER BY $KEY_NAME DESC"
        val vehicleList = ArrayList<Vehicle>()
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(getNameDescQuery, null)
        } catch (exception: SQLException) {
            db.execSQL(getNameDescQuery)
            return vehicleList
        }
        while (cursor != null && cursor.moveToNext()) {
            val id = cursor.getString(cursor.getColumnIndex(KEY_ID))
            val name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
            val type = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
            val price = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))

            vehicleList.add(Vehicle(id, name, type, price))
        }
        return vehicleList
    }

    fun getVehiclePriceAsc(): ArrayList<Vehicle> {
        val getNameDescQuery = "SELECT * FROM ${DatabaseManager.TABLE_NAME} ORDER BY $KEY_PRICE ASC"
        val vehicleList = ArrayList<Vehicle>()
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(getNameDescQuery, null)
        } catch (exception: SQLException) {
            db.execSQL(getNameDescQuery)
            return vehicleList
        }
        while (cursor != null && cursor.moveToNext()) {
            val id = cursor.getString(cursor.getColumnIndex(KEY_ID))
            val name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
            val type = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
            val price = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))

            vehicleList.add(Vehicle(id, name, type, price))
        }
        return vehicleList
    }

    fun getVehiclePriceDesc(): ArrayList<Vehicle> {
        val getNameDescQuery =
            "SELECT * FROM ${DatabaseManager.TABLE_NAME} ORDER BY $KEY_PRICE DESC"
        val vehicleList = ArrayList<Vehicle>()
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(getNameDescQuery, null)
        } catch (exception: SQLException) {
            db.execSQL(getNameDescQuery)
            return vehicleList
        }
        while (cursor != null && cursor.moveToNext()) {
            val id = cursor.getString(cursor.getColumnIndex(KEY_ID))
            val name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
            val type = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
            val price = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))

            vehicleList.add(Vehicle(id, name, type, price))
        }
        return vehicleList
    }

    fun getVehicleByPrice(price: Int): ArrayList<Vehicle> {
        val getNameDescQuery =
            "SELECT * FROM ${DatabaseManager.TABLE_NAME} WHERE $KEY_PRICE > $price"
        val vehicleList = ArrayList<Vehicle>()
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(getNameDescQuery, null)
        } catch (exception: SQLException) {
            db.execSQL(getNameDescQuery)
            return vehicleList
        }
        while (cursor != null && cursor.moveToNext()) {
            val id = cursor.getString(cursor.getColumnIndex(KEY_ID))
            val name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
            val type = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
            val price = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))

            vehicleList.add(Vehicle(id, name, type, price))
        }
        return vehicleList
    }

    fun getVehicleByID(id: String): Vehicle? {
        val getNameDescQuery =
            "SELECT * FROM ${DatabaseManager.TABLE_NAME} WHERE $KEY_ID == $id"
        var vehicle: Vehicle? = null
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(getNameDescQuery, null)
        } catch (exception: SQLException) {
            db.execSQL(getNameDescQuery)
            return null
        }
        if (cursor != null) {
            val id = cursor.getString(cursor.getColumnIndex(KEY_ID))
            val name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
            val type = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
            val price = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))
            vehicle = Vehicle(id, name, type, price)
        }
        return vehicle!!
    }

    fun getVehicleByName(name: String): Vehicle? {
        val getNameDescQuery =
            "SELECT * FROM ${DatabaseManager.TABLE_NAME} WHERE $KEY_NAME == $name"
        var vehicle: Vehicle? = null
        val db = this.readableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(getNameDescQuery, null)
        } catch (exception: SQLException) {
            db.execSQL(getNameDescQuery)
            return null
        }
        if (cursor != null) {
            val id = cursor.getString(cursor.getColumnIndex(KEY_ID))
            val name = cursor.getString(cursor.getColumnIndex(KEY_NAME))
            val type = cursor.getString(cursor.getColumnIndex(KEY_TYPE))
            val price = cursor.getInt(cursor.getColumnIndex(KEY_PRICE))
            vehicle = Vehicle(id, name, type, price)
        }
        return vehicle!!
    }
}