package com.kotlin.ourmemories.view.memory

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.ourmemories.R
import com.kotlin.ourmemories.view.MainActivity.Companion.CANARO_EXTRA_BOLD_PATH
import com.kotlin.ourmemories.view.memory.presenter.MemoryContract
import com.kotlin.ourmemories.view.memory.presenter.MemoryPresenter
import com.kotlin.ourmemories.view.review.ReviewActivity
import com.kotlin.ourmemories.view.timecapsule.TimeCapsuleActivity
import com.yalantis.guillotine.animation.GuillotineAnimation
import kotlinx.android.synthetic.main.fragment_memory.*
import kotlinx.android.synthetic.main.memory_menu.*

/**
 * Created by kimmingyu on 2017. 11. 5..
 */
class MemoryFragment : Fragment() {
    private lateinit var presenter:MemoryContract.Presenter
    companion object {
        val RIPPLE_DURATION:Long = 250
    }
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_memory, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val memoryMenu = LayoutInflater.from(context).inflate(R.layout.memory_menu, null)
        memoryRoot.addView(memoryMenu)

        // memory_menu 애니메이션
        GuillotineAnimation.GuillotineBuilder(memoryMenu,memoryMenu.findViewById(R.id.memoryHamburger),contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build()

        // memory, memory menu 글씨체 변경
        val canaroExtraBold = Typeface.createFromAsset(context.assets, CANARO_EXTRA_BOLD_PATH)
        titleText.typeface = canaroExtraBold
        with(memoryMenu){
            memoryTitleText.typeface = canaroExtraBold
            review.typeface = canaroExtraBold
            timeCapsule.typeface = canaroExtraBold
        }

        // presenter 연결부분
        presenter = MemoryPresenter().apply {
            fragment = this@MemoryFragment
        }

        review.setOnClickListener {
            presenter.intentActivity(ReviewActivity())
        }
        timeCapsule.setOnClickListener {
            presenter.intentActivity(TimeCapsuleActivity())
        }
    }

}