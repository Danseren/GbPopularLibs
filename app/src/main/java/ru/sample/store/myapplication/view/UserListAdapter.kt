package ru.sample.store.myapplication.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.sample.store.myapplication.databinding.ItemUserBinding
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.utils.POSITION
import ru.sample.store.myapplication.utils.loadImage

typealias OnUserClickListener = (login: String) -> Unit

class UserListAdapter(
    private val onUserClickListener: OnUserClickListener
) : RecyclerView.Adapter<UserListAdapter.GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GithubUserViewHolder(binding, onUserClickListener)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    inner class GithubUserViewHolder(
        private val binding: ItemUserBinding,
        private val onUserClickListener: OnUserClickListener
    ) : ViewHolder(binding.root) {

        fun bind(item: GithubUser) = with(binding) {
            tvUserLogin. text = item.login
            ivUserAvatar.loadImage(item.avatarURL)
            root.setOnClickListener {
                onUserClickListener.invoke(item.login)
            }
        }
    }
}