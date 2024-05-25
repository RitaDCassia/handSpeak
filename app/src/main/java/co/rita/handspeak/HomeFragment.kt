package co.rita.handspeak

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import soup.neumorphism.NeumorphCardView


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // url youtube
        val channelUrl = "https://www.youtube.com/@ritadecassiateixeira8847/featured"


        // onclick para ir para a tela 'praticar'
        val cardPraticar = view.findViewById<NeumorphCardView>(R.id.cardPraticar)
        cardPraticar.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_cameraFragment)
        }

        // onclick para ir para a tela 'quiz'
        val cardQuiz = view.findViewById<NeumorphCardView>(R.id.cardQuiz)
        cardQuiz.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_quizQuestionsFragment)
        }

        // onclick contato
        val cardContact = view.findViewById<NeumorphCardView>(R.id.cardContato)
        cardContact.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_contactFragment)
        }

        // Definir o evento onclick youtube
        val cardVideos = view.findViewById<NeumorphCardView>(R.id.cardVideos)
        cardVideos.setOnClickListener {
            abrirLink(channelUrl)
        }

        // Definir o evento onclick compartilhar
        val cardRigth = view.findViewById<NeumorphCardView>(R.id.cardRigth)
       cardRigth.setOnClickListener {
            val texto = "Descubra a beleza da lingua de sinais com nosso aplicativo de ensino de Libras!\n" +
                    "Utilizando inteligência artificial, oferecemos reconhecimento de mão preciso e interativo.\n" +
                    "Aproveite nosso quiz para testar seus conhecimentos e aprimorar suas habilidades.\n" +
                    "Siga-nos no Instagram para atualizações, dicas e conteúdo exclusivo. Compartilhe essa ideia inspiradora com amigos e familiares.\n" +
                    "Acesse agora: "
            val link = "https://www.instagram.com/_ritaaaaaaaaaa/"
            compartilharTextoELink(texto, link)
        }


        return view
    }

    // Função para abrir o link do youtube
    fun abrirLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    // Função para compartilhar o texto e o link
    fun compartilharTextoELink(texto: String, link: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "$texto $link")
        startActivity(Intent.createChooser(intent, "Compartilhar via"))
    }


}