package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adso.notificaciones.Notification
import com.adso.notificaciones.R

class NotificationAdapter(private val notifications: List<Notification>) :
    RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.notification_card, parent, false)
        return NotificationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notifications[position]
        holder.bind(notification)
    }

    override fun getItemCount() = notifications.size

    class NotificationViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.photo)
        val description: TextView = itemView.findViewById(R.id.description)
        val notif_time: TextView = itemView.findViewById(R.id.notif_time)

        fun bind(notification: Notification) {
            photo.setImageResource(notification.imageRes)
            description.text = notification.description
            notif_time.text = notification.time
            if (notification.isUnread) {
                itemView.setBackgroundResource(R.color.unreadBackground)
            } else {
                itemView.setBackgroundResource(R.color.readBackground)
            }
        }
    }
}
