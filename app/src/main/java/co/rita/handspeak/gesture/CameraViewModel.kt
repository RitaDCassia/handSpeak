package co.rita.handspeak.gesture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.rita.handspeak.R

class CameraViewModel : ViewModel() {
    private val _currentLetter = MutableLiveData<GestureResource>()
    val currentLetter = _currentLetter

    private val gestureResources = listOf(
        GestureResource("A", R.drawable.a, R.drawable.a_libras),
        GestureResource("B", R.drawable.b, R.drawable.b_libras),
        GestureResource("C", R.drawable.c, R.drawable.c_libras),
        GestureResource("D", R.drawable.d, R.drawable.d_libras),
        GestureResource("E", R.drawable.e, R.drawable.e_libras),
        GestureResource("F", R.drawable.f, R.drawable.f_libras),
        GestureResource("G", R.drawable.g, R.drawable.g_libras),
        GestureResource("H", R.drawable.h, R.drawable.h_libras),
        GestureResource("I", R.drawable.i, R.drawable.i_libras),
        GestureResource("J", R.drawable.j, R.drawable.j_libras),
        GestureResource("K", R.drawable.k, R.drawable.k_libras),
        GestureResource("L", R.drawable.l, R.drawable.l_libras),
        GestureResource("M", R.drawable.m, R.drawable.m_libras),
        GestureResource("N", R.drawable.n, R.drawable.n_libras),
        GestureResource("O", R.drawable.o, R.drawable.o_libras),
        GestureResource("P", R.drawable.p, R.drawable.p_libras),
        GestureResource("Q", R.drawable.q, R.drawable.q_libras),
        GestureResource("R", R.drawable.r, R.drawable.r_libras),
        GestureResource("S", R.drawable.s, R.drawable.s_libras),
        GestureResource("T", R.drawable.t, R.drawable.t_libras),
        GestureResource("U", R.drawable.u, R.drawable.u_libras),
        GestureResource("V", R.drawable.v, R.drawable.v_libras),
        GestureResource("W", R.drawable.w, R.drawable.w_libras),
        GestureResource("X", R.drawable.x, R.drawable.x_libras),
        GestureResource("Y", R.drawable.y, R.drawable.y_libras)
    )

    private var _currentStep = 0

    init {
        _currentLetter.value = gestureResources[_currentStep]
    }

    fun getCurrentLetter(): GestureResource {
        return gestureResources[_currentStep]
    }

    fun nextStep() {
        _currentStep++

        if (_currentStep < gestureResources.size) {
            _currentLetter.value = gestureResources[_currentStep]
            // quando chegar no indice 25 volta ara o indice 0
        }  else if (_currentStep == gestureResources.size) {
            _currentStep = 0
            _currentLetter.value = gestureResources[_currentStep]
        }
    }

}