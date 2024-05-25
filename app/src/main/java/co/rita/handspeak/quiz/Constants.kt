package co.rita.handspeak.quiz

import co.rita.handspeak.R


object Constants {
    val TOTAL_QUESTIONS: String = "total_questions"
    val SCORE: String = "score"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val questionOne = Question(
            1,
            "Identifique o sinal e marque a alternativa correta:",
            R.drawable.ic_letrak,
            arrayListOf("Letra K", "Letra F", "Letra T", "Letra R"),
            0,
        )
        questionsList.add(questionOne)

        // 2
        val questionTwo = Question(
            2,
            "Identifique o sinal e marque a alternativa correta:",
            R.drawable.ic_letrar,
            arrayListOf("Letra U", "Letra B",
                "Letra R", "Letra X"),
            2
        )
        questionsList.add(questionTwo)

        // 3
        val questionThree = Question(
            3,
            "Identifique o sinal e marque a alternativa correta:",
            R.drawable.ic_letraw,
            arrayListOf("Letra U", "Letra V",
                "Letra M", "Letra W"),
            3
        )
        questionsList.add(questionThree)

        // 4
        val questionFour = Question(
            4,
            "O alfabeto manual na sequência apresentada significa a palavra em datilologia:",
            R.drawable.ic_palavra_camilo,
            arrayListOf("Carlos", "Camilo",
                "Camila", "Cintia"),
            1
        )
        questionsList.add(questionFour)

        // 5
        val questionFive = Question(
            5,
            "O alfabeto manual na sequência apresentada significa a palavra em datilologia:",
            R.drawable.ic_palavra_casa,
            arrayListOf("Caso", "Cola",
                "Casa", "Capa"),
            2
        )
        questionsList.add(questionFive)

        // 6
        val questionSix = Question(
            6,
            "O alfabeto manual na sequência apresentada significa a palavra em datilologia:",
            R.drawable.ic_palavra_libras,
            arrayListOf("Libras", "Lider",
                "Legal", "Lutar"),
            0
        )

        questionsList.add(questionSix)

        // 7
        val questionSeven = Question(
            7,
            "O alfabeto manual na sequência apresentada significa a palavra em datilologia:",
            R.drawable.ic_palavra_paulo,
            arrayListOf("Paula", "Pedro",
                "Paulo", "Pablo"),
            2
        )
        questionsList.add(questionSeven)

        // 8
        val questionEight = Question(
            8,
            "O alfabeto manual na sequência apresentada significa a palavra em datilologia:",
            R.drawable.ic_palavra_peixe,
            arrayListOf("Prova", "Pleno",
                "Perto", "Peixe"),
            3
        )
        questionsList.add(questionEight)

        // 9
        val questionNine = Question(
            9,
            "O alfabeto manual na sequência apresentada significa a palavra em datilologia:",
            R.drawable.ic_palavra_rita,
            arrayListOf("Riso", "Rita",
                "Rito", "Rota"),
            1
        )
        questionsList.add(questionNine)

        // 10
        val questionTen = Question(
            10,
            "O alfabeto manual na sequência apresentada significa a palavra em datilologia:",
            R.drawable.ic_palavra_flor,
            arrayListOf("Flor", "Folha",
                "Fardo", "Fluxo"),
            0
        )
        questionsList.add(questionTen)

        return questionsList
    }
}