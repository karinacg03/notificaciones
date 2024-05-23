package com.adso.notificaciones

import adapter.NotificationAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private val notifications = mutableListOf<Notification>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadNotifications()


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NotificationAdapter(notifications)

        findViewById<TextView>(R.id.mark_as_read).setOnClickListener {
            markAllAsRead()
        }
    }

    // Carga las notificaciones en la lista
    private fun loadNotifications() {
        for (i in 1..6) {
            notifications.add(
                Notification(
                    android.R.drawable.sym_def_app_icon,
                    "tienes una nueva oferta de trabajo",
                    "1m ago",
                    i <= 3
                )
            )
        }
    }

    // Marca todas las notificaciones como leídas y notifica al adaptador
    private fun markAllAsRead() {
        notifications.forEach { it.isUnread = false }
        findViewById<RecyclerView>(R.id.recycler_view).adapter?.notifyDataSetChanged()
    }
}