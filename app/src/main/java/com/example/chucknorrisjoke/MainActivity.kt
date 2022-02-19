package com.example.chucknorrisjoke

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.chucknorrisjoke.databinding.ActivityMainBinding
import com.example.chucknorrisjoke.model.ModelService
import kotlinx.coroutines.*
import android.net.ConnectivityManager

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnapp.setOnClickListener(){
            binding.textapp.visibility = View.VISIBLE
            if (con(this)){
                CoroutineScope(Dispatchers.Main).launch {
                    val result = withContext(Dispatchers.IO) {
                        val helper = ModelService()
                        return@withContext helper
                    }
                    binding.textapp.text = result.mMineUserEntity.value

                }
            }
            else{
                binding.textapp.text = "Проверьте состояние инернета"
                //change1
            }
        }
    }

    private fun con(context: Context): Boolean{
        val cm = applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val nInfo = cm.activeNetworkInfo
        return nInfo != null && nInfo.isAvailable && nInfo.isConnected
    }
}
