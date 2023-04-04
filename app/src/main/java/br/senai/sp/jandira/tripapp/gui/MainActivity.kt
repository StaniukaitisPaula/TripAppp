package br.senai.sp.jandira.tripapp.gui

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.text.method.TextKeyListener.Capitalize
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.components.BottomShape
import br.senai.sp.jandira.tripapp.components.TopShape
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                    value = "",
                    onValueChange = {},
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.primary_color),
                        unfocusedBorderColor = colorResource(id = R.color.primary_color)
                    )
                )
                OutlinedTextField(
                    modifier = Modifier
                        .width(320.dp)
                        .padding(top = 6.dp, bottom = 12.dp),
                    value = "",
                    onValueChange = {},
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
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    shape = RoundedCornerShape(20.dp),
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
                            val openOther = Intent(context, LoginActivity::class.java)
                            context.startActivity(openOther)
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
