package ru.sample.store.myapplication.view

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
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.presenter.UserPresenter
import ru.sample.store.myapplication.repository.impl.GithubRepositoryImpl

class UserFragment: MvpAppCompatFragment(), UserView, BackPressedListener {

    companion object{
        fun getInstance(): UserFragment {
            return UserFragment()

//            return UserFragment().apply {
//                arguments = Bundle(
//                    "login" to login
//                )
//            }
        }
    }

    private var _viewBinding: FragmentUserListBinding? = null
    private val viewBinding: FragmentUserListBinding
        get() {
        return _viewBinding!!
        }

    private val adapter = UserAdapter()

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), GeekBrainsApp.instance.router)
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

    override fun onBackPressed(): Boolean = presenter.onBackPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}