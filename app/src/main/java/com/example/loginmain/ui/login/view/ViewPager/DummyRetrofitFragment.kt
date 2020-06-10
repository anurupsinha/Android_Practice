package com.example.loginmain.ui.login.view.ViewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.loginmain.R
import com.example.loginmain.ui.login.model.JSON_Post
import com.example.loginmain.ui.login.view.dummyRetrofit.JSON_PlaceholderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DummyRetrofitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DummyRetrofitFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var jsonplaceholder: JSON_PlaceholderApi
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.dummy_retrofit, container, false)

        tv = v.findViewById(R.id.text_view_result)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())

            .build()


        jsonplaceholder = retrofit.create(JSON_PlaceholderApi::class.java)

//        getTMDB_Demo()
        getPosts()

        return v
    }

    fun getPosts() {
        var call: Call<List<JSON_Post>> = jsonplaceholder.getPosts()

        call.enqueue(object : Callback<List<JSON_Post>> {
            override fun onFailure(call: Call<List<JSON_Post>>?, t: Throwable?) {
                tv.setText(t!!.message);
            }

            override fun onResponse(
                call: Call<List<JSON_Post>>?,
                response: Response<List<JSON_Post>>?
            ) {
                if (!response?.isSuccessful()!!) {
                    tv.setText("Code : ${response.code()}")
                    return
                }
                var posts: List<JSON_Post> = response.body()!!
                for (post: JSON_Post in posts) {
                    var content: String = ""
                    content += "ID: ${post.id}" + "\n"
                    content += "Name: $post.name" + "\n"
                    content += "UserName: ${post.username}" + "\n"
                    content += "Email: ${post.email}" + "\n"

                    tv.append(content)

                }


            }
        })

    }

    fun getTMDB_Demo() {
//        var call : Call<List<JSON_TMDB_Demo>> = jsonplaceholder.getMovies()
//
//        call.enqueue(object : Callback<List<JSON_TMDB_Demo>> {
//
//
//            override fun onFailure(call: Call<List<JSON_TMDB_Demo>>?, t: Throwable?) {
//                tv.setText(t!!.message)
//            }
//
//            override fun onResponse(
//                call: Call<List<JSON_TMDB_Demo>>?,
//                response: Response<List<JSON_TMDB_Demo>>?
//            ) {
//                if (!response?.isSuccessful()!!) {
//                    tv.setText("Code : ${response.code()}")
//                    return
//                }
//                var movies: List<JSON_TMDB_Demo> = response.body()!!
//                for (movie: JSON_TMDB_Demo in movies) {
//                    var content: String = ""
//                    content += "ID: ${movie.id}" + "\n"
//                    content += "Name: ${movie.original_title}" + "\n"
//                    content += "UserName: ${movie.overview}" + "\n"
//
//                    tv.append(content)
//
//                }
//
//
//            }})

    }
}



