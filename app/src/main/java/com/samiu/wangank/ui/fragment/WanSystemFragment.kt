package com.samiu.wangank.ui.fragment

import androidx.lifecycle.Observer
import com.samiu.base.ui.BaseFragment
import com.samiu.base.ui.viewBinding
import com.samiu.wangank.R
import com.samiu.wangank.databinding.FragmentWanSystemBinding
import com.samiu.wangank.ui.adapter.WanSystemAdapter
import com.samiu.wangank.viewmodel.WanSystemViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Samiu 2020/3/2
 * @github https://github.com/SamiuZhong
 * @blog samiu.top
 */
class WanSystemFragment : BaseFragment(R.layout.fragment_wan_system) {
    private val viewModel: WanSystemViewModel by viewModel()
    private val binding by viewBinding(FragmentWanSystemBinding::bind)

    override fun initView() = initRecyclerView()
    override fun initData() = viewModel.getSystem()

    private lateinit var adapter: WanSystemAdapter

    override fun startObserve() = viewModel.run {
        mSystems.observe(this@WanSystemFragment, Observer {
            adapter.addAll(it)
        })
    }

    private fun initRecyclerView() {
        adapter = WanSystemAdapter(context)
        binding.systemRv.adapter = adapter
    }
}