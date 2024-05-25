package co.rita.handspeak.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import co.rita.handspeak.R

class ResultFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)


        // busca a pontuação
        val totalQuestions = arguments?.getInt(Constants.TOTAL_QUESTIONS)
        val score = arguments?.getInt(Constants.SCORE)

        val congratulationsTv: TextView = view.findViewById(R.id.congratulationsTv)
        val scoreTv: TextView = view.findViewById(R.id.scoreTv)
        val btnRestart: Button = view.findViewById(R.id.btnRestart)

        congratulationsTv.text = "Parabéns!"
        scoreTv.text = "Você acertou $score de $totalQuestions"

        btnRestart.setOnClickListener {
            // vai para a home
            Navigation.findNavController(view).navigate(R.id.action_resultFragment_to_homeFragment)
        }

        return view
    }
}
