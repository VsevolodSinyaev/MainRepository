package com.vss3003.wallpapersearcher.view

import android.app.DownloadManager
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.vss3003.wallpapersearcher.R
import com.vss3003.wallpapersearcher.databinding.ActivityMainBinding
import com.vss3003.wallpapersearcher.domain.Heroes
import com.vss3003.wallpapersearcher.view.fragments.DetailsFragment
import com.vss3003.wallpapersearcher.view.fragments.FavoriteFragment
import com.vss3003.wallpapersearcher.view.fragments.HomeFragment
import com.vss3003.wallpapersearcher.view.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_placeholder, HomeFragment())
                .addToBackStack(null)
                .commit()

    }

    private fun checkFragmentExistence(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_placeholder, fragment, tag)
                .addToBackStack(null)
                .commit()
    }

    private fun initNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.home -> {
                    val tag = "home"
                    val fragment = checkFragmentExistence(tag)
                    //В первом параметре, если фрагмент не найден и метод вернул null, то с помощью
                    //элвиса мы вызываем создание нового фрагмента
                    changeFragment( fragment?: HomeFragment(), tag)
                    true
                }
                R.id.favorite -> {
                    val tag = "favorite"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: FavoriteFragment(), tag)
                    true
                }
                R.id.settings -> {
                    val tag = "settings"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: SettingsFragment(), tag)
                    true
                }
                else -> false
            }
        }
    }

    private var msg: String? = ""
    private var lastMsg = ""
    fun downloadImage(url: String) {
        val directory = File(Environment.DIRECTORY_DOWNLOADS)

        if (!directory.exists()) {
            directory.mkdirs()
        }

        val downloadManager = this.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        val downloadUri = Uri.parse(url)

        val request = DownloadManager.Request(downloadUri).apply {
            setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                    .setAllowedOverRoaming(false)
                    .setTitle(url.substring(url.lastIndexOf("/") + 1))
                    .setDescription("")
                    .setDestinationInExternalPublicDir(
                            directory.toString(),
                            url.substring(url.lastIndexOf("/") + 1)
                    )
        }

        val downloadId = downloadManager.enqueue(request)
        val query = DownloadManager.Query().setFilterById(downloadId)
        Thread(Runnable {
            var downloading = true
            while (downloading) {
                val cursor: Cursor = downloadManager.query(query)
                cursor.moveToFirst()
                if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                    downloading = false
                }
                val status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
                msg = statusMessage(url, directory, status)
                if (msg != lastMsg) {
                    this.runOnUiThread {
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                    }
                    lastMsg = msg ?: ""
                }
                cursor.close()
            }
        }).start()
    }

    private fun statusMessage(url: String, directory: File, status: Int): String {
        var msg = ""
        msg = when (status) {
            DownloadManager.STATUS_FAILED -> "Download has been failed, please try again"
            DownloadManager.STATUS_PAUSED -> "Paused"
            DownloadManager.STATUS_PENDING -> "Pending"
            DownloadManager.STATUS_RUNNING -> "Downloading..."
            DownloadManager.STATUS_SUCCESSFUL -> "Image downloaded successfully in $directory" + File.separator + url.substring(
                    url.lastIndexOf("/") + 1
            )
            else -> "There's nothing to download"
        }
        return msg
    }

    fun launchDetailsFragment(heroes: Heroes) {
        //Создаем "посылку"
        val bundle = Bundle()
        //Кладем наш фильм в "посылку"
        bundle.putParcelable("hero", heroes)
        //Кладем фрагмент с деталями в переменную
        val fragment = DetailsFragment()
        //Прикрепляем нашу "посылку" к фрагменту
        fragment.arguments = bundle

        //Запускаем фрагмент
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_placeholder, fragment)
                .addToBackStack(null)
                .commit()
    }
}