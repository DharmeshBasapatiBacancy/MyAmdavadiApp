package com.example.myamdavadiapp.data

import com.example.myamdavadiapp.R
import com.example.myamdavadiapp.data.models.Category
import com.example.myamdavadiapp.data.models.Recommendation

object DataSource {

    val categories = listOf(
        Category(1, "Coffee Shops", R.drawable.ic_coffee_shops),
        Category(2, "Restaurants", R.drawable.ic_restaurants),
        Category(3, "Kids Friendly", R.drawable.ic_kid_friendly),
        Category(4, "Parks", R.drawable.ic_parks),
        Category(5, "Shopping Malls", R.drawable.ic_shopping_malls),
    )

    val recommendations = listOf(
        Recommendation(
            1,
            1,
            "Java+",
            R.drawable.img_java_plus,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            2,
            1,
            "Mill & Co",
            R.drawable.img_mill_and_co,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            3,
            2,
            "Rajwadu",
            R.drawable.img_java_plus,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            4,
            2,
            "Agashiye",
            R.drawable.img_mill_and_co,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            5,
            3,
            "Science City",
            R.drawable.img_java_plus,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            6,
            3,
            "Balvatika",
            R.drawable.img_mill_and_co,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            7,
            4,
            "Kankaria Lake",
            R.drawable.img_java_plus,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            8,
            4,
            "Parimal Garden",
            R.drawable.img_mill_and_co,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            9,
            5,
            "Himalaya Mall",
            R.drawable.img_java_plus,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            10,
            5,
            "Shree Balaji Agora Mall",
            R.drawable.img_mill_and_co,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            11,
            1,
            "Momo Cafe",
            R.drawable.img_momo_cafe,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            12,
            1,
            "Shambhus Coffee Bar",
            R.drawable.img_shambhus,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
        Recommendation(
            13,
            1,
            "VarieTea",
            R.drawable.img_varie_tea,
            "Satellite Park Society Cross Road Ramdev Nagar Road Crossroad, Satellite, Ahmedabad 380015 India",
            "07:00 AM - 9:00 PM",
            "+91 79 6618 5146"
        ),
    )
}