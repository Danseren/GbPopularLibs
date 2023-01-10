package ru.sample.store.myapplication.view.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.sample.store.myapplication.GeekBrainsApp
import ru.sample.store.myapplication.core.BackPressedListener
import ru.sample.store.myapplication.core.network.NetworkProvider
import ru.sample.store.myapplication.databinding.FragmentUserListBinding
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.presenter.UserPresenter
import ru.sample.store.myapplication.repository.impl.GithubRepositoryImpl
import ru.sample.store.myapplication.utils.makeGone
import ru.sample.store.myapplication.utils.makeVisible
import ru.sample.store.myapplication.view.UserView

class UserListFragment : MvpAppCompatFragment(), UserView, BackPressedListener {

    companion object {
        fun getInstance(): UserListFragment {
            return UserListFragment()
        }
    }

    private var _viewBinding: FragmentUserListBinding? = null
    private val viewBinding: FragmentUserListBinding
        get() {
            return _viewBinding!!
        }

    private val adapter = UserListAdapter {
        presenter.onItemClicked(it)
    }

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(NetworkProvider.userApi), GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentUserListBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsers.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun showLoading() = with(viewBinding){
        rvGithubUsers.makeGone()
        progress.makeVisible()
    }

    override fun hideLoading() = with(viewBinding){
        rvGithubUsers.makeVisible()
        progress.makeGone()
    }

    override fun onBackPressed(): Boolean = presenter.onBackPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

}