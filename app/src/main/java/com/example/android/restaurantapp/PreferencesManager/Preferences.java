package com.example.android.restaurantapp.PreferencesManager;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.android.restaurantapp.Model.Restaurants;
import com.google.gson.Gson;

/**
 * Created by pc on 12/18/2017.
 */

public class Preferences {
    private static SharedPreferences getPreferences(Context context) {
        return context.getApplicationContext().getSharedPreferences("MySharedPreferencesFile", Activity.MODE_PRIVATE);
    }
    public static void addRestaurants (Restaurants user, Context context){
        Gson gson = new Gson();
        String mapStrnig = gson.toJson(user );
        getPreferences(context).edit().putString("restaurants", mapStrnig).apply();
    }
    public static Restaurants getRestaurants (Context context){
        return  new Gson().fromJson(getPreferences(context).getString("restaurants", restaurants), Restaurants.class);

    }

    private static String restaurants = "{\\rtf1\\ansi\\ansicpg1252\\cocoartf1561\\cocoasubrtf200\n" +
            "{\\fonttbl\\f0\\fswiss\\fcharset0 Helvetica;}\n" +
            "{\\colortbl;\\red255\\green255\\blue255;}\n" +
            "{\\*\\expandedcolortbl;;}\n" +
            "\\paperw11900\\paperh16840\\margl1440\\margr1440\\vieww15800\\viewh10580\\viewkind0\n" +
            "\\pard\\tx566\\tx1133\\tx1700\\tx2267\\tx2834\\tx3401\\tx3968\\tx4535\\tx5102\\tx5669\\tx6236\\tx6803\\pardirnatural\\partightenfactor0\n" +
            "\n" +
            "\\f0\\fs24 \\cf0 \\{\"restaurants\": [\\\n" +
            "  \\{\\\n" +
            "    \"logo\": \"https://en.opensuse.org/images/4/49/Amarok-logo-small.png\",\\\n" +
            "    \"city\": \"Skopje\",\\\n" +
            "    \"name\": \"Vijayawada\",\\\n" +
            "    \"rating\": \"2.5\",\\\n" +
            "    \"menu\": [\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/14.jpg\",\\\n" +
            "        \"price\": \"90\",\\\n" +
            "        \"foodname\": \"Cream Of Tomato Soup\",\\\n" +
            "        \"isveg\": true\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/14.jpg\",\\\n" +
            "        \"price\": \"90\",\\\n" +
            "        \"foodname\": \"Veg Clear Soup\",\\\n" +
            "        \"isveg\": true\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/14.jpg\",\\\n" +
            "        \"price\": \"90\",\\\n" +
            "        \"foodname\": \"Veg Hot &amp; Sour Soup\",\\\n" +
            "        \"isveg\": true\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/14.jpg\",\\\n" +
            "        \"price\": \"90\",\\\n" +
            "        \"foodname\": \"Veg Manchow Soup\",\\\n" +
            "        \"isveg\": true\\\n" +
            "      \\}\\\n" +
            "    ]\\\n" +
            "  \\},\\\n" +
            "  \\{\\\n" +
            "    \"logo\": \"http://skopskimerak.mk/mk/img/cali-logo.png\",\\\n" +
            "    \"city\": \"Skopje\",\\\n" +
            "    \"name\": \"Skopski Merak\",\\\n" +
            "    \"rating\": \"3.5\",\\\n" +
            "    \"menu\": [\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/14.jpg\",\\\n" +
            "        \"price\": \"190\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1055 \\u1072 \\u1089 \\u1090 \\u1088 \\u1084 \\u1072 \\u1112 \\u1083 \\u1080 \\u1112 \\u1072  \\u1057 \\u1074 \\u1080 \\u1085 \\u1089 \\u1082 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/14.jpg\",\\\n" +
            "        \"price\": \"180\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1055 \\u1072 \\u1089 \\u1090 \\u1088 \\u1084 \\u1072 \\u1112 \\u1083 \\u1080 \\u1112 \\u1072  \\u1055 \\u1080 \\u1083 \\u1077 \\u1096 \\u1082 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/14.jpg\",\\\n" +
            "        \"price\": \"220\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1055 \\u1072 \\u1089 \\u1090 \\u1088 \\u1084 \\u1072 \\u1112 \\u1083 \\u1080 \\u1112 \\u1072  \\u1042 \\u1077 \\u1075 \\u1077 \\u1090 \\u1077 \\u1088 \\u1112 \\u1072 \\u1085 \\u1089 \\u1082 \\u1072 \",\\\n" +
            "        \"isveg\": true\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/14.jpg\",\\\n" +
            "        \"price\": \"250\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1058 \\u1077 \\u1083 \\u1077 \\u1096 \\u1082 \\u1080  \\u1119 \\u1080 \\u1075 \\u1077 \\u1088 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/14.jpg\",\\\n" +
            "        \"price\": \"330\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1058 \\u1091 \\u1088 \\u1083 \\u1080  \\u1058 \\u1072 \\u1074 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\}\\\n" +
            "    ]\\\n" +
            "  \\},\\\n" +
            "\\{\\\n" +
            "    \"logo\": \"http://bravos.mk/img/bc-logos.png\",\\\n" +
            "    \"city\": \"Skopje\",\\\n" +
            "    \"name\": \"\\uc0\\u1041 \\u1088 \\u1072 \\u1074 \\u1086 \\u1089 \",\\\n" +
            "    \"rating\": \"4.5\",\\\n" +
            "    \"menu\": [\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://bravos.mk/img/wel-2.png\",\\\n" +
            "        \"price\": \"200\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1050 \\u1072 \\u1087 \\u1088 \\u1080 \\u1095 \\u1080 \\u1086 \\u1079 \\u1072  \\u1055 \\u1080 \\u1094 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://bravos.mk/img/wel-2.png\",\\\n" +
            "        \"price\": \"210\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1042 \\u1077 \\u1075 \\u1077 \\u1090 \\u1077 \\u1088 \\u1112 \\u1072 \\u1085 \\u1089 \\u1082 \\u1072  \\u1055 \\u1080 \\u1094 \\u1072 \",\\\n" +
            "        \"isveg\": true\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://bravos.mk/img/wel-2.png\",\\\n" +
            "        \"price\": \"210\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1050 \\u1091 \\u1083 \\u1077 \\u1085  \\u1055 \\u1080 \\u1094 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/27.jpg\",\\\n" +
            "        \"price\": \"160\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1062 \\u1077 \\u1079 \\u1072 \\u1088  \\u1057 \\u1072 \\u1083 \\u1072 \\u1090 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://skopskimerak.mk/mk/img/29.jpg\",\\\n" +
            "        \"price\": \"190\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1058 \\u1091 \\u1085 \\u1072  \\u1057 \\u1072 \\u1083 \\u1072 \\u1090 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://bravos.mk/img/bravos-flyer-min.jpg\",\\\n" +
            "        \"price\": \"150\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1057 \\u1077 \\u1085 \\u1076 \\u1074 \\u1080 \\u1095  \\u1057 \\u1086  \\u1041 \\u1077 \\u1095 \\u1082 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\}\\\n" +
            "    ]\\\n" +
            "  \\},\\\n" +
            "\\{\\\n" +
            "    \"logo\": \"http://bravos.mk/img/bc-logos.png\",\\\n" +
            "    \"city\": \"Skopje\",\\\n" +
            "    \"name\": \"S\\uc0\\u1074 \\u1077 \\u1079 \\u1076 \\u1077 \\u1085  \\u1054 \\u1082 \\u1077 \\u1072 \\u1085 \",\\\n" +
            "    \"rating\": \"4.1\",\\\n" +
            "    \"menu\": [\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/22_23.JPG\",\\\n" +
            "        \"price\": \"220\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1050 \\u1080 \\u1085 \\u1077 \\u1089 \\u1082 \\u1072  \\u1057 \\u1072 \\u1083 \\u1072 \\u1090 \\u1072 \",\\\n" +
            "        \"isveg\": true\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/141_2005.png\",\\\n" +
            "        \"price\": \"100\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1051 \\u1091 \\u1090 \\u1072  \\u1057 \\u1072 \\u1083 \\u1072 \\u1090 \\u1072  \\u1089 \\u1086  \\u1047 \\u1077 \\u1083 \\u1082 \\u1072 \",\\\n" +
            "        \"isveg\": true\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/40_30.JPG\",\\\n" +
            "        \"price\": \"230\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1055 \\u1088 \\u1078 \\u1077 \\u1085 \\u1080  \\u1055 \\u1080 \\u1083 \\u1077 \\u1096 \\u1082 \\u1080  \\u1050 \\u1088 \\u1080 \\u1083 \\u1094 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/49_%D0%A1%D0%B2%D0%B8%D0%BD%D1%81%D0%BA%D0%BE%20%D0%B2%D0%BE%20%D0%B3%D1%80%D0%BD%D0%B5%20_svinsko-vo-grne.png\",\\\n" +
            "        \"price\": \"390\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1057 \\u1074 \\u1080 \\u1085 \\u1089 \\u1082 \\u1086  \\u1042 \\u1086  \\u1043 \\u1088 \\u1085 \\u1077 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/98_81.JPG\",\\\n" +
            "        \"price\": \"170\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1064 \\u1087 \\u1072 \\u1075 \\u1077 \\u1090 \\u1080  \\u1089 \\u1086  \\u1088 \\u1072 \\u1082 \\u1095 \\u1080 \\u1114 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/99_80.JPG\",\\\n" +
            "        \"price\": \"230\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1053 \\u1091 \\u1076 \\u1083 \\u1080  \\u1089 \\u1086  \\u1055 \\u1080 \\u1083 \\u1077 \\u1096 \\u1082 \\u1086 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\},\\\n" +
            "      \\{\\\n" +
            "        \"link\": \"http://www.kineskirestoran.com.mk/images/menu/69_112.JPG\",\\\n" +
            "        \"price\": \"170\",\\\n" +
            "        \"foodname\": \"\\uc0\\u1054 \\u1088 \\u1080 \\u1079  \\u1089 \\u1086  \\u1056 \\u1072 \\u1082 \\u1095 \\u1080 \\u1114 \\u1072 \",\\\n" +
            "        \"isveg\": false\\\n" +
            "      \\}\\\n" +
            "    ]\\\n" +
            "  \\}\\\n" +
            "]\\}}";
}
