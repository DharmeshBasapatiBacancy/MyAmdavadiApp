package com.example.myamdavadiapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myamdavadiapp.data.DataSource
import com.example.myamdavadiapp.data.models.Recommendation
import com.example.myamdavadiapp.utils.AppContentType

@Composable
fun RecommendationDetailScreen(
    selectedOptionId: Int,
    contentType: AppContentType,
    modifier: Modifier = Modifier
) {
    val selectedOption: Recommendation? =
        DataSource.recommendations.find { it.optionId == selectedOptionId }
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(id = selectedOption?.optionImage!!),
            contentDescription = selectedOption.optionName,
            modifier = modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
            Spacer(modifier.height(10.dp))
            Text(selectedOption.optionName, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier.height(20.dp))
            IconWithText(Icons.Filled.Place, selectedOption.optionLocation)
            Spacer(modifier.height(15.dp))
            IconWithText(Icons.Default.DateRange, selectedOption.optionTimings)
            Spacer(modifier.height(15.dp))
            IconWithText(Icons.Filled.Phone, selectedOption.optionPhoneNumber)
        }
    }
}

@Composable
fun IconWithText(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
        )
        Spacer(modifier.width(15.dp))
        Text(
            text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        )
    }
}
