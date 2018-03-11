package br.com.roentgen.carros.activity

/**
 * Created by valdy on 10/03/2018.
 */

import android.annotation.SuppressLint
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

@SuppressLint("Registered")
open class BaseActivity:AppCompatActivity() {
    // Propriedade para acessar o contexto de qualquer lugar
    protected val context:Context get() = this

}