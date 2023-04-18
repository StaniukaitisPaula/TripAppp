package br.senai.sp.jandira.tripapp.repository

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Email
import br.senai.sp.jandira.tripapp.dao.TripDb
import br.senai.sp.jandira.tripapp.model.User

class UserRepository(context: Context) {

    //variavel que representa nosso banco de dados
    private val db = TripDb.getDataBase(context)

    //responsavel por inserir um novo usuario no banco
    fun save(user: User): Long{
        return db.userDao().save(user)
    }

    //responsavel por encontar  um usuario por e-mail
    fun  findUserByEmail(email: String): User{
        return db.userDao().findUserByEmail(email)
    }

    //responsavel pela aute
    fun  authenticate(email: String, password: String): User{
        return db.userDao().authenticate(email, password)
    }

    //repositoty Id

}