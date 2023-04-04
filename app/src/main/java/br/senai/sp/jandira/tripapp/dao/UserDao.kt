package br.senai.sp.jandira.tripapp.dao

import androidx.room.*
import br.senai.sp.jandira.tripapp.model.User

@Dao
interface UserDao {

    @Insert
    fun save(user: User): Long

    @Update
    fun update(user: User): Int

    @Delete
    fun delete(user: User): Int

    @Query("SELECT * FROM tbl_user WHERE email = :email AND password = :pass")
    fun authenticate(email: String, pass: String):User

    @Query("SELECT * FROM tbl_user WHERE email = :email")
    fun findUserByEmail(email: String): User

}