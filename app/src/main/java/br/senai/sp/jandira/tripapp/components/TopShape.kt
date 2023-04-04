package br.senai.sp.jandira.tripapp.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.tripapp.R

@Composable
fun TopShape () {
    Card(
        modifier = Modifier
            .height(40.dp)
            .width(120.dp),
        shape = RoundedCornerShape(bottomStart = 16.dp),
        backgroundColor = colorResource(id = R.color.primary_color)
    ) {
    }
}

@Preview
@Composable
fun TopShapePreview() {
    TopShape()
}