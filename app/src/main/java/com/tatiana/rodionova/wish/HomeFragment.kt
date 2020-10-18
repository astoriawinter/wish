package com.tatiana.rodionova.wish

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTapTargetView()

        add.setOnClickListener {
            AddWishBottomSheet().show(parentFragmentManager, AddWishBottomSheet::class.java.simpleName)
        }
    }

    private fun initTapTargetView() {
        TapTargetView.showFor(
            requireActivity(),
            TapTarget.forView(
                add,
                "Click to add first wish"
            )
                .outerCircleColor(R.color.colorPrimary)
                .outerCircleAlpha(0.9f)
                .targetCircleColor(R.color.white)
                .titleTextSize(20)
                .titleTextColor(R.color.white)
                .drawShadow(true)
                .cancelable(true)
                .tintTarget(true)
                .transparentTarget(true)
                .targetRadius(60),
            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView?) {
                    super.onTargetClick(view)
                    add.performClick()
                }
            }
        )
    }
}