package com.link.edulinker.ui.fragments

import androidx.navigation.fragment.findNavController
import com.link.edulinker.databinding.FragmentAllLinksBinding
import com.link.edulinker.ui.adapters.LinkListAdapter
import com.link.edulinker.utils.copyTextToClipboard
import com.link.edulinker.viewmodel.DashboardViewModel

class FragmentAllLinks : FragmentBase<FragmentAllLinksBinding>(FragmentAllLinksBinding::inflate), LinkListAdapter.LinkListener {

    private val dashboardVM by lazy { getViewModel(DashboardViewModel::class.java, true) }
    private val linkListAdapter by lazy { LinkListAdapter() }

    private fun initUi() {
        binding.cvBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.rvLinks.adapter = linkListAdapter
        linkListAdapter.setListener(this)
        when (dashboardVM.selectedLink) {
            1 -> linkListAdapter.setItems(dashboardVM.topLinks)
            2 -> linkListAdapter.setItems(dashboardVM.recentLinks)
        }
    }

    override fun setUpUi() {
        initUi()
    }

    override fun onClickCopyLink(link: String?) {
        link?.let {
            context?.copyTextToClipboard(it)
        }
    }
}