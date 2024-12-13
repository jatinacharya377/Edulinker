package com.link.edulinker.ui.adapters

import com.link.edulinker.data.model.Link
import com.link.edulinker.databinding.LayoutItemLinkBinding

class LinkListAdapter : RecyclerAdapterBase<Link, LayoutItemLinkBinding>(LayoutItemLinkBinding::inflate) {

    private lateinit var listener: LinkListener

    fun setListener(listener: LinkListener) {
        this.listener = listener
    }

    interface LinkListener {
        fun onClickCopyLink(link: String?)
    }

    override fun onBind(binding: LayoutItemLinkBinding, item: Link, position: Int) {
        binding.link = item
        binding.tvLink.setOnClickListener {
            listener.onClickCopyLink(item.web_link)
        }
    }
}