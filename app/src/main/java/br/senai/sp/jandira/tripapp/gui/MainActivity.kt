package br.senai.sp.jandira.tripapp.gui

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.text.method.TextKeyListener.Capitalize
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.android.TextLayout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.components.BottomShape
import br.senai.sp.jandira.tripapp.components.TopShape
import br.senai.sp.jandira.tripapp.model.User
import br.senai.sp.jandira.tripapp.repository.UserRepository
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user = User(
            email= "joaoVitor@g,ailcom",
            password = "joao12"
        )

        val userRep = UserRepository(this)
        var id = userRep.save(user)

        Toast.makeText(this, "$id", Toast.LENGTH_LONG).show()

        setContent {
            TripAppTheme {
                Column() {
                    TripAppScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TripAppScreen() {

    var emailState by remember {
        mutableStateOf("")
    }
    var passState by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.End
        ) {
            TopShape()
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 36.dp, end = 18.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = stringResource(
                        id = R.string.login,
                    ),
                    color = colorResource(id = R.color.primary_color),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    stringResource(id = R.string.please_sign_in),
                    color = colorResource(id = R.color.secondary_color),
                    fontSize = 14.sp,
                )
            }
            Spacer(modifier = Modifier.padding(bottom = 84.dp))
            Column(

            ) {

                OutlinedTextField(
                    modifier = Modifier.width(320.dp),
                    value = emailState ,
                    onValueChange = { emailState =  it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    shape = RoundedCornerShape(20.dp),
                    label = {
                        Text(
                            stringResource(id = R.string.email)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.email_24),
                            contentDescription = stringResource(id = R.string.email_description),
                            tint = colorResource(id = R.color.primary_color)
                        )
                    },

                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.primary_color),
                        unfocusedBorderColor = colorResource(id = R.color.primary_color)
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .width(320.dp)
                        .padding(top = 6.dp, bottom = 12.dp),
                    value = passState,
                    onValueChange = {passState = it},
                    shape = RoundedCornerShape(20.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    label = {
                        Text(
                            stringResource(id = R.string.password)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock_24),
                            contentDescription = stringResource(id = R.string.password_description),
                            tint = colorResource(id = R.color.primary_color)
                        )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.primary_color),
                        unfocusedBorderColor = colorResource(id = R.color.primary_color)
                    )
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 40.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = {
                            authenticate(
                                emailState,
                                passState,
                                context
                            )

                        },
                        modifier = Modifier
                            .size(height = 48.dp, width = 134.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.primary_color))

                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text(
                                stringResource(id = R.string.sign_in).uppercase(),
                                color = Color.White,
                                fontSize = 16.sp,

                                )
                            Icon(
                                painter = painterResource(id = R.drawable.forward_24),
                                contentDescription = stringResource(
                                    id = R.string.arrow_description
                                ),
                                tint = Color.White
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        Text(
                            stringResource(
                                id = R.string.dont_have_account
                            ),
                            color = colorResource(id = R.color.secondary_color),
                            fontSize = 12.sp,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            modifier = Modifier.clickable {
                                val openOther = Intent(context, SignUpActivity::class.java)
                                context.startActivity(openOther)
                            },
                            text = stringResource(
                                id = R.string.sign_up
                            ),
                            color = colorResource(id = R.color.primary_color),
                            fontSize = 12.sp,
                        )
                    }
                }
            }

        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom

        ) {
            BottomShape()
        }
    }
}

fun authenticate (
    email: String,
    password: String,
    context: Context
) {
    //criando uma instancia do repositório
    val userRepository = UserRepository(context)

    //verificar se o usuario ja existe
    val user = userRepository.authenticate(email, password)
    Log.i("ds3m", "${user.toString()}")

    if(user == null ){

        Toast.makeText(
            context,
            "invalid email or password!",
            Toast.LENGTH_LONG)
            .show()
    }else{
        val openOther = Intent(context, HomeActivity::class.java)
        openOther.putExtra("id", user.id)
        openOther.putExtra("name", user.userName)
        context.startActivity(openOther)

    }

}
