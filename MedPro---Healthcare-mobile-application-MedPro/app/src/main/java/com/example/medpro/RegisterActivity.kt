package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.medpro.API.MailApi
import com.example.medpro.Models.User

class RegisterActivity : AppCompatActivity() {
    lateinit var login: TextView
    lateinit var fullname : EditText
    lateinit var email : EditText
    lateinit var phone : EditText
    lateinit var password : EditText
    lateinit var repassword : EditText
    lateinit var submit : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        login = findViewById(R.id.haveAnAccount)
        fullname  = findViewById(R.id.edtFullname)
        email = findViewById(R.id.edtEmail)
        phone = findViewById(R.id.edtPhone)
        password = findViewById(R.id.edtPassword)
        repassword = findViewById(R.id.edtRePassword)
        submit = findViewById(R.id.btnSubmit1)


        login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }


        fun displayAlert(title:String, message:String){
            val builder = AlertDialog.Builder(this)
            builder.setTitle(title)
            builder.setMessage(message)
            builder.setPositiveButton("OK") { dialog, which ->
// Do something when the "OK" button is clicked
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
            val dialog = builder.create()
            dialog.show()
        }

        fun isValidPassword(password:String):Boolean{
            if(password.length < 8){
                return false
            }
            var hasLower = false
            var hasUpper  =false
            var hasNumber = false
            var hasSpecial = false


            for(cha in password){
                if(Character.isLowerCase(cha)){
                    hasLower = true
                }

                else if(Character.isUpperCase(cha)){
                    hasUpper = true
                }

                else if(Character.isDigit(cha)){
                    hasNumber = true
                }

                else if(!Character.isLetterOrDigit(cha)){
                    hasSpecial = true
                }
            }
            return hasLower && hasUpper && hasNumber && hasSpecial

        }

        fun isValidEmail(email:String):Boolean{
            var hasUpper  =true
            var hasDot  =false
            var hasAt = false


            for (cha in email){
                if(Character.isUpperCase(cha)){
                    hasUpper = false
                }

                else if(cha == '.'){
                    hasDot = true
                }

                else if(cha == '@'){
                    hasAt = true
                }
            }
            return hasUpper && hasDot && hasAt

        }



        submit.setOnClickListener{
            var user = User()
            user.fullname = fullname.text.toString()
            user.email  =email.text.toString()
            user.phone = phone.text.toString()
            user.password = password.text.toString()
            var repassword = repassword.text.toString()
            var db = com.example.medpro.Controllers.UserC(applicationContext,"Medpro",null,1)

            if(user.fullname.isEmpty() || user.email.isEmpty() ||user. phone.isEmpty() || user.password.isEmpty() || repassword.isEmpty()){
                Toast.makeText(applicationContext, "Fields can't be empty", Toast.LENGTH_LONG).show()
            }

            else if (!isValidPassword(user.password)){
                Toast.makeText(applicationContext, "Password should contain atleast 8 characters with uppercase,lowercase,digit and a special character", Toast.LENGTH_LONG).show()

            }

            else if(user.password.compareTo(repassword) == 1){
                Toast.makeText(applicationContext, "Password doesn't match", Toast.LENGTH_LONG).show()
            }

            else if(!isValidEmail(user.email)){
                Toast.makeText(applicationContext, "Email should contain @,., and shouldn't contain upeercase", Toast.LENGTH_LONG).show()
            }

            else if(user.phone.length != 10){
                Toast.makeText(applicationContext, "Phone number should containe 10 numbers", Toast.LENGTH_LONG).show()
            }

            else if(db.checkIfExists(user.email)){
                Toast.makeText(applicationContext, "Email already exists", Toast.LENGTH_LONG).show()

            }

            else{
                db.register(user)
                displayAlert("Success!!","You have registered successfully.")
                var subject = "Congaratulations!!"
                var message = "Dear ${user.fullname}, \nYou are now successfully registered to Medpro."

                var mailapi : MailApi = MailApi(this,user.email,subject,message)
                mailapi.execute()

                //ctdrcgvwtjluvizt
            }






        }

    }
}