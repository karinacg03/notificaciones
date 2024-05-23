package com.adso.notificaciones

data class Notification(
    val imageRes: Int,
    val description: String,
    val time: String,
    var isUnread: Boolean
)