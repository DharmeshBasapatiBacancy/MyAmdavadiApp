package com.example.myamdavadiapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myamdavadiapp.data.DataSource
import com.example.myamdavadiapp.data.models.Recommendation
import com.example.myamdavadiapp.utils.AppContentType

@Composable
fun RecommendationsListScreen(
    selectedCategoryId: Int,contentType: AppContentType, modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit
) {
    LazyColumn(modifier = modifier.padding(4.dp)) {
        items(items = DataSource.recommendations.filter { it.categoryId == selectedCategoryId }) { item ->
            RecommendationsItem(item) {
                onItemClick(it)
            }
        }
    }
}

@Composable
fun RecommendationsItem(
    item: Recommendation,
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit
) {
    Card(
        elevation = 2.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(10.dp)
            .clickable { onItemClick(item.optionId) }) {
        /*Row {
            Image(
                painter = painterResource(id = item.optionImage),
                contentDescription = item.optionName,
                modifier
                    .height(100.dp)
                    .width(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(item.optionName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier.height(5.dp))
                Text(item.optionLocation, fontSize = 12.sp, fontWeight = FontWeight.Normal)
            }
        }*/
        Box(contentAlignment = Alignment.BottomCenter) {
            Image(
                painter = painterResource(id = item.optionImage),
                contentDescription = item.optionName,
                modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier
                    .background(Color(0x88000000), RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .padding(10.dp)
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    item.optionName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier.height(5.dp))
                Text(
                    item.optionLocation,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            }
        }
    }
}