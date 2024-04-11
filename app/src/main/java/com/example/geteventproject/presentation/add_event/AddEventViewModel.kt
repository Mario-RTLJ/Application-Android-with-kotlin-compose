import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geteventproject.data.local.database.EventEntity
import com.example.geteventproject.domain.AddEventUseCase
import kotlinx.coroutines.launch

class AddEventViewModel(private val addEventUseCase: AddEventUseCase) : ViewModel() {

    fun addEvent(event: EventEntity) {
        viewModelScope.launch {
            addEventUseCase(event)
        }
    }
}
