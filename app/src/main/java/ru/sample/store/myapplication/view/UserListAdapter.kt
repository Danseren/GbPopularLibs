package ru.sample.store.myapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.sample.store.myapplication.databinding.ItemUserBinding
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.utils.POSITION

class UserListAdapter(private val presenter: IUserListPresenter) :
    RecyclerView.Adapter<UserListAdapter.GithubUserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val viewHolder = GithubUserViewHolder(ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    override fun getItemCount() = presenter.getCount()

    inner class GithubUserViewHolder(private val binding: ItemUserBinding) :
        ViewHolder(binding.root), UserItemView {

        override var pos = POSITION

        override fun setLogin(user: GithubUser) = with(binding) {
            tvUserLogin.text = user.login
        }
    }
}