package ru.sample.store.myapplication.view.userinfo

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
import ru.sample.store.myapplication.databinding.FragmentUserInfoBinding
import ru.sample.store.myapplication.model.GithubRepo
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.presenter.UserInfoPresenter
import ru.sample.store.myapplication.repository.impl.GithubRepositoryImpl
import ru.sample.store.myapplication.utils.*

class UserInfoFragment : MvpAppCompatFragment(), UserInfoView, BackPressedListener {

    companion object{
        fun getInstance(login: String): UserInfoFragment {
            return UserInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(USER_KEY, login)
                }
            }
        }
    }

    private var _viewBinding: FragmentUserInfoBinding? = null
    private val viewBinding: FragmentUserInfoBinding
        get() {
            return _viewBinding!!
        }

    private val adapter = RepoAdapter {
        presenter.onRepoClicked(it)
    }

    val presenter by moxyPresenter {
        UserInfoPresenter(
            GithubRepositoryImpl(NetworkProvider.userApi),
            GeekBrainsApp.instance.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentUserInfoBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(USER_KEY)?.let {
            presenter.loadUser(it)
        }
        viewBinding.apply {
            rvRepos.layoutManager = LinearLayoutManager(requireContext())
            rvRepos.adapter = adapter
        }
    }

    override fun showUserProfile(user: GithubUser, repo: List<GithubRepo>) {
        viewBinding.apply {
            tvUserLogin.text = user.login
            ivUserAvatar.loadImage(user.avatarURL)
            adapter.repos = repo
        }
    }

    override fun showLoading() {
        viewBinding.apply {
            tvUserLogin.makeGone()
            ivUserAvatar.makeGone()
            progress.makeVisible()
        }
    }

    override fun hideLoading() {
        viewBinding.apply {
            tvUserLogin.makeVisible()
            ivUserAvatar.makeVisible()
            progress.makeGone()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

    override fun onBackPressed() = presenter.onBackPressed()
}