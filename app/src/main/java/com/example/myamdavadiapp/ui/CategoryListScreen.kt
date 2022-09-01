package com.example.myamdavadiapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myamdavadiapp.data.DataSource
import com.example.myamdavadiapp.data.models.Category
import com.example.myamdavadiapp.utils.AppContentType

@Composable
fun CategoryListScreen(
    contentType: AppContentType,
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit
) {
    LazyColumn(modifier = modifier.padding(4.dp)) {
        items(items = DataSource.categories) { item ->
            CategoryItem(item) {
                onItemClick(it)
            }
        }
    }
}

@Composable
fun CategoryItem(item: Category, modifier: Modifier = Modifier, onItemClick: (Int) -> Unit) {
    Card(
        elevation = 2.dp,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable { onItemClick(item.categoryId) }) {
        Row(modifier = modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = item.icon), contentDescription = item.name,
                modifier.size(30.dp)
            )
            Spacer(modifier.width(15.dp))
            Text(item.name, fontSize = 20.sp)
        }
    }
}
