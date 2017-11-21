package com.kotlin.ourmemories.view.review.presenter

import android.content.Intent
import com.kotlin.ourmemories.view.review.ReviewActivity
import java.io.File

/**
 * Created by kimmingyu on 2017. 11. 19..
 */
interface ReviewContract {
    interface View{
        fun updateAddressView()
        fun updatePhotoView(uploadFile: File)
        fun updateVideoView(uploadFile: File)
    }
    interface Presenter{
        var mView: View
        var activity:ReviewActivity
        fun currentAddress()

        fun photoReview()
        fun videoReview()
        fun cameraPhotoReview()
        fun cameraVideoReview()

        fun getImage(data: Intent?)
        fun getVideo(data: Intent?)
    }
}