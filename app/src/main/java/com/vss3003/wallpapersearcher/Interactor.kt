import com.vss3003.wallpapersearcher.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import javax.inject.Inject

class Interactor (private val repo: MainRepository, private val retrofitService: CApi) {
@Inject constructor()

    fun getCharactersFromApi(page: Int, callback: CharacterViewModel.ApiCallback) {
        retrofitService.getCharacters(ApiConstants.API_KEY, page).enqueue(object : Callback<ResultsDto> {
            override fun onResponse(call: Call<ResultsDto>, response: Response<ResultsDto>) {
                callback.onSuccess(com.vss3003.wallpapersearcher.Converter.convertApiListToDTOList(response.body()?.))
            }

            override fun onFailure(call: Call<ResultsDto>, t: Throwable) {
                callback.onFailure()
            }
        })
    }
}

