package co.rita.handspeak.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import co.rita.handspeak.R
import soup.neumorphism.NeumorphCardView

class QuizQuestionsFragment : Fragment() {

    private val questionsList: ArrayList<Question> = Constants.getQuestions()
    private var currentQuestionIndex = 0
    private var selectedAlternativeIndex = -1
    private var isAnswerChecked = false
    private var totalScore = 0
    private val alternativesIds = arrayOf(R.id.optionOne, R.id.optionTwo, R.id.optionThree, R.id.optionFour)

    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var btnSubmit: Button? = null
    private var tvAlternatives: ArrayList<TextView>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_quiz_questions, container, false)


        tvQuestion = view.findViewById(R.id.tvQuestion)
        ivImage = view.findViewById(R.id.ivImage)
        progressBar = view.findViewById(R.id.progressBar)
        tvProgress = view.findViewById(R.id.tvProgress)
        btnSubmit = view.findViewById(R.id.btnSubmit)
        tvAlternatives = arrayListOf(
            view.findViewById(R.id.optionOne),
            view.findViewById(R.id.optionTwo),
            view.findViewById(R.id.optionThree),
            view.findViewById(R.id.optionFour)
        )

        updateQuestion()

        btnSubmit?.setOnClickListener {
            if (!isAnswerChecked) {
                val anyAnswerIsChecked = selectedAlternativeIndex != -1
                if (!anyAnswerIsChecked) {
                    Toast.makeText(requireContext(), "Por favor, selecione uma alternativa", Toast.LENGTH_SHORT).show()
                } else {
                    val currentQuestion = questionsList[currentQuestionIndex]
                    if (selectedAlternativeIndex == currentQuestion.correctAnswerIndex) {
                        answerView(tvAlternatives!![selectedAlternativeIndex], R.drawable.correct_option_border_bg)
                        totalScore++
                    } else {
                        answerView(tvAlternatives!![selectedAlternativeIndex], R.drawable.wrong_option_border_bg)
                        answerView(tvAlternatives!![currentQuestion.correctAnswerIndex], R.drawable.correct_option_border_bg)
                    }

                    isAnswerChecked = true
                    btnSubmit?.text = if (currentQuestionIndex == questionsList.size - 1) "Finalizar" else "Próxima pergunta"
                    selectedAlternativeIndex = -1
                }
            } else {
                if (currentQuestionIndex < questionsList.size - 1) {
                    currentQuestionIndex++
                    updateQuestion()
                    btnSubmit?.text = "RESPONDER"

                } else {

                    // mostra pontuação
                    val bundle = Bundle()
                    bundle.putInt(Constants.TOTAL_QUESTIONS, questionsList.size)
                    bundle.putInt(Constants.SCORE, totalScore)

                    val navController = Navigation.findNavController(view)
                    navController.navigate(R.id.action_quizQuestionsFragment_to_resultFragment, bundle)
                }

                isAnswerChecked = false
            }
        }

        tvAlternatives?.forEachIndexed { index, option ->
            option.setOnClickListener {
                if (!isAnswerChecked) {
                    selectedAlternativeView(option, index)
                }
            }
        }

        return view
    }

    private fun updateQuestion() {
        defaultAlternativesView()

        val currentQuestion = questionsList[currentQuestionIndex]

        tvQuestion?.text = currentQuestion.questionText
        ivImage?.setImageResource(currentQuestion.image)

        progressBar?.progress = currentQuestionIndex + 1
        tvProgress?.text = "${currentQuestionIndex + 1}/${questionsList.size}"

        for (i in tvAlternatives!!.indices) {
            tvAlternatives!![i].text = currentQuestion.alternatives[i]
        }
    }

    private fun defaultAlternativesView() {
        for (option in tvAlternatives!!) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(requireContext(), R.drawable.default_option_border_bg)
        }
    }

    private fun selectedAlternativeView(tv: TextView, selectedOptionIndex: Int) {
        defaultAlternativesView()
        selectedAlternativeIndex = selectedOptionIndex
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(requireContext(), R.drawable.selected_option_border_bg)
    }

    private fun answerView(tv: TextView, drawableView: Int) {
        tv.background = ContextCompat.getDrawable(requireContext(), drawableView)
    }
}
