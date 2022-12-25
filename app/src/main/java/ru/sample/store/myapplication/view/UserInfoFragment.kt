package ru.sample.store.myapplication.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.sample.store.myapplication.databinding.FragmentUserInfoBinding
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.presenter.UserInfoPresenter
import ru.sample.store.myapplication.utils.NO_LOGIN
import ru.sample.store.myapplication.utils.USER_KEY

class UserInfoFragment: MvpAppCompatFragment(), UserInfoView{

    companion object{
        fun getInstance(user: GithubUser): UserInfoFragment {

            val fragment = UserInfoFragment()
            val bundle = Bundle()
            bundle.putParcelable(USER_KEY, user)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var _viewBinding: FragmentUserInfoBinding? = null
    private val viewBinding: FragmentUserInfoBinding
        get() {
            return _viewBinding!!
        }

    val presenter by moxyPresenter { UserInfoPresenter(getUserInfo()) }

    private fun getUserInfo(): GithubUser {
        val user = this.arguments?.getParcelable(USER_KEY) as? GithubUser
        return user ?: GithubUser(NO_LOGIN)
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
        showUserProfile(getUserInfo())
    }

    override fun showUserProfile(user: GithubUser) {
        viewBinding.tvUserLogin.text = user.login
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}