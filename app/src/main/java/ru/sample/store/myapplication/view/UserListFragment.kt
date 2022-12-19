package ru.sample.store.myapplication.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.sample.store.myapplication.GeekBrainsApp
import ru.sample.store.myapplication.core.BackPressedListener
import ru.sample.store.myapplication.databinding.FragmentUserListBinding
import ru.sample.store.myapplication.presenter.UserPresenter
import ru.sample.store.myapplication.repository.impl.GithubRepositoryImpl

class UserListFragment: MvpAppCompatFragment(), UserView, BackPressedListener {

    companion object{
        fun getInstance(): UserListFragment {
            return UserListFragment()
        }
    }

    private var _viewBinding: FragmentUserListBinding? = null
    private val viewBinding: FragmentUserListBinding
        get() {
            return _viewBinding!!
        }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), GeekBrainsApp.instance.router)
    }
    private var adapter: UserListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentUserListBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun initList() {
        _viewBinding?.rvGithubUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UserListAdapter(presenter.userListPresenter)
        _viewBinding?.rvGithubUsers?.adapter = adapter
    }

    override fun onBackPressed(): Boolean = presenter.onBackPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }
}